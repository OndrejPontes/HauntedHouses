package cz.muni.fi.pa165.services;

import java.util.Date;
import java.util.List;

import cz.muni.fi.pa165.entity.House;
import org.springframework.stereotype.Service;

import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.Haunting;

/**
 * @author MonikaMociarikova
 *
 * An interface that defines a service access to the {@link Haunting} entity.
 */

@Service
public interface HauntingService {

    Haunting create(Haunting haunting);

    void remove(Haunting haunting);

    void addGhost(Haunting haunting, Ghost ghost);

    void removeGhost(Haunting haunting, Ghost ghost);

    Haunting update(Haunting haunting);

    Haunting getById(Long id);

    List<Haunting> getByDate(Date date);

    List<Haunting> getAll();

    List<Haunting> getHauntingsOfGhost(Ghost ghost);

    List<Haunting> getHauntingsOfHouse(House house);

}
