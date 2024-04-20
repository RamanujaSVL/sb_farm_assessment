package com.venuiti.sb_farm_assessment.service;

import com.venuiti.sb_farm_assessment.model.FarmPlantation;
import com.venuiti.sb_farm_assessment.repo.MockData;
import com.venuiti.sb_farm_assessment.util.FarmReportsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantationService {

    @Autowired
    FarmReportsUtil reportsUtil;

    private static final Logger logger = LoggerFactory.getLogger(PlantationService.class);

    public List<FarmPlantation> generatePlantationReport(String cropOrFarmName) {
        List<FarmPlantation> dataSource = MockData.getPlantedInfo();

        if (reportsUtil.isItACrop(cropOrFarmName)) {
            List<FarmPlantation> plantedInfoForCrop = new ArrayList<>();
            logger.info("Retrieving Plantation Info for Crop - {}",cropOrFarmName);

            for (FarmPlantation plantedInfo : dataSource) {
                if (plantedInfo.getCrop().name().equals(cropOrFarmName)) {
                    plantedInfoForCrop.add(plantedInfo);
                }
            }

            return plantedInfoForCrop;
        } else {
            List<FarmPlantation> plantedInfoForFarm = new ArrayList<>();
            logger.info("Retrieving Plantation Info for Farm - {}",cropOrFarmName);

            for (FarmPlantation plantedInfo : dataSource) {
                if (plantedInfo.getFarm().getName().equals(cropOrFarmName)) {
                    plantedInfoForFarm.add(plantedInfo);
                }
            }

            return plantedInfoForFarm;
        }
    }
}
