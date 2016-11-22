package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.dto.HauntingCreateDTO;
import cz.muni.fi.pa165.dto.HauntingDTO;
import cz.muni.fi.pa165.dto.HauntingUpdateDTO;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.services.GhostService;
import cz.muni.fi.pa165.services.HauntingService;
import cz.muni.fi.pa165.services.HouseService;
import cz.muni.fi.pa165.services.MappingService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.List;


/**
 * @author MonikaMociarikova
 */

@Service
@Transactional
public class HauntingFacadeImpl implements HauntingFacade{


    @Inject
    private HauntingService hauntingService;

    @Inject
    private HouseService houseService;

    @Inject
    private GhostService ghostService;

    //@Autowired
    @Inject
    private MappingService mappingService;

    @Override
    public Long createHaunting(HauntingCreateDTO haunting) {
        Haunting hauntingToCreate = mappingService.mapObject(haunting,Haunting.class);
        hauntingToCreate.setHauntedHouse(houseService.getById(haunting.getHauntedHouseId()));
        for (Long id : haunting.getGhostsIds()) {
            hauntingToCreate.addGhost(ghostService.getById(id));
        }

        Haunting createdHaunting = hauntingService.create(hauntingToCreate);
        return createdHaunting.getId();
    }

    @Override
    public void updateHaunting(HauntingUpdateDTO haunting) {
        Haunting hauntingToUpdate = mappingService.mapObject(haunting,Haunting.class);
        hauntingToUpdate.setHauntedHouse(houseService.getById(haunting.getHauntedHouseId()));
        for (Long id : haunting.getGhostsIds()) {
            hauntingToUpdate.addGhost(ghostService.getById(id));
        }
        hauntingService.update(hauntingToUpdate);
    }

    @Override
    public void addGhostsToHaunting(Long hauntingId, List<GhostDTO> ghosts) {
        Haunting haunting = hauntingService.getById(hauntingId);
        for (GhostDTO ghostDto : ghosts) {
            Ghost ghost = mappingService.mapObject(ghostDto,Ghost.class);
            hauntingService.addGhost(haunting, ghost);
        }

    }

    @Override
    public void removeHaunting(HauntingDTO haunting) {
        Haunting hauntingToDelete = mappingService.mapObject(haunting,Haunting.class);
        hauntingService.remove(hauntingToDelete);
    }


    @Override
    public HauntingDTO findHauntingById(Long id) {
        Haunting haunting = hauntingService.getById(id);
        return mappingService.mapObject(haunting,HauntingDTO.class);
    }

    @Override
    public List<HauntingDTO> findHauntingByDate(Calendar date) {
        return mappingService.mapCollection(hauntingService.getByDate(date),HauntingDTO.class);
    }

    @Override
    public List<HauntingDTO> findAllHauntings() {
        return mappingService.mapCollection(hauntingService.getAll(), HauntingDTO.class);
    }
}
