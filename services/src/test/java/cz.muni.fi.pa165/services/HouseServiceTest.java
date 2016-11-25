package cz.muni.fi.pa165.services;

import cz.muni.fi.pa165.config.ServiceConfig;
import cz.muni.fi.pa165.dao.HouseDao;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.entity.House;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

/**
 * @author Vojta David, vojtadavid
 */
@Test
@ContextConfiguration(classes = {ServiceConfig.class})
public class HouseServiceTest extends AbstractTestNGSpringContextTests {

    @Mock
    private HouseDao houseDao;
    @Autowired

    @InjectMocks
    private HouseService houseService;

    private House h1;
    private House h2;

    private Haunting haunting;

    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);

        h1 = new House();
        h2 = new House();

        h1.setName("a").setAddress("b").setHistory("xxx").setHauntingFrom(Calendar.getInstance().getTime());
        h2.setName("c").setAddress("d").setHistory("yyyy").setHauntingFrom(Calendar.getInstance().getTime());

        haunting = new Haunting();
        haunting.setHauntedHouse(h1).setDate(Calendar.getInstance().getTime()).setNumberOfPeoplePresent(123);

        h1.addHaunting(haunting);
    }


    public void getAllTest(){
        List<House> houses = new ArrayList<>();
        houses.add(h1);
        houses.add(h2);
        when(houseDao.getAll()).thenReturn(houses);
        assertThat(houseService.getAll()).isEqualTo(2);
    }

    public void getByNameTest(){
        when(houseDao.getByName("a")).thenReturn(h1);
        assertThat(houseService.getByName("a")).isEqualTo(h1);
    }

    public void getByAddressTest(){
        when(houseDao.getByAddress("d")).thenReturn(h2);
        assertThat(houseService.getByName("a")).isEqualTo(h1);
    }

    public void getByIdTest(){
        long id = 123456;
        when(houseDao.getById(id)).thenReturn(h1);
        assertThat(houseService.getById(id)).isEqualTo(h1);
    }

    public void createTest(){
        houseService.create(h1);
        verify(houseDao).create(h1);
    }
//    @Test
//    public void updateTest(){
////        houseService.create(h1);
////        h1.setAddress("192.168.1.1");
////        houseService.update(h1);
////        verify(houseDao).update(h1);
//    }
//    @Test
//    public void deleteTest(){
//        houseService.delete(h1.getId());
//        verify(houseDao).delete(h1.getId());
//    }
}
