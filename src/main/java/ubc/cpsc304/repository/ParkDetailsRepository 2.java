package ubc.cpsc304.repository;

import ubc.cpsc304.repository.DTO.ParkDetailsDto;

public interface ParkDetailsRepository {

  ParkDetailsDto parkInfoById(Integer parkId);

}
