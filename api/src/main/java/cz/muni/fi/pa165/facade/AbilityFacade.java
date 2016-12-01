package cz.muni.fi.pa165.facade;

import java.util.Collection;

import cz.muni.fi.pa165.dto.AbilityCreateDTO;
import cz.muni.fi.pa165.dto.AbilityDTO;

/**
 * Created by vojta on 22.11.16.
 */
public interface AbilityFacade {

    AbilityDTO create(AbilityCreateDTO abilityCreateDTO);

    AbilityDTO update(AbilityDTO abilityDTO);

    void delete(AbilityDTO abilityDTO);

    AbilityDTO getById(Long id);

    AbilityDTO getByName(String name);

    Collection<AbilityDTO> getAll();
}
