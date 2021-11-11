package com.qa.rp.dto;

import com.qa.rp.domain.CauseOfDeath;
import com.qa.rp.domain.CharacterClass;
import com.qa.rp.domain.CharacterRace;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class PlayerCharacterDTO {
	private Integer id;
	private String charactername;
	private String playername;
	private CharacterClass characterclass;
	private CharacterRace characterrace;
	private int characterlevel;
	private CauseOfDeath causeofdeath;

}
