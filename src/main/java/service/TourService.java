package service;

import hibernate.TourRepoImpl;
import model.Tour;

import java.util.List;

public class TourService {

    private TourRepoImpl tourRepo = new TourRepoImpl();

    public Tour getTourById(Long id) {
        return tourRepo.getById(id);
    }

    public List<Tour> getAllTours() {
        return tourRepo.getAll();
    }

    public void addTour(Tour tour) {
        tourRepo.add(tour);
    }

    public void deleteTour(Tour tour) {
        tourRepo.delete(tour);
    }

    public void updateTour(Tour tour) {
        tourRepo.update(tour);
    }
}
