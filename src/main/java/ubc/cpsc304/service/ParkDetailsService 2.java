package ubc.cpsc304.service;

import ubc.cpsc304.repository.DTO.ParkDetailsDto;

public interface ParkDetailsService {

  ParkDetailsDto findByParkId(Integer parkId);

}
