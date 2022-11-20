package ubc.cpsc304.domain;
import lombok.Data;
@Data
public class Countries {
    private String countryName;

    public Countries() {

    }

    public Countries(String countryName) {
        this.countryName = countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return this.countryName;
    }
}

