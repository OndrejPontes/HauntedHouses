package cz.muni.fi.pa165.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Vojta David, vojtadavid
 */
public class AbilityCreateDTO {
    private String name;

    private String description;

    private List<Long> ghosts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public AbilityCreateDTO() {
    }

    public AbilityCreateDTO(String name, String description, List<Long> ghosts) {
        this.name = name;
        this.description = description;
        this.ghosts = ghosts;
    }

    public AbilityCreateDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AbilityCreateDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Long> getGhosts() {
        return Collections.unmodifiableList(ghosts);
    }

    public AbilityCreateDTO setGhosts(List<Long> ghosts) {
        this.ghosts = ghosts;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbilityCreateDTO that = (AbilityCreateDTO) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return ghosts != null ? ghosts.equals(that.ghosts) : that.ghosts == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (ghosts != null ? ghosts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AbilityCreateDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ghosts=" + ghosts +
                '}';
    }
}
