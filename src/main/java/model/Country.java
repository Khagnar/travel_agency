package model;

public class Country {

    private long countryId;
    private String name;

    public Country(String name) {
        this.name = name;
    }

    public Country(long countryId, String name) {
        this.countryId = countryId;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
