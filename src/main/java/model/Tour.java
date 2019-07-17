package model;

import java.util.Objects;

public class Tour {

    private long tourId;
    private String name;
    private long countryId;
    private long reviewId;
    private long hotelId;

    public Tour(long tourId, String name, long countryId, long reviewId, long hotelId) {
        this.tourId = tourId;
        this.name = name;
        this.countryId = countryId;
        this.reviewId = reviewId;
        this.hotelId = hotelId;
    }

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

    public void setTourId(long tourId) {
        this.tourId = tourId;
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
