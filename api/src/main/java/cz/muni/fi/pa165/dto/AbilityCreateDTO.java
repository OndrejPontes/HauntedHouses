package cz.muni.fi.pa165.dto;

/**
 * @author Vojta David, vojtadavid
 */
public class AbilityCreateDTO {
    private String name;

    private String description;

    public String getName() {
        return name;
    }

    public AbilityCreateDTO() {
    }

    public AbilityCreateDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public AbilityCreateDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AbilityCreateDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbilityCreateDTO that = (AbilityCreateDTO) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AbilityCreateDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
