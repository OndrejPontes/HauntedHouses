package cz.muni.fi.pa165.services;

import java.util.List;

import cz.muni.fi.pa165.entity.Ability;

/**
 * @author Vojta David, vojtadavod
 */
public interface AbilityService {
    /**
     * Create Ability
     * @param ability Ability object for creating
     */
    Ability create(Ability ability);

    /**
     * Updates Ability
     * @param ability Ability object for updating
     */
    Ability update(Ability ability);

    /**
     * Removes Ability
     * @param ability Ability object for deleting
     */
    void delete(Ability ability);

    /**
     * Gets Ability by id
     * @param id of Ability to be found
     * @return ability object with specified id
     */
    Ability getById(Long id);

    /**
     * Gets Ability by name
     * @param name of Ability to be found
     * @return list of Ability object with specified name
     */
    Ability getByName(String name);

    /**
     * Gets all Abilitys
     * @return list of all Abilitys.
     */
    List<Ability> getAll();
}
