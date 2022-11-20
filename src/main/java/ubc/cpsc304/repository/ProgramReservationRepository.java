package ubc.cpsc304.repository;


import ubc.cpsc304.domain.ProgramReservation;
import java.util.List;

public interface ProgramReservationRepository {

  ProgramReservation save(ProgramReservation programReservation);

  public void update(int id, ProgramReservationUpdateDto updateParam);


  public void delete(int id);

  public List<ProgramReservation> findAll(ProgramReservationSearchCond cond);
}
