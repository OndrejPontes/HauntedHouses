package cz.muni.fi.pa165.controller;

import cz.muni.fi.pa165.ApiUris;
import cz.muni.fi.pa165.dto.HauntingDTO;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.facade.HauntingFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author
 */
@RestController
@RequestMapping(ApiUris.ROOT_URI_HAUNTINGS)
public class HauntingCotroller {

    @Autowired
    private HauntingFacade hauntingFacade;


}
