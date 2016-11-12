package cz.muni.fi.pa165.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ondrej Ponteš
 */
public class GhostUpdateDTO {
    private String name;
    private Date hauntsFrom;
    private Date hauntsTo;
    private String description;
    private HouseDTO hauntedHouse;
    private List<AbilityDTO> abilities = new ArrayList<>();
    private List<HauntingDTO> hauntings = new ArrayList<>();

    public String getName() {
        return name;
    }

    public GhostUpdateDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Date getHauntsFrom() {
        return hauntsFrom;
    }

    public GhostUpdateDTO setHauntsFrom(Date hauntsFrom) {
        this.hauntsFrom = hauntsFrom;
        return this;
    }

    public Date getHauntsTo() {
        return hauntsTo;
    }

    public GhostUpdateDTO setHauntsTo(Date hauntsTo) {
        this.hauntsTo = hauntsTo;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GhostUpdateDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public HouseDTO getHauntedHouse() {
        return hauntedHouse;
    }

    public GhostUpdateDTO setHauntedHouse(HouseDTO hauntedHouse) {
        this.hauntedHouse = hauntedHouse;
        return this;
    }

    public List<AbilityDTO> getAbilities() {
        return abilities;
    }

    public GhostUpdateDTO setAbilities(List<AbilityDTO> abilities) {
        this.abilities = abilities;
        return this;
    }

    public List<HauntingDTO> getHauntings() {
        return hauntings;
    }

    public GhostUpdateDTO setHauntings(List<HauntingDTO> hauntings) {
        this.hauntings = hauntings;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GhostUpdateDTO that = (GhostUpdateDTO) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (hauntsFrom != null ? !hauntsFrom.equals(that.hauntsFrom) : that.hauntsFrom != null) return false;
        if (hauntsTo != null ? !hauntsTo.equals(that.hauntsTo) : that.hauntsTo != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (hauntedHouse != null ? !hauntedHouse.equals(that.hauntedHouse) : that.hauntedHouse != null) return false;
        if (abilities != null ? !abilities.equals(that.abilities) : that.abilities != null) return false;
        return hauntings != null ? hauntings.equals(that.hauntings) : that.hauntings == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (hauntsFrom != null ? hauntsFrom.hashCode() : 0);
        result = 31 * result + (hauntsTo != null ? hauntsTo.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (hauntedHouse != null ? hauntedHouse.hashCode() : 0);
        result = 31 * result + (abilities != null ? abilities.hashCode() : 0);
        result = 31 * result + (hauntings != null ? hauntings.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GhostUpdateDTO{" +
                "name='" + name + '\'' +
                ", hauntsFrom=" + hauntsFrom +
                ", hauntsTo=" + hauntsTo +
                ", description='" + description + '\'' +
                ", hauntedHouse=" + hauntedHouse +
                ", abilities=" + abilities +
                ", hauntings=" + hauntings +
                '}';
    }
}
