package dao;

import model.Order;
import util.DBCPDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepoImpl implements CommonRepo<Order> {

    private static final String TABLE_NAME = "public.\"Order\"";

    @Override
    public List<Order> getAll() {
        List<Order> list = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM " + OrderRepoImpl.TABLE_NAME)) {

            while (rs.next()) {
                long id = rs.getLong("Id");
                long customer_id = rs.getLong("Customer_id");
                long tour_id = rs.getLong("Tour_id");
                Timestamp date = rs.getTimestamp("Date");
                Order Order = new Order(id, customer_id, tour_id, date);
                list.add(Order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(Order order) {
        try (Connection connection = DBCPDataSource.getConnection();
             PreparedStatement OrderStatement = connection.prepareStatement(
                     "INSERT INTO " + OrderRepoImpl.TABLE_NAME + " (customer_id, tour_id, date) VALUES (?,?,?)")) {
            OrderStatement.setLong(1, order.getCustomerId());
            OrderStatement.setLong(2, order.getTourId());
            OrderStatement.setTimestamp(3, order.getDate());
            OrderStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = DBCPDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM " + OrderRepoImpl.TABLE_NAME + "WHERE id = " + id)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order getById(Long id) {
        Order order = null;
        try (Connection connection = DBCPDataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(
                     "SELECT * FROM " + OrderRepoImpl.TABLE_NAME + "WHERE id = "+ id)) {
            if (rs.next()) {
                long customer_id = rs.getLong("Customer_id");
                long tour_id = rs.getLong("Tour_id");
                Timestamp date = rs.getTimestamp("Date");
                order = new Order(customer_id, tour_id, date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void update(Order order) {
        try (Connection connection = DBCPDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE " + OrderRepoImpl.TABLE_NAME + " SET customer_id = (?), tour_id = (?), date = (?) WHERE id = (?)")) {
            statement.setLong(1, order.getCustomerId());
            statement.setLong(2, order.getTourId());
            statement.setTimestamp(3, order.getDate());
            statement.setLong(4, order.getOrderId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
