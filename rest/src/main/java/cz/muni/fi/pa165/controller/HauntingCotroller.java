package cz.muni.fi.pa165.controller;

import cz.muni.fi.pa165.ApiUris;
import cz.muni.fi.pa165.dto.HauntingCreateDTO;
import cz.muni.fi.pa165.dto.HauntingDTO;
import cz.muni.fi.pa165.exception.ScaryDataAccessException;
import cz.muni.fi.pa165.facade.HauntingFacade;
import cz.muni.fi.pa165.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author MonikaMociarikova
 */
@RestController
@RequestMapping(ApiUris.ROOT_URI_HAUNTINGS)
public class HauntingCotroller {

    @Autowired
    private HauntingFacade hauntingFacade;

    @Autowired
    private Validator validator;

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST)
    public HauntingDTO createHaunting(@RequestBody HauntingCreateDTO haunting) {
        List<String> errors = validator.validate(haunting);
        if (!errors.isEmpty()) {
            throw new ScaryDataAccessException(errors);
        } else {
            return hauntingFacade.create(haunting);
        }
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET)
    public Collection<HauntingDTO> getAllHauntings() {
        return hauntingFacade.getAll();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE, value = "/date/{date}")
    public Collection<HauntingDTO> getHauntingByDate(@PathVariable Date date) {
        return hauntingFacade.getByDate(date);
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public HauntingDTO getHauntingById(@PathVariable long id) {
        return hauntingFacade.getById(id);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = DELETE)
    public HttpStatus deleteHaunting(@PathVariable long id) {
        hauntingFacade.delete(getHauntingById(id));
        return HttpStatus.OK;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.PUT)
    public HauntingDTO updateHaunting(@RequestBody HauntingDTO haunting) {
        List<String> errors = validator.validate(haunting);
        if (!errors.isEmpty()) {
            throw new ScaryDataAccessException(errors);
        } else {
            return hauntingFacade.update(haunting);
        }
    }
}
