package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.config.ServiceConfig;
import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.dto.HauntingCreateDTO;
import cz.muni.fi.pa165.dto.HauntingDTO;
import cz.muni.fi.pa165.dto.HouseDTO;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.services.HauntingService;
import cz.muni.fi.pa165.services.MappingService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.util.Calendar.FEBRUARY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author opontes
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class})
public class HauntingFacadeTest extends AbstractTestNGSpringContextTests {

    @InjectMocks
    private HauntingFacade hauntingFacade = new HauntingFacadeImpl();

    @Mock
    private HauntingService hauntingService;

    @Mock
    private MappingService mappingService;

    @Mock
    private HauntingCreateDTO hauntingCreateDTO;

    @Mock
    private Haunting haunting;

    @Mock
    private List<Haunting> hauntings;

    @Mock
    private HouseDTO houseDTO;

    @Mock
    private GhostDTO ghostDTO;

    private Calendar calendar;
    private HauntingDTO hauntingDTO;
    private List<HauntingDTO> hauntingDTOs;


    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        calendar = Calendar.getInstance();
        calendar.set(2016, FEBRUARY, 20);

        hauntingDTO = new HauntingDTO()
                .setNumberOfPeoplePresent(4)
                .setDate(calendar.getTime())
                .setHauntedHouse(houseDTO)
                .setGhosts(new ArrayList<GhostDTO>() {{
                    add(ghostDTO);
                }});

        hauntingDTOs = new ArrayList<>();
        hauntingDTOs.add(hauntingDTO);

        when(mappingService.mapObject(hauntingCreateDTO, Haunting.class)).thenReturn(haunting);
        when(mappingService.mapObject(hauntingDTO, Haunting.class)).thenReturn(haunting);
        when(mappingService.mapObject(haunting, HauntingDTO.class)).thenReturn(hauntingDTO);
        when(mappingService.mapCollection(hauntings, HauntingDTO.class)).thenReturn(hauntingDTOs);

        when(hauntingService.getById(1L)).thenReturn(haunting);
        when(hauntingService.create(haunting)).thenReturn(haunting);
        when(hauntingService.getByDate(calendar.getTime())).thenReturn(hauntings);
        when(hauntingService.getAll()).thenReturn(hauntings);
        when(hauntingService.update(haunting)).thenReturn(haunting);
    }

    @Test
    public void testCreate() {
        assertThat(hauntingFacade.create(hauntingCreateDTO)).isEqualTo(hauntingDTO);
        verify(hauntingService).create(haunting);
    }

    @Test
    public void testGetById() {
        assertThat(hauntingFacade.getById(1L)).isEqualTo(hauntingDTO);
        verify(hauntingService).getById(1L);
    }

    @Test
    public void testGetByDate() {
        assertThat(hauntingFacade.getByDate(calendar.getTime())).isEqualTo(hauntingDTOs);
        verify(hauntingService).getByDate(calendar.getTime());
    }

    @Test
    public void testGetAll() {
        assertThat(hauntingFacade.getAll()).isEqualTo(hauntingDTOs);
        verify(hauntingService).getAll();
    }

    @Test
    public void testUpdate() {
        hauntingDTO.setNumberOfPeoplePresent(5);
        hauntingFacade.update(hauntingDTO);
        assertThat(hauntingFacade.getById(1L)).isEqualTo(hauntingDTO);
        verify(hauntingService).update(haunting);
    }

    @Test
    public void testDelete() {
        hauntingFacade.delete(hauntingDTO);
        verify(hauntingService).remove(haunting);
    }
}
