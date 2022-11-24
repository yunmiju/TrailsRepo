package ubc.cpsc304.repository;


import java.util.List;
import ubc.cpsc304.domain.ProgramReservation;
import ubc.cpsc304.repository.DTO.ProgramReservationSearchCond;
import ubc.cpsc304.repository.DTO.ReservationRequestDto;

public interface ProgramReservationRepository {

  ProgramReservation save(ProgramReservation programReservation);

  Integer update(ReservationRequestDto updateParam);


  Integer delete(String reservationNumer);

  List<ProgramReservation> findAll(ProgramReservationSearchCond cond);

  ProgramReservation findByReservationNumber(String reservationNumber);
}

