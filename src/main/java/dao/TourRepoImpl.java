package dao;

import model.Tour;
import util.DBCPDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TourRepoImpl implements CommonRepo<Tour> {

    private static final String TABLE_NAME = "public.\"Tour\"";

    @Override
    public List<Tour> getAll() {
        List<Tour> list = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM " + TourRepoImpl.TABLE_NAME)) {

            while (rs.next()) {
                long id = rs.getLong("Id");
                String name = rs.getString("Name");
                long country_id = rs.getLong("Country_id");
                long review_id = rs.getLong("Review_id");
                long hotel_id = rs.getLong("Hotel_id");
                Tour tour = new Tour(id, name, country_id, review_id, hotel_id);
                list.add(tour);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(Tour tour) {
        try (Connection connection = DBCPDataSource.getConnection();
             PreparedStatement tourStatement = connection.prepareStatement(
                     "INSERT INTO " + TourRepoImpl.TABLE_NAME + " (name, country_id, reiew_id, hotel_id) VALUES (?,?,?,?)")) {
            tourStatement.setString(1, tour.getName());
            tourStatement.setLong(2, tour.getCountryId());
            tourStatement.setLong(3, tour.getReviewId());
            tourStatement.setLong(4, tour.getHotelId());
            tourStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = DBCPDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM " + TourRepoImpl.TABLE_NAME + "WHERE id = " + id)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tour getById(Long id) {
        Tour tour = null;
        try (Connection connection = DBCPDataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(
                     "SELECT * FROM " + TourRepoImpl.TABLE_NAME + "WHERE id = "+ id)) {
            if (rs.next()) {
                String name = rs.getString("Name");
                long country_id = rs.getLong("Country_id");
                long review_id = rs.getLong("Review_id");
                long hotel_id = rs.getLong("Hotel_id");
                tour = new Tour(name, country_id, review_id, hotel_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tour;
    }

    @Override
    public void update(Tour tour) {
        try (Connection connection = DBCPDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE " + TourRepoImpl.TABLE_NAME + " SET name = (?), country_id = (?), review_id = (?), hotel_id = (?) WHERE id = (?)")) {
            statement.setString(1, tour.getName());
            statement.setLong(2, tour.getCountryId());
            statement.setLong(3, tour.getReviewId());
            statement.setLong(4, tour.getHotelId());
            statement.setLong(5, tour.getTourId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
