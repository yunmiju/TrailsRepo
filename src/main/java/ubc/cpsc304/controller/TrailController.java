package ubc.cpsc304.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ubc.cpsc304.repository.DTO.TrailDto;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ubc.cpsc304.service.TrailImageService;
import ubc.cpsc304.service.TrailService;
import ubc.cpsc304.service.TrailServiceV2;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("trails")
@RequiredArgsConstructor
public class TrailController {

    @Autowired
    private final TrailService trailService;
    @Autowired
    private final TrailImageService trailImageService;

    @GetMapping("{parkId}")
    public List<TrailDto> trailsByParkId(@PathVariable int parkId) {
        return trailService.getAllTrails(parkId);
    }

    @GetMapping("/filter/")
    @ResponseBody
    public List<TrailDto> division(int parkId, String seasonName) {
        return trailService.trailsDivision(parkId, seasonName);
    }

    @GetMapping("/image/{trailName}")
    @ResponseBody
    public List<String> getImage(int parkId, String trailName) {
        return trailImageService.getImages(parkId, trailName);
    }
//    @GetMapping("{id}")
//    public Optional<ProgramInfo> programById(@PathVariable int id, Model model) {
//        return programService.findById(id);
//    }
//
//    @PutMapping("delete/{programId}")
//    public String deleteReservation(@PathVariable Integer programId) {
//        return programService.delete(programId);
//    }
}