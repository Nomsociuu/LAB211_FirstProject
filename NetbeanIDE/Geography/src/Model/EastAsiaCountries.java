
package Model;

public class EastAsiaCountries extends Country {

    private String countryTerrain;

    public EastAsiaCountries() {
    }
    
    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-15s %-15s",
                getCountryCode(), getCountryName(), getTotalArea(), getCountryTerrain());
    }
}
