package ubc.cpsc304.controller;

import java.util.Optional;
import ubc.cpsc304.domain.Program;
import ubc.cpsc304.domain.ProgramInfo;
import ubc.cpsc304.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequestMapping("programs")
@RequiredArgsConstructor
public class ProgramController {

  private final ProgramService programService;

//  @GetMapping
//  @ResponseBody
//  public String listProgram(Model model) {
//    model.addAttribute("programs", programService.findAll());
//    System.out.println(programService.findAll());
//    return "programs";
//  }
  @GetMapping
  @ResponseBody
  public List<Program> listProgram(Model model) {
    return programService.findAll();
  }


  @GetMapping("?park=parkId")
  @ResponseBody
  public List<Program> programs(@RequestParam long parkId) {
    return programService.findByParkId(parkId);
  }

  @GetMapping("{id}")
  @ResponseBody
  public Optional<ProgramInfo> program(@PathVariable int id, Model model) {
    return programService.findById(id);
  }

}

