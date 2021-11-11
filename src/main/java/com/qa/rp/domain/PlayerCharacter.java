package com.qa.rp.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerCharacter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
	private Integer id;
	
	private String charactername;
	private String playername;
	@Enumerated(EnumType.STRING)	//enumerated annotation ensures enums are handled correctly, chose to persist as string format.
	private CharacterClass characterclass;
	@Enumerated(EnumType.STRING)
	private CharacterRace characterrace;
	private int characterlevel;
	@Enumerated(EnumType.STRING)
	private CauseOfDeath causeofdeath;
//	private String causeofdeathdetail;
	
	public PlayerCharacter(String charactername, String playername, CharacterClass characterclass,
			CharacterRace characterrace, int characterlevel, CauseOfDeath causeofdeath) {
		this.charactername = charactername;
		this.playername = playername;
		this.characterclass = characterclass;
		this.characterrace = characterrace;
		this.characterlevel = characterlevel;
		this.causeofdeath = causeofdeath;
	}

}
