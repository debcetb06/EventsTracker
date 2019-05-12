package com.debasis.repoeventstracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {

	private String id;
	private String type;
	private boolean isPublic;
	@JsonProperty("created_at")
	private String createdDate;
	private Actor actor;
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	
}
