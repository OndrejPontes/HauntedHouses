package cz.muni.fi.pa165.services;

import cz.muni.fi.pa165.dao.HouseDao;
import cz.muni.fi.pa165.entity.House;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collection;

/**
 * @author Vojta David, vojtadavid
 */
public class HouseServiceTest extends AbstractTestNGSpringContextTests {

    @Mock
    private HouseDao houseDao;
    @Autowired
    @InjectMocks
    private HouseService houseService;



    @BeforeMethod
    public void init() {

    }

    @BeforeClass
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void getAllTest(){

    }
    @Test
    public voidgetByNameTest(){

    }
    @Test
    public voidgetByAddressTest(){

    }
    @Test
    public voidgetByIdTest(){

    }
    @Test
    public voidcreateTest(){

    }
    @Test
    public void updateTest(){

    }
    @Test
    public void deleteTest(){

    }
}
