package cz.muni.fi.pa165;

import cz.muni.fi.pa165.dao.AbilityDao;
import cz.muni.fi.pa165.entity.Ability;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


/**
 * @author Monika Mociarikova
 */

@ContextConfiguration(classes = PersistenceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class AbilityDaoTest extends AbstractTestNGSpringContextTests {

    @PersistenceContext
    public EntityManager em;

    @Autowired
    public AbilityDao abilityDao;


    private Ability ability1;
    private Ability ability2;
    private Ability ability3;
    private Ability ability4;

    @BeforeMethod
    public void createAbilities() {
        ability1 = new Ability();
        ability2 = new Ability();
        ability3 = new Ability();
        ability4 = new Ability();

        ability1.setName("Overshadowing");
        ability1.setDescription("The power to take over another body");
        ability2.setName("Flying");
        ability3.setName("Invisibility");
        ability4.setName("Intangibility");

        abilityDao.create(ability1);
        abilityDao.create(ability2);
        abilityDao.create(ability3);
        abilityDao.create(ability4);
    }


    @Test(expectedExceptions=ConstraintViolationException.class)
    public void testNullAbilityNameNotAllowed(){
        Ability ability = new Ability();
        ability.setName(null);
        abilityDao.create(ability);
    }

    @Test(expectedExceptions=DataAccessException.class)
    public void testNameIsUnique(){
        Ability ability = new Ability();
        ability.setName("Flying");
        abilityDao.create(ability);
    }

    @Test()
    public void testCreate(){
        Ability ability = new Ability();
        ability.setName("Duplication");
        abilityDao.create(ability);
        Assert.assertEquals(abilityDao.findById(ability.getId()).getName(),"Duplication");
    }

    @Test()
    public void testDelete(){
        Assert.assertNotNull(abilityDao.findById(ability1.getId()));
        abilityDao.delete(ability1);
        Assert.assertNull(abilityDao.findById(ability1.getId()));
    }

    @Test
    public void testUpdate(){
        ability1.setName("Shadowing");
        abilityDao.update(ability1);
        Assert.assertEquals(abilityDao.findById(ability1.getId()).getName(),"Shadowing");
    }

    @Test
    public void testFindAll() {
        List<Ability> allAbilities = abilityDao.findAll();
        Assert.assertEquals(allAbilities.size(), 4);
    }

    @Test
    public void testFindById() {
        Ability ability = abilityDao.findById(ability1.getId());
        Assert.assertEquals(ability.getName(), "Overshadowing");
        Assert.assertEquals(ability.getDescription(), "The power to take over another body");
    }

    @Test
    public void testFindByName() {
        Assert.assertEquals(abilityDao.findByName("ity").size(), 2);
        Assert.assertEquals(abilityDao.findByName("hhh").size(), 0);
        Assert.assertEquals(abilityDao.findByName("Flying").size(), 1);
    }

}
