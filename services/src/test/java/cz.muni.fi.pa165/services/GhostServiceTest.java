package cz.muni.fi.pa165.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cz.muni.fi.pa165.config.ServiceConfig;
import cz.muni.fi.pa165.dao.GhostDao;
import cz.muni.fi.pa165.entity.Ghost;

@ContextConfiguration(classes = {ServiceConfig.class})
public class GhostServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private GhostService ghostService;

    @Mock
    @Autowired
    private GhostDao ghostDao;

    private Ghost ghost;

    private Ghost ghost2;

    private List<Ghost> ghosts;

    @BeforeClass
    public void setup() {
        MockitoAnnotations.initMocks(this);
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

        List<Ghost> ghosts = new ArrayList<>();
        ghosts.add(ghost);
        ghosts.add(ghost2);

        when(ghostDao.create(ghost)).thenReturn(ghost);
        when(ghostDao.getById(1)).thenReturn(ghost);
        List<Ghost> singleGhost = new ArrayList<>();
        singleGhost.add(ghost);
        when(ghostDao.getByName("name")).thenReturn(singleGhost);
        when(ghostDao.getAll()).thenReturn(ghosts);
    }

    @Test
    public void createTest() {
        assertThat(ghostService.create(ghost).equals(ghost));
    }

    @Test
    public void findByIdTest() {
        assertThat(ghostService.getById(1).equals(ghost));
    }

    @Test
    public void getAllTests() {
        assertThat(ghostService.getAll().equals(ghosts));
    }

    @Test
    public void getByName() {
        assertThat(ghostService.getByName("name").equals(ghost));
    }
}
