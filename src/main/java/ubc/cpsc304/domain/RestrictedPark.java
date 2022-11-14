package ubc.cpsc304.domain;
import lombok.Data;

public class RestrictedPark extends Parks{

    private int dailyCapacity;
    private String permitType;

    public RestrictedPark() {

    }

    public RestrictedPark(int id, int provinceId, String parkName, String parkAddress, String openHour, String closeHour, int dailyCapacity, String permitType) {
        super(id, provinceId, parkName, parkAddress, openHour, closeHour);
        this.dailyCapacity = dailyCapacity;
        this.permitType = permitType;
    }

    public int getDailyCapacity(int dailyCapacity) {
        return this.dailyCapacity;
    }

    public String getPermitType() {
        return permitType;
    }

    public int getDailyCapacity() {
        return this.dailyCapacity;
    }
}
