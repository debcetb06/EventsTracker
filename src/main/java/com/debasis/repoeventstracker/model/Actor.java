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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatarUrl == null) ? 0 : avatarUrl.hashCode());
		result = prime * result + ((displayLogin == null) ? 0 : displayLogin.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		if (avatarUrl == null) {
			if (other.avatarUrl != null)
				return false;
		} else if (!avatarUrl.equals(other.avatarUrl))
			return false;
		if (displayLogin == null) {
			if (other.displayLogin != null)
				return false;
		} else if (!displayLogin.equals(other.displayLogin))
			return false;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
}
