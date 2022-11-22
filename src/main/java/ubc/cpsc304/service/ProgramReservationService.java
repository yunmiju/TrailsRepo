package ubc.cpsc304.service;

import java.util.List;
import ubc.cpsc304.domain.ProgramReservation;
import ubc.cpsc304.repository.DTO.ProgramReservationSearchCond;
import ubc.cpsc304.repository.DTO.ReservationRequestDto;

public interface ProgramReservationService {

  ProgramReservation save(ReservationRequestDto param);

  List<ProgramReservation> findByCond(ProgramReservationSearchCond cond);

  ProgramReservation update(ReservationRequestDto updateParam);

  String delete(String reservationNumber);
}
