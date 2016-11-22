package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.dto.HauntingCreateDTO;
import cz.muni.fi.pa165.dto.HauntingDTO;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.services.GhostService;
import cz.muni.fi.pa165.services.HauntingService;
import cz.muni.fi.pa165.services.MappingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author MonikaMociarikova
 */

@Service
@Transactional
public class HauntingFacadeImpl implements HauntingFacade{


    @Inject
    private HauntingService hauntingService;

//    @Inject
//    private HouseService houseService;

    @Inject
    private GhostService ghostService;

    @Autowired
    private MappingService mappingService;

    @Override
    public Long createHaunting(HauntingCreateDTO haunting) {
        Haunting hauntingToCreate = mappingService.mapObject(haunting,Haunting.class);
//        hauntingToCreate.setHauntedHouse(houseService.getHouseById(haunting.getHauntedHouseId()));
        List<Ghost> ghosts = new ArrayList<>();
        for (Long id : haunting.getGhostsIds()) {
            ghosts.add(ghostService.getById(id));
        }
        hauntingToCreate.setGhosts(ghosts);

        Haunting createdHaunting = hauntingService.create(hauntingToCreate);
        return createdHaunting.getId();
    }

    @Override
    public void addGhostsToHaunting(Long hauntingId, List<GhostDTO> ghosts) {

    }

    @Override
    public void removeHaunting(HauntingDTO haunting) {
        Haunting hauntingToDelete = mappingService.mapObject(haunting,Haunting.class);
        hauntingService.remove(hauntingToDelete);
    }


    @Override
    public HauntingDTO findHauntingById(Long id) {
        Haunting haunting = hauntingService.findById(id);
        return mappingService.mapObject(haunting,HauntingDTO.class);
    }

    @Override
    public List<HauntingDTO> findHauntingByDate(Date date) {
        return mappingService.mapCollection(hauntingService.findByDate(date),HauntingDTO.class);
    }

    @Override
    public List<HauntingDTO> findAllHauntings() {
        return mappingService.mapCollection(hauntingService.findAll(), HauntingDTO.class);
    }
}
