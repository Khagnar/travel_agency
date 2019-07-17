package model;

import java.util.Objects;

public class Tour {

    private long tourId;
    private String name;
    private long country_id;
    private long review_id;
    private long hotel_id;

    public Tour(long tourId, String name, long country_id, long review_id, long hotel_id) {
        this.tourId = tourId;
        this.name = name;
        this.country_id = country_id;
        this.review_id = review_id;
        this.hotel_id = hotel_id;
    }

    public Tour(String name, long country_id, long review_id, long hotel_id) {
        this.name = name;
        this.country_id = country_id;
        this.review_id = review_id;
        this.hotel_id = hotel_id;
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

    public long getCountry_id() {
        return country_id;
    }

    public void setCountry_id(long country_id) {
        this.country_id = country_id;
    }

    public long getReview_id() {
        return review_id;
    }

    public void setReview_id(long review_id) {
        this.review_id = review_id;
    }

    public long getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(long hotel_id) {
        this.hotel_id = hotel_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return tourId == tour.tourId &&
                country_id == tour.country_id &&
                review_id == tour.review_id &&
                hotel_id == tour.hotel_id &&
                Objects.equals(name, tour.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourId, name, country_id, review_id, hotel_id);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourId=" + tourId +
                ", name='" + name + '\'' +
                ", country_id=" + country_id +
                ", review_id=" + review_id +
                ", hotel_id=" + hotel_id +
                '}';
    }
}
