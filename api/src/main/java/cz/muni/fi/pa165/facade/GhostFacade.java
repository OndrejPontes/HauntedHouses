package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.GhostCreateDTO;
import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.dto.GhostUpdateDTO;

import java.util.Collection;

/**
 * @author Ondrej Ponteš
 */
public interface GhostFacade {
    Long createGhost(GhostCreateDTO ghostCreateDTO);

    Collection<GhostDTO> getAllGhosts();

    Collection<GhostDTO> getGhostsByName(String ghostName);

    GhostDTO getGhostById(Long ghostId);

    void updateGhost(GhostUpdateDTO ghostUpdateDTO);

    void deleteGhost(GhostDTO ghostId);
}
