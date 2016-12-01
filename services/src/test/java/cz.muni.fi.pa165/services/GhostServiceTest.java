package cz.muni.fi.pa165.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cz.muni.fi.pa165.config.ServiceConfig;
import cz.muni.fi.pa165.dao.GhostDao;
import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.entity.Ghost;


@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class})
public class GhostServiceTest extends AbstractTestNGSpringContextTests {

    @InjectMocks
    private GhostService ghostService = new GhostServiceImpl();

    @Mock
    private GhostDao ghostDao;

    private Ghost ghost;

    private Ghost ghost2;

    private List<Ghost> ghosts;

    @BeforeClass
    public void setup() {
        MockitoAnnotations.initMocks(this);

        Ability ability = new Ability()
                .setName("ability name")
                .setDescription("ability desc");

        List<Ability> abilities = new ArrayList<>();
        abilities.add(ability);


        ghost = new Ghost()
                .setName("name")
                .setDescription("desc")
                .setHauntsFrom(new Date(0))
                .setHauntsTo(new Date(0));

        ghost2 = new Ghost()
                .setName("name2")
                .setDescription("desc2")
                .setHauntsFrom(new Date(0))
                .setHauntsTo(new Date(0));

        ghosts = new ArrayList<>();
        ghosts.add(ghost);
        ghosts.add(ghost2);

        List<Ghost> singleGhost = new ArrayList<>();
        singleGhost.add(ghost);

        when(ghostDao.create(ghost)).thenReturn(ghost);
        when(ghostDao.getById(1)).thenReturn(ghost);
        when(ghostDao.getByName("name")).thenReturn(singleGhost);
        when(ghostDao.getAll()).thenReturn(ghosts);
    }

    @Test
    public void createTest() {
        assertThat(ghostService.create(ghost)).isEqualTo(ghost);
        verify(ghostDao).create(ghost);
    }

    @Test
    public void findByIdTest() {
        assertThat(ghostService.getById(1)).isEqualTo(ghost);
        verify(ghostDao).getById(1);
    }

    @Test
    public void getAllTests() {
        assertThat(ghostService.getAll()).isEqualTo(ghosts);
        verify(ghostDao).getAll();
    }

    @Test
    public void getByNameTest() {
        assertThat(ghostService.getByName("name")).contains(ghost);
        verify(ghostDao).getByName("name");
    }
}
