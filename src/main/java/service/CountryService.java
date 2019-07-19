package service;

import hibernate.CountryRepoImpl;
import model.Country;

import java.util.List;

public class CountryService {

    private CountryRepoImpl countryRepo = new CountryRepoImpl();

    public Country getCountryById(Long id) {
        return countryRepo.getById(id);
    }

    public List<Country> getAllCountries() {
        return countryRepo.getAll();
    }

    public void addCountry(Country country) {
        countryRepo.add(country);
    }

    public void deleteCountry(Country country) {
        countryRepo.delete(country);
    }

    public void updateCountry(Country country) {
        countryRepo.update(country);
    }
}
