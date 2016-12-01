package cz.muni.fi.pa165.facade;

import java.util.Calendar;

import org.hibernate.service.spi.ServiceException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cz.muni.fi.pa165.config.ServiceConfig;
import cz.muni.fi.pa165.entity.House;
import cz.muni.fi.pa165.services.HouseService;

/**
 * @author Vojta David, vojtadavid
 */
@Test
@ContextConfiguration(classes = {ServiceConfig.class})
public class HouseFacadeTest extends AbstractTestNGSpringContextTests {

    @Mock
    private HouseService houseService;

    @Autowired
    private HouseFacade houseFacade;

    @Autowired
    private HauntingFacade hauntingFacade;

    @Autowired
    private AbilityFacade abilityFacade;

    @Autowired
    private GhostFacade ghostFacade;

    private House h1;
    private House h2;

    @BeforeMethod
    public void init() {
        h1 = new House();
        h2 = new House();

        h1.setName("a").setAddress("b").setHistory("xxx").setHauntingFrom(Calendar.getInstance().getTime());
        h2.setName("c").setAddress("d").setHistory("yyyy").setHauntingFrom(Calendar.getInstance().getTime());


    }

    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() { }

}
