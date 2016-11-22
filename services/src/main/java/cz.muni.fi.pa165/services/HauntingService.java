package cz.muni.fi.pa165.services;

import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.Haunting;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

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

    Haunting findById(Long id);

    List<Haunting> findByDate (Date date);

    List<Haunting> findAll();


}
