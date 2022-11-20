package ubc.cpsc304.controller;

import lombok.RequiredArgsConstructor;
import ubc.cpsc304.domain.ParkA;
import ubc.cpsc304.domain.Program;
import ubc.cpsc304.service.ParkService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://localhost:8080")
@RestController
@RequiredArgsConstructor
@RequestMapping("/parks")
public class ParkController {
    private final ParkService parkService;

    @GetMapping
    public List<ParkA> listPark(Model model) {
        return parkService.getAllParks();
    }

    @GetMapping("{parkId}")
    public Optional<ParkA> park(@PathVariable int parkId, Model model) {
        return Optional.ofNullable(parkService.getParkById(parkId));
    }

    @GetMapping("?province=provinceId")
    @ResponseBody
    public List<ParkA> parks(@RequestParam int provinceId) {
        return parkService.getParksByProvince(provinceId);
    }

    @GetMapping("?country=countryName")
    @ResponseBody
    public List<ParkA> parks(@RequestParam String countryName) {
        return parkService.getParksByCountry(countryName);
    }

}

