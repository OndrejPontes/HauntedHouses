package cz.muni.fi.pa165.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ondrej Ponteš
 */
public class GhostDTO {
    private Long id;
    private String name;
    private Date hauntsFrom;
    private Date hauntsTo;
    private String description;
    private List<AbilityDTO> abilities = new ArrayList<>();

    public GhostDTO() {
    }

    public GhostDTO(Long id, String name, Date hauntsFrom, Date hauntsTo, String description, List<AbilityDTO> abilities) {
        this.id = id;
        this.name = name;
        this.hauntsFrom = hauntsFrom;
        this.hauntsTo = hauntsTo;
        this.description = description;
        this.abilities = abilities;
    }

    public Long getId() {
        return id;
    }

    public GhostDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GhostDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Date getHauntsFrom() {
        return hauntsFrom;
    }

    public GhostDTO setHauntsFrom(Date hauntsFrom) {
        this.hauntsFrom = hauntsFrom;
        return this;
    }

    public Date getHauntsTo() {
        return hauntsTo;
    }

    public GhostDTO setHauntsTo(Date hauntsTo) {
        this.hauntsTo = hauntsTo;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GhostDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<AbilityDTO> getAbilities() {
        return abilities;
    }

    public GhostDTO setAbilities(List<AbilityDTO> abilities) {
        this.abilities = abilities;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GhostDTO ghostDTO = (GhostDTO) o;

        if (id != null ? !id.equals(ghostDTO.id) : ghostDTO.id != null) return false;
        if (name != null ? !name.equals(ghostDTO.name) : ghostDTO.name != null) return false;
        if (hauntsFrom != null ? !hauntsFrom.equals(ghostDTO.hauntsFrom) : ghostDTO.hauntsFrom != null) return false;
        if (hauntsTo != null ? !hauntsTo.equals(ghostDTO.hauntsTo) : ghostDTO.hauntsTo != null) return false;
        if (description != null ? !description.equals(ghostDTO.description) : ghostDTO.description != null)
            return false;
        return abilities != null ? abilities.equals(ghostDTO.abilities) : ghostDTO.abilities != null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (hauntsFrom != null ? hauntsFrom.hashCode() : 0);
        result = 31 * result + (hauntsTo != null ? hauntsTo.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (abilities != null ? abilities.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GhostDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hauntsFrom=" + hauntsFrom +
                ", hauntsTo=" + hauntsTo +
                ", description='" + description + '\'' +
                ", abilities=" + abilities +
                '}';
    }
}
