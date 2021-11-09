package com.qa.rp.domain;

public enum CauseOfDeath {
	GOBLIN ("a level 1 Goblin"),
	ROCKS ("rocks falling, everyone died."),
	FRIENDLYFIRE ("friendly fire");
	
	private final String description;
	
	CauseOfDeath(String description) {
	this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
