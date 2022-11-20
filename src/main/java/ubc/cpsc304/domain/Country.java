package ubc.cpsc304.domain;
import lombok.Data;
@Data
public class Country {
    private String cname;

    public Country() {

    }

    public Country(String cname) {
        this.cname = cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCname() {
        return cname;
    }
}

