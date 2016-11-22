package cz.muni.fi.pa165.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Vojta David, vojtadavid
 */
public class AbilityCreateDTO {
    private Long id;

    private String name;

    private String description;

    private List<GhostDTO> ghosts = new ArrayList<>();


    public AbilityDTO() {
    }


    public AbilityDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public AbilityDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AbilityDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AbilityDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<GhostDTO> getGhosts() {
        return Collections.unmodifiableList(ghosts);
    }

    public AbilityDTO setGhosts(List<GhostDTO> ghosts) {
        this.ghosts = ghosts;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().isInstance(o)) return false;

        AbilityDTO ability = (AbilityDTO) o;

        if (getId() != null ? !getId().equals(ability.getId()) : ability.getId() != null) return false;
        if (getName() != null ? !getName().equals(ability.getName()) : ability.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(ability.getDescription()) : ability.getDescription() != null)
            return false;
        return getGhosts() != null ? getGhosts().equals(ability.getGhosts()) : ability.getGhosts() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getGhosts() != null ? getGhosts().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AbilityDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ghosts=" + ghosts +
                '}';
    }
}
