package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.config.ServiceConfig;
import cz.muni.fi.pa165.dao.AbilityDao;
import cz.muni.fi.pa165.dto.AbilityCreateDTO;
import cz.muni.fi.pa165.dto.AbilityDTO;
import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.services.AbilityService;
import cz.muni.fi.pa165.services.MappingService;
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


    @InjectMocks
    @Autowired
    private AbilityFacade abilityFacade;

    @Mock
    private AbilityService abilityService;

    @Autowired
    private MappingService mapper;

    @BeforeClass
    public void init() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }

    private AbilityCreateDTO abilityCreateDto;
    private AbilityDTO abilityDTO;
    private Ability ability1;
    private Ability ability2;


    @BeforeMethod
    public void setUp(){

        ability1 = new Ability()
                .setName("Invisibility")
                .setDescription("The power that causes the ghost to become completely transparent to all forms of vision.");

        ability2 = new Ability()
                .setName("Overshadowing")
                .setDescription("The power to take over another body");

        abilityCreateDto = mapper.mapObject(ability1, AbilityCreateDTO.class);
        abilityDTO = mapper.mapObject(ability1, AbilityDTO.class);

    }

    @Test
    public void testCreate(){
        abilityFacade.create(abilityCreateDto);
        verify(abilityService).create(ability1);
    }

    @Test
    public void testDelete(){
        abilityFacade.delete(abilityDTO);
        verify(abilityService).delete(ability1);
    }

    @Test
    public void testUpdate(){
        abilityFacade.update(abilityDTO);
        verify(abilityService).update(ability1);
    }

    @Test
    public void testGetById() {
        when(abilityService.getById(1L)).thenReturn(ability1);
        assertThat(ability1.getName()).isEqualTo(abilityFacade.getById(1L).getName());
        assertThat(ability1.getDescription()).isEqualTo(abilityFacade.getById(1L).getDescription());
    }

    @Test
    public void testGetByName(){
        when(abilityService.getByName("Overshadowing")).thenReturn(ability2);
        assertThat(ability2.getDescription()).isEqualTo(abilityFacade.getByName("Overshadowing").getDescription());
    }

    @Test
    public void testGetAll(){
        List<Ability> expected = new ArrayList<>();
        expected.add(ability1);
        expected.add(ability2);

        when(abilityService.getAll()).thenReturn(expected);

        List<AbilityDTO> actual = new ArrayList<>();
        actual.addAll(abilityFacade.getAll());

        assertThat(actual).hasSize(2);
        assertThat(mapper.mapCollection(expected, AbilityDTO.class)).isEqualTo(actual);
    }





}
