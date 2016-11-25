package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.dto.HauntingCreateDTO;
import cz.muni.fi.pa165.dto.HauntingDTO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author MonikaMociarikova
 */
public interface HauntingFacade {

    HauntingDTO create(HauntingCreateDTO haunting);

    HauntingDTO update(HauntingDTO haunting);

    void addGhostsToHaunting(Long hauntingId, List<GhostDTO> ghosts);

    void delete(HauntingDTO haunting);

    HauntingDTO getById(Long id);

    List<HauntingDTO> getByDate(Date date);

    List<HauntingDTO> getAll();
}
