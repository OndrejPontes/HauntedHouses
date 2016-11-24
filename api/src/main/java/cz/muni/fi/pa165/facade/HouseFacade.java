package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.HouseCreateDTO;
import cz.muni.fi.pa165.dto.HouseDTO;

import java.util.Collection;

/**
 * @author Jirka Kruml
 */
public interface HouseFacade {

    Collection<HouseDTO> getAll();

    HouseDTO getByName(String name);

    HouseDTO getByAddress(String address);

    HouseDTO getById(Long id);

    HouseDTO create(HouseCreateDTO house);

    void addHaunting(Long hauntingId, Long houseId);

    void removeHaunting(Long hauntingId, Long houseId);

    void update(HouseDTO house);

    void delete(Long id);

}
