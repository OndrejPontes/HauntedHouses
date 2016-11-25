package cz.muni.fi.pa165.services;

import cz.muni.fi.pa165.config.ServiceConfig;
import cz.muni.fi.pa165.dao.AbilityDao;
import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.entity.Ghost;
import org.assertj.core.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.osgi.framework.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author MonikaMociarikova
 */
@ContextConfiguration(classes = {ServiceConfig.class})
public class AbilityServiceTest  extends AbstractTestNGSpringContextTests {

    @Autowired
    @InjectMocks
    private AbilityService abilityService;

    @Mock
    @Autowired
    private AbilityDao abilityDao;

    private Ability ability1;
    private Ability ability2;
    private List<Ability> abilities;

    @BeforeClass
    public void setUp(){

        MockitoAnnotations.initMocks(this);

        ability1 = new Ability()
                .setName("Invisibility")
                .setDescription("The power that causes the ghost to become completely transparent to all forms of vision.");

        ability2 = new Ability()
                .setName("Overshadowing")
                .setDescription("The power to take over another body");

        abilities = new ArrayList<>();
        abilities.add(ability1);
        abilities.add(ability2);

        when(abilityDao.getById(1L)).thenReturn(ability1);
        when(abilityDao.getByName("Invisibility")).thenReturn(ability1);
        when(abilityDao.getAll()).thenReturn(abilities);
        when(abilityDao.update(ability1)).thenReturn(ability1);
    }

    @Test
    public void testCreate(){
        assertThat(abilityService.create(ability1)).isEqualTo(ability1);
    }

    @Test
    public void testGetById() {
        Assertions.assertThat(abilityService.getById(1L).equals(ability1));
    }

    @Test
    public void testGetByName(){
        Assertions.assertThat(abilityService.getByName("Invisibility").equals(ability1));
    }

    @Test
    public void testGetAll(){
        Assertions.assertThat(abilityService.getAll().equals(abilities));
    }



}
