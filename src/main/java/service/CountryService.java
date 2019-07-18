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
        int count = 0;
        for (Country c : countryRepo.getAll()) {
            if (id == c.getCountryId()) {
                count++;
                System.out.println("Country " + countryRepo.getById(id).getName() + " was deleted!");
                countryRepo.delete(id);
            }
        }
        if (count == 0) System.out.println("This id doesn't exist. Please choose a valid id");
    }

    public void setCountry(Long id, String name) {
        Country update = countryRepo.getById(id);
        update.setCountryId(id);
        update.setName(name);
        countryRepo.update(update);
        System.out.println("Country was changed!");
    }
}
