package cz.muni.fi.pa165.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author MonikaMociarikova
 */
public class HauntingDTO {

    private Long id;

    private Date date;

    private int numberOfPeoplePresent;

    private HouseDTO hauntedHouse;

    private List<GhostDTO> ghosts = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public HauntingDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public HauntingDTO setDate(Date date) {
        this.date = date;
        return this;
    }

    public int getNumberOfPeoplePresent() {
        return numberOfPeoplePresent;
    }

    public HauntingDTO setNumberOfPeoplePresent(int numberOfPeoplePresent) {
        this.numberOfPeoplePresent = numberOfPeoplePresent;
        return this;
    }

    public HouseDTO getHauntedHouse() {
        return hauntedHouse;
    }

    public HauntingDTO setHauntedHouse(HouseDTO hauntedHouse) {
        this.hauntedHouse = hauntedHouse;
        return this;
    }

    public List<GhostDTO> getGhosts() {
        return Collections.unmodifiableList(ghosts);
    }

    public HauntingDTO setGhosts(List<GhostDTO> ghosts) {
        this.ghosts = ghosts;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().isInstance(o)) return false;

        HauntingDTO haunting = (HauntingDTO) o;

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
        return "Haunting DTO{" +
                "id =" + id +
                ", date ='" + date.toString() + '\'' +
                ", number of people present ='" + numberOfPeoplePresent + '\'' +
                ", haunted house =" + hauntedHouse +
                ", ghosts ='" + ghosts + '\'' +
                '}';
    }
}
