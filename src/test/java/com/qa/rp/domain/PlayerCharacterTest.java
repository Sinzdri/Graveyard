package com.qa.rp.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerCharacterTest {
//Just testing constructors
	@Test 
	void playercharacternoargs() {
		PlayerCharacter character = new PlayerCharacter();
		assertTrue(character instanceof PlayerCharacter);
		assertTrue(character.getCharactername() == null);
	}
	@Test
	void playercharacternoid() {
		PlayerCharacter character = new PlayerCharacter("Bilston", "Chris", CharacterClass.CLERIC, CharacterRace.GNOME, 4, CauseOfDeath.GOBLIN);
		assertTrue(character instanceof PlayerCharacter);
		assertTrue(character.getId() == null);
	}
	@Test
	void playercharacterid() {
		PlayerCharacter character = new PlayerCharacter(1, "Bilston", "Chris", CharacterClass.CLERIC, CharacterRace.GNOME, 4, CauseOfDeath.GOBLIN);
		assertTrue(character instanceof PlayerCharacter);
		assertTrue(character.getId() == 1);
	}
}
