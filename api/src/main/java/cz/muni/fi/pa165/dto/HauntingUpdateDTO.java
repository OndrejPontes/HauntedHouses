package cz.muni.fi.pa165.dto;

/**
 * @author MonikaMociarikova
 */
public class HauntingUpdateDTO extends HauntingCreateDTO{

    private Long id;

    public Long getId() {
        return id;
    }

    public HauntingUpdateDTO setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        HauntingUpdateDTO that = (HauntingUpdateDTO) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HauntingUpdateDTO{" +
                "id=" + id +
                "} " + super.toString();
    }
}
