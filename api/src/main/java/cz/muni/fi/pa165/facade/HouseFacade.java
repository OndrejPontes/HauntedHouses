package cz.muni.fi.pa165.facade;

import java.util.Collection;

import cz.muni.fi.pa165.dto.HouseCreateDTO;
import cz.muni.fi.pa165.dto.HouseDTO;
import cz.muni.fi.pa165.dto.HouseUpdateDTO;

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

    void update(HouseUpdateDTO house);

    void delete(Long id);

}
