package com.debasis.eventstracker.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.debasis.eventstracker.constant.Constants;
import com.debasis.eventstracker.model.EventCriteria;

/**
 *<P>This class is used to build the repo events URI 
 * @author Debasis Panda
 *
 */
@Component
public class UriBuilder {

	@Autowired
	private ApplicationProperties app;

	public String getRepoEventsURI(EventCriteria eventCriteria) {
		return new StringBuilder(app.getApiEndpoint())
				         .append(eventCriteria.getOwnerName())
				         .append("/")
				         .append(eventCriteria.getRepo())
				         .append("/")
				         .append(Constants.EVENTS).toString();
	}
}
