package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.dto.HauntingCreateDTO;
import cz.muni.fi.pa165.dto.HauntingDTO;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.services.HauntingService;
import cz.muni.fi.pa165.services.MappingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Calendar;
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

    //@Autowired
    @Inject
    private MappingService mappingService;

    @Override
    public HauntingDTO createHaunting(HauntingCreateDTO haunting) {
        Haunting hauntingToCreate = mappingService.mapObject(haunting, Haunting.class);
        hauntingService.create(hauntingToCreate);
        return mappingService.mapObject(hauntingToCreate, HauntingDTO.class);
    }

    @Override
    public HauntingDTO updateHaunting(HauntingDTO haunting) {
        Haunting hauntingToUpdate = mappingService.mapObject(haunting, Haunting.class);
        hauntingService.update(hauntingToUpdate);
        return mappingService.mapObject(hauntingToUpdate, HauntingDTO.class);
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
        Haunting hauntingToDelete = mappingService.mapObject(haunting, Haunting.class);
        hauntingService.remove(hauntingToDelete);
    }


    @Override
    public HauntingDTO findHauntingById(Long id) {
        Haunting haunting = hauntingService.getById(id);
        return mappingService.mapObject(haunting, HauntingDTO.class);
    }

    @Override
    public List<HauntingDTO> findHauntingByDate(Date date) {
        return mappingService.mapCollection(hauntingService.getByDate(date), HauntingDTO.class);
    }

    @Override
    public List<HauntingDTO> findAllHauntings() {
        return mappingService.mapCollection(hauntingService.getAll(), HauntingDTO.class);
    }
}
