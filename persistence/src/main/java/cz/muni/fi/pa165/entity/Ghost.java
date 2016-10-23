package cz.muni.fi.pa165.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ondrej Ponteš
 */
@Entity
public class Ghost {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate hauntsFrom;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate hauntsTo;

    @NotNull
    private String description;

    @ManyToOne
    private House hauntedHouse;

    @ManyToMany
    private List<Ability> abilities = new ArrayList<Ability>();

    @ManyToMany
    private List<Haunting> hauntings = new ArrayList<Haunting>();

    public Ghost() {
    }

    public Ghost(String name, LocalDate hauntsFrom, LocalDate hauntsTo, String description) {
        this.name = name;
        this.hauntsFrom = hauntsFrom;
        this.hauntsTo = hauntsTo;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Ghost setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Ghost setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getHauntsFrom() {
        return hauntsFrom;
    }

    public Ghost setHauntsFrom(LocalDate hauntsFrom) {
        this.hauntsFrom = hauntsFrom;
        return this;
    }

    public LocalDate getHauntsTo() {
        return hauntsTo;
    }

    public Ghost setHauntsTo(LocalDate hauntsTo) {
        this.hauntsTo = hauntsTo;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Ghost setDescription(String description) {
        this.description = description;
        return this;
    }

    public House getHauntedHouse() {
        return hauntedHouse;
    }

    public Ghost setHauntedHouse(House hauntedHouse) {
        this.hauntedHouse = hauntedHouse;
        return this;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public Ghost setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
        return this;
    }

    public List<Haunting> getHauntings() {
        return hauntings;
    }

    public Ghost setHauntings(List<Haunting> hauntings) {
        this.hauntings = hauntings;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ghost ghost = (Ghost) o;

        if (id != ghost.id) return false;
        if (!name.equals(ghost.name)) return false;
        if (!hauntsFrom.equals(ghost.hauntsFrom)) return false;
        if (!hauntsTo.equals(ghost.hauntsTo)) return false;
        if (!description.equals(ghost.description)) return false;
        if (hauntedHouse != null ? !hauntedHouse.equals(ghost.hauntedHouse) : ghost.hauntedHouse != null) return false;
        if (abilities != null ? !abilities.equals(ghost.abilities) : ghost.abilities != null) return false;
        return hauntings != null ? hauntings.equals(ghost.hauntings) : ghost.hauntings == null;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = id;
        result = prime * result + name.hashCode();
        result = prime * result + hauntsFrom.hashCode();
        result = prime * result + hauntsTo.hashCode();
        result = prime * result + description.hashCode();
        result = prime * result + (hauntedHouse != null ? hauntedHouse.hashCode() : 0);
        result = prime * result + (abilities != null ? abilities.hashCode() : 0);
        result = prime * result + (hauntings != null ? hauntings.hashCode() : 0);
        return result;
    }
}
