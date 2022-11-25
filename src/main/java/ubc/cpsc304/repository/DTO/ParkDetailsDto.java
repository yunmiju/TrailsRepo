package ubc.cpsc304.repository.DTO;

import lombok.Builder;
import lombok.Data;

@Data
public class ParkDetailsDto {

  private Integer id;
  private String parkName;
  private String parkAddress;
  private String openHours;
  private String closeHours;
  private String centerName;
  private String email;
  private String centerAddress;
  private String provinceName;
  private String countryName;
  private String permitType;
  private Integer campingSite;
  private Integer programNums;

  public ParkDetailsDto() {

  }

  @Builder
  public ParkDetailsDto(int id, String parkName, String parkAddress, String openHours,
      String closeHours, String centerName, String email, String centerAddress, String provinceName,
      String countryName, Integer programNums, String permitType, Integer camping_site) {
    this.id = id;
    this.parkName = parkName;
    this.parkAddress = parkAddress;
    this.openHours = openHours;
    this.closeHours = closeHours;
    this.centerName = centerName;
    this.email = email;
    this.centerAddress = centerAddress;
    this.provinceName = provinceName;
    this.countryName = countryName;
    this.permitType = permitType;
    this.campingSite = camping_site;
    this.programNums = programNums;

  }
}
