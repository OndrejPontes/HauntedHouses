package cz.muni.fi.pa165.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cz.muni.fi.pa165.config.ServiceConfig;
import cz.muni.fi.pa165.dao.HouseDao;
import cz.muni.fi.pa165.entity.House;

/**
 * @author Vojta David, vojtadavid
 */

@ContextConfiguration(classes = {ServiceConfig.class})
public class HouseServiceTest extends AbstractTestNGSpringContextTests {

    @InjectMocks
    private HouseService houseService = new HouseServiceImpl();

    @Mock
    private HouseDao houseDao;

    private House h1;
    private House h2;
    private List<House> houses;

    @BeforeClass
    public void setup() {
        MockitoAnnotations.initMocks(this);

        h1 = new House()
                .setName("a")
                .setAddress("b")
                .setHistory("xxx")
                .setHauntingFrom(Calendar.getInstance().getTime());

        h2 = new House()
                .setName("c")
                .setAddress("d")
                .setHistory("yyyy")
                .setHauntingFrom(Calendar.getInstance().getTime());

        houses = new ArrayList<>();

        houses.add(h1);
        houses.add(h2);

        when(houseDao.create(h1)).thenReturn(h1);
        when(houseDao.create(h2)).thenReturn(h2);
        when(houseDao.getAll()).thenReturn(houses);
        when(houseDao.getByName("a")).thenReturn(h1);
        when(houseDao.getByAddress("d")).thenReturn(h2);
        when(houseDao.getById(1)).thenReturn(h1);
    }

    @Test
    public void getAllTest(){
        Collection<House> all = houseService.getAll();
        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(h1);
        assertThat(all).contains(h2);
    }

    @Test
    public void getByNameTest(){
        assertThat(houseService.getByName("a")).isEqualTo(h1);
    }

    @Test
    public void getByAddressTest(){
        assertThat(houseService.getByName("a")).isEqualTo(h1);
    }

    @Test
    public void getByIdTest(){
        House house = houseService.getById(1);
        assertThat(house).isEqualTo(h1);
        verify(houseDao).getById(1);
    }

    @Test
    public void createTest(){
        House created = houseService.create(h1);
        assertThat(created).isEqualTo(h1);
        verify(houseDao).create(h1);
    }
    @Test
    public void updateTest(){
        houseService.create(h1);
        h1.setAddress("192.168.1.1");
        houseService.update(h1);
        verify(houseDao).update(h1);
    }

    @Test
    public void deleteTest(){
        houseService.delete(1);
        verify(houseDao).delete(1);
    }
}
