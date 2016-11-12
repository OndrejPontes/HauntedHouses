package cz.muni.fi.pa165.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GhostCreateDTO that = (GhostCreateDTO) o;

        if (!name.equals(that.name)) return false;
        if (!hauntsFrom.equals(that.hauntsFrom)) return false;
        if (!hauntsTo.equals(that.hauntsTo)) return false;
        return description != null ? description.equals(that.description) : that.description == null;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + hauntsFrom.hashCode();
        result = 31 * result + hauntsTo.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GhostCreateDTO{" +
                "name='" + name + '\'' +
                ", hauntsFrom=" + hauntsFrom +
                ", hauntsTo=" + hauntsTo +
                ", description='" + description + '\'' +
                '}';
    }
}
