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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
@ContextConfiguration(classes = {ServiceConfig.class})
public class AbilityFacadeTest extends AbstractTestNGSpringContextTests {

    @Mock
    private AbilityDao abilityDao;

    @Autowired
    private final AbilityFacade abilityFacade = new AbilityFacadeImpl();

    @InjectMocks
    @Autowired
    private AbilityService abilityService;

    @Autowired
    private MappingService mapper;

    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }

    private AbilityCreateDTO abilityCreateDto;
    private AbilityDTO abilityDTO;
    private Ability ability1;
    private Ability ability2;


//    @BeforeMethod
//    public void initData(){
//
//        ability1 = new Ability()
//                .setName("Invisibility")
//                .setDescription("The power that causes the ghost to become completely transparent to all forms of vision.");
//
//        ability2 = new Ability()
//                .setName("Overshadowing")
//                .setDescription("The power to take over another body");
//
//        abilityCreateDto = mapper.mapObject(ability1, AbilityCreateDTO.class);
//        abilityDTO = mapper.mapObject(ability1, AbilityDTO.class);
//
//    }
//
////    @Test
//    public void testCreate(){
//        abilityFacade.create(abilityCreateDto);
//        verify(abilityDao).create(ability1);
//    }
//
////    @Test
//    public void testDelete(){
//        abilityFacade.delete(abilityDTO);
//        verify(abilityDao).delete(ability1);
//    }
//
////    @Test
//    public void testUpdate(){
//        abilityFacade.update(abilityDTO);
//        verify(abilityDao).update(ability1);
//    }
//
////    @Test
//    public void testGetById() {
//        when(abilityDao.getById(1)).thenReturn(ability1);
//        assertThat(ability1.getName()).isEqualTo(abilityFacade.getById(1L).getName());
//        assertThat(ability1.getDescription()).isEqualTo(abilityFacade.getById(1L).getDescription());
//    }
//
//    @Test
//    public void testGetByName(){
//        when(abilityDao.getByName("Overshadowing")).thenReturn(ability2);
//        assertThat(ability2.getDescription()).isEqualTo(abilityFacade.getByName("Overshadowing").getDescription());
//    }
//
////    @Test
//    public void testGetAll(){
//        List<Ability> expected = new ArrayList<>();
//        expected.add(ability1);
//        expected.add(ability2);
//
//        List<AbilityDTO> actual = new ArrayList<>();
//        actual.addAll(abilityFacade.getAll());
//
//        assertThat(actual).hasSize(2);
//        assertThat(mapper.mapCollection(expected, AbilityDTO.class)).isEqualTo(actual);
//    }





}
