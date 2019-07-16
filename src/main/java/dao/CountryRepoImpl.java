package dao;

import model.Country;
import util.DBCPDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryRepoImpl implements CountryRepo {

    private static final String TABLE_NAME = "public.\"Country\"";

    @Override
    public List<Country> getAllCountries() {
        List<Country> list = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM " + CountryRepoImpl.TABLE_NAME)) {

            while (rs.next()) {
                long id = rs.getLong("Id");
                String name = rs.getString("Name");
                Country country = new Country(id, name);
                list.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addCountry(Country country) {
        try (Connection connection = DBCPDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO " + CountryRepoImpl.TABLE_NAME + " (name) VALUES (?)")) {
            statement.setString(1, country.getName());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCountry(Long id) {
        try (Connection connection = DBCPDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM " + CountryRepoImpl.TABLE_NAME + "WHERE id = " + id)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Country getCountryId(Long id) {
        Country country = null;
        try (Connection connection = DBCPDataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(
                     "SELECT * FROM " + CountryRepoImpl.TABLE_NAME + "WHERE id = "+ id)) {

            if (rs.next()) {
                String name = rs.getString("Name");
                country = new Country(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public void saveCountry(Country country) {
        try (Connection connection = DBCPDataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                "UPDATE " + CountryRepoImpl.TABLE_NAME + " SET name = (?) WHERE id = (?)")) {
            statement.setString(1, country.getName());
            statement.setLong(2, country.getCountryId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
