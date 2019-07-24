package model;

import java.util.Objects;
import java.util.Set;

public class Review {

    private long reviewId;
    private String description;
    private Set<Tour> tours;

    public Review() {
    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Tour> getTours() {
        return tours;
    }

    public void setTours(Set<Tour> tours) {
        this.tours = tours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return reviewId == review.reviewId &&
                description.equals(review.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, description);
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", description='" + description + '\'' +
                '}';
    }
}
