package com.venuiti.sb_farm_assessment.util;

import com.venuiti.sb_farm_assessment.model.Crops;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class FarmReportsUtil {
    public boolean isItACrop(String value) {
        return Arrays.stream(Crops.values()).anyMatch(val -> val.name().equals(value));
    }
}
