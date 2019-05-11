package com.debasis.eventstracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.debasis.eventstracker.common.UriBuilder;
import com.debasis.eventstracker.dao.RepoEventsDAO;
import com.debasis.eventstracker.exception.SystemException;
import com.debasis.eventstracker.model.Event;
import com.debasis.eventstracker.model.EventCriteria;
import com.debasis.eventstracker.service.RepoEventsService;

/**
 * <P> GithubRepoEventTrackerImpl is implementation of getting events from GitHub Repositories 
 * @author Debasis Panda
 *
 */
@Service ("repoEventsService")
public class GithubRepoEventsServiceImpl implements RepoEventsService {

	@Autowired
	private UriBuilder uriBuilder;
	
	@Autowired
	RepoEventsDAO repoEventsDAO;

	@Override
	public List<Event> getRepoEvents(EventCriteria eventCriteria) throws SystemException{

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Event>> events = restTemplate.exchange(uriBuilder.getRepoEventsURI(eventCriteria),
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Event>>() {
				});
		List<Event> eventsList = events.getBody();
		return eventsList;
	}
	
	@Override
	public List<String> getRepoEventTypes() throws SystemException{
		return repoEventsDAO.getEventTypes();
	}

}
