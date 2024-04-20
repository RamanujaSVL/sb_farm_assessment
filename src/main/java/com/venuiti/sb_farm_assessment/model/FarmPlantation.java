package com.venuiti.sb_farm_assessment.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FarmPlantation {
    private Season season;
    private Crops crop;
    private double plantingAreaInAcres;
    private double expectedProduct;
    private Farm farm;
}
