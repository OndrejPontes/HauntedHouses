package cz.muni.fi.pa165.facade;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cz.muni.fi.pa165.config.ServiceConfig;
import cz.muni.fi.pa165.dto.AbilityCreateDTO;
import cz.muni.fi.pa165.dto.AbilityDTO;
import cz.muni.fi.pa165.dto.GhostCreateDTO;
import cz.muni.fi.pa165.dto.GhostDTO;

/**
 * @author Jirka Kruml
 */
@Test
@ContextConfiguration(classes = {ServiceConfig.class})
public class GhostFacadeTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private GhostFacade ghostFacade;

    @Autowired
    private AbilityFacade abilityFacade;

    private GhostCreateDTO ghostCreateDTO;
    private GhostDTO ghostDTO;
    private AbilityDTO abilityDTO;

    @BeforeClass
    public void setup() throws ParseException {
        SimpleDateFormat time = new SimpleDateFormat("hh:mm");

        AbilityCreateDTO abilityCreateDTO = new AbilityCreateDTO()
                .setName("ability name")
                .setDescription("ability desc");

        abilityDTO = abilityFacade.create(abilityCreateDTO);

        ghostCreateDTO = new GhostCreateDTO()
                .setName("name")
                .setDescription("desc")
                .setHauntsFrom(time.parse("8:00"))
                .setHauntsTo(time.parse("16:00"))
                .setAbilities(new ArrayList<AbilityDTO>(){{add(abilityDTO);}});

        ghostDTO = ghostFacade.create(ghostCreateDTO);
    }

    @Test
    public void findGhostTest() {
        GhostDTO foundGhost = ghostFacade.getById(ghostDTO.getId());
        assertThat(ghostDTO.equals(foundGhost));
    }

    @Test
    public void updateTest() {
        GhostDTO ghostToUpdate = ghostFacade.create(
                new GhostCreateDTO()
                .setName("Pepa")
                .setDescription("some desc")
                .setHauntsFrom(new Date(0))
                .setHauntsTo(new Date(1))
        );

        ghostToUpdate.setName("a different name")
                .setAbilities(new ArrayList<AbilityDTO>(){{add(abilityDTO);}});

        GhostDTO updateGhost = ghostFacade.update(ghostToUpdate);
        assertThat(ghostToUpdate.equals(updateGhost));
    }

    @Test
    public void deleteByIdTest() {
        GhostDTO ghostToDelete = ghostFacade.create(
                new GhostCreateDTO()
                        .setName("Josef")
                        .setDescription("some desc")
                        .setHauntsFrom(new Date(0))
                        .setHauntsTo(new Date(1))
                        .setAbilities(new ArrayList<AbilityDTO>(){{add(abilityDTO);}})
        );

        Long id = ghostToDelete.getId();
        ghostFacade.delete(ghostToDelete);

        assertThat(ghostFacade.getById(id)).isNull();
    }

    @Test
    public void getAllTest() {
        GhostDTO anotherGhost = ghostFacade.create(
                new GhostCreateDTO()
                        .setName("Jenda")
                        .setDescription("some desc")
                        .setHauntsFrom(new Date(0))
                        .setHauntsTo(new Date(1))
        );

        Collection<GhostDTO> ghosts = ghostFacade.getAll();
        assertThat(ghosts.size() == 2);
        assertThat(ghosts.contains(anotherGhost));
        assertThat(ghosts.contains(ghostDTO));
    }

    @Test
    public void getGhostByNameTest() {
        GhostDTO ghost = ghostFacade.getByName("name");
        assertThat(ghost).isEqualTo(ghostDTO);

        ghost = ghostFacade.getByName("inexisting name");
        assertThat(ghost).isNull();
    }
}
