package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.AbilityCreateDTO;
import cz.muni.fi.pa165.dto.AbilityDTO;
import cz.muni.fi.pa165.dto.AbilityUpdateDTO;

import java.util.Collection;
import java.util.List;

/**
 * Created by vojta on 22.11.16.
 */
public interface AbilityFacade {

    AbilityDTO create(AbilityCreateDTO Ability);

    void update(AbilityUpdateDTO Ability);

    void delete(AbilityDTO Ability);

    AbilityDTO getById(long id);

    AbilityDTO getByName(String name);

    Collection<AbilityDTO> getAll();
}
