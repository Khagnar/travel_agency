package dao;

import model.Country;
import java.util.List;

public interface CountryRepo {

    List<Country> getAllCountries();
    void addCountry(Country country);
    void deleteCountry(Long id);
    Country getCountryId(Long id);
    void saveCountry(Country country);

}
