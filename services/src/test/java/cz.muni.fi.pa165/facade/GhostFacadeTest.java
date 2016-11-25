package cz.muni.fi.pa165.facade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cz.muni.fi.pa165.config.ServiceConfig;
import cz.muni.fi.pa165.dto.GhostCreateDTO;
import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.dto.HouseCreateDTO;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Jirka Kruml
 */
@Test
@ContextConfiguration(classes = {ServiceConfig.class})
public class GhostFacadeTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private GhostFacade ghostFacade;

    @Autowired
    private HouseFacade houseFacade;

    @Autowired
    private AbilityFacade abilityFacade;

    private GhostCreateDTO ghostCreateDTO;
    private GhostDTO ghostDTO;

    @BeforeClass
    public void setup() throws ParseException {
        SimpleDateFormat time = new SimpleDateFormat("hh:mm");

        HouseCreateDTO houseCreateDTO = new HouseCreateDTO()
                .setName("house")
                .setAddress("somewhere");

//        AbilityCreateDTO abilityCreateDTO = new AbilityCreateDTO()
//                .setName("abilityname")
//                .setDescription("abiltiy desc");

//        AbilityDTO abilityDTO = abilityFacade.create(abilityCreateDTO);

        ghostCreateDTO = new GhostCreateDTO()
                .setName("name")
                .setDescription("desc")
                .setHauntsFrom(time.parse("8:00"))
                .setHauntsTo(time.parse("16:00"));
//                .setAbilities(new ArrayList<Long>(){{add(abilityDTO.getId());}});
        ghostDTO = ghostFacade.createGhost(ghostCreateDTO);
    }

    @Test
    public void findGhostTest() {
        GhostDTO foundGhost = ghostFacade.getGhostById(ghostDTO.getId());
        assertThat(ghostDTO.equals(foundGhost));
    }

    @Test
    public void updateTest() {
        GhostDTO ghostToUpdate = ghostFacade.createGhost(
                new GhostCreateDTO()
                .setName("some name")
                .setDescription("some desc")
                .setHauntsFrom(new Date(0))
                .setHauntsTo(new Date(1))
        );

        ghostToUpdate.setName("a different name");

        GhostDTO updateGhost = ghostFacade.updateGhost(ghostToUpdate);
        assertThat(ghostToUpdate.equals(updateGhost));
    }

    @Test
    public void deleteByIdTest() {
        GhostDTO ghostToDelete = ghostFacade.createGhost(
                new GhostCreateDTO()
                        .setName("some name")
                        .setDescription("some desc")
                        .setHauntsFrom(new Date(0))
                        .setHauntsTo(new Date(1))
        );

        Long id = ghostToDelete.getId();
        ghostFacade.deleteGhost(ghostToDelete);

        assertThat(ghostFacade.getGhostById(id) == null);
    }

    @Test
    public void getAllTest() {
        GhostDTO anotherGhost = ghostFacade.createGhost(
                new GhostCreateDTO()
                        .setName("some name")
                        .setDescription("some desc")
                        .setHauntsFrom(new Date(0))
                        .setHauntsTo(new Date(1))
        );

        Collection<GhostDTO> ghosts = ghostFacade.getAllGhosts();
        assertThat(ghosts.size() == 2);
        assertThat(ghosts.contains(anotherGhost));
        assertThat(ghosts.contains(ghostDTO));
    }

    @Test
    public void getGhostByNameTest() {
        Collection<GhostDTO> ghosts = ghostFacade.getGhostsByName("name");
        assertThat(ghosts.contains(ghostDTO));
        assertThat(ghosts.size() == 1);

        ghosts = ghostFacade.getGhostsByName("inexisting name");
        assertThat(ghosts.isEmpty());
    }
}
