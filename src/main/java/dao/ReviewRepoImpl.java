package dao;

import model.Review;
import util.DBCPDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewRepoImpl implements CommonRepo<Review> {

    private static final String TABLE_NAME = "public.\"Review\"";

    @Override
    public List<Review> getAll() {
        List<Review> list = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM " + ReviewRepoImpl.TABLE_NAME)) {

            while (rs.next()) {
                long id = rs.getLong("Id");
                String description = rs.getString("Description");
                Review review = new Review(id, description);
                list.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(Review review) {
        try (Connection connection = DBCPDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO " + ReviewRepoImpl.TABLE_NAME + " (name) VALUES (?)")) {
            statement.setString(1, review.getDescription());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = DBCPDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM " + ReviewRepoImpl.TABLE_NAME + "WHERE id = " + id)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Review getById(Long id) {
        Review Review = null;
        try (Connection connection = DBCPDataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(
                     "SELECT * FROM " + ReviewRepoImpl.TABLE_NAME + "WHERE id = "+ id)) {

            if (rs.next()) {
                String description = rs.getString("Description");
                Review = new Review(description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Review;
    }

    @Override
    public void update(Review review) {
        try (Connection connection = DBCPDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE " + ReviewRepoImpl.TABLE_NAME + " SET name = (?) WHERE id = (?)")) {
            statement.setString(1, review.getDescription());
            statement.setLong(2, review.getReviewId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
