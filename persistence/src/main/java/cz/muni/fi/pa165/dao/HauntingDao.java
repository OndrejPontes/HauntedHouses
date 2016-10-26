package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Haunting;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Monika Mociarikova
 */
public interface HauntingDao {


    /**
     * Create haunting
     * @param haunting Haunting object for creating
     */
    public void create(Haunting haunting);

    /**
     * Updates haunting
     * @param haunting Haunting object for updating
     */
    public Haunting update(Haunting haunting);

    /**
     * Removes haunting
     * @param haunting Haunting object for deleting
     */
    public void delete(Haunting haunting);

    /**
     * Gets haunting by id
     * @param id of haunting to be found
     * @return Haunting object with specified id
     */
    public Haunting getById(Long id);

    /**
     * Gets hauntings by date
     * @param date of haunting to be found
     * @return list of Haunting objects with specified date
     */
    public List<Haunting> getByDate (LocalDate date);

    /**
     * Gets all hauntings
     * @return list of all hauntings.
     */
    public List<Haunting> getAll();

}
