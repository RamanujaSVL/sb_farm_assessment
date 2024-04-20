package com.venuiti.sb_farm_assessment.repo;

import com.venuiti.sb_farm_assessment.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockData {

    public static List<Farm> getFarms() {
        List<Farm> farms = new ArrayList<>();

        Farm farm1 = new Farm(1L, "Farm1");
        Farm farm2 = new Farm(2L,"Farm2");
        Farm farm3 = new Farm(3L, "Farm3");

        farms.add(farm1);
        farms.add(farm2);
        farms.add(farm3);

        return farms;
    }

    public static List<Crops> getCrops() {
        return Arrays.asList(Crops.CORN, Crops.POTATO);
    }

    public static List<Season> getSeasons() {
        List<Season> seasons = new ArrayList<>();

        Season season1 = new Season("Spring");
        Season season2 = new Season("Summer");

        seasons.add(season1);
        seasons.add(season2);

        return seasons;
    }

    public static List<FarmPlantation> getPlantedInfo() {
        List<FarmPlantation> plantedInfoList = new ArrayList<>();

        for (Farm farm : getFarms()) {
            for (Crops crop : getCrops()) {
                for (Season season : getSeasons()) {
                    FarmPlantation plantedInfo = new FarmPlantation();
                    plantedInfo.setFarm(farm);
                    plantedInfo.setCrop(crop);
                    plantedInfo.setSeason(season);
                    plantedInfo.setPlantingAreaInAcres(10.0);
                    plantedInfo.setExpectedProduct(100.0 * farm.getId());
                    plantedInfoList.add(plantedInfo);
                }
            }
        }

        return plantedInfoList;
    }

    public static List<FarmHarvest> getHarvestedInfo() {
        List<FarmHarvest> harvestedInfoList = new ArrayList<>();

        for (Farm farm : getFarms()) {
            for (Crops crop : getCrops()) {
                for (Season season : getSeasons()) {
                    FarmHarvest harvestedInfo = new FarmHarvest();
                    harvestedInfo.setFarm(farm);
                    harvestedInfo.setCrop(crop);
                    harvestedInfo.setSeason(season);
                    harvestedInfo.setActualProductOutput(80.0 * farm.getId());
                    harvestedInfoList.add(harvestedInfo);
                }
            }
        }

        return harvestedInfoList;
    }
}
