package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.services.HauntingService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * @author opontes
 */
@Test
@ContextConfiguration(classes = {HauntingService.class})
public class HauntingFacadeMockTest extends AbstractTestNGSpringContextTests {

}
