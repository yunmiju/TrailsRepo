package ubc.cpsc304.repository.DTO;

import lombok.Builder;
import lombok.Data;

@Data
public class ReservationInfoDto {
  private Integer programId;
  private String reservationNumber;
  private String programName;
  private String email;
  private Integer ppl;

  public ReservationInfoDto() {

  }

  @Builder
  public ReservationInfoDto(Integer programId, String reservationNumber, String programName, String email,
      Integer ppl) {
    this.programId = programId;
    this.reservationNumber = reservationNumber;
    this.programName = programName;
    this.email = email;
    this.ppl = ppl;
  }
}
