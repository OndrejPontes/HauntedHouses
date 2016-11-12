package cz.muni.fi.pa165.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author Ondrej Ponteš
 */
@Entity
public class Ghost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date hauntsFrom;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date hauntsTo;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private House hauntedHouse;

    @ManyToMany
    private List<Ability> abilities = new ArrayList<>();

    @ManyToMany(mappedBy = "ghosts")
    private List<Haunting> hauntings = new ArrayList<>();

    public Ghost() {
    }

    public Ghost(String name, Date hauntsFrom, Date hauntsTo, String description) {
        this.name = name;
        this.hauntsFrom = hauntsFrom;
        this.hauntsTo = hauntsTo;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Ghost setId(Long id) {
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

    public Date getHauntsFrom() {
        return hauntsFrom;
    }

    public Ghost setHauntsFrom(Date hauntsFrom) {
        this.hauntsFrom = hauntsFrom;
        return this;
    }

    public Date getHauntsTo() {
        return hauntsTo;
    }

    public Ghost setHauntsTo(Date hauntsTo) {
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
        return Collections.unmodifiableList(abilities);
    }

    public Ghost setAbilities(List<Ability> abilities) {
        this.abilities = Collections.unmodifiableList(abilities);
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
        if (o == null || !getClass().isInstance(o)) return false;

        Ghost ghost = (Ghost) o;

        if (getId() != ghost.getId()) return false;
        if (getName() != null ? !getName().equals(ghost.getName()) : ghost.getName() != null) return false;
        if (getHauntsFrom() != null ? !getHauntsFrom().equals(ghost.getHauntsFrom()) : ghost.getHauntsFrom() != null)
            return false;
        if (getHauntsTo() != null ? !getHauntsTo().equals(ghost.getHauntsTo()) : ghost.getHauntsTo() != null)
            return false;
        if (getDescription() != null ? !getDescription().equals(ghost.getDescription()) : ghost.getDescription() != null)
            return false;
        if (getHauntedHouse() != null ? !getHauntedHouse().equals(ghost.getHauntedHouse()) : ghost.getHauntedHouse() != null)
            return false;
        if (getAbilities() != null ? !getAbilities().equals(ghost.getAbilities()) : ghost.getAbilities() != null)
            return false;
        return getHauntings() != null ? getHauntings().equals(ghost.getHauntings()) : ghost.getHauntings() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getHauntsFrom() != null ? getHauntsFrom().hashCode() : 0);
        result = 31 * result + (getHauntsTo() != null ? getHauntsTo().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getHauntedHouse() != null ? getHauntedHouse().hashCode() : 0);
        result = 31 * result + (getAbilities() != null ? getAbilities().hashCode() : 0);
        result = 31 * result + (getHauntings() != null ? getHauntings().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ghost{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hauntsFrom=" + hauntsFrom +
                ", hauntsTo=" + hauntsTo +
                ", description='" + description + '\'' +
                ", hauntedHouse=" + hauntedHouse +
                ", abilities=" + abilities +
                ", hauntings=" + hauntings +
                '}';
    }
}
