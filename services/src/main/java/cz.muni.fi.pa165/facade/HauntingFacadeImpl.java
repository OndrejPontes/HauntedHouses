package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.dto.HauntingCreateDTO;
import cz.muni.fi.pa165.dto.HauntingDTO;
import cz.muni.fi.pa165.dto.HouseDTO;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.entity.House;
import cz.muni.fi.pa165.services.GhostService;
import cz.muni.fi.pa165.services.HauntingService;
import cz.muni.fi.pa165.services.HouseService;
import cz.muni.fi.pa165.services.MappingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * @author MonikaMociarikova
 */
@Service
@Transactional
public class HauntingFacadeImpl implements HauntingFacade {

    @Inject
    private HauntingService hauntingService;

    @Inject
    private MappingService mappingService;

    @Override
    public HauntingDTO create(HauntingCreateDTO haunting) {
        Haunting hauntingToCreate = mappingService.mapObject(haunting, Haunting.class);
        hauntingToCreate = hauntingService.create(hauntingToCreate);
        return mappingService.mapObject(hauntingToCreate, HauntingDTO.class);
    }

    @Override
    public HauntingDTO update(HauntingDTO haunting) {
        Haunting hauntingToUpdate = mappingService.mapObject(haunting, Haunting.class);
        hauntingToUpdate = hauntingService.update(hauntingToUpdate);
        return mappingService.mapObject(hauntingToUpdate, HauntingDTO.class);
    }

    @Override
    public void addGhostsToHaunting(Long hauntingId, List<GhostDTO> ghosts) {
        Haunting haunting = hauntingService.getById(hauntingId);
        for (GhostDTO ghostDto : ghosts) {
            Ghost ghost = mappingService.mapObject(ghostDto, Ghost.class);
            hauntingService.addGhost(haunting, ghost);
        }

    }

    @Override
    public void delete(HauntingDTO haunting) {
        Haunting hauntingToDelete = mappingService.mapObject(haunting, Haunting.class);
        hauntingService.remove(hauntingToDelete);
    }


    @Override
    public HauntingDTO getById(Long id) {
        Haunting haunting = hauntingService.getById(id);
        return mappingService.mapObject(haunting, HauntingDTO.class);
    }

    @Override
    public List<HauntingDTO> getByDate(Date date) {
        return mappingService.mapCollection(hauntingService.getByDate(date), HauntingDTO.class);
    }

    @Override
    public List<HauntingDTO> getAll() {
        return mappingService.mapCollection(hauntingService.getAll(), HauntingDTO.class);
    }

    @Override
    public List<HauntingDTO> getHauntingsOfGhost(GhostDTO ghost) {
        List<Haunting>  hauntings = hauntingService.getHauntingsOfGhost(mappingService.mapObject(ghost, Ghost.class));
        return mappingService.mapCollection(hauntings, HauntingDTO.class);
    }

    @Override
    public List<HauntingDTO> getHauntingsOfHouse(HouseDTO house) {
        List<Haunting>  hauntings = hauntingService.getHauntingsOfHouse(mappingService.mapObject(house, House.class));
        return mappingService.mapCollection(hauntings, HauntingDTO.class);
    }
}
