package cz.muni.fi.pa165.controller;

import cz.muni.fi.pa165.ApiUris;
import cz.muni.fi.pa165.dto.GhostCreateDTO;
import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.exception.ScaryDataAccessException;
import cz.muni.fi.pa165.facade.GhostFacade;
import cz.muni.fi.pa165.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

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

    @Autowired
    private Validator validator;

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST)
    public GhostDTO createGhost(@RequestBody GhostCreateDTO ghostDTO) {
        List<String> errors = validator.validate(ghostDTO);
        if (!errors.isEmpty()) {
            throw new ScaryDataAccessException(errors);
        } else {
            return ghostFacade.create(ghostDTO);
        }
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET)
    public Collection<GhostDTO> getAll() {
        return ghostFacade.getAll();
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public GhostDTO getGhostByName(@PathVariable String name) {
        return ghostFacade.getByName(name);
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public GhostDTO getGhostById(@PathVariable long id) {
        return ghostFacade.getById(id);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteGhost(@PathVariable long id) {
        ghostFacade.delete(getGhostById(id));
        return HttpStatus.OK;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = PUT)
    public GhostDTO updateGhost(@RequestBody GhostDTO ghostDTO) {
        List<String> errors = validator.validate(ghostDTO);
        if (!errors.isEmpty()) {
            throw new ScaryDataAccessException(errors);
        } else {
            return ghostFacade.update(ghostDTO);
        }
    }
}
