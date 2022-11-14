package ubc.cpsc304.domain;
import lombok.Data;

@Data
public class Huts {
    private int id;
    private String trailName;
    private int parkId;
    private String difficulty;
    private int beds;

    public Huts() {

    }

    public Huts(int id, String trailName, int parkId, String difficulty, int beds) {
        this.id = id;
        this.trailName = trailName;
        this.parkId = parkId;
        this.difficulty = difficulty;
        this.beds = beds;
    }

    public int getId() {
        return id;
    }

    public String getTrailName() {
        return trailName;
    }

    public int getParkId() {
        return parkId;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getBeds() {
        return beds;
    }
}

