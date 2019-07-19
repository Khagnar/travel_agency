package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hotelId;
    @Column(name = "name")
    private String name;

    public Hotel(String name) {
        this.name = name;
    }

    public Hotel() {
    }

    public long getHotelId() {
        return hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return hotelId == hotel.hotelId &&
                Objects.equals(name, hotel.name);
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
