package com.qa.rp.domain;

public enum CharacterRace {
	DRAGONBORN ("Dragonborn"),
	DWARF ("Dwarf"),
	ELF ("Elf"),
	GNOME ("Gnome"),
	HALFELF ("Half-Elf"),
	HALFORC ("Half-Orc"),
	HALFLING ("Halfling"),
	HUMAN ("Human"),
	TIEFLING ("Tiefling");
	
	private final String name;
	
	CharacterRace(String name) {
	this.name = name;
	}

	public String getName() {
		return name;
	}
}
