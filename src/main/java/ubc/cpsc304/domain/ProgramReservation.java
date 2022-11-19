package ubc.cpsc304.domain;

import lombok.Data;

@Data
public class ProgramReservation {
  private int id;
  private String reservationNumber;
  private int programId;
  private String email;
  private int ppl;

  public ProgramReservation() {

  }

  public ProgramReservation(int id, String reservationNumber, int programId, String email, int ppl) {
    this.id = id;
    this.reservationNumber = reservationNumber;
    this.programId = programId;
    this.email = email;
    this.ppl = ppl;
  }
}
