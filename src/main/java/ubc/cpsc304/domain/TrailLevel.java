package ubc.cpsc304.domain;
import lombok.Data;

@Data
public class TrailLevel {
    private Float distance;
    private String difficulty;
    private Float duration;

    public TrailLevel() {}

    public TrailLevel(Float distance, String difficulty, Float duration) {
        this.distance = distance;
        this.difficulty = difficulty;
        this.duration = duration;
    }

    public Float getDistance() {
        return distance;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public Float getDuration() {
        return duration;
    }
}
