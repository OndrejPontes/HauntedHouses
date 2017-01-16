package cz.muni.fi.pa165.dao;

import java.util.List;

import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.entity.House;

/**
 * @author Ondrej Ponteš
 */
public interface GhostDao {
    /**
     * Create ghost
     * @param ghost Ghost object for creating
     */
     Ghost create(Ghost ghost);

    /**
     * Updates ghost
     * @param ghost Ghost object for updating
     */
     Ghost update(Ghost ghost);

    /**
     * Removes ghost
     * @param ghost Ghost object for deleting
     */
     void delete(Ghost ghost);

    /**
     * Gets ghost by id
     * @param id of ghost to be found
     * @return Ghost object with specified id
     */
     Ghost getById(long id);

    /**
     * Gets ghost by name
     * @param name of ghost to be found
     * @return Ghost object with specified name
     */
     Ghost getByName(String name);

    /**
     * Gets all ghosts
     * @return list of all ghosts.
     */
     List<Ghost> getAll();

    /**
     * Gets ghost by ability
     * @param ability of ghost to be found
     * @return Ghost collection with specified ability
     */
    List<Ghost> getByAbility(Ability ability);

    List<Ghost> getGhostsOfHouse(House house);

}
