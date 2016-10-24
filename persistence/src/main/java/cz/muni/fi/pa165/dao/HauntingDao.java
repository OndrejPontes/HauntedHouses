package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Haunting;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Monika Mociarikova
 */
public interface HauntingDao {


    public void create(Haunting haunting);

    public Haunting update(Haunting haunting);

    public void delete(Haunting haunting);

    public Haunting getById(Long id);

    public List<Haunting> getByDate (LocalDate date);

    public List<Haunting> getAll();

}
