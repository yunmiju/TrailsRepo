package ubc.cpsc304.repository.DTO;

import lombok.Data;

@Data
public class ProgramReservationUpdateDto {

  private String email;
  private Integer ppl;

  public ProgramReservationUpdateDto() {

  }

  public ProgramReservationUpdateDto(String email, Integer ppl) {
    this.email = email;
    this.ppl = ppl;
  }
}
