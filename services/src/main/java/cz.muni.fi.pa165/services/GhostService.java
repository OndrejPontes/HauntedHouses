package cz.muni.fi.pa165.services;

import java.util.List;

import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.entity.House;

/**
 * @author Ondrej Ponteš
 */
public interface GhostService {
    Ghost create(Ghost ghost);
    Ghost update(Ghost ghost);
    void delete(Ghost ghost);
    Ghost getById(long id);
    Ghost getByName(String name);
    List<Ghost> getAll();
    List<Ghost> getByAbility(Ability aiblity);
    List<Ghost> getGhostsOfHouse(House house);
}
