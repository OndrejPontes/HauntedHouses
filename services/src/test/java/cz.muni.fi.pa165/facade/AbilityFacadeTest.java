package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.config.ServiceConfig;
import cz.muni.fi.pa165.dao.AbilityDao;
import cz.muni.fi.pa165.dto.AbilityCreateDTO;
import cz.muni.fi.pa165.dto.AbilityDTO;
import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.services.AbilityService;
import cz.muni.fi.pa165.services.MappingService;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.osgi.framework.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.util.Calendar.NOVEMBER;
import static java.util.Calendar.OCTOBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author MonikaMociarikova
 */

@ContextConfiguration(classes = {ServiceConfig.class})
//@RunWith(MockitoJUnitRunner.class)
public class AbilityFacadeTest extends AbstractTestNGSpringContextTests {


    @Autowired
    @InjectMocks
    private AbilityFacade abilityFacade;

    @Mock
    @Autowired
    private AbilityService abilityService;

    @Autowired
    private MappingService mapper;

    private Ability ability1;
    private Ability ability2;
    private List<Ability> abilities;
    private List<AbilityDTO> abilitiesDTO;
    private AbilityDTO abilityDTO;
    private AbilityDTO abilityDTO2;
    private AbilityCreateDTO abilityCreateDTO;

    @BeforeClass
    public void setUp(){

        MockitoAnnotations.initMocks(this);

        ability1 = new Ability()
                .setName("Invisibility")
                .setDescription("The power that causes the ghost to become completely transparent to all forms of vision.");

        ability2 = new Ability()
                .setName("Overshadowing")
                .setDescription("The power to take over another body");

        abilityDTO = mapper.mapObject(ability1, AbilityDTO.class);
        abilityDTO2 = mapper.mapObject(ability2, AbilityDTO.class);
        abilityCreateDTO = mapper.mapObject(ability1, AbilityCreateDTO.class);

        abilities = new ArrayList<>();
        abilities.add(ability1);
        abilities.add(ability2);

        abilitiesDTO = new ArrayList<>();
        abilitiesDTO.add(abilityDTO);
        abilitiesDTO.add(abilityDTO2);

        when(abilityService.getById(1L)).thenReturn(ability1);
        when(abilityService.getByName("Invisibility")).thenReturn(ability1);
        when(abilityService.getAll()).thenReturn(abilities);
        when(abilityService.update(ability1)).thenReturn(ability1);
    }


    @Test
    public void testCreate(){
        Assertions.assertThat(abilityFacade.create(abilityCreateDTO).equals(abilityDTO));
    }

    @Test
    public void testGetById() {
        Assertions.assertThat(abilityFacade.getById(1L).equals(abilityDTO));
    }

    @Test
    public void testGetByName(){
        Assertions.assertThat(abilityFacade.getByName("Invisibility").equals(abilityDTO));
    }

    @Test
    public void testGetAll(){
        Assertions.assertThat(abilityFacade.getAll().equals(abilitiesDTO));
    }

}
