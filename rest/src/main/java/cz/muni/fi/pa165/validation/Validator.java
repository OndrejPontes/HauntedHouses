package cz.muni.fi.pa165.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

@Component
public class Validator {

    @Autowired
    private HouseFacade houseFacade;
    @Autowired
    private AbilityFacade abilityFacade;
    @Autowired
    private GhostFacade ghostFacade;
    @Autowired
    private MappingService mappingService;

    public List<String> validate(HouseDTO houseDTO) {
        List<String> errors = new ArrayList<>();
        if (houseDTO == null) {
            errors.add("The house cannot be null.");
        } else if (houseDTO.getId() == null) {
            errors.add("The house id cannot be null.");
        } else {
            HouseDTO byName = null;
            if (houseDTO.getName() == null) {
                errors.add("You must fill the name of the house.");
            } else {
                byName = houseFacade.getByName(houseDTO.getName());
            }

            HouseDTO byAddress = null;
            if (houseDTO.getAddress() == null) {
                errors.add("You must fill the address of the house.");
            } else {
                byAddress = houseFacade.getByAddress(houseDTO.getAddress());
            }

            if (byName != null && !byName.getId().equals(houseDTO.getId())) {
                errors.add("A house with this name already exists.");
            }

            if (byAddress != null && !byAddress.getId().equals(houseDTO.getId())) {
                errors.add("A house with this address already exists.");
            }
        }

        return errors;
    }

    public List<String> validate(HouseCreateDTO houseCreateDTO) {
        HouseDTO houseDTO = mappingService.mapObject(houseCreateDTO, HouseDTO.class).setId(-1L);
        return validate(houseDTO);
    }

    public List<String> validate(AbilityDTO abilityDTO) {
        List<String> errors = new ArrayList<>();
        if (abilityDTO == null) {
            errors.add("The ability cannot be null.");
        } else if (abilityDTO.getId() == null) {
            errors.add("The ability id cannot be null.");
        } else {
            AbilityDTO byName = null;
            if (abilityDTO.getName() == null) {
                errors.add("You must fill the name of the ability.");
            } else {
                byName = abilityFacade.getByName(abilityDTO.getName());
            }

            if (byName != null && !byName.getId().equals(abilityDTO.getId())) {
                errors.add("An ability with this name already exists.");
            }
        }
        return errors;
    }

    public List<String> validate(AbilityCreateDTO abilityCreateDTO) {
        AbilityDTO abilityDTO = mappingService.mapObject(abilityCreateDTO, AbilityDTO.class).setId(-1L);
        return validate(abilityDTO);
    }

    public List<String> validate(HauntingDTO hauntingDTO) {
        List<String> errors = new ArrayList<>();
        if (hauntingDTO == null) {
            errors.add("The haunting cannot be null.");
        } else if (hauntingDTO.getId() == null) {
            errors.add("The id of the haunting cannot be null.");
        } else {

            if (hauntingDTO.getDate() == null) {
                errors.add("You must fill the date.");
            }

            if (hauntingDTO.getHauntedHouse() == null) {
                errors.add("You must specify the house.");
            }

            if (hauntingDTO.getGhosts() == null || hauntingDTO.getGhosts().isEmpty()) {
                errors.add("At least one ghost must be present.");
            }

            for (GhostDTO ghostDTO : hauntingDTO.getGhosts()) {
                errors.addAll(validate(ghostDTO));
            }
            errors.addAll(validate(hauntingDTO.getHauntedHouse()));
        }
        return errors;
    }

    public List<String> validate(HauntingCreateDTO hauntingCreateDTO) {
        HauntingDTO hauntingDTO = mappingService.mapObject(hauntingCreateDTO, HauntingDTO.class).setId(-1L);
        return validate(hauntingDTO);
    }

    public List<String> validate(GhostDTO ghostDTO) {
        List<String> errors = new ArrayList<>();

        if (ghostDTO == null) {
            errors.add("The ghost cannot be null.");
        } else if (ghostDTO.getId() == null) {
            errors.add("The ghost id cannot be null.");
        } else {
            GhostDTO byName = null;
            if (ghostDTO.getName() == null) {
                errors.add("You must fill the name of the ghost.");
            } else {
                byName = ghostFacade.getByName(ghostDTO.getName());
            }

            if (ghostDTO.getHauntsFrom() == null) {
                errors.add("You must fill from when the ghost is haunting.");
            }

            if (ghostDTO.getHauntsTo() == null) {
                errors.add("You must fill until when the ghost is haunting.");
            }

            if (ghostDTO.getDescription() == null) {
                errors.add("You must enter a description of the ghost.");
            }

            if (byName != null && !byName.getId().equals(ghostDTO.getId())) {
                errors.add("A ghost with this name already exists.");
            }

            if (ghostDTO.getHauntedHouse() != null) {
                errors.addAll(validate(ghostDTO.getHauntedHouse()));
            }

            if (ghostDTO.getAbilities() != null) {
                for(AbilityDTO ability : ghostDTO.getAbilities()) {
                    errors.addAll(validate(ability));
                }
            }
        }


        return errors;
    }

    public List<String> validate(GhostCreateDTO ghostCreateDTO) {
        GhostDTO ghostDTO = mappingService.mapObject(ghostCreateDTO, GhostDTO.class).setId(-1L);
        return validate(ghostDTO);
    }
}
