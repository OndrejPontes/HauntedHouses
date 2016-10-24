package cz.muni.fi.pa165.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
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
    private LocalDate date;

    @NotNull
    private int numberOfPeoplePresent;

    @ManyToOne
    private House hauntedHouse;

    @ManyToMany
    private List<Ghost> ghosts;

    public Haunting(){
    }

    public Haunting(LocalDate date, int numberOfPeoplePresent) {
        this.date = date;
        this.numberOfPeoplePresent = numberOfPeoplePresent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNumberOfPeoplePresent() {
        return numberOfPeoplePresent;
    }

    public void setNumberOfPeoplePresent(int numberOfPeoplePresent) {
        this.numberOfPeoplePresent = numberOfPeoplePresent;
    }

    public House getHauntedHouse() {
        return hauntedHouse;
    }

    public void setHauntedHouse(House hauntedHouse) {
        this.hauntedHouse = hauntedHouse;
    }

    public List<Ghost> getGhosts() {
        return ghosts;
    }

    public void setGhosts(List<Ghost> ghosts) {
        this.ghosts = ghosts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Haunting haunting = (Haunting) o;

        if (numberOfPeoplePresent != haunting.numberOfPeoplePresent) return false;
        if (!id.equals(haunting.id)) return false;
        if (!date.equals(haunting.date)) return false;
        if (hauntedHouse != null ? !hauntedHouse.equals(haunting.hauntedHouse) : haunting.hauntedHouse != null)
            return false;
        return ghosts != null ? ghosts.equals(haunting.ghosts) : haunting.ghosts == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + numberOfPeoplePresent;
        result = 31 * result + (hauntedHouse != null ? hauntedHouse.hashCode() : 0);
        result = 31 * result + (ghosts != null ? ghosts.hashCode() : 0);
        return result;
    }

}
