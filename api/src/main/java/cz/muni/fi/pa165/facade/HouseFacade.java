package cz.muni.fi.pa165.facade;

import java.util.Collection;

import cz.muni.fi.pa165.dto.HouseCreateDTO;
import cz.muni.fi.pa165.dto.HouseDTO;

/**
 * @author Jirka Kruml
 */
public interface HouseFacade {

    Collection<HouseDTO> getAll();

    HouseDTO getByName(String name);

    HouseDTO getByAddress(String address);

    HouseDTO getById(long id);

    HouseDTO create(HouseCreateDTO house);

    HouseDTO update(HouseDTO house);

    void delete(long id);

}
