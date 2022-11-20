package ubc.cpsc304.repository;


import ubc.cpsc304.domain.ProgramReservation;
import java.util.List;

public interface ProgramReservationRepository {

  ProgramReservation save(ProgramReservation programReservation);

  ProgramReservation update(ReservationRequestDto updateParam);


  String delete(int id);

  List<ProgramReservation> findAll(ProgramReservationSearchCond cond);
}
