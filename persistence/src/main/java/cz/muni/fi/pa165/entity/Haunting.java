package cz.muni.fi.pa165.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author Monika Mociarikova
 */
@Entity
public class Haunting {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date;

    @NotNull
    private int numberOfPeoplePresent;

    @ManyToOne
    private House hauntedHouse;

    @ManyToMany
    private List<Ghost> ghosts;

    public Haunting(){
    }

    public Haunting(Date date, int numberOfPeoplePresent) {
        this.date = date;
        this.numberOfPeoplePresent = numberOfPeoplePresent;
    }

    public Long getId() {
        return id;
    }

    public Haunting setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Haunting setDate(Date date) {
        this.date = date;
        return this;
    }

    public int getNumberOfPeoplePresent() {
        return numberOfPeoplePresent;
    }

    public Haunting setNumberOfPeoplePresent(int numberOfPeoplePresent) {
        this.numberOfPeoplePresent = numberOfPeoplePresent;
        return this;
    }

    public House getHauntedHouse() {
        return hauntedHouse;
    }

    public Haunting setHauntedHouse(House hauntedHouse) {
        this.hauntedHouse = hauntedHouse;
        return this;
    }

    public List<Ghost> getGhosts() {
        return ghosts;
    }

    public Haunting setGhosts(List<Ghost> ghosts) {
        this.ghosts = ghosts;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().isInstance(o)) return false;

        Haunting haunting = (Haunting) o;

        if (getNumberOfPeoplePresent() != haunting.getNumberOfPeoplePresent()) return false;
        if (getId() != null ? !getId().equals(haunting.getId()) : haunting.getId() != null) return false;
        if (getDate() != null ? !getDate().equals(haunting.getDate()) : haunting.getDate() != null) return false;
        if (getHauntedHouse() != null ? !getHauntedHouse().equals(haunting.getHauntedHouse()) : haunting.getHauntedHouse() != null)
            return false;
        return getGhosts() != null ? getGhosts().equals(haunting.getGhosts()) : haunting.getGhosts() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + getNumberOfPeoplePresent();
        result = 31 * result + (getHauntedHouse() != null ? getHauntedHouse().hashCode() : 0);
        result = 31 * result + (getGhosts() != null ? getGhosts().hashCode() : 0);
        return result;
    }
}
