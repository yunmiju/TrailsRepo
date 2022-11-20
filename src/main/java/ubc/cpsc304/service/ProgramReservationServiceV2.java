package ubc.cpsc304.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ubc.cpsc304.domain.ProgramReservation;
import ubc.cpsc304.repository.ProgramReservationRepository;
import ubc.cpsc304.repository.ReservationRequestDto;

@Service
@RequiredArgsConstructor
@Transactional
public class ProgramReservationServiceV2 {

  private final ProgramReservationRepository programReservationRepository;

  //public ProgramReservation save(ReservationRequestDto reservationRequestDto) {
  //  handleRequest(reservationRequestDto);
  //  String reservationNumber = generateReservationNumber();
  //  ProgramReservation programReservation = new ProgramReservation();
  //  programReservation.setProgramId(reservationRequestDto.programId);
  // programReservation.setEmail(reservationRequestDto.email);
 //   programReservation.setPpl(reservationRequestDto.ppl | 1);
  //  programReservation.setReservationNumber(generateReservationNumber());
  //  return programReservationRepository.save(programReservation);
 // }

 // public Optional<ProgramReservation>
 // public List<ProgramReservation> find () {
//
//  }

  private void handleRequest(ReservationRequestDto reservationRequest) {
  //  if (!reservationRequest) {
  //    throw new Error();
  //  }
  //  if (!reservationRequest.programId || !reservationRequest.email) {
  //    throw new Error();
  //  }
  }

  private String generateReservationNumber() {
    return "111";
  }
}
