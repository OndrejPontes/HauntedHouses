package cz.muni.fi.pa165.controller;

import cz.muni.fi.pa165.ApiUris;
import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.facade.GhostFacade;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author opontes
 */
@RestController
@RequestMapping(ApiUris.ROOT_URI_GHOSTS)
public class GhostController {
    @Autowired
    private GhostFacade ghostFacade;

//    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
    @RequestMapping("/ghost")
    public GhostDTO createGhost(@RequestParam(value = "name", defaultValue = "Ghost") String name){
        return new GhostDTO().setName(name);
    }
}
