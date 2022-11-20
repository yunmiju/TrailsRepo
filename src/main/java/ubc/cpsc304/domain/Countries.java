package ubc.cpsc304.domain;
import lombok.Data;
@Data
public class Countries {
    private String cname;

    public Countries() {

    }

    public Countries(String cname) {
        this.cname = cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCname() {
        return cname;
    }
}

