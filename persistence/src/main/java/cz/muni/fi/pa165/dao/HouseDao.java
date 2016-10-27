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
     * Finds a house in the database by it's name
     * @param name - the name of the house
     * @return - the house by the given name
     */
    House getByName(String name);

    /**
     * Finds a house in the database by it's address
     * @param address - the address of the house
     * @return - the house by the given address
     */
    House getByAddress(String address);

    /**
     * @return a collection of all houses stored in the database
     */
    List<House> getAll();
}
