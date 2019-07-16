package model;

public class Tour {

    private long tourId;
    private String name;
    private String country;
    private String review;
    private String hotel;

    public Tour(String name, String country, String review, String hotel) {
        this.name = name;
        this.country = country;
        this.review = review;
        this.hotel = hotel;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
}
