package cz.muni.fi.pa165;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
import cz.muni.fi.pa165.dao.GhostDao;
import cz.muni.fi.pa165.dao.HouseDao;
import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.House;

/**
 * @author Jirka Kruml
 */

@ContextConfiguration(classes = PersistenceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class GhostDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private GhostDao ghostDao;

    @Autowired
    private HouseDao houseDao;

    @Autowired
    private AbilityDao abilityDao;

    private Ghost ghost;
    private Ghost ghost2;

    @BeforeMethod
    public void init() throws ParseException {
        SimpleDateFormat time = new SimpleDateFormat("hh:mm");
        SimpleDateFormat date = new SimpleDateFormat("dd-mm-yyyy");

        House house = new House("Dreamhouse",
                "Dream Street n.2",
                date.parse("29-10-2016"),
                null);

        houseDao.create(house);

        List<Ability> abilities = new ArrayList<>();
        Ability ability = new Ability("Overshadowing", "The power to take over another body");
        abilityDao.create(ability);
        abilities.add(ability);

        ghost = new Ghost();
        ghost.setName("Pepa")
                .setDescription("Just a regular ghost.")
                .setHauntsFrom(time.parse("08:00"))
                .setHauntsTo(time.parse("16:00"))
                .setHauntedHouse(house)
                .setAbilities(abilities);

        ghost2 = new Ghost();
        ghost2.setName("Karel")
                .setDescription("Just a context-free ghost.")
                .setHauntsFrom(time.parse("09:00"))
                .setHauntsTo(time.parse("15:00"))
                .setHauntedHouse(house)
                .setAbilities(abilities);
    }


    @Test
    public void createGhostTest() {
        assertThat(ghost.getId()).isNull();
        ghostDao.create(ghost);
        assertThat(ghost.getId()).isNotNull();
    }

    @Test
    public void deleteGhostTest() {
        ghostDao.create(ghost);
        ghostDao.delete(ghost);

        assertThat(ghostDao.getByName("Pepa").size()).isEqualTo(0);
    }

    @Test
    public void getByNameTest() {
        ghostDao.create(ghost);
        List<Ghost> ghosts = ghostDao.getByName("Pepa");
        assertThat(ghosts.size()).isEqualTo(1);
        assertThat(ghostDao.getByName("Pepa").get(0)).isEqualTo(ghost);
    }

    @Test
    public void updateGhostTest() {
        ghostDao.create(ghost);
        Ghost updated = ghostDao.update(ghost.setName("Pepik"));
        assertThat(updated.getName()).isEqualTo("Pepik");
    }

    @Test
    public void getByIdTest() {
        ghostDao.create(ghost);
        assertThat(ghostDao.getById(ghost.getId())).isEqualTo(ghost);
    }

    @Test(expectedExceptions = PersistenceException.class)
    public void nameCannotBeNull() {
        ghost.setName(null);
        ghostDao.create(ghost);
    }

    @Test(expectedExceptions = PersistenceException.class)
    public void descriptionCannotBeNull() {
        ghost.setDescription(null);
        ghostDao.create(ghost);
    }

    @Test(expectedExceptions = PersistenceException.class)
    public void hauntingFromCannotBeNull() {
        ghost.setHauntsFrom(null);
        ghostDao.create(ghost);
    }

    @Test(expectedExceptions = PersistenceException.class)
    public void hauntingToCannotBeNull() {
        ghost.setHauntsTo(null);
        ghostDao.create(ghost);
    }

    @Test
    public void getAllTest() {
        ghostDao.create(ghost);
        ghostDao.create(ghost2);
        List<Ghost> all = ghostDao.getAll();

        assertThat(all.size()).isEqualTo(2);
        assertThat(all.contains(ghost));
        assertThat(all.contains(ghost2));
    }
}
