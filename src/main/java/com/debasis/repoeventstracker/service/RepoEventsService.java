package com.debasis.repoeventstracker.service;

import java.util.List;

import com.debasis.repoeventstracker.exception.SystemException;
import com.debasis.repoeventstracker.model.Event;
import com.debasis.repoeventstracker.model.EventCriteria;
import com.debasis.repoeventstracker.model.EventType;

/**
 * <p>This interfaces provides the contact for getting event details from Code repositories</p>
 * @author Debasis Panda
 *
 */
public interface RepoEventsService {

	public List<Event> getRepoEvents(EventCriteria eventCriteria)throws SystemException;
	
	public List<EventType> getRepoEventTypes() throws SystemException;
}
