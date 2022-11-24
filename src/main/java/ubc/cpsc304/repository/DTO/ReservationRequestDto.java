package ubc.cpsc304.repository.DTO;

import lombok.Data;

@Data
public class ReservationRequestDto {

  private Integer programId;
  private String email;
  private Integer ppl;
  private String reservationNumber;

  public ReservationRequestDto() {

  }

  public ReservationRequestDto(String reservationNumber, Integer programId, String email,
      Integer ppl) {
    this.reservationNumber = reservationNumber;
    this.programId = programId;
    this.email = email;
    this.ppl = ppl | 1;
  }
}
