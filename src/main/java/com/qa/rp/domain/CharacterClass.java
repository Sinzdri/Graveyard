package com.qa.rp.domain;

public enum CharacterClass {
	BARBARIAN ("Barbarian"),
	BARD ("Bard"),
	CLERIC ("Cleric"),
	DRUID ("Druid"),
	FIGHTER ("Fighter"),
	MONK ("Monk"),
	PALADIN ("Paladin"),
	RANGER ("Ranger"),
	ROGUE ("Rogue"),
	SORCERER ("Sorcerer"),
	WARLOCK ("Warlock"),
	WIZARD ("Wizard");
	
	private final String name;
	
	CharacterClass(String name) {
	this.name = name;
	}

	public String getName() {
		return name;
	}
}
