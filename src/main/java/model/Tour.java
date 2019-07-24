package model;

import java.util.Objects;
import java.util.Set;

public class Tour {

    private long tourId;
    private String name;
    private Country country;
    private Hotel hotel;
    private Review review;
    private Set<Order> orders;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return tourId == tour.tourId &&
                name.equals(tour.name) &&
                country.equals(tour.country) &&
                hotel.equals(tour.hotel) &&
                review.equals(tour.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourId, name, country, hotel, review);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourId=" + tourId +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", hotel=" + hotel +
                ", review=" + review +
                '}';
    }
}
