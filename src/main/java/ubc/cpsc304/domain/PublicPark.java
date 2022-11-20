package ubc.cpsc304.domain;

public class PublicPark extends Parks{

    public PublicPark(int id) {
        this.id = id;
    }

    public PublicPark(int id, boolean campingSite) {
        this.id = id;
        this.campingSite = campingSite;
    }

    public void setCampingSite(boolean campingSite) {
        this.campingSite = campingSite;
    }
}
