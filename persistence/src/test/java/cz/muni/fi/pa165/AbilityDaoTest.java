package cz.muni.fi.pa165;

import cz.muni.fi.pa165.dao.AbilityDao;
import cz.muni.fi.pa165.entity.Ability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


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


    @Test(expectedExceptions = PersistenceException.class)
    public void nullAbilityNameNotAllowed() {
        Ability ability = new Ability();
        ability.setName(null);
        abilityDao.create(ability);
    }

    @Test(expectedExceptions = DataAccessException.class)
    public void nameHasToBeUnique() {
        Ability ability = new Ability();
        ability.setName("Flying");
        abilityDao.create(ability);
    }

    @Test()
    public void createAbility() {
        Ability ability = new Ability();
        ability.setName("Duplication");
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
    }

    @Test
    public void findAbilityByName() {
        assertThat(abilityDao.getByName("hhh")).isNull();

        Ability abilityFlying = abilityDao.getByName("Flying");
        assertThat(abilityFlying).isEqualTo(ability2);
    }


}
