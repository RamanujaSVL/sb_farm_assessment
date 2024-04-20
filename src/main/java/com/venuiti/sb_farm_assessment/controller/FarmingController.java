package com.venuiti.sb_farm_assessment.controller;

import com.venuiti.sb_farm_assessment.model.FarmHarvest;
import com.venuiti.sb_farm_assessment.model.FarmPlantation;
import com.venuiti.sb_farm_assessment.service.HarvestService;
import com.venuiti.sb_farm_assessment.service.PlantationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/venuiti/farms")
public class FarmingController {

    @Autowired
    PlantationService plantationService;

    @Autowired
    HarvestService harvestService;


    @GetMapping("/reports/plantation/{value}")
    public ResponseEntity<?> getFarmReports(@PathVariable("value") String cropOrFarmName) {
        List<FarmPlantation> plantationReports = plantationService.generatePlantationReport(cropOrFarmName);
        ResponseEntity<?> response;
        if(!plantationReports.isEmpty())
             response = ResponseEntity.ok(plantationReports);
        else
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Data Found");
        return response;
    }

    @GetMapping("/reports/harvest/{value}")
    public ResponseEntity<?> getCropReports(@PathVariable("value") String cropOrFarmName) {
        List<FarmHarvest> harvestReports = harvestService.generateHarvestReport(cropOrFarmName);
        ResponseEntity<?> response;
        if(!harvestReports.isEmpty())
            response = ResponseEntity.ok(harvestReports);
        else
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Data Found");
        return response;
    }
}
