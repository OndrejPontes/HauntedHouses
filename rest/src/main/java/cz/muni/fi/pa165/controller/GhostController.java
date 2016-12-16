package cz.muni.fi.pa165.controller;

import cz.muni.fi.pa165.ApiUris;
import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.facade.GhostFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author opontes
 */
@RestController
@RequestMapping(ApiUris.ROOT_URI_GHOSTS)
public class GhostController {
    @Autowired
    private GhostFacade ghostFacade;

    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE, value = "/ghost")
    public GhostDTO createGhost(@RequestParam(value = "name", defaultValue = "Ghost") String name){
        return new GhostDTO().setName(name);
    }

    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
    public Collection<GhostDTO> getAllGhosts() {
        return ghostFacade.getAll();
    }

    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE, value = "/name/{name}")
    public GhostDTO getGhostByName(@PathVariable String name) {
        return ghostFacade.getByName(name);
    }

    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE, value = "/{id}")
    public GhostDTO getGhostById(@PathVariable long id) {
        return ghostFacade.getById(id);
    }

    @RequestMapping(method = DELETE)
    public HttpStatus deleteGhost(@RequestBody GhostDTO ghostDTO) {
        ghostFacade.delete(ghostDTO);
        return HttpStatus.OK;
    }

    @RequestMapping(method = PUT)
    public GhostDTO updateGhost(@RequestBody GhostDTO ghostDTO) {
        return ghostFacade.update(ghostDTO);
    }
}
