package ubc.cpsc304.controller;

import ubc.cpsc304.domain.Program;
import ubc.cpsc304.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequestMapping("/programs")
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramService programService;

  @GetMapping
  public String listProgram(Model model) {
    model.addAttribute("programs", programService.findAll());
    // is Empty?
    return "programs";
  }

    @GetMapping("/{parkId}")
    public String programs(@PathVariable long parkId, Model model) {
      List<Program> programs = programService.findByParkId(parkId);
      model.addAttribute("programs", programs);
        // is Empty?
        return "programs";
    }


    
}

