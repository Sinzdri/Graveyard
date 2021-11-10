package com.qa.rp.domain;

public enum CauseOfDeath {
	FRIENDLYFIRE ("friendly fire"),
	ROCKS ("rocks falling, everyone died."),
	GOBLIN ("a level 1 Goblin");
	
	
	private final String description;
	
	CauseOfDeath(String description) {
	this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
