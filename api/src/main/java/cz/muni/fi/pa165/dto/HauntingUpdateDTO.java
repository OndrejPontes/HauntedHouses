package cz.muni.fi.pa165.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author MonikaMociarikova
 */

public class HauntingUpdateDTO {

    private Long hauntingId;

    @NotNull
    @Min(0)
    private int newNumberOfPeoplePresent;

    public Long getHauntingId() {
        return hauntingId;
    }

    public void setHauntingId(Long hauntingId) {
        this.hauntingId = hauntingId;
    }

    public int getNewNumberOfPeoplePresent() {
        return newNumberOfPeoplePresent;
    }

    public void setNewNumberOfPeoplePresent(int newNumberOfPeoplePresent) {
        this.newNumberOfPeoplePresent = newNumberOfPeoplePresent;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().isInstance(o)) return false;

        HauntingUpdateDTO that = (HauntingUpdateDTO) o;

        if (getNewNumberOfPeoplePresent() != that.getNewNumberOfPeoplePresent()) return false;
        return getHauntingId() != null ? getHauntingId().equals(that.getHauntingId()) : that.getHauntingId() == null;

    }

    @Override
    public int hashCode() {
        int result = getHauntingId() != null ? getHauntingId().hashCode() : 0;
        result = 31 * result + getNewNumberOfPeoplePresent();
        return result;
    }

    @Override
    public String toString() {
        return "HauntingUpdateDTO{" +
                "hauntingId=" + hauntingId +
                ", newNumberOfPeoplePresent=" + newNumberOfPeoplePresent +
                '}';
    }
}
