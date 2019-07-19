import model.Country;
import service.CountryService;

public class Main {
    public static void main(String[] args) {
        CountryService service = new CountryService();
        Country russia = new Country("Russia");
        service.addCountry(russia);
    }
}
