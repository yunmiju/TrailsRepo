package ubc.cpsc304.domain;

public class VisitorCenter {
    private int id;
    private int parkId;
    private String centerName;
    private String email;
    private String centerAddress;

    public VisitorCenter(int id) {
        this.id = id;
    }
    public VisitorCenter(int id, int parkId, String centerName, String email, String centerAddress) {
        this.id = id;
        this.parkId = parkId;
        this.centerName = centerName;
        this.email = email;
        this.centerAddress = centerAddress;
    }

    public int getId() {
        return id;
    }

    public String getCenterName() {
        return centerName;
    }

    public int getParkId() {
        return parkId;
    }

    public void setParkId(int parkId) {
        this.parkId = parkId;
    }

    public String getEmail() {
        return email;
    }

    public String getCenterAddress() {
        return centerAddress;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCenterAddress(String centerAddress) {
        this.centerAddress = centerAddress;
    }
}

