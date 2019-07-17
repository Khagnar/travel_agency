package service;

import dao.CountryRepoImpl;
import model.Country;

public class CountryService {

    private CountryRepoImpl countryRepo = new CountryRepoImpl();

    public void getCountryById(Long id) {
        System.out.println("| " + id + " | " + countryRepo.getById(id).getName() + " |");
    }

    public void getAllCountries() {
        for (Country c : countryRepo.getAll()) {
            getCountryById(c.getCountryId());
        }
    }

    public void addCountry(Country country) {
        countryRepo.add(country);
        System.out.println("Country " + country.getName() + " was added!" );
    }

    public void deleteCountry(Long id) {
        System.out.println("Country " + countryRepo.getById(id).getName() + "was deleted!");
        countryRepo.delete(id);
    }

    public void setCountry(Long id, String name) {
        Country update = countryRepo.getById(id);
        update.setCountryId(id);
        update.setName(name);
        countryRepo.update(update);
        System.out.println("Country was changed!");
    }
}
