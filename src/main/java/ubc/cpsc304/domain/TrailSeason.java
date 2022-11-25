package ubc.cpsc304.domain;

public class TrailSeason {
    private String trailName;
    private String seasonName;
    private int parkId;
    private String difficulty;

    public TrailSeason() {

    }

    public TrailSeason(String trailName, String seasonName, int parkId, String difficulty) {
        this.trailName = trailName;
        this.seasonName = seasonName;
        this.parkId = parkId;
        this.difficulty = difficulty;
    }

    public String getTrailName() {
        return trailName;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public int getParkId() {
        return parkId;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setTrailName(String trailName) {
        this.trailName = trailName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public void setParkId(int parkId) {
        this.parkId = parkId;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
