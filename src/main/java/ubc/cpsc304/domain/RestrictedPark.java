package ubc.cpsc304.domain;

public class RestrictedPark extends Parks {

    public RestrictedPark(int id) {
        this.id = id;
    }

    public RestrictedPark(int id, int dailyCapacity, String permitType) {
        this.id = id;
        this.dailyCapacity = dailyCapacity;
        this.permitType = permitType;
    }

    public void setDailyCapacity(int dailyCapacity) {
        this.dailyCapacity = dailyCapacity;
    }

    public void setPermitType(String permitType) {
        this.permitType = permitType;
    }

}