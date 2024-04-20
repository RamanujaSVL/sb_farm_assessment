package com.venuiti.sb_farm_assessment;

import com.venuiti.sb_farm_assessment.controller.FarmingController;
import com.venuiti.sb_farm_assessment.model.FarmPlantation;
import com.venuiti.sb_farm_assessment.service.HarvestService;
import com.venuiti.sb_farm_assessment.service.PlantationService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(FarmingController.class)
class SbFarmAssessmentApplicationTests {

	@MockBean
	private PlantationService plantationService;

	@MockBean
	private HarvestService harvestService;

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetPlantedInfoForFarm_ValidFarmName() throws Exception {

		List<FarmPlantation> plantedInfoList = Arrays.asList(new FarmPlantation(), new FarmPlantation());
		Mockito.when(plantationService.generatePlantationReport(Mockito.anyString())).thenReturn(plantedInfoList);

		mockMvc.perform(MockMvcRequestBuilders.get("/venuiti/farms/reports/plantation/Farm1"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)));
	}

	@Test
	public void testGetPlantedInfoForFarm_InvalidFarmName_ReturnsNotFound() throws Exception {
		Mockito.when(plantationService.generatePlantationReport(Mockito.anyString())).thenReturn(Collections.emptyList());

		mockMvc.perform(MockMvcRequestBuilders.get("/venuiti/farms/reports/plantation/Farm10"))
				.andExpect(MockMvcResultMatchers.status().isNoContent())
				.andExpect(MockMvcResultMatchers.content().string("No Data Found"));
	}

}
