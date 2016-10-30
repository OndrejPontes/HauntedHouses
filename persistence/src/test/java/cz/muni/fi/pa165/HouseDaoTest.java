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
        house =  new House();
        house.setName("SCALA");
        house.setAddress("MORAVAK");
        house.setHistory("Brief history of time");
        house.setHauntingFrom(Calendar.getInstance().getTime());

    }

    @Test
    public void createHouseTest() {
        assertThat(house.getId()).isNull();
        houseDao.create(house);
        assertThat(house.getId()).isNotNull();

    }

    @Test
    public void updateTest(){
        houseDao.create(house);
        houseDao.update(houseDao.getByName("SCALA").setName("MORGAL"));
        assertThat(houseDao.getByName("MORGAL").getName()).isEqualTo("MORGAL");
    }

    @Test
    public void deleteTest(){
        houseDao.create(house);
        houseDao.delete(house);
        assertThat(houseDao.getAll()).hasSize(0);
    }

    @Test
    public void getAllTest(){
        houseDao.create(house);
        assertThat(houseDao.getAll()).hasSize(1);
    }

    @Test
    public void getByNameTest(){
        houseDao.create(house);
        assertThat(houseDao.getByName("SCALA")).isEqualTo(house);
    }

    @Test
    public void getByAdress(){
        houseDao.create(house);
        assertThat(houseDao.getByAddress("MORAVAK")).isEqualTo(house);
    }

}
