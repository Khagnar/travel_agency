package service;

import dao.CountryRepo;
import dao.CountryRepoImpl;
import model.Country;
import java.util.List;

public class CountryServiceImpl implements CountryService {

    private CountryRepo countryRepo = new CountryRepoImpl();

    @Override
    public void addCountry(Country country) {
        countryRepo.addCountry(country);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepo.deleteCountry(id);
    }

    @Override
    public void updateCountry(Long id, String name) {
        Country update = countryRepo.getCountryId(id);
        update.setCountryId(id);
        update.setName(name);
        countryRepo.saveCountry(update);
    }

    @Override
    public Country getCountryId(Long id) {
        return countryRepo.getCountryId(id);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepo.getAllCountries();
    }
}
