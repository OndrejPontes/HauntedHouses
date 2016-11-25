package cz.muni.fi.pa165.services;

import java.util.Collection;

import cz.muni.fi.pa165.entity.House;

/**
 * @author Jirka Kruml
 */
public interface HouseService {

    Collection<House> getAll();

    House getByName(String name);

    House getByAddress(String address);

    House getById(Long id);

    House create(House house);

    House update(House house);

    void delete(Long id);

}
