package ubc.cpsc304.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ubc.cpsc304.advice.ApiException;
import ubc.cpsc304.advice.ExceptionEnum;
import ubc.cpsc304.repository.DTO.ParkDetailsDto;
import ubc.cpsc304.repository.ParkDetailsRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ParkDetailsServiceV1 implements ParkDetailsService {

  private final ParkDetailsRepository parkDetailsRepository;

  @Override
  public ParkDetailsDto findByParkId(Integer parkId) {
    try {
      ParkDetailsDto queryResult = parkDetailsRepository.parkInfoById(parkId);
      return queryResult;
    } catch (DataAccessException e) {
      throw new ApiException(ExceptionEnum.EMPTY_RESULT);
    }
  }
}
