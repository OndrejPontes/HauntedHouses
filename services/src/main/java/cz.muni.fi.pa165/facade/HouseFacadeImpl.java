package cz.muni.fi.pa165.facade;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import cz.muni.fi.pa165.dto.HouseCreateDTO;
import cz.muni.fi.pa165.dto.HouseDTO;
import cz.muni.fi.pa165.dto.HouseUpdateDTO;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.entity.House;
import cz.muni.fi.pa165.services.HauntingService;
import cz.muni.fi.pa165.services.HouseService;
import cz.muni.fi.pa165.services.MappingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jirka Kruml
 */
@Service
@Transactional
public class HouseFacadeImpl implements HouseFacade {

    @Autowired
    private HouseService houseService;

    @Autowired
    private HauntingService hauntingService;

    @Autowired
    private MappingService mappingService;

    @Override
    public Collection<HouseDTO> getAll() {
        return mappingService.mapCollection(houseService.getAll(), HouseDTO.class);
    }

    @Override
    public HouseDTO getByName(String name) {
        return mappingService.mapObject(houseService.getByName(name), HouseDTO.class);
    }

    @Override
    public HouseDTO getByAddress(String address) {
        return mappingService.mapObject(houseService.getByAddress(address), HouseDTO.class);
    }

    @Override
    public HouseDTO getById(Long id) {
        return mappingService.mapObject(houseService.getById(id), HouseDTO.class);
    }

    @Override
    public HouseDTO create(HouseCreateDTO house) {
        return mappingService.mapObject(houseService.create(mappingService.mapObject(house, House.class)), HouseDTO.class);
    }

    @Override
    public void addHaunting(Long hauntingId, Long houseId) {
        Haunting haunting = hauntingService.getById(hauntingId);
        House house = houseService.getById(houseId);

        house.addHaunting(haunting);
        houseService.update(house);
    }

    @Override
    public void removeHaunting(Long hauntingId, Long houseId) {
        Haunting haunting = hauntingService.getById(hauntingId);
        House house = houseService.getById(houseId);

        house.removeHaunting(haunting);
        houseService.update(house);
    }

    @Override
    public void update(HouseUpdateDTO house) {
        houseService.update(mappingService.mapObject(house, House.class));
    }

    @Override
    public void delete(Long id) {
        houseService.delete(id);
    }
}
