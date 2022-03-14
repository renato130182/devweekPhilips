package com.class_dio.devweek;

import com.class_dio.devweek.Controller.RegionController;
import com.class_dio.devweek.Entity.AgeGroup;
import com.class_dio.devweek.Entity.Incidence;
import com.class_dio.devweek.Entity.Region;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class DevweekApplicationTests {
	private final String URLRegion = "/api/regions";
	private final String URLAgeGroup = "/api/age-groups";
	private final String URLIncidence = "/api/incidences";
	@Autowired
	MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private RegionController regionController;

	//tests for Region
	@Test
	public void getControllerTest() throws Exception{
		mockMvc.perform(get(URLRegion)).andExpect(status().isOk());
	}
	@Test
	public void getControllerTestById()throws Exception{
		mockMvc.perform(get(URLRegion).
				param("id", "1")).
				andExpect(status().isOk());
	}

	@Test
	public void addNewRegion() throws Exception {
		Region newRegion = new Region(2L,"Test",10L);

		mockMvc.perform(post(URLRegion + "/add").
				contentType(MediaType.APPLICATION_JSON).
				content(asJsonString(newRegion)
				)).andExpect(status().isOk());
	}

	@Test
	public void deleteRegion() throws Exception{
		mockMvc.perform(delete(URLRegion + "/delete/2")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}
	//tests for age group
	@Test
	public void getControllerTestAgeGroup() throws Exception{
		mockMvc.perform(get(URLAgeGroup)).andExpect(status().isOk());
	}
	@Test
	public void getControllerTestByIdAgeGroup()throws Exception{
		mockMvc.perform(get(URLAgeGroup).
						param("id", "1")).
				andExpect(status().isOk());
	}

	@Test
	public void addNewAgeGroup() throws Exception {
		AgeGroup newAgeGroup = new AgeGroup(1L,2L,1L,"Test");

		mockMvc.perform(post(URLAgeGroup + "/add").
				contentType(MediaType.APPLICATION_JSON).
				content(asJsonString(newAgeGroup)
				)).andExpect(status().isOk());
	}

	@Test
	public void deleteAgeGroup() throws Exception{
		mockMvc.perform(delete(URLAgeGroup + "/delete/2")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	//tests incidences
	@Test
	public void getControllerTestIncidences() throws Exception{
		mockMvc.perform(get(URLIncidence)).andExpect(status().isOk());
	}
	@Test
	public void getControllerTestByIdIncidences()throws Exception{
		mockMvc.perform(get(URLIncidence).
						param("id", "1")).
				andExpect(status().isOk());
	}

	@Test
	public void addNewIncidences() throws Exception {
		Incidence newIncidence = new Incidence(1L,1L,1,1L,10);

		mockMvc.perform(post(URLIncidence + "/add").
				contentType(MediaType.APPLICATION_JSON).
				content(asJsonString(newIncidence)
				)).andExpect(status().isOk());
	}

	@Test
	public void deleteIncidences() throws Exception{
		mockMvc.perform(delete(URLIncidence + "/delete/2")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	//util
	@Test
	public static String asJsonString(final Object obj){
		try {
			return new ObjectMapper().writeValueAsString(obj);
		}catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}




}
