package com.debasis.repoeventstracker.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.debasis.repoeventstracker.common.UriBuilder;
import com.debasis.repoeventstracker.controller.RepoEventsTrackerContoller;
import com.debasis.repoeventstracker.dao.RepoEventsDAO;
import com.debasis.repoeventstracker.exception.ResourceNotFoundException;
import com.debasis.repoeventstracker.exception.SystemException;
import com.debasis.repoeventstracker.model.Event;
import com.debasis.repoeventstracker.model.EventCriteria;
import com.debasis.repoeventstracker.model.EventType;
import com.debasis.repoeventstracker.service.RepoEventsService;

/**
 * <p>
 * class GithubRepoEventTrackerImpl is implementation of getting events from
 * GitHub Repositories
 * </p>
 * 
 * @author Debasis Panda
 *
 */
@Service("repoEventsService")
public class GithubRepoEventsServiceImpl implements RepoEventsService {
	
	private static final Logger LOGGER = LogManager.getLogger(RepoEventsTrackerContoller.class);

	@Autowired
	private UriBuilder uriBuilder;

	@Autowired
	RepoEventsDAO repoEventsDAO;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Event> getRepoEvents(EventCriteria eventCriteria) throws SystemException {
		List<Event> eventsList = null;
		try {
			ResponseEntity<List<Event>> events = null;
			events = restTemplate.exchange(uriBuilder.getRepoEventsURI(eventCriteria), HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Event>>() {
					});
			eventsList = events.getBody();
		} catch (HttpClientErrorException e) {
			if (e.getRawStatusCode() == 404) {
				LOGGER.error("Repo Events are not avaiable", e);
				throw new ResourceNotFoundException("Resource Not found");
			}
		}

		return eventsList;
	}

	@Override
	public List<EventType> getRepoEventTypes() throws SystemException {
		return repoEventsDAO.getEventTypes();
	}

}
