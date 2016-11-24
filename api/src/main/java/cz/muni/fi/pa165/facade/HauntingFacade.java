package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.dto.HauntingCreateDTO;
import cz.muni.fi.pa165.dto.HauntingDTO;
import cz.muni.fi.pa165.dto.HauntingUpdateDTO;
import cz.muni.fi.pa165.entity.Haunting;

import java.util.Calendar;
import java.util.List;

/**
 * @author MonikaMociarikova
 */
public interface HauntingFacade {

    HauntingDTO createHaunting(HauntingCreateDTO haunting);

    void updateHaunting(HauntingUpdateDTO haunting);

    void addGhostsToHaunting(Long hauntingId, List<GhostDTO> ghosts);

    void removeHaunting(HauntingDTO haunting);

    HauntingDTO findHauntingById(Long id);

    List<HauntingDTO> findHauntingByDate (Calendar date);

    List<HauntingDTO> findAllHauntings();
}
