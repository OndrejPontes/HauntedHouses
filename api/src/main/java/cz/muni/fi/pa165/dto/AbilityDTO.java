package cz.muni.fi.pa165.dto;

/**
 * @author Ondrej Ponteš
 */
public class AbilityDTO {

    private Long id;
    private String name;
    private String description;

    public AbilityDTO() {
    }

    public AbilityDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public AbilityDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AbilityDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AbilityDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().isInstance(o)) return false;

        AbilityDTO ability = (AbilityDTO) o;

        if (getId() != null ? !getId().equals(ability.getId()) : ability.getId() != null) return false;
        if (getName() != null ? !getName().equals(ability.getName()) : ability.getName() != null) return false;
        return getDescription() != null ? getDescription().equals(ability.getDescription()) : ability.getDescription() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AbilityDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
