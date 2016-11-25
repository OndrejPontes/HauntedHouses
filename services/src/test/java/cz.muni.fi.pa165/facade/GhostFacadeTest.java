package cz.muni.fi.pa165.facade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
import cz.muni.fi.pa165.dto.HouseCreateDTO;
import cz.muni.fi.pa165.dto.HouseDTO;

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

        HouseDTO house = houseFacade.create(houseCreateDTO);

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
    }

    @Test
    public void createAndFindGhostTest() {
        GhostDTO createdGhost = ghostFacade.createGhost(ghostCreateDTO);
        GhostDTO foundGhost = ghostFacade.getGhostById(createdGhost.getId());
        assertThat(createdGhost.equals(foundGhost));
    }
}
