package com.qa.rp.domain;

public enum CauseOfDeath {
	GOBLIN ("Level 1 Goblin"),
	ROCKS ("Rocks fell"),
	FRIENDLYFIRE ("Friendly fire");
	
	private final String description;
	
	CauseOfDeath(String description) {
	this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
