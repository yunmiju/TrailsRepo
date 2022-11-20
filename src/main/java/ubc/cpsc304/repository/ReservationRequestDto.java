package ubc.cpsc304.repository;

import lombok.Data;

@Data
public class ReservationRequestDto {

  private Integer programId;
  private String email;
  private Integer ppl;

  public ReservationRequestDto() {

  }

  public ReservationRequestDto(Integer programId, String email, Integer ppl) {
    this.programId = programId;
    this.email = email;
    this.ppl = ppl | 1;
  }
}
