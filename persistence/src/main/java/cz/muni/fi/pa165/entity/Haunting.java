package cz.muni.fi.pa165.entity;


import javax.persistence.*;
import java.util.*;

/**
 * @author Monika Mociarikova
 */
@Entity
public class Haunting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(nullable = false)
    private int numberOfPeoplePresent;

    @ManyToOne
    private House hauntedHouse;

    @ManyToMany
    private List<Ghost> ghosts = new ArrayList<>();

    public Haunting() {
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

    public Haunting setGhosts(List<Ghost> ghosts) {
        this.ghosts = ghosts;
        return this;
    }

    public List<Ghost> getGhosts() {
        return Collections.unmodifiableList(ghosts);
    }

    public void addGhost(Ghost ghost) {
        ghosts.add(ghost);
        ghost.addHaunting(this);
    }

    public void removeGhost(Ghost ghost){
        ghosts.remove(ghost);
        ghost.removeHaunting(this);
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

    @Override
    public String toString(){
        return "Haunting{" +
                "id =" + id +
                ", date ='" + date.toString() + '\'' +
                ", number of people present ='" + numberOfPeoplePresent + '\'' +
                ", haunted house =" + hauntedHouse +
                ", ghosts ='" + ghosts + '\'' +
                '}';
    }
}
