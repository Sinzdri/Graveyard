package com.qa.rp.service;


import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.rp.domain.CauseOfDeath;
import com.qa.rp.domain.CharacterClass;
import com.qa.rp.domain.CharacterRace;
import com.qa.rp.domain.PlayerCharacter;
import com.qa.rp.dto.PlayerCharacterDTO;
import com.qa.rp.repo.PlayerCharacterRepo;

@SpringBootTest
class PlayerCharacterServiceTest {
	@Autowired
	private PlayerCharacterService service;
	@MockBean
	private PlayerCharacterRepo repo;
	@MockBean
	private ModelMapper mapper;
	private List<PlayerCharacter> playercharacterList;
	private PlayerCharacter testCharacter;
	private PlayerCharacter testCharacterWithID;
	private PlayerCharacterDTO testcharacterDTO;
	private int id = 1;
	@BeforeEach
	void testSetup() {
		this.testCharacter = new PlayerCharacter("Bilston", "Chris", CharacterClass.CLERIC, CharacterRace.GNOME, 4, CauseOfDeath.GOBLIN);
		this.testCharacterWithID = new PlayerCharacter(1, "Bilston", "Chris", CharacterClass.CLERIC, CharacterRace.GNOME, 4, CauseOfDeath.GOBLIN);
		this.testcharacterDTO = new ModelMapper().map(testCharacterWithID, PlayerCharacterDTO.class);
		
		
		this.playercharacterList = new ArrayList<>();
	}
	
	@Test
	void testCreate() {
		PlayerCharacterDTO create = new PlayerCharacterDTO(null, "Bilston", "Chris", CharacterClass.CLERIC, CharacterRace.GNOME, 4, CauseOfDeath.GOBLIN);
		
		when(this.mapper.map(create, PlayerCharacter.class)).thenReturn(testCharacter);
		when(this.repo.save(testCharacter)).thenReturn(testCharacterWithID);
		when(this.mapper.map(testCharacterWithID, PlayerCharacterDTO.class)).thenReturn(testcharacterDTO);
		
		Assertions.assertEquals(this.testcharacterDTO,this.service.addCharacter(create));	//verify that mocked add character is as expected

		verify(this.repo, times(1)).save(this.testCharacter);	//verify that only ran method once
		
	}
	
//	@Test
//	void testDelete() {
//		when(this.repo.existsById(id)).thenReturn(true, false);
//		assertThat(this.service.deleteCharacter(id)).isTrue();
//		verify(this.repo, times(1)).deleteById(id);
//		verify(this.repo, times(2)).existsById(id);
//	}

	
	//todo other tests

	
}
