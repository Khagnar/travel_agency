package model;

import java.util.Objects;

public class Review {

    private long reviewId;
    private String description;

    public Review(long reviewId, String description) {
        this.reviewId = reviewId;
        this.description = description;
    }

    public Review() {
    }

    public Review(String description) {
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return reviewId == review.reviewId &&
                Objects.equals(description, review.description);
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
