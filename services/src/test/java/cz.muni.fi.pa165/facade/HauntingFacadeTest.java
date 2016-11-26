package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.config.ServiceConfig;
import cz.muni.fi.pa165.dto.*;
import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.entity.House;
import cz.muni.fi.pa165.services.GhostService;
import cz.muni.fi.pa165.services.HauntingService;
import cz.muni.fi.pa165.services.HouseService;
import cz.muni.fi.pa165.services.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeClass;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.util.Calendar.*;
import static org.mockito.Mockito.when;

/**
 * @author opontes
 */
//@Test
@ContextConfiguration(classes = {ServiceConfig.class})
public class HauntingFacadeTest extends AbstractTestNGSpringContextTests {
    @Mock
    private GhostService ghostService;

    @Mock
    private HouseService houseService;

    @Mock
    private HauntingService hauntingService;

    @Autowired
    private MappingService mappingService;

    @InjectMocks
    private final HauntingFacade hauntingFacade = new HauntingFacadeImpl();

    private House house1;

    private House house2;

    private Ghost ghost1;
    private Ghost ghost2;

    private GhostDTO ghostDTO1;
    private GhostDTO ghostDTO2;
    private GhostDTO ghostDTO3;
    private HouseDTO houseDTO1;
    private HouseDTO houseDTO2;

    @Mock
    private Haunting haunting;
    @Mock
    private Haunting haunting1;
    @Mock
    private Haunting haunting2;
    @Mock
    private HauntingDTO hauntingDTO1;
    @Mock
    private HauntingDTO hauntingDTO2;
    @Mock
    private Haunting updateHaunting;
    @Mock
    private HauntingDTO updateHauntingDTO;
    @Mock
    private HauntingCreateDTO hauntingCreateDTO;

    private Calendar calendar;

    @BeforeClass
    public void setup() {
        MockitoAnnotations.initMocks(this);

        calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        calendar1.set(2016,OCTOBER,27);
        calendar2.set(2016, OCTOBER,28);
        ghostDTO1 = new GhostDTO()
                .setName("John")
                .setDescription("Attractive ghost1")
                .setHauntsFrom(calendar1.getTime())
                .setHauntsTo(calendar2.getTime());

        calendar1.set(2016,NOVEMBER,2);
        calendar2.set(2016, NOVEMBER,3);
        ghostDTO2 = new GhostDTO()
                .setName("Hans")
                .setDescription("Bad ghost1")
                .setHauntsFrom(calendar1.getTime())
                .setHauntsTo(calendar2.getTime());

        calendar1.set(2016,DECEMBER,12);
        calendar2.set(2016, DECEMBER,13);
        ghostDTO3 = new GhostDTO()
                .setName("Luis")
                .setDescription("Angry ghost1")
                .setHauntsFrom(calendar1.getTime())
                .setHauntsTo(calendar2.getTime());

        houseDTO1 = new HouseDTO()
                .setName("Lucky Hotel")
                .setAddress("Kounicova DC")
                .setHistory("Some history");

        houseDTO2 = new HouseDTO()
                .setName("Train station")
                .setAddress("Silicon valley");

        calendar1.set(2016, JANUARY, 22);
        haunting = new Haunting()
                .setId(1L)
                .setNumberOfPeoplePresent(3)
                .setDate(calendar1.getTime())
                .setHauntedHouse(house1)
                .setGhosts(new ArrayList<Ghost>() {{
                    add(ghost1);
                }});


        List<Long> ghosts = new ArrayList<>();
        haunting.getGhosts().forEach(ghost -> ghosts.add(ghost.getId()));

        hauntingDTO1 = new HauntingDTO()
                .setId(haunting.getId())
                .setNumberOfPeoplePresent(haunting.getNumberOfPeoplePresent())
                .setDate(haunting.getDate())
                .setHauntedHouse(haunting.getHauntedHouse().getId())
                .setGhosts(ghosts);

        hauntingCreateDTO = new HauntingCreateDTO()
                .setDate(hauntingDTO1.getDate())
                .setNumberOfPeoplePresent(hauntingDTO1.getNumberOfPeoplePresent())
                .setHouse(hauntingDTO1.getHauntedHouse())
                .setGhosts(hauntingDTO1.getGhosts());

        calendar1.set(2016, JULY, 4);
        updateHaunting = new Haunting()
                .setId(haunting.getId())
                .setNumberOfPeoplePresent(30)
                .setDate(calendar.getTime())
                .setGhosts(new ArrayList<Ghost>() {{
                    add(ghost2);
                }})
                .setHauntedHouse(house2);

        updateHaunting.getGhosts().forEach(ghost -> ghosts.add(ghost.getId()));

        updateHauntingDTO = new HauntingDTO()
                .setId(updateHaunting.getId())
                .setNumberOfPeoplePresent(updateHaunting.getNumberOfPeoplePresent())
                .setDate(updateHaunting.getDate())
                .setGhosts(ghosts)
                .setHauntedHouse(updateHaunting.getHauntedHouse().getId());

        when(ghostService.getById(ghostDTO1.getId())).thenReturn(ghost1);
        when(ghostService.getById(ghostDTO2.getId())).thenReturn(ghost2);
//        when(ghostService.getById(ghostDTO3.getId())).thenReturn(ghost3);

        when(houseService.getById(house1.getId())).thenReturn(house1);
        when(houseService.getById(house2.getId())).thenReturn(house2);
    }

    @BeforeMethod
    public void init(){
//        haunting = new HauntingDTO();
    }

//    @Test
    public void shouldCreateAndFindHaunting(){
        HauntingDTO createdHaunting = hauntingFacade.create(hauntingCreateDTO);
        HauntingDTO foundHaunting = hauntingFacade.getById(createdHaunting.getId());

        assertThat(createdHaunting).isNotNull();
        assertThat(createdHaunting).isEqualTo(foundHaunting);
    }

//    @Test
    public void shouldCreateUpdateAndFindHaunting(){
        HauntingDTO createdHaunting = hauntingFacade.create(hauntingCreateDTO);
        HauntingDTO foundHaunting = hauntingFacade.getById(createdHaunting.getId());

        calendar.set(1999, MARCH, 3);
        foundHaunting
                .setNumberOfPeoplePresent(30)
                .setDate(calendar.getTime())
                .setGhosts(new ArrayList<Long>(){{add(ghostDTO2.getId());}})
                .setHauntedHouse(houseDTO2.getId());
        hauntingFacade.update(foundHaunting);

        HauntingDTO updatedHaunting = hauntingFacade.getById(foundHaunting.getId());
        assertThat(updatedHaunting).isEqualTo(foundHaunting);
    }
}
