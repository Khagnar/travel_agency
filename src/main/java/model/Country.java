package model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "country")
public class Country {

    private long countryId;
    private String name;
    private List<Tour> tours;

    public Country() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_seq")
    @SequenceGenerator(name = "country_seq", sequenceName = "country_id_seq",  allocationSize = 1, initialValue = 1 )
    @Column(name = "id")
    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "country",cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return countryId == country.countryId &&
                name.equals(country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, name);
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", name='" + name + '\'' +
                '}';
    }
}
