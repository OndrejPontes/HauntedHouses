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

    @Autowired
    private AbilityDao abilityDao;

    @Autowired
    private GhostDao ghostDao;

    @Autowired
    private HauntingDao hauntingDao;

    private House house;


    @BeforeMethod
    public void createHouses() {
//        Ability a1 = new Ability("Shadowing", "super skill by ghost ltc.");
//        abilityDao.create(a1);
//
//        Calendar from = Calendar.getInstance();
//        from.set(2016, Calendar.OCTOBER, 01);
//        Calendar to = Calendar.getInstance();
//        to.set(2016, Calendar.OCTOBER, 30);
//
//        Ghost g1 = new Ghost("G1", from.getTime(), to.getTime(), "uz mi z toho strasi v kebuli");
//
//        List<Ability> abilityList = new ArrayList<>();
//        abilityList.add(a1);
//        g1.setAbilities(abilityList);
//
//        List<Ghost> ghostList = new ArrayList<>();
//        ghostList.add(g1);
//
//        ghostDao.create(g1);
//
//        Haunting haunting = new Haunting(from.getTime(),1);
//        haunting.setGhosts(ghostList);
//        haunting.setHauntedHouse(house);
//
//        hauntingDao.create(haunting);
//
//        List<Haunting> hauntingList = new ArrayList<>();
//        hauntingList.add(haunting);


        house =  new House();
        house.setName("SCALA");
        house.setAddress("MORAVAK");
//        house.setHauntingFrom(from.getTime());
//        house.setHauntings(hauntingList);
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

//    @Test
//    public void getByNameTest(){
//        houseDao.create(house);
//        assertThat(houseDao.getByName("SCALA").getName()).isEqualTo("SCALA");
//    }




}
