package service;

import hibernate.ReviewRepoImpl;
import model.Review;

import java.util.List;

public class ReviewService {

    private ReviewRepoImpl reviewRepo = new ReviewRepoImpl();

    public Review getReviewById(Long id) {
        return reviewRepo.getById(id);
    }

    public List<Review> getAllReview() {
        return reviewRepo.getAll();
    }

    public void addReview(Review review) {
        reviewRepo.add(review);
    }

    public void deleteReview(Review review) {
        reviewRepo.delete(review);
    }

    public void updateReview(Review review) {
        reviewRepo.update(review);
    }
}
