package cz.muni.fi.pa165.services;

import cz.muni.fi.pa165.config.ServiceConfig;
import cz.muni.fi.pa165.dao.HauntingDao;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.entity.House;
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
 * @author Ondrej Ponteš
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class})
public class HauntingServiceTest extends AbstractTestNGSpringContextTests {

    @InjectMocks
    private HauntingService hauntingService = new HauntingServiceImpl();

    @Mock
    private HauntingDao hauntingDao;

    @Mock
    private House house;

    @Mock
    private Ghost ghost;

    private Haunting haunting;
    private Calendar calendar;
    private List<Haunting> hauntings;

    @BeforeClass
    public void setup() {
        MockitoAnnotations.initMocks(this);

        calendar = Calendar.getInstance();
        calendar.set(2016, FEBRUARY, 20);

        haunting = new Haunting()
                .setDate(calendar.getTime())
                .setNumberOfPeoplePresent(4)
                .setGhosts(new ArrayList<Ghost>(){{add(ghost);}})
                .setHauntedHouse(house);

        hauntings = new ArrayList<>();
        hauntings.add(haunting);

        when(hauntingDao.getById(1L)).thenReturn(haunting);
        when(hauntingDao.update(haunting)).thenReturn(haunting);
        when(hauntingDao.getAll()).thenReturn(hauntings);
        when(hauntingDao.getByDate(calendar.getTime())).thenReturn(hauntings);
        when(hauntingDao.create(haunting)).thenReturn(haunting);
    }

    @Test
    public void testCreate() {
        assertThat(hauntingService.create(haunting)).isEqualTo(haunting);
        verify(hauntingDao).create(haunting);
    }

    @Test
    public void testGetById(){
        assertThat(hauntingService.getById(1L)).isEqualTo(haunting);
        verify(hauntingDao).getById(1L);
    }

    @Test
    public void testGetAll(){
        assertThat(hauntingService.getAll()).isEqualTo(hauntings);
        verify(hauntingDao).getAll();
    }

    @Test
    public void testGetByDate(){
        assertThat(hauntingService.getByDate(calendar.getTime())).isEqualTo(hauntings);
        verify(hauntingDao).getByDate(calendar.getTime());
    }

    @Test
    public void testUpdate(){
        haunting.setNumberOfPeoplePresent(5);
        hauntingService.update(haunting);
        assertThat(hauntingService.getById(1L)).isEqualTo(haunting);
        verify(hauntingDao).update(haunting);
    }

    @Test
    public void testDelete(){
        hauntingService.remove(haunting);
        verify(hauntingDao).delete(haunting);
    }

}
