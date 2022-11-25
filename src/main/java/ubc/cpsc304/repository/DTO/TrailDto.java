package ubc.cpsc304.repository.DTO;

import lombok.Builder;
import lombok.Data;

@Data
public class TrailDto {
    private int id;
    private String trailName;
    private String difficulty;
    private float duration;
    private float distance;
    private String trailDescription;
    private String imageUrl;
    private String seasonName;

    public TrailDto() {

    }

    @Builder
    public TrailDto(int id, String trailName, String difficulty, float duration,
                    float distance, String trailDescription, String imageUrl,
                    String seasonName) {
        this.id = id;
        this.trailName = trailName;
        this.difficulty = difficulty;
        this.duration = duration;
        this.distance = distance;
        this.trailDescription = trailDescription;
        this.imageUrl = imageUrl;
        this.seasonName = seasonName;
    }
}
