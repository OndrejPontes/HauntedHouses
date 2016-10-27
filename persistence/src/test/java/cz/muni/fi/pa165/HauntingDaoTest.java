package cz.muni.fi.pa165;

import cz.muni.fi.pa165.dao.HauntingDao;
import cz.muni.fi.pa165.entity.Haunting;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * @author opontes
 */
@ContextConfiguration(classes=PersistenceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class HauntingDaoTest extends AbstractTestNGSpringContextTests {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public HauntingDao hauntingDao;

    private Haunting h1;
    private Haunting h2;
    private Haunting h3;

    @BeforeMethod
    public void setUp(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016,Calendar.OCTOBER,27);
        h1 = new Haunting(calendar.getTime(), 5);

        calendar.set(2016,Calendar.OCTOBER,27);
        h2 = new Haunting(calendar.getTime(), 3);

        calendar.set(2016,Calendar.NOVEMBER,06);
        h3 = new Haunting(calendar.getTime(), 1);

        hauntingDao.create(h1);
        hauntingDao.create(h2);
    }

    @Test
    public void treeHauntingWereCreated(){
        assertThat(h3.getId()).isNull();
        hauntingDao.create(h3);
        assertThat(h3.getId()).isNotNull();
    }

    @Test
    public void getByDateReturnCorrectHaunting(){
        List<Haunting> found = hauntingDao.getByDate(h1.getDate());
        assertThat(found).hasSize(2);
        assertThat(found).contains(h1);
        assertThat(found).contains(h2);
    }

    @Test
    public void getByIDReturnCorrectHaunting(){
        Haunting found = hauntingDao.getById(h1.getId());
        assertThat(found).isEqualTo(h1);
    }

    @Test
    public void getAllReturnCorrectHauntings(){
        List<Haunting> hauntings = hauntingDao.getAll();
        assertThat(hauntings).hasSize(2);
        assertThat(hauntings).contains(h1);
        assertThat(hauntings).contains(h2);
    }

    @Test
    public void isPossibleToUpdateHaunting(){
        h1.setNumberOfPeoplePresent(111);
        Haunting updated = hauntingDao.update(h1);
        assertThat(updated).hasFieldOrPropertyWithValue("numberOfPeoplePresent", 111);
    }

    @Test
    public void isPossibleToDeleteHaunting(){
        assertThat(em.contains(h1)).isTrue();
        hauntingDao.delete(h1);
        assertThat(em.contains(h1)).isFalse();
    }

    @Test(expectedExceptions=ConstraintViolationException.class)
    public void isForbiddenToPersistHauntingWithNullDate(){
        hauntingDao.create(new Haunting().setDate(null));
    }

}
