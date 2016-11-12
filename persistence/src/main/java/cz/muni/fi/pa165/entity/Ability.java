package cz.muni.fi.pa165.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Vojta David
 * @author Monika Mociarikova
 */
@Entity
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToMany(mappedBy = "abilities")
    private List<Ghost> ghosts = new ArrayList<>();
    

    public Ability() {
    }


    public Ability(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Ability setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Ability setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Ability setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Ghost> getGhosts() {
        return Collections.unmodifiableList(ghosts);
    }

    public Ability setGhosts(List<Ghost> ghosts) {
        this.ghosts = ghosts;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().isInstance(o)) return false;

        Ability ability = (Ability) o;

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
}
