package cz.muni.fi.pa165.facade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cz.muni.fi.pa165.config.ServiceConfig;
import cz.muni.fi.pa165.dto.AbilityCreateDTO;
import cz.muni.fi.pa165.dto.AbilityDTO;
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

    @BeforeMethod
    public void setup() throws ParseException {
        SimpleDateFormat time = new SimpleDateFormat("hh:mm");

        HouseCreateDTO houseCreateDTO = new HouseCreateDTO()
                .setName("house")
                .setAddress("somewhere");

        AbilityCreateDTO abilityCreateDTO = new AbilityCreateDTO()
                .setName("abilityname")
                .setDescription("abiltiy desc");

        AbilityDTO abilityDTO = abilityFacade.create(abilityCreateDTO);

        ghostCreateDTO = new GhostCreateDTO()
                .setName("name")
                .setDescription("desc")
                .setHauntsFrom(time.parse("8:00"))
                .setHauntsTo(time.parse("16:00"))
                .setAbilities(new ArrayList<Long>(){{add(abilityDTO.getId());}});
        ghostDTO = ghostFacade.createGhost(ghostCreateDTO);
    }

    @Test
    public void findGhostTest() {
        GhostDTO foundGhost = ghostFacade.getGhostById(ghostDTO.getId());
        assertThat(ghostDTO.equals(foundGhost));
    }

    @Test
    public void updateTest() {
        AbilityDTO abilityDTO = abilityFacade.create(
                new AbilityCreateDTO()
                .setDescription("desc 2")
                .setName("ability 2")
        );
        ghostDTO.setName("othername")
                .setAbilities(new ArrayList<Long>() {{ add( abilityDTO.getId()); }});

        GhostDTO updateGhost = ghostFacade.updateGhost(ghostDTO);
        assertThat(ghostDTO.equals(updateGhost));
    }

    @Test
    public void deleteByIdTest() {
        Long id = ghostDTO.getId();
        ghostFacade.getGhostById(id);

        assertThat(ghostFacade.getGhostById(id) == null);
    }

    @Test
    public void getAllTest() {
        ghostCreateDTO.setName("ghost 2")
                .setAbilities(null)
                .setDescription("desc 2");
        GhostDTO createdGhost = ghostFacade.createGhost(ghostCreateDTO);
        Collection<GhostDTO> ghosts = ghostFacade.getAllGhosts();
        assertThat(ghosts.size() == 2);
        assertThat(ghosts.contains(createdGhost));
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
