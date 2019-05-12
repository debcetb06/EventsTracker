package com.debasis.repoeventstracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Actor {
	
	private long id;
	private String login;
	@JsonProperty("display_login")
	private String displayLogin;
	@JsonProperty("avatar_url")
	private String avatarUrl;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getDisplayLogin() {
		return displayLogin;
	}
	public void setDisplayLogin(String displayLogin) {
		this.displayLogin = displayLogin;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
}
