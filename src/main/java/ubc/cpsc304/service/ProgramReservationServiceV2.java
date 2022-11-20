package ubc.cpsc304.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ubc.cpsc304.domain.ProgramReservation;
import ubc.cpsc304.repository.ProgramReservationRepository;
import ubc.cpsc304.repository.ProgramReservationSearchCond;
import ubc.cpsc304.repository.ReservationRequestDto;

@Service
@RequiredArgsConstructor
@Transactional
public class ProgramReservationServiceV2 implements ProgramReservationService {

  private final ProgramReservationRepository programReservationRepository;

  public ProgramReservation save(ReservationRequestDto param) {
    Integer ppl = param.getPpl() == null ? 1 : param.getPpl();
    System.out.println("ppl :  " + ppl);
    ProgramReservation programReservation = new ProgramReservation();
    programReservation.setProgramId(param.getProgramId());
    programReservation.setEmail(param.getEmail());
    programReservation.setPpl(ppl);
    programReservation.setReservationNumber(generateReservationNumber());
    return programReservationRepository.save(programReservation);
  }

//   public Optional<ProgramReservation>
//  public List<ProgramReservation> findByCond(ReservationRequestDto reservationRequestDto) {
//    handleRequest(reservationRequestDto);
//  }

  public List<ProgramReservation> findByCond(ProgramReservationSearchCond cond) {
    checkSearchParam(cond);
    return programReservationRepository.findAll(cond);
  }

  public ProgramReservation updateReservation(ReservationRequestDto updateParam) {
    return programReservationRepository.update(updateParam);
  }

  public String delete(int id) {
    return programReservationRepository.delete(id);
  }

  private void handleRequest(ReservationRequestDto reservationRequestDto) {
//    if (!reservationRequestDto) {
//      throw new Error();
//    }
//    if (!reservationRequestDto.programId || !reservationRequestDto.email) {
//      throw new Error();
//    }
  }

  private void checkRequestParam(ReservationRequestDto param) {
    if (param.getProgramId() == null || param.getEmail() == null) {
      throw new ApiException(ExceptionEnum.INVALID_INPUT);
    }
  }

  private void checkSearchParam(ProgramReservationSearchCond cond) {
    System.out.println("in checkINput Empty check");
    if (cond.getEmail() == null && cond.getReservationNumber() == null) {
      throw new ApiException(ExceptionEnum.INVALID_INPUT);
    }
  }

  private ReservationRequestDto checkRequestPpl(ReservationRequestDto paramRaw) {
    if (paramRaw.getPpl() == null) {
      paramRaw.setPpl(1);
    }
    return paramRaw;
  }

  private String generateReservationNumber() {
    return "111";
  }
}
