package ubc.cpsc304.domain;
import lombok.Data;
@Data
public class Provinces {
    private int id;
    private String provinceName;
    private String countryName;

    public  Provinces() {

    }

    public Provinces(int id) {
        this.id = id;
    }

    public Provinces(int id, String provinceName, String countryName) {
        this.id = id;
        this.provinceName = provinceName;
        this.countryName = countryName;
    }

    public int getId() {
        return id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
