package cz.muni.fi.pa165.services;

import cz.muni.fi.pa165.entity.Ghost;

import java.util.List;

/**
 * @author Ondrej Ponteš
 */
public interface GhostService {
    Long create(Ghost ghost);
    Ghost update(Ghost ghost);
    void delete(Ghost ghost);
    Ghost getById(long id);
    List<Ghost> getByName(String name);
    List<Ghost> getAll();
}
