package ubc.cpsc304.domain;

public class VisitorCentre {
    private int id;
    private String centerName;
    private String email;
    private String centerAddress;

    public VisitorCentre() {

    }
    public VisitorCentre(int id, String centerName, String email, String centerAddress) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public String getCenterAddress() {
        return centerAddress;
    }
}

