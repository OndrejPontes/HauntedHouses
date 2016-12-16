package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.config.ServiceConfig;
import cz.muni.fi.pa165.dao.AbilityDao;
import cz.muni.fi.pa165.dto.AbilityCreateDTO;
import cz.muni.fi.pa165.dto.AbilityDTO;
import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.services.AbilityService;
import cz.muni.fi.pa165.services.MappingService;
import org.hibernate.service.spi.ServiceException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.mockito.runners.MockitoJUnitRunner;
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

@Test
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class})
public class AbilityFacadeTest extends AbstractTestNGSpringContextTests {


    @InjectMocks
    private final AbilityFacade abilityFacade = new AbilityFacadeImpl();

    @Mock
    private AbilityService abilityService;

    @Mock
    private MappingService mappingService;

    private AbilityCreateDTO abilityCreateDto;
    private AbilityDTO abilityDTO;
    private Ability ability;
    private List<Ability> abilities;
    private List<AbilityDTO> abilitiesDto = new ArrayList<>();;


    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void initData(){

        abilityDTO = new AbilityDTO()
                .setName("Invisibility")
                .setDescription("The power that causes the ghost to become completely transparent to all forms of vision.");


        when(mappingService.mapObject(abilityCreateDto, Ability.class)).thenReturn(ability);
        when(mappingService.mapObject(abilityDTO, Ability.class)).thenReturn(ability);
        when(mappingService.mapObject(ability, AbilityDTO.class)).thenReturn(abilityDTO);
        when(mappingService.mapCollection(abilities, AbilityDTO.class)).thenReturn(abilitiesDto);

        when(abilityService.create(ability)).thenReturn(ability);
        when(abilityService.update(ability)).thenReturn(ability);
        when(abilityService.getById(1L)).thenReturn(ability);
        when(abilityService.getByName("Invisibility")).thenReturn(ability);
        when(abilityService.getAll()).thenReturn(abilities);

    }

    @Test
    public void testCreate(){
        assertThat(abilityFacade.create(abilityCreateDto)).isEqualTo(abilityDTO);
        verify(abilityService).create(ability);
    }

    @Test
    public void testDelete(){
        abilityFacade.delete(abilityDTO);
        verify(abilityService).delete(ability);
    }

    @Test
    public void testUpdate(){
        abilityDTO.setName("Total invisibility");
        abilityFacade.update(abilityDTO);
        assertThat(abilityFacade.getById(1L)).isEqualTo(abilityDTO);
        verify(abilityService).update(ability);
    }

    @Test
    public void testGetById() {
        assertThat(abilityFacade.getById(1L)).isEqualTo(abilityDTO);
        verify(abilityService).getById(1L);
    }

    @Test
    public void testGetByName(){
        assertThat(abilityFacade.getByName("Invisibility")).isEqualTo(abilityDTO);
        verify(abilityService).getByName("Invisibility");
    }

    @Test
    public void testGetAll(){
        assertThat(abilityFacade.getAll()).isEqualTo(abilitiesDto);
        verify(abilityService).getAll();
    }





}
