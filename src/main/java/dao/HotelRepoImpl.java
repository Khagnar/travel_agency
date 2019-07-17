package dao;

import model.Hotel;
import util.DBCPDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelRepoImpl implements CommonRepo<Hotel>{
    
    private static final String TABLE_NAME = "public.\"Hotel\"";

    @Override
    public List<Hotel> getAll() {
        List<Hotel> list = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM " + HotelRepoImpl.TABLE_NAME)) {

            while (rs.next()) {
                long id = rs.getLong("Id");
                String name = rs.getString("Name");
                Hotel hotel = new Hotel(id, name);
                list.add(hotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(Hotel hotel) {
        try (Connection connection = DBCPDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO " + HotelRepoImpl.TABLE_NAME + " (name) VALUES (?)")) {
            statement.setString(1, hotel.getName());
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
                     "DELETE FROM " + HotelRepoImpl.TABLE_NAME + "WHERE id = " + id)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Hotel getById(Long id) {
        Hotel hotel = null;
        try (Connection connection = DBCPDataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(
                     "SELECT * FROM " + HotelRepoImpl.TABLE_NAME + "WHERE id = "+ id)) {

            if (rs.next()) {
                String name = rs.getString("Name");
                hotel = new Hotel(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotel;
    }

    @Override
    public void update(Hotel hotel) {
        try (Connection connection = DBCPDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE " + HotelRepoImpl.TABLE_NAME + " SET name = (?) WHERE id = (?)")) {
            statement.setString(1, hotel.getName());
            statement.setLong(2, hotel.getHotelId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
