package cz.muni.fi.pa165.controller;

import cz.muni.fi.pa165.ApiUris;
import cz.muni.fi.pa165.dto.HouseCreateDTO;
import cz.muni.fi.pa165.dto.HouseDTO;
import cz.muni.fi.pa165.facade.HouseFacade;
import cz.muni.fi.pa165.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Jirka Kruml
 */
@RestController
@RequestMapping(ApiUris.ROOT_URI_HOUSES)
public class HouseController {

    @Autowired
    private HouseFacade houseFacade;
    @Autowired
    private Validator validator;

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET)
    public Collection<HouseDTO> getAll() {
        return houseFacade.getAll();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public HouseDTO getByName(@PathVariable String name) {
        return houseFacade.getByName(name);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/address/{address}", method = RequestMethod.GET)
    public HouseDTO getByAddress(@PathVariable String address) {
        return houseFacade.getByAddress(address);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public HouseDTO getHouse(@PathVariable long id) {
        return houseFacade.getById(id);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST)
    public HouseDTO createHouse(@RequestBody HouseCreateDTO houseDTO) {
        validator.validate(houseDTO);
        return houseFacade.create(houseDTO);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteHouse(@PathVariable long id) {
        houseFacade.delete(id);
        return HttpStatus.OK;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.PUT)
    public HouseDTO updateHouse(@RequestBody HouseDTO houseDTO) {
        validator.validate(houseDTO);
        return houseFacade.update(houseDTO);
    }


}
