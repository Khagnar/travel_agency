package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tourId;
    @Column(name = "name")
    private String name;
    @Column(name = "country_id")
    private long countryId;
    @Column(name = "review_id")
    private long reviewId;
    @Column(name = "hotel_id")
    private long hotelId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    public Tour(String name, long countryId, long reviewId, long hotelId) {
        this.name = name;
        this.countryId = countryId;
        this.reviewId = reviewId;
        this.hotelId = hotelId;
    }

    public Tour() {
    }

    public long getTourId() {
        return tourId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return tourId == tour.tourId &&
                countryId == tour.countryId &&
                reviewId == tour.reviewId &&
                hotelId == tour.hotelId &&
                Objects.equals(name, tour.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourId, name, countryId, reviewId, hotelId);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourId=" + tourId +
                ", name='" + name + '\'' +
                ", countryId=" + countryId +
                ", reviewId=" + reviewId +
                ", hotelId=" + hotelId +
                '}';
    }
}
