package com.example.air_quality_check;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String noUrl() {
        return "Please enter data to view the info about air quality in given floors, or enter airQualityInfo to check the purity of air!! Thank you";
    }

    @GetMapping("/data")
    public List<entity> list() {
        return userService.listAllData();
    }

    @GetMapping("airQualityInfo")
    public List<entity> air_quality_check() {
        List<entity> airMeasure = userService.listAllData();
        
        for (int i = 0; i < airMeasure.size(); i++ ){
            float air_quality_index = airMeasure.get(i).getCo2_level() + airMeasure.get(i).getC_level() + airMeasure.get(i).getCo_level() + airMeasure.get(i).getSo2_level() - airMeasure.get(i).getO2_level();
            if (air_quality_index <= 50) {
                airMeasure.get(i).setAir_quality_level("Air Quality is good and healthy :-)");
            }
            else if (air_quality_index >= 51 && air_quality_index <= 100) {
                airMeasure.get(i).setAir_quality_level("Air Quality is " + air_quality_index + ", which is Moderate!!!!");
            }
            else if (air_quality_index >= 101 && air_quality_index <= 150) {
                airMeasure.get(i).setAir_quality_level("Air Quality is " + air_quality_index + ", which is unhealthy for sensetive people, please do vacate the floor " +airMeasure.get(i).getFloor() + " if you're sensetive :-)");
            }
            else if (air_quality_index >= 151 && air_quality_index <= 200) {
                airMeasure.get(i).setAir_quality_level("Air Quality is " + air_quality_index + ", which is unhealthy, please do vacate the floor " +airMeasure.get(i).getFloor() + "!!!!");
            }
            else if (air_quality_index >= 201 && air_quality_index <= 300) {
                airMeasure.get(i).setAir_quality_level("Air Quality is " + air_quality_index + ", which is extremely unhealthy, please do vacate the floor " +airMeasure.get(i).getFloor() + " immediately!!!!!");
            }
            else if (air_quality_index >= 301) {
                airMeasure.get(i).setAir_quality_level("Air Quality is " + air_quality_index + ", which is hazardous, please do vacate the floor " +airMeasure.get(i).getFloor() + " immediately, DANGER DANGER!!!!!");
            }

        }
        return userService.listAllData();
    }
}
