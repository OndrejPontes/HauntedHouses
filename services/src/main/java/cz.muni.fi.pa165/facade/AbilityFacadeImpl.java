package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.AbilityCreateDTO;
import cz.muni.fi.pa165.dto.AbilityDTO;
import cz.muni.fi.pa165.dto.AbilityUpdateDTO;
import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.services.AbilityService;
import cz.muni.fi.pa165.services.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Vojta David, vojtadavid
 */
@Transactional
@Service
public class AbilityFacadeImpl implements AbilityFacade {
    @Autowired
    private MappingService mappingService;

    @Autowired
    private AbilityService abilityService;


    @Override
    public Long create(AbilityCreateDTO abilityCreateDTO) {
        Ability ability = mappingService.mapObject(abilityCreateDTO, Ability.class);
        abilityService.create(ability);
        return ability.getId();
    }

    @Override
    public void update(AbilityUpdateDTO abilityUpdateDTO) {
        Ability ability = mappingService.mapObject(abilityUpdateDTO, Ability.class);
        abilityService.update(ability);
    }

    @Override
    public void delete(AbilityDTO abilityDTO) {
        Ability ghost = mappingService.mapObject(abilityDTO, Ability.class);
        abilityService.delete(ghost);
    }

    @Override
    public AbilityDTO getById(long id) {
        Ability ability = abilityService.getById(id);
        return mappingService.mapObject(ability, AbilityDTO.class);
    }

    @Override
    public AbilityDTO getByName(String name) {
        Ability ability = abilityService.getByName(name);
        return mappingService.mapObject(ability, AbilityDTO.class);
    }

    @Override
    public List<AbilityDTO> getAll() {
        List<AbilityDTO> abilityDTOs = mappingService.mapCollection(abilityService.getAll(), AbilityDTO.class);
        return abilityDTOs;
    }
}