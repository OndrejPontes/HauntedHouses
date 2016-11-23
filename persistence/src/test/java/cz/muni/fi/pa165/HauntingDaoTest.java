package cz.muni.fi.pa165;

import cz.muni.fi.pa165.dao.HauntingDao;
import cz.muni.fi.pa165.entity.Haunting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ondrej Ponteš
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
        h1 = new Haunting(calendar, 5);

        calendar.set(2016,Calendar.OCTOBER,27);
        h2 = new Haunting(calendar, 3);

        calendar.set(2016,Calendar.NOVEMBER,6);
        h3 = new Haunting(calendar, 1);

        hauntingDao.create(h1);
        hauntingDao.create(h2);
    }

    @Test
    public void shouldCreateHaunting(){
        assertThat(h3.getId()).isNull();
        hauntingDao.create(h3);
        assertThat(h3.getId()).isNotNull();
    }

    @Test
    public void shouldReturnCorrectHauntingByName(){
        List<Haunting> found = hauntingDao.getByDate(h1.getDate());
        assertThat(found).hasSize(2);
        assertThat(found).contains(h1);
        assertThat(found).contains(h2);
    }

    @Test
    public void shouldReturnCorrectHauntingById(){
        Haunting found = hauntingDao.getById(h1.getId());
        assertThat(found).isEqualTo(h1);
    }

    @Test
    public void shouldReturnAllHaunting(){
        List<Haunting> hauntings = hauntingDao.getAll();
        assertThat(hauntings).hasSize(2);
        assertThat(hauntings).contains(h1);
        assertThat(hauntings).contains(h2);
    }

    @Test
    public void canUpdateHaunting(){
        h1.setNumberOfPeoplePresent(111);
        Haunting updated = hauntingDao.update(h1);
        assertThat(updated).hasFieldOrPropertyWithValue("numberOfPeoplePresent", h1.getNumberOfPeoplePresent());
    }

    @Test
    public void canDeleteHaunting(){
        assertThat(em.contains(h1)).isTrue();
        hauntingDao.delete(h1);
        assertThat(em.contains(h1)).isFalse();
    }

    @Test(expectedExceptions= PersistenceException.class)
    public void cantDeleteHauntingWithoutDate(){
        hauntingDao.create(new Haunting().setDate(null));
    }

    @Test
    public void shouldReturnNullByNonexistentId(){
        Haunting found = hauntingDao.getById(-1L);
        assertThat(found).isNull();
    }

    @Test
    public void shouldNotDeleteAnythingWithHauntingWithoutId(){
        hauntingDao.delete(new Haunting());
        List<Haunting> hauntings = hauntingDao.getAll();
        assertThat(hauntings).hasSize(2);
        assertThat(hauntings).contains(h1);
        assertThat(hauntings).contains(h2);
    }

    @Test
    public void shouldReturnEmptyListOfHauntingByDateWhichIsNotInDatabase(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2006,Calendar.OCTOBER,27);
        List<Haunting> found = hauntingDao.getByDate(calendar);
        assertThat(found).isEmpty();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenCreatingNull(){
        hauntingDao.create(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenFindingByIdWithNull(){
        hauntingDao.getById(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenFindingByDateWithNull(){
        hauntingDao.getByDate(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenUpdatingWithNull(){
        hauntingDao.update(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenDeletingWithNull(){
        hauntingDao.delete(null);
    }
}
