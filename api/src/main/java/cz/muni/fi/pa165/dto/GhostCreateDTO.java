package cz.muni.fi.pa165.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author Ondrej Ponteš
 */
public class GhostCreateDTO {
    @NotNull
    @Size(min = 3, max = 8)
    private String name;

    @NotNull
    private Date hauntsFrom;

    @NotNull
    private Date hauntsTo;

    private String description;
    private List<Long> abilities = new ArrayList<>();
    private List<Long> hauntings = new ArrayList<>();

    public GhostCreateDTO() {
    }

    public GhostCreateDTO(String name, Date hauntsFrom, Date hauntsTo, String description, List<Long> abilities, List<Long> hauntings) {
        this.name = name;
        this.hauntsFrom = hauntsFrom;
        this.hauntsTo = hauntsTo;
        this.description = description;
        this.abilities = abilities;
        this.hauntings = hauntings;
    }

    public String getName() {
        return name;
    }

    public GhostCreateDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Date getHauntsFrom() {
        return hauntsFrom;
    }

    public GhostCreateDTO setHauntsFrom(Date hauntsFrom) {
        this.hauntsFrom = hauntsFrom;
        return this;
    }

    public Date getHauntsTo() {
        return hauntsTo;
    }

    public GhostCreateDTO setHauntsTo(Date hauntsTo) {
        this.hauntsTo = hauntsTo;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GhostCreateDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Long> getAbilities() {
        return Collections.unmodifiableList(abilities);
    }

    public GhostCreateDTO setAbilities(List<Long> abilities) {
        this.abilities = abilities;
        return this;
    }

    public List<Long> getHauntings() {
        return Collections.unmodifiableList(hauntings);
    }

    public GhostCreateDTO setHauntings(List<Long> hauntings) {
        this.hauntings = hauntings;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GhostCreateDTO that = (GhostCreateDTO) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (hauntsFrom != null ? !hauntsFrom.equals(that.hauntsFrom) : that.hauntsFrom != null) return false;
        if (hauntsTo != null ? !hauntsTo.equals(that.hauntsTo) : that.hauntsTo != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (abilities != null ? !abilities.equals(that.abilities) : that.abilities != null) return false;
        return hauntings != null ? hauntings.equals(that.hauntings) : that.hauntings == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (hauntsFrom != null ? hauntsFrom.hashCode() : 0);
        result = 31 * result + (hauntsTo != null ? hauntsTo.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (abilities != null ? abilities.hashCode() : 0);
        result = 31 * result + (hauntings != null ? hauntings.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GhostCreateDTO{" +
                "name='" + name + '\'' +
                ", hauntsFrom=" + hauntsFrom +
                ", hauntsTo=" + hauntsTo +
                ", description='" + description + '\'' +
                ", abilities=" + abilities +
                ", hauntings=" + hauntings +
                '}';
    }
}
