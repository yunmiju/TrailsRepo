package ubc.cpsc304.domain;
import lombok.Data;
@Data
public abstract class Parks {
    protected int id;
    protected String parkName;
    protected int provinceId;
    protected String parkAddress;
    protected String openHour;
    protected String closeHour;

    public Parks() {
    }

    public Parks(int id, int provinceId, String parkName, String parkAddress, String openHour, String closeHour) {
        this.id = id;
        this.provinceId = provinceId;
        this.parkName = parkName;
        this.parkAddress = parkAddress;
        this.openHour = openHour;
        this.closeHour = closeHour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkAddress(String parkAddress) {
        this.parkAddress = parkAddress;
    }

    public String getParkAddress() {
        return parkAddress;
    }

    public String getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(String closeHour) {
        this.closeHour = closeHour;
    }

    public String getOpenHour() {
        return openHour;
    }

    public void setOpenHour(String openHour) {
        this.openHour = openHour;
    }
 }
