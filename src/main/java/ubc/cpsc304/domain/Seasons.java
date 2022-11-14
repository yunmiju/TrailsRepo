package ubc.cpsc304.domain;
import lombok.Data;

@Data
public class Seasons {
    private String seasonName;

    public Seasons() {}

    public Seasons(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }
}
