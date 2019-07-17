package service;

import dao.HotelRepoImpl;
import model.Hotel;

public class HotelService {
    
    private HotelRepoImpl hotelRepo = new HotelRepoImpl();

    public void getHotelById(Long id) {
        System.out.println("| " + id + " | " + hotelRepo.getById(id).getName() + " |");
    }

    public void getAllHotels() {
        for (Hotel h : hotelRepo.getAll()) {
            getHotelById(h.getHotelId());
        }
    }

    public void addHotel(Hotel hotel) {
        hotelRepo.add(hotel);
        System.out.println("Hotel " + hotel.getName() + " was added!" );
    }

    public void deleteHotel(Long id) {
        System.out.println("Hotel " + hotelRepo.getById(id).getName() + "was deleted!");
        hotelRepo.delete(id);
    }

    public void setHotel(Long id, String name) {
        Hotel update = hotelRepo.getById(id);
        update.setHotelId(id);
        update.setName(name);
        hotelRepo.update(update);
        System.out.println("Hotel was changed!");
    }
}
