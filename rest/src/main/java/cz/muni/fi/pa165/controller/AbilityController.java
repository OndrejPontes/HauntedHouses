package cz.muni.fi.pa165.controller;

import cz.muni.fi.pa165.ApiUris;
import cz.muni.fi.pa165.dto.AbilityCreateDTO;
import cz.muni.fi.pa165.dto.AbilityDTO;
import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.exception.ScaryDataAccessException;
import cz.muni.fi.pa165.facade.AbilityFacade;
import cz.muni.fi.pa165.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author vojtadavid, Vojta David
 */
@RestController
@RequestMapping(ApiUris.ROOT_URI_ABILITIES)
public class AbilityController {
    @Autowired
    private AbilityFacade abilityFacade;
    @Autowired
    private Validator validator;

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST)
    public AbilityDTO createAbility(@RequestBody AbilityCreateDTO abilityCreateDTO) {
        List<String> errors = validator.validate(abilityCreateDTO);
        if (!errors.isEmpty()) {
            throw new ScaryDataAccessException(errors);
        } else {
            return abilityFacade.create(abilityCreateDTO);
        }
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
    public Collection<AbilityDTO> getAllAbilities() {
        return abilityFacade.getAll();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public AbilityDTO getAbilityByName(@PathVariable String name) {
        return abilityFacade.getByName(name);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AbilityDTO getHouse(@PathVariable long id) {
        return abilityFacade.getById(id);
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteAbility(@PathVariable long id) {
        abilityFacade.delete(id);
        return HttpStatus.OK;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = PUT)
    public AbilityDTO updateAbility(@RequestBody AbilityDTO abilityDTO) {
        List<String> errors = validator.validate(abilityDTO);
        if (!errors.isEmpty()) {
            throw new ScaryDataAccessException(errors);
        } else {
            return abilityFacade.update(abilityDTO);

        }
    }
}
