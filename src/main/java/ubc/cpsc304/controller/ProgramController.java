package ubc.cpsc304.controller;

import ubc.cpsc304.domain.Program;
import ubc.cpsc304.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@Controller
@RequestMapping("/programs")
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramService programService;

    @GetMapping("/{id}")
    public List<Program> programs(@PathVariable int parkId, Model model) {
      List<Program> programs = programService.findByParkId(parkId);
        // is Empty?
        return programs;
    }

    
}

