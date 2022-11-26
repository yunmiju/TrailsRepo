package ubc.cpsc304.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import ubc.cpsc304.advice.ApiException;
import ubc.cpsc304.repository.DTO.ParkDetailsDto;
import ubc.cpsc304.service.ParkDetailsService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class ParkDetailController {

  @Autowired
  private final ParkDetailsService parkDetailsService;

  @GetMapping("parkdetails/{id}")
  public ParkDetailsDto parkDetailById(@PathVariable int id) {
    return parkDetailsService.findByParkId(id);
  }
}
