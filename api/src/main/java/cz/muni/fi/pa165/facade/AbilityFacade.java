package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.AbilityCreateDTO;
import cz.muni.fi.pa165.dto.AbilityDTO;

import java.util.Collection;

/**
 * Created by vojta on 22.11.16.
 */
public interface AbilityFacade {

    Long create(AbilityCreateDTO Ability);

    void update(AbilityDTO Ability);

    void delete(AbilityDTO Ability);

    AbilityDTO getById(long id);

    AbilityDTO getByName(String name);

    Collection<AbilityDTO> getAll();
}
