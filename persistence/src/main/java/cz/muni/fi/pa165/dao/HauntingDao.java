package cz.muni.fi.pa165.dao;

import java.util.Date;
import java.util.List;

import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.entity.House;

/**
 * @author Monika Mociarikova
 */
public interface HauntingDao {
    /**
     * Create haunting
     * @param haunting Haunting object for creating
     */
    Haunting create(Haunting haunting);

    /**
     * Updates haunting
     * @param haunting Haunting object for updating
     */
     Haunting update(Haunting haunting);

    /**
     * Removes haunting
     * @param haunting Haunting object for deleting
     */
     void delete(Haunting haunting);

    /**
     * Gets haunting by id
     * @param id of haunting to be found
     * @return Haunting object with specified id
     */
     Haunting getById(Long id);

    /**
     * Gets hauntings by date
     * @param date of haunting to be found
     * @return list of Haunting objects with specified date
     */
     List<Haunting> getByDate (Date date);

    /**
     * Gets all hauntings
     * @return list of all hauntings.
     */
     List<Haunting> getAll();

     List<Haunting> getHauntingsOfGhost(Ghost ghost);

     List<Haunting> getHauntingsOfHouse(House house);


}
