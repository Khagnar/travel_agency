package service;

import dao.ReviewRepoImpl;
import model.Review;

public class ReviewService {
    private ReviewRepoImpl reviewRepo = new ReviewRepoImpl();

    public void getReviewById(Long id) {
        System.out.println("| " + id + " | " + reviewRepo.getById(id).getDescription() + " |");
    }

    public void getAllReviews() {
        for (Review r : reviewRepo.getAll()) {
            getReviewById(r.getReviewId());
        }
    }

    public void addReview(Review review) {
        reviewRepo.add(review);
        System.out.println("Review " + review.getDescription() + " was added!" );
    }

    public void deleteReview(Long id) {
        System.out.println("Review " + reviewRepo.getById(id).getDescription() + "was deleted!");
        reviewRepo.delete(id);
    }

    public void setReview(Long id, String description) {
        Review update = reviewRepo.getById(id);
        update.setReviewId(id);
        update.setDescription(description);
        reviewRepo.update(update);
        System.out.println("Review was changed!");
    }
}
