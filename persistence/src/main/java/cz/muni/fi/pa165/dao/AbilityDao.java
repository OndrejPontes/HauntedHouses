package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Ability;

import java.util.List;

/**
 * Created by vojta on 10/25/16.
 * @author vojta
 */
public interface AbilityDao {
    /**
     * Create Ability
     * @param Ability Ability object for creating
     */
    public void create(Ability Ability);

    /**
     * Updates Ability
     * @param Ability Ability object for updating
     */
    public Ability update(Ability Ability);

    /**
     * Removes Ability
     * @param Ability Ability object for deleting
     */
    public void delete(Ability Ability);

    /**
     * Gets Ability by id
     * @param id of Ability to be found
     * @return Ability object with specified id
     */
    public Ability getById(long id);

    /**
     * Gets Ability by name
     * @param name of Ability to be found
     * @return list of Ability object with specified name
     */
    public Ability getByName(String name);

    /**
     * Gets all Abilitys
     * @return list of all Abilitys.
     */
    public List<Ability> getAll();
}
