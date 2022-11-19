package ubc.cpsc304.domain;
import lombok.Data;


public class  PublicParks extends Parks {
    private boolean hasCampingSite;

    public PublicParks() {

    }

    public PublicParks(int id, int provinceId, String parkName, String parkAddress, String openHour, String closeHour, boolean hasCampingSite) {
        super(id, provinceId, parkName, parkAddress, openHour, closeHour);
        this.hasCampingSite = hasCampingSite;
    }

    public boolean hasCampingSite() {
        return hasCampingSite;
    }

}
