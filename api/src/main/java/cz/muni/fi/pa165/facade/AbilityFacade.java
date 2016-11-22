package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.AbilityDTO;

import java.util.List;

/**
 * Created by vojta on 22.11.16.
 */
public interface AbilityFacade {
    /**
     * Create Ability
     * @param Ability Ability object for creating
     */
    void create(AbilityDTO Ability);

    /**
     * Updates Ability
     * @param Ability Ability object for updating
     */
    AbilityDTO update(AbilityDTO Ability);

    /**
     * Removes Ability
     * @param Ability Ability object for deleting
     */
    void delete(AbilityDTO Ability);

    /**
     * Gets Ability by id
     * @param id of Ability to be found
     * @return Ability object with specified id
     */
    AbilityDTO getById(long id);

    /**
     * Gets Ability by name
     * @param name of Ability to be found
     * @return list of Ability object with specified name
     */
    AbilityDTO getByName(String name);

    /**
     * Gets all Abilitys
     * @return list of all Abilitys.
     */
    List<AbilityDTO> getAll();
}
