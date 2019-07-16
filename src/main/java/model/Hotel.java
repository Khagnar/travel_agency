package model;

public class Hotel {

    private long hotelId;
    private String name;

    public Hotel(String name) {
        this.name = name;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
