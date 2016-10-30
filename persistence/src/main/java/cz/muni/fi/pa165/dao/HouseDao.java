package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.House;

import java.util.List;

/**
 * @author Jirka Kruml
 */
public interface HouseDao {

    /**
     * Saves the entity into the database
     * @param house - the entity
     */
    void create(House house);

    /**
     * Updates the entity in the database and returns it
     * @param house - the entity
     * @return - the updated entity
     */
    House update(House house);

    /**
     * Removes the entity from the database
     * @param house - the entity
     * @return true if the deletion was successful, false otherwise
     */
    void delete(House house);

    /**
     * Finds the entity in the database by it's id
     * @param id - the id of the entity
     * @return - the entity by the given id
     */
    House getById(long id);

    /**
     * Finds a list of houses in the database by their name
     * @param name - the name of the houses
     * @return - the list of houses by the given name
     */
    List<House> getByName(String name);

    /**
     * Finds a list of houses in the database by their address
     * @param address - the address of the houses
     * @return - the list of hosues by the given address
     */
    List<House> getByAddress(String address);

    /**
     * @return a collection of all houses stored in the database
     */
    List<House> getAll();
}
