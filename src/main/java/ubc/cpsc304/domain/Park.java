package ubc.cpsc304.domain;
import lombok.Data;

@Data
public class Park extends ParkA {
    protected int id;
    protected String parkName;
    protected int provinceId;
    protected String parkAddress;
    protected String openHour;
    protected String closeHour;

    public Park() {

    }

    public Park(int id) {
        this.id = id;
    }

    public Park(int id, int provinceId, String parkName, String parkAddress, String openHour, String closeHour) {
        this.id = id;
        this.provinceId = provinceId;
        this.parkName = parkName;
        this.parkAddress = parkAddress;
        this.openHour = openHour;
        this.closeHour = closeHour;
    }

}
