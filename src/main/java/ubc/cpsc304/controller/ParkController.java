package ubc.cpsc304.controller;

import lombok.RequiredArgsConstructor;
import ubc.cpsc304.service.ParkService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://localhost:8080")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/parks", method = RequestMethod.GET)
public class ParkController {
    private final ParkService parkService;

    @RequestMapping(value = "/park", method = RequestMethod.GET)
    public String listPark(Model model) {
        model.addAttribute("parks", parkService.getAllParks());
        // is Empty?
        return "parks";
    }

    @GetMapping("/{parkId}")
    public String parks(@PathVariable String f1, Model model) {
        List<String> parks = parkService.getSecondFilter(f1);
        model.addAttribute("parks", parks);
        // is Empty?
        return "parks";
    }
}

