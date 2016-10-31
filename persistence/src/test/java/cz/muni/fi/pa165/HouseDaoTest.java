package cz.muni.fi.pa165;

import cz.muni.fi.pa165.dao.AbilityDao;
import cz.muni.fi.pa165.dao.GhostDao;
import cz.muni.fi.pa165.dao.HauntingDao;
import cz.muni.fi.pa165.dao.HouseDao;
import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.entity.House;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author vojtadavid
 */

@ContextConfiguration(classes = PersistenceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class HouseDaoTest extends AbstractTestNGSpringContextTests {

    @PersistenceContext
    public EntityManager em;

    @Autowired
    private HouseDao houseDao;

    private House h1;
    private House h2;
    private House h3;
    private House h4;
    private House h5;

    @BeforeMethod
    public void createHouses() {
        h1 = new House()
                .setName("House")
                .setAddress("Adress")
                .setHistory("Brief history of time")
                .setHauntingFrom(Calendar.getInstance().getTime());

        h2 = new House()
                .setName("TRUBA")
                .setAddress("stramberk")
                .setHistory("Brief history of time")
                .setHauntingFrom(Calendar.getInstance().getTime());
        houseDao.create(h2);

        h3 = new House()
                .setName("PtaciHnizdo")
                .setAddress("Babisov")
                .setHistory("Brief history of time")
                .setHauntingFrom(Calendar.getInstance().getTime());
        houseDao.create(h3);

        h4 = new House()
                .setName("Pyramidenkogel")
                .setAddress("austria")
                .setHistory("Brief history of time")
                .setHauntingFrom(Calendar.getInstance().getTime());
        houseDao.create(h4);

        h5 = new House()
                .setName("GliwiceRadioTower")
                .setAddress("Poland")
                .setHistory("The Gliwice Radio Tower is 118 m")
                .setHauntingFrom(Calendar.getInstance().getTime());
        houseDao.create(h5);

    }

    @Test
    public void createHouseTest() {
        assertThat(h1.getId()).isNull();
        houseDao.create(h1);
        assertThat(h1.getId()).isNotNull();

    }

    @Test
    public void updateTest(){

        h2.setAddress("STRAMBERK");
        houseDao.update(h2);
        assertThat(houseDao.getById(h2.getId())).hasFieldOrPropertyWithValue("address", "STRAMBERK");
    }

    @Test
    public void deleteTest(){
        houseDao.delete(h3);
        assertThat(houseDao.getById(h3.getId())).isNull();

    }

    @Test
    public void getAllTest(){
        assertThat(houseDao.getAll()).hasSize(4);
    }

    @Test
    public void getByNameTest(){
        assertThat(houseDao.getByName("Pyramidenkogel")).isEqualTo(h4);
    }

    @Test
    public void getByAdress(){
        assertThat(houseDao.getByAddress("Poland")).isEqualTo(h5);
    }

}