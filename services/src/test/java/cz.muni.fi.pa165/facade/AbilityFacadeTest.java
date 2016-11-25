package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.config.ServiceConfig;
import cz.muni.fi.pa165.dto.AbilityDTO;
import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.services.AbilityService;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Calendar;

import static java.util.Calendar.NOVEMBER;
import static java.util.Calendar.OCTOBER;

/**
 * @author MonikaMociarikova
 */

@Test
@ContextConfiguration(classes = {ServiceConfig.class})
public class AbilityFacadeTest extends AbstractTestNGSpringContextTests {

    @Mock
    private AbilityService abilityService;

    @Autowired
    private final AbilityFacade abilityFacade = new AbilityFacadeImpl();

    private AbilityDTO ability;
    private AbilityDTO ability1;
    private AbilityDTO ability2;

    private GhostDTO ghost1;
    private GhostDTO ghost2;

    private Calendar calendar;

    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        calendar1.set(2016,OCTOBER,27);
        calendar2.set(2016, OCTOBER,28);
        ghost1 = new GhostDTO()
                .setName("John")
                .setDescription("Attractive ghost")
                .setHauntsFrom(calendar1.getTime())
                .setHauntsTo(calendar2.getTime());

        calendar1.set(2016,NOVEMBER,2);
        calendar2.set(2016, NOVEMBER,3);
        ghost2 = new GhostDTO()
                .setName("Hans")
                .setDescription("Bad ghost")
                .setHauntsFrom(calendar1.getTime())
                .setHauntsTo(calendar2.getTime());


        ability1 = new AbilityDTO()
                .setName("Invisibility")
                .setDescription("Ability to disappear");


    }

    @BeforeMethod
    public void init(){
        ability = new AbilityDTO();
    }

    @Test
    public void createAndFindAbility(){

    }


}
