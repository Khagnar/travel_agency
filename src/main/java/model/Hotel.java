package model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "hotel")
public class Hotel {

    private long hotelId;
    private String name;
    private List<Tour> tours;

    public Hotel() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_seq")
    @SequenceGenerator(name = "hotel_seq", sequenceName = "hotel_id_seq",  allocationSize = 1, initialValue = 1 )
    @Column(name = "id")
    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL, orphanRemoval = true)
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
        Hotel hotel = (Hotel) o;
        return hotelId == hotel.hotelId &&
                name.equals(hotel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelId, name);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", name='" + name + '\'' +
                '}';
    }
}
