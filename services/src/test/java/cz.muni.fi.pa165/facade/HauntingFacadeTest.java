package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.config.ServiceConfig;
import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.dto.HauntingCreateDTO;
import cz.muni.fi.pa165.dto.HauntingDTO;
import cz.muni.fi.pa165.dto.HouseDTO;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.entity.House;
import cz.muni.fi.pa165.services.GhostService;
import cz.muni.fi.pa165.services.HauntingService;
import cz.muni.fi.pa165.services.HouseService;
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

import static java.util.Calendar.*;
import static org.mockito.Mockito.when;

/**
 * @author opontes
 */
@Test
@ContextConfiguration(classes = {ServiceConfig.class})
public class HauntingFacadeTest extends AbstractTestNGSpringContextTests {
    @Mock
    private GhostService ghostService;

    @Mock
    private HouseService houseService;

    @InjectMocks
    private final HauntingFacade hauntingFacade = new HauntingFacadeImpl();

    private HauntingDTO haunting;

    private Ghost ghost1;
    private Ghost ghost2;
    private Ghost ghost3;

    private GhostDTO ghostDTO1;
    private GhostDTO ghostDTO2;
    private GhostDTO ghostDTO3;

    private House house1;
    private House house2;

    private HouseDTO houseDTO1;
    private HouseDTO houseDTO2;

    private Haunting haunting1;
    private Haunting haunting2;

    private HauntingDTO hauntingDTO1;
    private HauntingDTO hauntingDTO2;

    @BeforeClass
    public void setup(){
        MockitoAnnotations.initMocks(this);

        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        calendar1.set(2016,OCTOBER,27);
        calendar2.set(2016, OCTOBER,28);
        ghost1 = new Ghost()
                .setId(1L)
                .setName("John")
                .setDescription("Attractive ghost")
                .setHauntsFrom(calendar1.getTime())
                .setHauntsTo(calendar2.getTime());

        calendar1.set(2016,NOVEMBER,2);
        calendar2.set(2016, NOVEMBER,3);
        ghost2 = new Ghost()
                .setId(2L)
                .setName("Hans")
                .setDescription("Bad ghost")
                .setHauntsFrom(calendar1.getTime())
                .setHauntsTo(calendar2.getTime());

        calendar1.set(2016,DECEMBER,12);
        calendar2.set(2016, DECEMBER,13);
        ghost3 = new Ghost()
                .setId(3L)
                .setName("Luis")
                .setDescription("Angry ghost")
                .setHauntsFrom(calendar1.getTime())
                .setHauntsTo(calendar2.getTime());

        house1 = new House()
                .setId(1L)
                .setName("Lucky Hotel")
                .setAddress("Kounicova DC");

        house2 = new House()
                .setId(2L)
                .setName("Train station")
                .setAddress("Silicon valley");

        calendar1.set(2016,Calendar.JANUARY,22);
        hauntingDTO1 = new HauntingDTO()
                .setNumberOfPeoplePresent(4)
                .setDate(calendar1.getTime())
                .setGhosts(new ArrayList<GhostDTO>(){{add(ghostDTO1);}})
                .setHauntedHouse(houseDTO1);

        when(ghostService.getById(ghost1.getId())).thenReturn(ghost1);
        when(ghostService.getById(ghost2.getId())).thenReturn(ghost2);
        when(ghostService.getById(ghost3.getId())).thenReturn(ghost3);

        when(houseService.getById(house1.getId())).thenReturn(house1);
        when(houseService.getById(house2.getId())).thenReturn(house2);
    }

    @BeforeMethod
    public void init(){
        haunting = new HauntingDTO();
    }

    @Test
    public void shouldCreateHaunting(){
        HauntingCreateDTO haunting = new HauntingCreateDTO()
                .setDate(hauntingDTO1.getDate())
                .setNumberOfPeoplePresent(hauntingDTO1.getNumberOfPeoplePresent());
        Long id = hauntingFacade.createHaunting(haunting);
        assertThat(id).isNotNull();
    }
}
