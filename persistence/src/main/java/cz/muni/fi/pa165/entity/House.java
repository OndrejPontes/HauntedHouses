package cz.muni.fi.pa165.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Jirka Kruml
 */
@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String address;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date hauntingFrom;

    @Column(nullable = true, length = 2000)
    private String history;

    public House() {
    }

    public House(String name, String address, Date hauntingFrom, String history) {
        this.name = name;
        this.address = address;
        this.hauntingFrom = hauntingFrom;
        this.history = history;
    }

    public Long getId() {
        return id;
    }

    public House setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public House setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public House setAddress(String address) {
        this.address = address;
        return this;
    }

    public Date getHauntingFrom() {
        return hauntingFrom;
    }

    public House setHauntingFrom(Date hauntingFrom) {
        this.hauntingFrom = hauntingFrom;
        return this;
    }

    public String getHistory() {
        return history;
    }

    public House setHistory(String history) {
        this.history = history;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().isInstance(o)) return false;

        House house = (House) o;

        if (getId() != null ? !getId().equals(house.getId()) : house.getId() != null) return false;
        if (getName() != null ? !getName().equals(house.getName()) : house.getName() != null) return false;
        if (getAddress() != null ? !getAddress().equals(house.getAddress()) : house.getAddress() != null) return false;
        if (getHauntingFrom() != null ? !getHauntingFrom().equals(house.getHauntingFrom()) : house.getHauntingFrom() != null)
            return false;
        return getHistory() != null ? getHistory().equals(house.getHistory()) : house.getHistory() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getHauntingFrom() != null ? getHauntingFrom().hashCode() : 0);
        result = 31 * result + (getHistory() != null ? getHistory().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", hauntingFrom=" + hauntingFrom +
                ", history='" + history + '\'' +
                '}';
    }
}
