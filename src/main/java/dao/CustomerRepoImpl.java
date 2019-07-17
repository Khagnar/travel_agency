package dao;

import model.Customer;
import util.DBCPDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepoImpl implements CommonRepo<Customer> {

    private static final String TABLE_NAME = "public.\"Customer\"";

    @Override
    public List<Customer> getAll() {
        List<Customer> list = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM " + CustomerRepoImpl.TABLE_NAME)) {

            while (rs.next()) {
                long id = rs.getLong("Id");
                String name = rs.getString("Name");
                Customer customer = new Customer(id, name);
                list.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(Customer customer) {
        try (Connection connection = DBCPDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO " + CustomerRepoImpl.TABLE_NAME + " (name) VALUES (?)")) {
            statement.setString(1, customer.getName());
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
                     "DELETE FROM " + CustomerRepoImpl.TABLE_NAME + "WHERE id = " + id)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getById(Long id) {
        Customer customer = null;
        try (Connection connection = DBCPDataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(
                     "SELECT * FROM " + CustomerRepoImpl.TABLE_NAME + "WHERE id = "+ id)) {

            if (rs.next()) {
                String name = rs.getString("Name");
                customer = new Customer(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void update(Customer customer) {
        try (Connection connection = DBCPDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE " + CustomerRepoImpl.TABLE_NAME + " SET name = (?) WHERE id = (?)")) {
            statement.setString(1, customer.getName());
            statement.setLong(2, customer.getCustomerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
