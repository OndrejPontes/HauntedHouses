package cz.muni.fi.pa165.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
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
    private Long hauntedHouseId;
    private List<HouseDTO> possibleHouses = new ArrayList<>();

    @NotNull
    private Long ghostId;
    private List<GhostDTO> possibleGhosts = new ArrayList<>();

    public List<HouseDTO> getPossibleHouses() {
        return possibleHouses;
    }

    public HauntingCreateDTO setPossibleHouses(List<HouseDTO> possibleHouses) {
        this.possibleHouses = possibleHouses;
        return this;
    }

    public Long getHauntedHouseId() {
        return hauntedHouseId;
    }

    public HauntingCreateDTO setHauntedHouseId(Long hauntedHouseId) {
        this.hauntedHouseId = hauntedHouseId;
        return this;
    }

    public List<GhostDTO> getPossibleGhosts() {
        return possibleGhosts;
    }

    public HauntingCreateDTO setPossibleGhosts(List<GhostDTO> possibleGhosts) {
        this.possibleGhosts = possibleGhosts;
        return this;
    }

    public Long getGhostId() {
        return ghostId;
    }

    public HauntingCreateDTO setGhostId(Long ghostId) {
        this.ghostId = ghostId;
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
    public String toString(){
        return "HauntingCreateDTO{" +
                ", date ='" + date.toString() + '\'' +
                ", number of people present ='" + numberOfPeoplePresent + '\'' +
                ", haunted house ID =" + hauntedHouseId +
                ", ghost ID ='" + ghostId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().isInstance(o)) return false;

        HauntingCreateDTO that = (HauntingCreateDTO) o;

        if (getNumberOfPeoplePresent() != that.getNumberOfPeoplePresent()) return false;
        if (getDate() != null ? !getDate().equals(that.getDate()) : that.getDate() != null) return false;
        if (getHauntedHouseId() != null ? !getHauntedHouseId().equals(that.getHauntedHouseId()) : that.getHauntedHouseId() != null)
            return false;
        return getGhostId() != null ? getGhostId().equals(that.getGhostId()) : that.getGhostId() == null;

    }

    @Override
    public int hashCode() {
        int result = getDate() != null ? getDate().hashCode() : 0;
        result = 31 * result + getNumberOfPeoplePresent();
        result = 31 * result + (getHauntedHouseId() != null ? getHauntedHouseId().hashCode() : 0);
        result = 31 * result + (getGhostId() != null ? getGhostId().hashCode() : 0);
        return result;
    }
}
