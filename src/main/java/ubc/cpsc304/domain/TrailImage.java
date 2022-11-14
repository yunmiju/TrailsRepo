package ubc.cpsc304.domain;
import lombok.Data;

@Data
public class TrailImage {
    private String trailName;
    private int parkId;
    private String difficulty;
    private String imageUrl;

    public TrailImage() {}

    public TrailImage(String trailName, int parkId, String difficulty, String imageUrl) {
        this.trailName = trailName;
        this.parkId = parkId;
        this.difficulty = difficulty;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }
}
