package ubc.cpsc304.controller;

import lombok.RequiredArgsConstructor;
import ubc.cpsc304.domain.ParkA;
import ubc.cpsc304.domain.Program;
import ubc.cpsc304.service.ParkService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("parks")

public class ParkController {
    private final ParkService parkService;

    @GetMapping
    public List<ParkA> getParks() {
        return parkService.getAllParks();
    }

    @GetMapping("/{parkId}")
    public Optional<ParkA> getParkById(@PathVariable int parkId ) {
        return Optional.ofNullable(parkService.getParkById(parkId));
    }

    @GetMapping("/provinceName/{provinceId}")
    public String getProvinceName(@PathVariable int provinceId) {
        return parkService.getProvinceName(provinceId);
    }

    @GetMapping("/countryName/{provinceId}")
    public String getCountryName(@PathVariable int provinceId) {
        return parkService.getCountryName(provinceId);
    }

//    @GetMapping
//    public List<ParkA> parks(@RequestParam int provinceId) {
//        return parkService.getParksByProvince(provinceId);
//    }

    @GetMapping("/filter/")
    @ResponseBody
    public List<String> getMainFilter() {
        return parkService.getMainFilter();
    }

    @GetMapping("/filter/{firstFilter}")
    @ResponseBody
    public List<String> getSecondFilter(@PathVariable String firstFilter) {
        return parkService.getSecondFilter(firstFilter);
    }

    @GetMapping("/filter")
    @ResponseBody
    public List<ParkA> select(@RequestParam String firstFilter, @RequestParam String secondFilter) {
        return parkService.getParksByFilter(firstFilter, secondFilter);
    }

    @GetMapping("/filter/count")
    @ResponseBody
    public int selectCount(@RequestParam String firstFilter, @RequestParam String secondFilter) {
        return parkService.getParksByFilterAgg(firstFilter, secondFilter);
    }


    @GetMapping("/image/{parkId}")
    @ResponseBody
    public List<String> getImage(@PathVariable int parkId) {
        return parkService.getImages(parkId);
    }

    @GetMapping("/filter/count/{provinceId}")
    @ResponseBody
    public int getProvinceCount(@PathVariable int provinceId) {
        return parkService.getCountByProvinceId(provinceId);
    }


}

