package cz.muni.fi.pa165.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author MonikaMociarikova
 */
public class HauntingCreateDTO {

    @NotNull
    private Date date;

    @NotNull
    @Min(0)
    private int numberOfPeoplePresent;

    @NotNull
    private List<HouseDTO> houses = new ArrayList<>();

    @NotNull
    private List<GhostDTO> ghosts = new ArrayList<>();

    public List<HouseDTO> getHouses() {
        return houses;
    }

    public HauntingCreateDTO setHouses(List<HouseDTO> houses) {
        this.houses = houses;
        return this;
    }

    public List<GhostDTO> getGhosts() {
        return ghosts;
    }

    public HauntingCreateDTO setGhosts(List<GhostDTO> ghosts) {
        this.ghosts = ghosts;
        return this;
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


    @Override
    public String toString() {
        return "HauntingCreateDTO{" +
                "date=" + date +
                ", numberOfPeoplePresent=" + numberOfPeoplePresent +
                ", houses=" + houses +
                ", ghosts=" + ghosts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().isInstance(o)) return false;

        HauntingCreateDTO that = (HauntingCreateDTO) o;

        if (getNumberOfPeoplePresent() != that.getNumberOfPeoplePresent()) return false;
        if (getDate() != null ? !getDate().equals(that.getDate()) : that.getDate() != null) return false;
        if (getHouses() != null ? !getHouses().equals(that.getHouses()) : that.getHouses() != null) return false;
        return getGhosts() != null ? getGhosts().equals(that.getGhosts()) : that.getGhosts() == null;

    }

    @Override
    public int hashCode() {
        int result = getDate() != null ? getDate().hashCode() : 0;
        result = 31 * result + getNumberOfPeoplePresent();
        result = 31 * result + (getHouses() != null ? getHouses().hashCode() : 0);
        result = 31 * result + (getGhosts() != null ? getGhosts().hashCode() : 0);
        return result;
    }
}
