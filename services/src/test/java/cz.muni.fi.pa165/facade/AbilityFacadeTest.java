package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.services.AbilityService;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * @author MonikaMociarikova
 */
public class AbilityFacadeTest extends AbstractTestNGSpringContextTests {

    @Mock
    private AbilityService abilityService;

    @Autowired
    private final AbilityFacade abilityFacade = new AbilityFacadeImpl();




}
