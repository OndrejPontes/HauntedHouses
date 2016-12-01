package cz.muni.fi.pa165.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author MonikaMociarikova
 */
public class HauntingCreateDTO {

    private Date date;
    private int numberOfPeoplePresent;
    private HouseDTO house;
    private List<GhostDTO> ghosts = new ArrayList<>();

    public HauntingCreateDTO() {
    }

    public HauntingCreateDTO(Date date, int numberOfPeoplePresent, HouseDTO house, List<GhostDTO> ghosts) {
        this.date = date;
        this.numberOfPeoplePresent = numberOfPeoplePresent;
        this.house = house;
        this.ghosts = ghosts;
    }

    public Date getDate() {
        return date;
    }

    public HauntingCreateDTO setDate(Date date) {
        this.date = date;
        return this;
    }

    public int getNumberOfPeoplePresent() {
        return numberOfPeoplePresent;
    }

    public HauntingCreateDTO setNumberOfPeoplePresent(int numberOfPeoplePresent) {
        this.numberOfPeoplePresent = numberOfPeoplePresent;
        return this;
    }

    public HouseDTO getHouse() {
        return house;
    }

    public HauntingCreateDTO setHouse(HouseDTO house) {
        this.house = house;
        return this;
    }

    public List<GhostDTO> getGhosts() {
        return ghosts;
    }

    public HauntingCreateDTO setGhosts(List<GhostDTO> ghosts) {
        this.ghosts = ghosts;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HauntingCreateDTO that = (HauntingCreateDTO) o;

        if (numberOfPeoplePresent != that.numberOfPeoplePresent) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (house != null ? !house.equals(that.house) : that.house != null) return false;
        return ghosts != null ? ghosts.equals(that.ghosts) : that.ghosts == null;

    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + numberOfPeoplePresent;
        result = 31 * result + (house != null ? house.hashCode() : 0);
        result = 31 * result + (ghosts != null ? ghosts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HauntingCreateDTO{" +
                "date=" + date +
                ", numberOfPeoplePresent=" + numberOfPeoplePresent +
                ", house=" + house +
                ", ghosts=" + ghosts +
                '}';
    }
}
