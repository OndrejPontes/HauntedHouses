package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.dto.HauntingCreateDTO;
import cz.muni.fi.pa165.dto.HauntingDTO;

import java.util.Date;
import java.util.List;

/**
 * @author MonikaMociarikova
 */
public interface HauntingFacade {

    Long createHaunting(HauntingCreateDTO haunting);

    void addGhostsToHaunting(Long hauntingId, List<GhostDTO> ghosts);

    void removeHaunting(HauntingDTO haunting);

    HauntingDTO findHauntingById(Long id);

    List<HauntingDTO> findHauntingByDate (Date date);

    List<HauntingDTO> findAllHauntings();
}
