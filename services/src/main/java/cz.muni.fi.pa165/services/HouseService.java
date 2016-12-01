package cz.muni.fi.pa165.services;

import java.util.Collection;

import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.entity.House;

/**
 * @author Jirka Kruml
 */
public interface HouseService {

    Collection<House> getAll();

    House getByName(String name);

    House getByAddress(String address);

    House getById(long id);

    /**
     * Get all abilities from haunting history of house.
     */
    Collection<Ability> getAllAbilities(Long id);

    /**
     * Get all abilities from haunting history of house.
     */
    Collection<Ability> getAllAbilities(House house);

    /**
     * Get only abilities from currently active ghosts.
     */
    Collection<Ability> getActiveAbilities(Long id);

    /**
     * Get only abilities from currently active ghosts.
     */
    Collection<Ability> getActiveAbilities(House house);

    House create(House house);

    House update(House house);

    void delete(long id);

}
