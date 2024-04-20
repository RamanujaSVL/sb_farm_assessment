package com.venuiti.sb_farm_assessment.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FarmHarvest {
    private Farm farm;
    private Season season;
    private Crops crop;
    private double actualProductOutput;
}
