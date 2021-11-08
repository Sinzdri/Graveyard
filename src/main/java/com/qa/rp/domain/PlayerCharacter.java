package com.qa.rp.domain;

public class PlayerCharacter {
	private Integer id;
	
	private String charactername;
	private String playername;
	private CharacterClass characterclass;
	private CharacterRace characterrace;
	private int characterlevel;
	private CauseOfDeath causeofdeath;
//	private String causeofdeathdetail;
	
	public PlayerCharacter(Integer id, String charactername, String playername, CharacterClass characterclass,
			CharacterRace characterrace, int characterlevel, String causeofdeath) {
		this.id = id;
		this.charactername = charactername;
		this.playername = playername;
		this.characterclass = characterclass;
		this.characterrace = characterrace;
		this.characterlevel = characterlevel;
		this.causeofdeath = causeofdeath;
	}
	
	
	
	
}
