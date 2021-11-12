package com.qa.rp.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.rp.domain.CauseOfDeath;
import com.qa.rp.domain.CharacterClass;
import com.qa.rp.domain.CharacterRace;
import com.qa.rp.domain.PlayerCharacter;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:character-schema.sql", "classpath:character-data.sql"}
				, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD) //runs test schema and data before each test to provide dataset for tests
@ActiveProfiles("test")

class CharacterIntegrationTest {
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;	//Use mapper to convert to and from JSON
	
	@Test
	void testCreate() throws Exception {
		PlayerCharacter requestBody = new PlayerCharacter("Allivandrell", "Andy", CharacterClass.ROGUE, CharacterRace.ELF, 3, CauseOfDeath.ROCKS);	//create test character
		String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody);	//convert test character to json
		
		RequestBuilder request = post("/pc/create").contentType(MediaType.APPLICATION_JSON).content(requestBodyAsJSON);	//assemble test request
		
		PlayerCharacter responseBody = requestBody;	//test response expected to be same as request character
		responseBody.setId(2);	//except need to manually set id to match expected id of 2 (due to existing test data at id 1)
		String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody); //convert response character to json
		
		ResultMatcher checkStatus = status().isCreated();	//expect 201 created status
		ResultMatcher checkBody = content().json(responseBodyAsJSON);	//assemble expected response character
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);	//perform test and check against expected results
	}
	
	@Test
	void testGetAll() throws Exception {
		RequestBuilder request = get("/pc/getAll");
		ResultMatcher checkStatus = status().isOk();
		PlayerCharacter expected = new PlayerCharacter(1, "Bilston", "Chris", CharacterClass.CLERIC, CharacterRace.GNOME, 4, CauseOfDeath.GOBLIN);
		List<PlayerCharacter> characters = List.of(expected);
		String responseBody = this.mapper.writeValueAsString(characters);
		ResultMatcher checkBody = content().json(responseBody);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetByID() throws Exception {
		RequestBuilder request = get("/pc/get/1");
		
		ResultMatcher checkStatus = status().isOk();
		PlayerCharacter expected = new PlayerCharacter(1, "Bilston", "Chris", CharacterClass.CLERIC, CharacterRace.GNOME, 4, CauseOfDeath.GOBLIN);
		String responseBody = this.mapper.writeValueAsString(expected);
		ResultMatcher checkBody = content().json(responseBody);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetByCharacterName() throws Exception {
		RequestBuilder request = get("/pc/get/bycharname/Bilston");
		
		ResultMatcher checkStatus = status().isOk();
		PlayerCharacter expected = new PlayerCharacter(1, "Bilston", "Chris", CharacterClass.CLERIC, CharacterRace.GNOME, 4, CauseOfDeath.GOBLIN);
		List<PlayerCharacter> characters = List.of(expected);
		String responseBody = this.mapper.writeValueAsString(characters);
		ResultMatcher checkBody = content().json(responseBody);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void ost() throws Exception {
		RequestBuilder request = get("/pc/get/byplayername/Chris");
		
		ResultMatcher checkStatus = status().isOk();
		PlayerCharacter expected = new PlayerCharacter(1, "Bilston", "Chris", CharacterClass.CLERIC, CharacterRace.GNOME, 4, CauseOfDeath.GOBLIN);
		List<PlayerCharacter> characters = List.of(expected);
		String responseBody = this.mapper.writeValueAsString(characters);
		ResultMatcher checkBody = content().json(responseBody);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetByCharacterRace() throws Exception {
		RequestBuilder request = get("/pc/get/bycharrace/gnome");
		
		ResultMatcher checkStatus = status().isOk();
		PlayerCharacter expected = new PlayerCharacter(1, "Bilston", "Chris", CharacterClass.CLERIC, CharacterRace.GNOME, 4, CauseOfDeath.GOBLIN);
		List<PlayerCharacter> characters = List.of(expected);
		String responseBody = this.mapper.writeValueAsString(characters);
		ResultMatcher checkBody = content().json(responseBody);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testReplace() throws Exception {
		PlayerCharacter requestBody = new PlayerCharacter("Piety", "Andy", CharacterClass.DRUID, CharacterRace.TIEFLING, 4, CauseOfDeath.FRIENDLYFIRE);
		String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody);
		
		RequestBuilder request = put("/pc/replace/1").contentType(MediaType.APPLICATION_JSON).content(requestBodyAsJSON);
		
		PlayerCharacter responseBody = new PlayerCharacter(1, "Piety", "Andy", CharacterClass.DRUID, CharacterRace.TIEFLING, 4, CauseOfDeath.FRIENDLYFIRE);
		String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody);
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(responseBodyAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);	
	}
	
	@Test
	void testDelete() throws Exception {
		RequestBuilder request = delete("/pc/remove/1");
		
		ResultMatcher checkStatus = status().isNoContent();
		
		this.mvc.perform(request).andExpect(checkStatus);
	}
	
	@Test
	void testFailGet() throws Exception {
		this.mvc.perform(get("/pc/get/99999")).andExpect(status().isNotFound());	//test invalid get request for not found exception
	}
	
	@Test
	void testFailDelete() throws Exception {
		this.mvc.perform(delete("/pc/remove/99999")).andExpect(status().isNotFound());	//test invalid delete request for not found exception
	}
	
}
