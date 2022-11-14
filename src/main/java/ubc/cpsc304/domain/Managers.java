package ubc.cpsc304.domain;
import lombok.Data;

@Data
public class Managers {
    private int id;
    private String managerName;

    public Managers() {
    }

    public Managers(int id, String managerName) {
        this.id = id;
        this.managerName = managerName;
    }

    public int getId() {
        return id;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}
