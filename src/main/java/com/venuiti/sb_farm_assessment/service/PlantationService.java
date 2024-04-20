package com.venuiti.sb_farm_assessment.service;

import com.venuiti.sb_farm_assessment.model.FarmPlantation;
import com.venuiti.sb_farm_assessment.repo.MockData;
import com.venuiti.sb_farm_assessment.util.FarmReportsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantationService {

    @Autowired
    FarmReportsUtil reportsUtil;

    public List<FarmPlantation> generatePlantationReport(String cropOrFarmName) {
        List<FarmPlantation> dataSource = MockData.getPlantedInfo();

        if (reportsUtil.isItACrop(cropOrFarmName)) {
            List<FarmPlantation> plantedInfoForCrop = new ArrayList<>();

            for (FarmPlantation plantedInfo : dataSource) {
                if (plantedInfo.getCrop().name().equals(cropOrFarmName)) {
                    plantedInfoForCrop.add(plantedInfo);
                }
            }

            return plantedInfoForCrop;
        } else {
            List<FarmPlantation> plantedInfoForFarm = new ArrayList<>();

            for (FarmPlantation plantedInfo : dataSource) {
                if (plantedInfo.getFarm().getName().equals(cropOrFarmName)) {
                    plantedInfoForFarm.add(plantedInfo);
                }
            }

            return plantedInfoForFarm;
        }
    }
}
