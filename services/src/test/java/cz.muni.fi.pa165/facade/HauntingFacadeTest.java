package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.dto.HauntingDTO;
import cz.muni.fi.pa165.dto.HouseDTO;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.House;
import cz.muni.fi.pa165.services.GhostService;
import cz.muni.fi.pa165.services.HauntingService;
import cz.muni.fi.pa165.services.HouseService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;

/**
 * @author opontes
 */
@Test
@ContextConfiguration(classes = {HauntingService.class})
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

    @BeforeClass
    public void setup(){
        MockitoAnnotations.initMocks(this);

        when(ghostService.getById(ghost1.getId())).thenReturn(ghost1);
        when(ghostService.getById(ghost2.getId())).thenReturn(ghost2);
        when(ghostService.getById(ghost3.getId())).thenReturn(ghost3);

        when(houseService.getById(house1.getId())).thenReturn(house1);
        when(houseService.getById(house2.getId())).thenReturn(house2);
    }

    @Before
    public void init(){
        haunting = new HauntingDTO();
    }
}
