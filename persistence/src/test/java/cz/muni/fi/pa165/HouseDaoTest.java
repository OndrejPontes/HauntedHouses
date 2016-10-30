package cz.muni.fi.pa165;

import cz.muni.fi.pa165.dao.HouseDao;
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
    public HouseDao houseDao;

    private House h1;
    private House h2;


    @BeforeMethod
    public void createHouses() {

        h1 = new House();
        h2 = new House();
        h1.setName("SCALA");
        h2.setName("MORGAL");


    }
    @Test
    public void createHouseTest() {
        assertThat(h1.getId()).isNull();
        houseDao.create(h1);
        assertThat(h1.getId()).isNotNull();
    }

    @Test
    public void deleteHouseTest() {
        houseDao.create(h1);
        houseDao.delete(h1);

        assertThat(houseDao.getByName("SCALA")).isNull();
    }

    @Test
    public void getByNameTest() {
        houseDao.create(h1);
        assertThat(houseDao.getByName("SCALA")).isEqualTo(h1);
    }

    @Test
    public void updateHouseTest() {
        houseDao.create(h1);
        House h = houseDao.update(h1.setAddress("MORAVAK"));
        assertThat(houseDao.getByAddress("MORAVAK")).isEqualTo(h);
    }

    @Test
    public void getAllTest() {
        houseDao.create(h1);
        houseDao.create(h2);

        List<House> all = houseDao.getAll();

        assertThat(all.size()).isEqualTo(2);
        assertThat(all.contains(h1));
        assertThat(all.contains(h2));

    }

    @Test
    public void getByAdressTest(){
        h1.setAddress("MORAVAK");
        houseDao.create(h1);
        assertThat(houseDao.getByAddress("MORAVAK")).isEqualTo(h1);
    }

}
