package com.qa.rp.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class PlayerCharacter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY) //lazy fetch avoids potential query issues
	@JoinColumn(name = "player_id")
	private PlayerCharacter playercharacter;
	
	private String charactername;
	@Enumerated(EnumType.STRING)
	private CharacterClass characterclass;
	@Enumerated(EnumType.STRING)
	private CharacterRace characterrace;
	private int characterlevel;
	@Enumerated(EnumType.STRING)
	private CauseOfDeath causeofdeath;
//	private String causeofdeathdetail;
	
	public PlayerCharacter(Integer id, String charactername, PlayerCharacter playercharacter, CharacterClass characterclass,
			CharacterRace characterrace, int characterlevel, CauseOfDeath causeofdeath) {
		this.id = id;
		this.charactername = charactername;
		this.playercharacter = playercharacter;
		this.characterclass = characterclass;
		this.characterrace = characterrace;
		this.characterlevel = characterlevel;
		this.causeofdeath = causeofdeath;
	}
	
	public PlayerCharacter(String charactername, PlayerCharacter playercharacter, CharacterClass characterclass,
			CharacterRace characterrace, int characterlevel, CauseOfDeath causeofdeath) {
		this.charactername = charactername;
		this.playercharacter = playercharacter;
		this.characterclass = characterclass;
		this.characterrace = characterrace;
		this.characterlevel = characterlevel;
		this.causeofdeath = causeofdeath;
	}
	
	public PlayerCharacter() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCharactername() {
		return charactername;
	}

	public void setCharactername(String charactername) {
		this.charactername = charactername;
	}


	public PlayerCharacter getPlayercharacter() {
		return playercharacter;
	}

	public void setPlayercharacter(PlayerCharacter playercharacter) {
		this.playercharacter = playercharacter;
	}

	public CharacterClass getCharacterclass() {
		return characterclass;
	}

	public void setCharacterclass(CharacterClass characterclass) {
		this.characterclass = characterclass;
	}

	public CharacterRace getCharacterrace() {
		return characterrace;
	}

	public void setCharacterrace(CharacterRace characterrace) {
		this.characterrace = characterrace;
	}

	public int getCharacterlevel() {
		return characterlevel;
	}

	public void setCharacterlevel(int characterlevel) {
		this.characterlevel = characterlevel;
	}

	public CauseOfDeath getCauseofdeath() {
		return causeofdeath;
	}

	public void setCauseofdeath(CauseOfDeath causeofdeath) {
		this.causeofdeath = causeofdeath;
	}
	
	
	
	
}
