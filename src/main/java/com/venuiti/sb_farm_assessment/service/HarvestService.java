package com.venuiti.sb_farm_assessment.service;

import com.venuiti.sb_farm_assessment.model.FarmHarvest;
import com.venuiti.sb_farm_assessment.repo.MockData;
import com.venuiti.sb_farm_assessment.util.FarmReportsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HarvestService {
    @Autowired
    FarmReportsUtil reportsUtil;

    public List<FarmHarvest> generateHarvestReport(String cropOrFarmName) {
        List<FarmHarvest> dataSource = MockData.getHarvestedInfo();
        if (reportsUtil.isItACrop(cropOrFarmName)) {
            List<FarmHarvest> harvestedInfoForCrop = new ArrayList<>();

            for (FarmHarvest harvestInfo : dataSource) {
                if (harvestInfo.getCrop().name().equals(cropOrFarmName)) {
                    harvestedInfoForCrop.add(harvestInfo);
                }
            }

            return harvestedInfoForCrop;
        } else {
            List<FarmHarvest> harvestedInfoForFarm = new ArrayList<>();

            for (FarmHarvest harvestInfo : dataSource) {
                if (harvestInfo.getFarm().getName().equals(cropOrFarmName)) {
                    harvestedInfoForFarm.add(harvestInfo);
                }
            }

            return harvestedInfoForFarm;
        }
    }
}
