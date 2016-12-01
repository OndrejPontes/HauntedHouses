package cz.muni.fi.pa165.dto;

import java.util.Date;

/**
 * @author Jirka Kruml
 */
public class HouseCreateDTO {

    private String name;
    private String address;
    private Date hauntingFrom;
    private String history;

    public HouseCreateDTO() {
    }

    public HouseCreateDTO(String name, String address, Date hauntingFrom, String history) {
        this.name = name;
        this.address = address;
        this.hauntingFrom = hauntingFrom;
        this.history = history;
    }

    public String getName() {
        return name;
    }

    public HouseCreateDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public HouseCreateDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public Date getHauntingFrom() {
        return hauntingFrom;
    }

    public HouseCreateDTO setHauntingFrom(Date hauntingFrom) {
        this.hauntingFrom = hauntingFrom;
        return this;
    }

    public String getHistory() {
        return history;
    }

    public HouseCreateDTO setHistory(String history) {
        this.history = history;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HouseCreateDTO that = (HouseCreateDTO) o;

        if (!name.equals(that.name)) return false;
        if (!address.equals(that.address)) return false;
        if (hauntingFrom != null ? !hauntingFrom.equals(that.hauntingFrom) : that.hauntingFrom != null) return false;
        return history != null ? history.equals(that.history) : that.history == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + (hauntingFrom != null ? hauntingFrom.hashCode() : 0);
        result = 31 * result + (history != null ? history.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HouseCreateDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", hauntingFrom=" + hauntingFrom +
                ", history='" + history + '\'' +
                '}';
    }
}
