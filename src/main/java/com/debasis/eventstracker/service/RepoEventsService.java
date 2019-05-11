package com.debasis.eventstracker.service;

import java.util.List;

import com.debasis.eventstracker.exception.SystemException;
import com.debasis.eventstracker.model.Event;
import com.debasis.eventstracker.model.EventCriteria;

/**
 * <p>This interfaces provides the contact for getting event details from Code repositories</p>
 * @author Debasis Panda
 *
 */
public interface RepoEventsService {

	public List<Event> getRepoEvents(EventCriteria eventCriteria)throws SystemException;
	
	public List<String> getRepoEventTypes() throws SystemException;
}
