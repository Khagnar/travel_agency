package service;

import model.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAllCountries();
    void addCountry(Country country);
    void deleteCountry(Long id);
    void updateCountry(Long id, String name);
    Country getCountryId(Long id);
}
