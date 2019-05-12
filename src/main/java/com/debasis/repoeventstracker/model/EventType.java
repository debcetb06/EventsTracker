package com.debasis.repoeventstracker.model;

public class EventType {

	private long id;
	
	private String eventType;
	
	public EventType(long id, String eventType) {
		this.id= id;
		this.eventType = eventType;
	}

	public long getId() {
		return id;
	}


	public String getEventType() {
		return eventType;
	}

	
}
