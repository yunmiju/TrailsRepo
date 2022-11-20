package ubc.cpsc304.domain;

import static ch.qos.logback.core.joran.action.ActionConst.NULL;

public abstract class ParkA {

    protected int id = 0;
    protected String parkName = NULL;
    protected int provinceId = 0;
    protected String parkAddress = NULL;
    protected String openHour = NULL;
    protected String closeHour = NULL;
    protected int dailyCapacity = 0;
    protected String permitType = NULL;
    protected boolean campingSite = false;

    public int getId() {
        return id;
    }

    public String getParkName() {
        return parkName;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public String getParkAddress() {
        return parkAddress;
    }

    public String getOpenHour() {
        return openHour;
    }

    public String getCloseHour() {
        return closeHour;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public void setParkAddress(String parkAddress) {
        this.parkAddress = parkAddress;
    }

    public void setOpenHour(String openHour) {
        this.openHour = openHour;
    }

    public void setCloseHour(String closeHour) {
        this.closeHour = closeHour;
    }

    public int getDailyCapacity() {
        return dailyCapacity;
    }

    public String getPermitType() {
        return permitType;
    }

    public boolean isCampingSite() {
        return campingSite;
    }

    public void setDailyCapacity(int dailyCapacity) {
        this.dailyCapacity = dailyCapacity;
    }

    public void setPermitType(String permitType) {
        this.permitType = permitType;
    }

    public void setCampingSite(boolean campingSite) {
        this.campingSite = campingSite;
    }
}
