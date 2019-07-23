package service;

import hibernate.HotelRepoImpl;
import model.Hotel;

import java.util.List;

public class HotelService {

    private HotelRepoImpl hotelRepo = new HotelRepoImpl();

    public Hotel getHotelById(Long id) {
        return hotelRepo.getById(id);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepo.getAll();
    }

    public void addHotel(Hotel hotel) {
        hotelRepo.add(hotel);
    }

    public void deleteHotel(Hotel hotel) {
        hotelRepo.delete(hotel);
    }

    public void updateHotel(Hotel hotel) {
        hotelRepo.update(hotel);
    }
}
