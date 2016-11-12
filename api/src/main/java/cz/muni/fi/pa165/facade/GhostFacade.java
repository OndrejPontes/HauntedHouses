package cz.muni.fi.pa165.facade;

import main.java.cz.muni.fi.pa165.dto.GhostCreateDTO;
import main.java.cz.muni.fi.pa165.dto.GhostDTO;
import main.java.cz.muni.fi.pa165.dto.GhostUpdateDTO;

import java.util.Collection;

/**
 * @author Ondrej Ponteš
 */
public interface GhostFacade {
    Collection<GhostDTO> getAllGhosts();

    Collection<GhostDTO> getGhostsByName(String ghostName);

    GhostDTO getGhostById(Long forestId);

    GhostDTO createGhost(GhostCreateDTO ghostCreateDTO);

    void updateGhost(GhostUpdateDTO ghostUpdateDTO);

    void deleteGhost(Long ghostId);
}
