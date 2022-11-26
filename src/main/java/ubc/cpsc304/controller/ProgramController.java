package ubc.cpsc304.controller;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import ubc.cpsc304.advice.ApiException;
import ubc.cpsc304.advice.ExceptionResponse;
import ubc.cpsc304.domain.Program;
import ubc.cpsc304.domain.ProgramInfo;
import ubc.cpsc304.service.ProgramService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("programs")
@RequiredArgsConstructor
public class ProgramController {

  @Autowired
  private final ProgramService programService;

  // @GetMapping
  // @ResponseBody
  // public String listProgram(Model model) {
  // model.addAttribute("programs", programService.findAll());
  // System.out.println(programService.findAll());
  // return "programs";
  // }

  // @GetMapping
  // public List<Program> listProgram(Model model) {
  // return programService.findAll();
  // }

  @GetMapping
  public List<Program> programsByParkId(
      @RequestParam(value = "parkId", required = true) long parkId) {
    return programService.findByParkId(parkId);
  }

  @GetMapping("{id}")
  public Optional<ProgramInfo> programById(@PathVariable int id, Model model) {
    return programService.findById(id);
  }

  @PutMapping("delete/{programId}")
  public String deleteReservation(@PathVariable Integer programId) {
    return programService.delete(programId);
  }

  // @GetMapping("test")
  // public ResponseEntity test() {
  // return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessgae.))
  // }

  @ExceptionHandler(ApiException.class)
  public ResponseEntity<ExceptionResponse> handleUserNotFoundException(ApiException ex,
      WebRequest request) {
    final ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getError().getCode(), ex.getMessage());
    ResponseEntity.BodyBuilder builder;
    builder = ResponseEntity.status(ex.getError().getStatus());
    System.out.println("exceptionRespons : " + exceptionResponse);
    // return new ResponseEntity<String>("hi", ex.getError().getStatus());
    return builder.body(exceptionResponse);
  }

}
