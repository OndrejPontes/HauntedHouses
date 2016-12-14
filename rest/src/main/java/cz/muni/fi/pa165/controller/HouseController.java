package cz.muni.fi.pa165.controller;

import java.util.Arrays;
import java.util.Collection;

import cz.muni.fi.pa165.ApiUris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cz.muni.fi.pa165.dto.HouseCreateDTO;
import cz.muni.fi.pa165.dto.HouseDTO;
import cz.muni.fi.pa165.facade.HouseFacade;

/**
 * @author Jirka Kruml
 */
@RestController
@RequestMapping(ApiUris.ROOT_URI_HOUSES)
public class HouseController {

    @Autowired
    private HouseFacade houseFacade;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<HouseDTO> getAll() {
        return Arrays.asList(
                new HouseDTO().setId(1L).setAddress("New York").setName("Scary house").setHistory("history1"),
                new HouseDTO().setId(2L).setAddress("Washington DC").setName("New house").setHistory("history2")
                );
//        return houseFacade.getAll();
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public HouseDTO getByName(@PathVariable String name) {
        return houseFacade.getByName(name);
    }

    @RequestMapping(value = "/address/{address}", method = RequestMethod.GET)
    public HouseDTO getByAddress(@PathVariable String address) {
        return houseFacade.getByAddress(address);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public HouseDTO getHouse(@PathVariable long id) {
        return houseFacade.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public HouseDTO createHouse(@RequestBody HouseCreateDTO houseDTO) {
        return houseFacade.create(houseDTO);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteHouse(@PathVariable long id) {
        houseFacade.delete(id);
        return HttpStatus.OK;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public HouseDTO updateHouse(@RequestBody HouseDTO houseDTO) {
        return houseFacade.update(houseDTO);
    }


}
