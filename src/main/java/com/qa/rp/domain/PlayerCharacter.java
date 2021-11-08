package com.qa.rp.domain;

public class PlayerCharacter {
	private Integer id;
	
	private String charactername;
	private String playername;
	private String characterclass;
	private int characterlevel;
	private String causeofdeath;
	
	public PlayerCharacter(Integer id, String charactername, String playername, String characterclass,
			int characterlevel, String causeofdeath) {
		this.id = id;
		this.charactername = charactername;
		this.playername = playername;
		this.characterclass = characterclass;
		this.characterlevel = characterlevel;
		this.causeofdeath = causeofdeath;
	}
	
	
}
