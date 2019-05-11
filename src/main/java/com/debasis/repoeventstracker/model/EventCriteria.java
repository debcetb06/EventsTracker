package com.debasis.repoeventstracker.model;

public class EventCriteria {

	private String ownerName;
	private String repo;
	private String eventType;

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getRepo() {
		return repo;
	}

	public void setRepo(String repo) {
		this.repo = repo;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
}
