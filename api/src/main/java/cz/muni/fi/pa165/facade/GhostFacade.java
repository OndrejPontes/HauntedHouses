package cz.muni.fi.pa165.facade;

import java.util.Collection;

import cz.muni.fi.pa165.dto.GhostCreateDTO;
import cz.muni.fi.pa165.dto.GhostDTO;

/**
 * @author Ondrej Ponteš
 */
public interface GhostFacade {
    GhostDTO create(GhostCreateDTO ghostCreateDTO);

    Collection<GhostDTO> getAll();

    Collection<GhostDTO> getByName(String ghostName);

    GhostDTO getById(Long ghostId);

    GhostDTO update(GhostDTO ghostDTO);

    void delete(GhostDTO ghostDTO);
}
