package ubc.cpsc304.repository;

import java.util.List;
import java.util.Optional;
import ubc.cpsc304.domain.Program;
import ubc.cpsc304.domain.ProgramInfo;

public interface ProgramRepository {

  ProgramInfo save(ProgramInfo programInfo);

  List<Program> findAll();

  List<Program> findByParkId(long parkId);

  Optional<ProgramInfo> findById(int id);

  Integer delete(Integer id);
}
