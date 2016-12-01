package cz.muni.fi.pa165;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cz.muni.fi.pa165.dao.AbilityDao;
import cz.muni.fi.pa165.entity.Ability;


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

        ability2.setName("Flying")
                .setDescription("The power to defy gravity, and propel themselves through the air. " +
                        "Flight is one of the most basic powers. Most ghosts (if not all) can fly or float.");

        ability3.setName("Invisibility")
                .setDescription("The power that causes the ghost to become completely transparent to all forms of vision.");

        ability4.setName("Intangibility")
                .setDescription("The power to phase through all forms of matter, but not always energy.");

        abilityDao.create(ability1);
        abilityDao.create(ability2);
        abilityDao.create(ability3);
        abilityDao.create(ability4);
    }


    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createNullParam() {
        abilityDao.create(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void updateNullParam() {
        abilityDao.update(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void deleteNullParam() {
        abilityDao.delete(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void getByNameNullParam() {
        abilityDao.getByName(null);
    }

    @Test(expectedExceptions = PersistenceException.class)
    public void nullAbilityNameNotAllowed() {
        Ability ability = new Ability();
        ability.setName(null);
        abilityDao.create(ability);
    }


    @Test(expectedExceptions = PersistenceException.class)
    public void nameHasToBeUnique() {
        Ability ability = new Ability();
        ability.setName("Flying")
            .setDescription("The power to defy gravity, and propel themselves through the air. " +
                    "Flight is one of the most basic powers. Most ghosts (if not all) can fly or float.");
        abilityDao.create(ability);
    }

    @Test()
    public void createAbility() {
        Ability ability = new Ability();
        ability.setName("Duplication")
                .setDescription("The ability of a ghost to make exact copies of themself, each possessing its personality and powers.");
        assertThat(ability.getId()).isNull();
        abilityDao.create(ability);
        assertThat(ability.getId()).isNotNull();
        assertThat(abilityDao.getById(ability.getId())).hasFieldOrPropertyWithValue("name", "Duplication");
    }

    @Test()
    public void deleteAbility() {
        assertThat(abilityDao.getById(ability1.getId())).isNotNull();
        abilityDao.delete(ability1);
        assertThat(abilityDao.getById(ability1.getId())).isNull();
    }

    @Test
    public void updateAbility() {
        ability1.setName("Shadowing");
        abilityDao.update(ability1);
        assertThat(abilityDao.getById(ability1.getId())).hasFieldOrPropertyWithValue("name", "Shadowing");
    }

    @Test
    public void findAllAbilities() {
        List<Ability> allAbilities = abilityDao.getAll();
        assertThat(allAbilities).hasSize(4);
        assertThat(allAbilities).contains(ability1);
        assertThat(allAbilities).contains(ability2);
        assertThat(allAbilities).contains(ability3);
        assertThat(allAbilities).contains(ability4);
    }

    @Test
    public void findAbilityById() {
        Ability ability = abilityDao.getById(ability1.getId());
        assertThat(ability).hasFieldOrPropertyWithValue("name", "Overshadowing");
        assertThat(ability).hasFieldOrPropertyWithValue("description", "The power to take over another body");

        Ability ability2 = abilityDao.getById(-3L);
        assertThat(ability2).isNull();

    }

    @Test
    public void findAbilityByName() {
        assertThat(abilityDao.getByName("hhh")).isNull();

        Ability abilityFlying = abilityDao.getByName("Flying");
        assertThat(abilityFlying).isEqualTo(ability2);
    }


}
