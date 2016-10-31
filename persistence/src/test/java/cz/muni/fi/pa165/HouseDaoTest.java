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

    private House house;


    @BeforeMethod
    public void createHouses() {
        house = new House()
                .setName("SCALA")
                .setAddress("MORAVAK")
                .setHistory("Brief history of time")
                .setHauntingFrom(Calendar.getInstance().getTime());

        houseDao.create(house);

    }

    @Test
    public void createHouseTest() {
        House h1 = new House()
                .setName("House")
                .setAddress("Adress")
                .setHistory("Brief history of time")
                .setHauntingFrom(Calendar.getInstance().getTime());

        assertThat(h1.getId()).isNull();
        houseDao.create(h1);
        assertThat(h1.getId()).isNotNull();

    }

    @Test
    public void updateTest(){
        this.house.setName("NoName");
        houseDao.update(this.house);
        assertThat(houseDao.getById(house.getId())).hasFieldOrPropertyWithValue("name", "NoName");
    }

    @Test
    public void deleteTest(){
        House h1 = new House()
                .setName("PtaciHnizdo")
                .setAddress("Babisov")
                .setHistory("Brief history of time")
                .setHauntingFrom(Calendar.getInstance().getTime());

        assertThat(h1.getId()).isNull();
        houseDao.create(h1);
        assertThat(h1.getId()).isNotNull();
        houseDao.delete(h1);
        assertThat(houseDao.getById(h1.getId())).isNull();

    }

    @Test
    public void getAllTest(){
        assertThat(houseDao.getAll()).hasSize(1);
    }

    @Test
    public void getByNameTest(){
        House h1 = new House()
                .setName("Pyramidenkogel")
                .setAddress("austria")
                .setHistory("Brief history of time")
                .setHauntingFrom(Calendar.getInstance().getTime());
        houseDao.create(h1);
        assertThat(houseDao.getByName("Pyramidenkogel")).isEqualTo(h1);
    }

    @Test
    public void getByAdress(){
        House h1 = new House()
                .setName("GliwiceRadioTower")
                .setAddress("Poland")
                .setHistory("The Gliwice Radio Tower is 118 m")
                .setHauntingFrom(Calendar.getInstance().getTime());
        houseDao.create(h1);
        assertThat(houseDao.getByAddress("Poland")).isEqualTo(h1);
    }

}