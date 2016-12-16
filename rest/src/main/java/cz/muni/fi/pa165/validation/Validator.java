package cz.muni.fi.pa165.validation;

import org.springframework.beans.factory.annotation.Autowired;

import cz.muni.fi.pa165.dto.AbilityCreateDTO;
import cz.muni.fi.pa165.dto.AbilityDTO;
import cz.muni.fi.pa165.dto.GhostCreateDTO;
import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.dto.HauntingCreateDTO;
import cz.muni.fi.pa165.dto.HauntingDTO;
import cz.muni.fi.pa165.dto.HouseCreateDTO;
import cz.muni.fi.pa165.dto.HouseDTO;
import cz.muni.fi.pa165.exception.ScaryDataAccessException;
import cz.muni.fi.pa165.facade.AbilityFacade;
import cz.muni.fi.pa165.facade.GhostFacade;
import cz.muni.fi.pa165.facade.HouseFacade;
import cz.muni.fi.pa165.services.MappingService;

public class Validator {

    @Autowired
    private HouseFacade houseFacade;
    @Autowired
    private AbilityFacade abilityFacade;
    @Autowired
    private GhostFacade ghostFacade;
    @Autowired
    private MappingService mappingService;

    public void validate(HouseDTO houseDTO) {
        if (houseDTO == null) {
            throw new ScaryDataAccessException("house is null");
        }

        if (houseDTO.getId() == null) {
            throw new ScaryDataAccessException("id is null");
        }

        if (houseDTO.getName() == null) {
            throw new ScaryDataAccessException("name is null");
        }

        if (houseDTO.getAddress() == null) {
            throw new ScaryDataAccessException("address is null");
        }

        HouseDTO byName = houseFacade.getByName(houseDTO.getName());
        HouseDTO byAddress = houseFacade.getByAddress(houseDTO.getAddress());

        if (byName != null && !byName.getId().equals(houseDTO.getId())) {
            throw new ScaryDataAccessException("duplicit name");
        }

        if (byAddress != null && !byAddress.getId().equals(houseDTO.getId())) {
            throw new ScaryDataAccessException("duplicit name");
        }
    }

    public void validate(HouseCreateDTO houseCreateDTO) {
        HouseDTO houseDTO = mappingService.mapObject(houseCreateDTO, HouseDTO.class).setId(-1L);
        validate(houseDTO);
    }

    public void validate(AbilityDTO abilityDTO) {
        if (abilityDTO == null) {
            throw new ScaryDataAccessException("ability is null");
        }

        if (abilityDTO.getName() == null) {
            throw new ScaryDataAccessException("name is null");
        }

        AbilityDTO byName = abilityFacade.getByName(abilityDTO.getName());

        if (byName != null && !byName.getId().equals(abilityDTO.getId())) {
            throw new ScaryDataAccessException("duplicit name");
        }
    }

    public void validate(AbilityCreateDTO abilityCreateDTO) {
        AbilityDTO abilityDTO = mappingService.mapObject(abilityCreateDTO, AbilityDTO.class).setId(-1L);
        validate(abilityDTO);
    }

    public void validate(HauntingDTO hauntingDTO) {
        if(hauntingDTO == null) {
            throw new ScaryDataAccessException("haunting is null");
        }

        if(hauntingDTO.getDate() == null) {
            throw new ScaryDataAccessException("date is null");
        }

        if(hauntingDTO.getHauntedHouse() == null) {
            throw new ScaryDataAccessException("house is null");
        }

        if(hauntingDTO.getGhosts() == null || hauntingDTO.getGhosts().isEmpty()) {
            throw new ScaryDataAccessException("ghosts are null or empty");
        }

        if(hauntingDTO.getId() == null) {
            throw new ScaryDataAccessException("id is null");
        }

        for(GhostDTO ghostDTO : hauntingDTO.getGhosts()) {
            validate(ghostDTO);
        }

        validate(hauntingDTO.getHauntedHouse());
    }

    public void validate(HauntingCreateDTO hauntingCreateDTO) {
        HauntingDTO hauntingDTO = mappingService.mapObject(hauntingCreateDTO, HauntingDTO.class).setId(-1L);
        validate(hauntingDTO);
    }

    public void validate(GhostDTO ghostDTO) {
        if(ghostDTO == null) {
            throw new ScaryDataAccessException("ghost is null");
        }

        if(ghostDTO.getId() == null) {
            throw new ScaryDataAccessException("id is null");
        }

        if(ghostDTO.getName() == null) {
            throw new ScaryDataAccessException("name is null");
        }

        if(ghostDTO.getHauntsFrom() == null) {
            throw new ScaryDataAccessException("hauntsFrom is null");
        }

        if(ghostDTO.getHauntsTo() == null) {
            throw new ScaryDataAccessException("hauntsTo is null");
        }

        if(ghostDTO.getDescription() == null) {
            throw new ScaryDataAccessException("description is null");
        }

        GhostDTO byName = ghostFacade.getByName(ghostDTO.getName());

        if(byName != null && !byName.getId().equals(ghostDTO.getId())) {
            throw new ScaryDataAccessException("duplicit name");
        }
    }

    public void validate(GhostCreateDTO ghostCreateDTO) {
        GhostDTO ghostDTO = mappingService.mapObject(ghostCreateDTO, GhostDTO.class).setId(-1L);
        validate(ghostDTO);
    }
}
