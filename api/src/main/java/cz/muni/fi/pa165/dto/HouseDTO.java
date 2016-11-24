package cz.muni.fi.pa165.dto;

import java.util.Date;
import java.util.List;

/**
 * @author Jirka Kruml
 */
public class HouseDTO {

    private Long id;
    private String name;
    private String address;
    private Date hauntingFrom;
    private String history;
    private List<HauntingDTO> hauntings;

    public HouseDTO() {
    }

    public HouseDTO(Long id, String name, String address, Date hauntingFrom, String history, List<HauntingDTO> hauntings) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.hauntingFrom = hauntingFrom;
        this.history = history;
        this.hauntings = hauntings;
    }

    public Long getId() {
        return id;
    }

    public HouseDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public HouseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public HouseDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public Date getHauntingFrom() {
        return hauntingFrom;
    }

    public HouseDTO setHauntingFrom(Date hauntingFrom) {
        this.hauntingFrom = hauntingFrom;
        return this;
    }

    public String getHistory() {
        return history;
    }

    public HouseDTO setHistory(String history) {
        this.history = history;
        return this;
    }

    public List<HauntingDTO> getHauntings() {
        return hauntings;
    }

    public HouseDTO setHauntings(List<HauntingDTO> hauntings) {
        this.hauntings = hauntings;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HouseDTO houseDTO = (HouseDTO) o;

        if (!id.equals(houseDTO.id)) return false;
        if (!name.equals(houseDTO.name)) return false;
        if (!address.equals(houseDTO.address)) return false;
        if (hauntingFrom != null ? !hauntingFrom.equals(houseDTO.hauntingFrom) : houseDTO.hauntingFrom != null) return false;
        if (history != null ? !history.equals(houseDTO.history) : houseDTO.history != null) return false;
        return hauntings != null ? hauntings.equals(houseDTO.hauntings) : houseDTO.hauntings == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + (hauntingFrom != null ? hauntingFrom.hashCode() : 0);
        result = 31 * result + (history != null ? history.hashCode() : 0);
        result = 31 * result + (hauntings != null ? hauntings.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HouseDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", hauntingFrom=" + hauntingFrom +
                ", history='" + history + '\'' +
                ", hauntings=" + hauntings +
                '}';
    }
}
