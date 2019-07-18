package service;

import dao.TourRepoImpl;
import model.Tour;

public class TourService {

    private TourRepoImpl tourRepo = new TourRepoImpl();

    public void getTourById(Long id) {
        System.out.println("| " + id + " | " + tourRepo.getById(id).getName() + " |");
    }

    public void getAllTours() {
        for (Tour t : tourRepo.getAll()) {
            getTourById(t.getTourId());
        }
    }

    public void addTour(Tour tour) {
        tourRepo.add(tour);
        System.out.println("Tour " + tour.getName() + " was added!" );
    }

    public void deleteTour(Long id) {
        int count = 0;
        for (Tour t : tourRepo.getAll()) {
            if (id == t.getCountryId()) {
                count++;
                System.out.println("Tour " + tourRepo.getById(id).getName() + " was deleted!");
                tourRepo.delete(id);
            }
        }
        if (count == 0) System.out.println("This id doesn't exist. Please choose a valid id");
    }

    public void setTour(Long id, String name, long country_id, long review_id, long hotel_id) {
        Tour update = tourRepo.getById(id);
        update.setTourId(id);
        update.setName(name);
        update.setCountryId(country_id);
        update.setReviewId(review_id);
        update.setHotelId(hotel_id);
        tourRepo.update(update);
        System.out.println("Tour was changed!");
    }
}
