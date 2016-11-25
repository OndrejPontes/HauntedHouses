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
    private Long hauntedHouse;
    private List<Long> ghosts = new ArrayList<>();

    public HauntingDTO() {
    }

    public HauntingDTO(Long id, Date date, int numberOfPeoplePresent, Long hauntedHouse, List<Long> ghosts) {
        this.id = id;
        this.date = date;
        this.numberOfPeoplePresent = numberOfPeoplePresent;
        this.hauntedHouse = hauntedHouse;
        this.ghosts = ghosts;
    }

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

    public Long getHauntedHouse() {
        return hauntedHouse;
    }

    public HauntingDTO setHauntedHouse(Long hauntedHouse) {
        this.hauntedHouse = hauntedHouse;
        return this;
    }

    public List<Long> getGhosts() {
        return ghosts;
    }

    public HauntingDTO setGhosts(List<Long> ghosts) {
        this.ghosts = ghosts;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HauntingDTO that = (HauntingDTO) o;

        if (numberOfPeoplePresent != that.numberOfPeoplePresent) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (hauntedHouse != null ? !hauntedHouse.equals(that.hauntedHouse) : that.hauntedHouse != null) return false;
        return ghosts != null ? ghosts.equals(that.ghosts) : that.ghosts == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + numberOfPeoplePresent;
        result = 31 * result + (hauntedHouse != null ? hauntedHouse.hashCode() : 0);
        result = 31 * result + (ghosts != null ? ghosts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HauntingDTO{" +
                "id=" + id +
                ", date=" + date +
                ", numberOfPeoplePresent=" + numberOfPeoplePresent +
                ", hauntedHouse=" + hauntedHouse +
                ", ghosts=" + ghosts +
                '}';
    }
}
