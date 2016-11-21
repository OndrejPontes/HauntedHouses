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
    private Long hauntedHouseId;
    private List<HouseDTO> possibleHouses = new ArrayList<>();

    @NotNull
    private Long[] ghostsIds;
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

    public Long[] getGhostsIds() {
        return ghostsIds;
    }

    public HauntingCreateDTO setGhostsIds(Long[] ghostsIds) {
        this.ghostsIds = ghostsIds;
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
                ", hauntedHouseId=" + hauntedHouseId +
                ", possibleHouses=" + possibleHouses +
                ", ghostsIds=" + Arrays.toString(ghostsIds) +
                ", possibleGhosts=" + possibleGhosts +
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
        return Arrays.deepEquals(getGhostsIds(), that.getGhostsIds());

    }

    @Override
    public int hashCode() {
        int result = getDate() != null ? getDate().hashCode() : 0;
        result = 31 * result + getNumberOfPeoplePresent();
        result = 31 * result + (getHauntedHouseId() != null ? getHauntedHouseId().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getGhostsIds());
        return result;
    }
}
