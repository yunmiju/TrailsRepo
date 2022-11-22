package ubc.cpsc304.controller;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ubc.cpsc304.domain.Program;
import ubc.cpsc304.domain.ProgramInfo;
import ubc.cpsc304.service.ProgramService;

@RestController
@RequestMapping("programs")
@RequiredArgsConstructor
public class ProgramController {

  @Autowired
  private final ProgramService programService;

//  @GetMapping
//  @ResponseBody
//  public String listProgram(Model model) {
//    model.addAttribute("programs", programService.findAll());
//    System.out.println(programService.findAll());
//    return "programs";
//  }

//  @GetMapping
//  public List<Program> listProgram(Model model) {
//    return programService.findAll();
//  }

  @GetMapping
  public List<Program> programsByParkId(
      @RequestParam(value = "parkId", required = true) long parkId) {
    System.out.println("here  !!!!");
    return programService.findByParkId(parkId);
  }

  @GetMapping("{id}")
  public Optional<ProgramInfo> programById(@PathVariable int id, Model model) {
    return programService.findById(id);
  }

//  @GetMapping("test")
//  public ResponseEntity test() {
//    return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessgae.))
//  }

}

