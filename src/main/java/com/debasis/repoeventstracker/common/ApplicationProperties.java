package com.debasis.eventstracker.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>This is common place to get all the properties in the application</p>
 * @author Debasis Panda
 *
 */
@Component
public final class ApplicationProperties {

	@Value("${app.repoendpoint}") 
	private String apiEndpoint;

	public String getApiEndpoint() {
		return apiEndpoint;
	}

	public void setApiEndpoint(String apiEndpoint) {
		this.apiEndpoint = apiEndpoint;
	}
}
