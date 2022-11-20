package ubc.cpsc304.domain;
import lombok.Data;

@Data
public class Parks extends ParkA {
    protected int id;
    protected String parkName;
    protected int provinceId;
    protected String parkAddress;
    protected String openHour;
    protected String closeHour;

    public Parks() {

    }

    public Parks(int id) {
        this.id = id;
    }

    public Parks(int id, int provinceId, String parkName, String parkAddress, String openHour, String closeHour) {
        this.id = id;
        this.provinceId = provinceId;
        this.parkName = parkName;
        this.parkAddress = parkAddress;
        this.openHour = openHour;
        this.closeHour = closeHour;
    }

}