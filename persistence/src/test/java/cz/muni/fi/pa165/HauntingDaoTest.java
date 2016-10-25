package cz.muni.fi.pa165;

import cz.muni.fi.pa165.dao.HauntingDao;
import cz.muni.fi.pa165.entity.Haunting;
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
    private Haunting h4;
    private Haunting h5;


    @BeforeClass
    public void setUp(){
        h1 = new Haunting(LocalDate.now().plus(1, ChronoUnit.DAYS), 5);
        h2 = new Haunting(LocalDate.now().plus(1, ChronoUnit.DAYS), 3);
        h3 = new Haunting(LocalDate.now().minus(1, ChronoUnit.DAYS), 1);
        h4 = new Haunting(LocalDate.now().minus(4, ChronoUnit.DAYS), 9);
        h5 = new Haunting(LocalDate.now(), 7);

        hauntingDao.create(h1);
        hauntingDao.create(h2);
        hauntingDao.create(h4);
        hauntingDao.create(h5);
    }

    @Test
    public void treeHauntingWereCreated(){
        assertThat(h3.getId()).isNull();
        hauntingDao.create(h3);
        assertThat(h3.getId()).isNotNull();
    }

    @Test
    public void findByDateReturnCorrectHaunting(){
        List<Haunting> found = hauntingDao.getByDate(h1.getDate());
        assertThat(found).hasSize(2);
        assertThat(found).contains(h1);
        assertThat(found).contains(h2);
    }

    @Test
    public void isPossibleToUpdateHaunting(){
        h4.setNumberOfPeoplePresent(111);
        Haunting updated = hauntingDao.update(h4);
        assertThat(updated).hasFieldOrPropertyWithValue("numberOfPeoplePresent", 111);
    }

    @Test
    public void isPossibleToDeleteHaunting(){
        assertThat(em.contains(h5)).isTrue();
        hauntingDao.delete(h5);
        assertThat(em.contains(h5)).isFalse();
    }

}
