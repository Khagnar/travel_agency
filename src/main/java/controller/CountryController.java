package controller;

import model.Country;
import service.CountryService;
import service.CountryServiceImpl;

public class CountryController {

    private CountryService service = new CountryServiceImpl();

    public void printCountry(Long id) {
        System.out.println("| " + id + " | " + service.getCountryId(id).getName() + " |");
    }

    public void printAllCountry() {
        for (Country c : service.getAllCountries()) {
            printCountry(c.getCountryId());
        }
    }

    public void addCountry(Country country) {
        service.addCountry(country);
        System.out.println("Country " + country.getName() + " was added!" );
    }

    public void deleteCountry(Long id) {
        System.out.println("Country " + service.getCountryId(id).getName() + "was deleted!");
        service.deleteCountry(id);
    }

    public void setCountry(Long id, String name) {
        service.updateCountry(id, name);
        System.out.println("Country was changed!");
    }
}
