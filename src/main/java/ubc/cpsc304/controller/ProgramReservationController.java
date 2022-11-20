package ubc.cpsc304.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ubc.cpsc304.repository.ProgramReservationSearchCond;
import ubc.cpsc304.repository.ReservationRequestDto;
import ubc.cpsc304.service.ProgramReservationService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("reservation")
@RequiredArgsConstructor
public class ProgramReservationController {

  @Autowired
  private final ProgramReservationService programReservationService;

  @PostMapping("save")
  @ResponseBody
  public String makeReservation(@RequestBody ReservationRequestDto param) {
    System.out.println("param :: " + param);
    programReservationService.save(param);
    return "test!";
  }

  @GetMapping("find")
  @ResponseBody
  public String findReservationByCond(@ModelAttribute ProgramReservationSearchCond cond) {
    programReservationService.findByCond(cond);
    return "test!";
  }

  @GetMapping("test")
  @ResponseBody
  public String test(HttpServletRequest request, HttpServletResponse response, Model model) {
    System.out.println("request : " + request);
    return "test!";
  }
}
