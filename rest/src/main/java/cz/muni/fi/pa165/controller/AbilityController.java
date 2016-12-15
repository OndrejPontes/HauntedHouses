package cz.muni.fi.pa165.controller;

import cz.muni.fi.pa165.ApiUris;
import cz.muni.fi.pa165.dto.AbilityDTO;
import cz.muni.fi.pa165.facade.AbilityFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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

    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE, value = "/ability")
    public AbilityDTO createGhost(@RequestParam(value = "name", defaultValue = "Ability") String name){
        return new AbilityDTO().setName(name);
    }

    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
    public Collection<AbilityDTO> getAllAbilities() {
        return abilityFacade.getAll();
    }

    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE, value = "/name/{name}")
    public AbilityDTO getAbilityByName(@PathVariable String name) {
        return abilityFacade.getByName(name);
    }

    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE, value = "/{id}")
    public AbilityDTO getGhostById(@PathVariable long id) {
        return abilityFacade.getById(id);
    }

    @RequestMapping(method = DELETE)
    public HttpStatus deleteAbility(@RequestBody AbilityDTO abilityDTO) {
        abilityFacade.delete(abilityDTO);
        return HttpStatus.OK;
    }

    @RequestMapping(method = PUT)
    public AbilityDTO updateAbility(@RequestBody AbilityDTO abilityDTO) {
        return abilityFacade.update(abilityDTO);
    }
}
