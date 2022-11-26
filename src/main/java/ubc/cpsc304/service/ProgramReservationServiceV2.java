package ubc.cpsc304.service;

import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ubc.cpsc304.advice.ApiException;
import ubc.cpsc304.advice.ExceptionEnum;
import ubc.cpsc304.domain.ProgramReservation;
import ubc.cpsc304.repository.DTO.ProgramReservationSearchCond;
import ubc.cpsc304.repository.DTO.ReservationInfoDto;
import ubc.cpsc304.repository.DTO.ReservationRequestDto;
import ubc.cpsc304.repository.ProgramReservationRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ProgramReservationServiceV2 implements ProgramReservationService {

  private final ProgramReservationRepository programReservationRepository;

  public ProgramReservation save(ReservationRequestDto param) {
    Integer ppl = param.getPpl() == null ? 1 : param.getPpl();
    ProgramReservation programReservation = new ProgramReservation();
    programReservation.setProgramId(param.getProgramId());
    programReservation.setEmail(param.getEmail());
    programReservation.setPpl(ppl);
    programReservation.setReservationNumber(generateReservationNumber());
    Integer queryResult = programReservationRepository.save(programReservation);
    if (queryResult == 1) {
      return programReservation;
    } else {
      throw new ApiException(ExceptionEnum.RUNTIME_EXCEPTION);
    }
  }

  // public Optional<ProgramReservation>
  // public List<ProgramReservation> findByCond(ReservationRequestDto
  // reservationRequestDto) {
  // handleRequest(reservationRequestDto);
  // }

  @Override
  public List<ReservationInfoDto> findByCond(ProgramReservationSearchCond cond) {
    if (cond != null && cond.getEmail() != null && cond.getEmail().length() > 1) {
      String email = cond.getEmail();
      return programReservationRepository.findInfoByEmail(email);
    }
    return programReservationRepository.findAll(cond);
  }

  @Override
  public ReservationInfoDto update(ReservationRequestDto updateParam) {
    Integer queryResult = programReservationRepository.update(updateParam);
    if (queryResult == 0) {
      throw new ApiException(ExceptionEnum.RUNTIME_EXCEPTION);
    }
    return programReservationRepository.findInfoByReservationNumber(
        updateParam.getReservationNumber());
  }

  @Override
  public String delete(String reservationNumber) {
    Integer queryResult = programReservationRepository.delete(reservationNumber);
    if (queryResult != 1) {
      throw new ApiException(ExceptionEnum.EMPTY_RESULT);
    }
    return reservationNumber + " has been deleted";
  }

  private void handleRequest(ReservationRequestDto reservationRequestDto) {
    // if (!reservationRequestDto) {
    // throw new Error();
    // }
    // if (!reservationRequestDto.programId || !reservationRequestDto.email) {
    // throw new Error();
    // }
  }

  private void checkRequestParam(ReservationRequestDto param) {
    if (param.getProgramId() == null || param.getEmail() == null) {
      throw new ApiException(ExceptionEnum.INVALID_INPUT);
    }
  }

  private void checkSearchParam(ProgramReservationSearchCond cond) {
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
    int len = 7;
    Random random = new Random();
    int createNum = 0;
    String ranNum = "";
    String resultNum = "";

    for (int i = 0; i < len; i++) {
      createNum = random.nextInt(9);
      ranNum = Integer.toString(createNum);
      resultNum += ranNum;
    }
    return resultNum;
  }
}
