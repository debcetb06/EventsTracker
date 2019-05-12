package com.debasis.repoeventstracker.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.debasis.repoeventstracker.exception.ResourceNotFoundException;
import com.debasis.repoeventstracker.exception.SystemException;
import com.debasis.repoeventstracker.model.Event;
import com.debasis.repoeventstracker.model.EventCriteria;
import com.debasis.repoeventstracker.model.EventType;
import com.debasis.repoeventstracker.service.RepoEventsService;

@RestController
@RequestMapping("api/v1")
public class RepoEventsTrackerContoller {

	@Autowired
	private RepoEventsService repoEventsService;

	private static final Logger LOGGER = LogManager.getLogger(RepoEventsTrackerContoller.class);

	@GetMapping(value = "/events")
	public ResponseEntity<List<Event>> events(@RequestParam(name = "owner", required = true) String owner,
			@RequestParam(name = "repo", required = true) String repo,
			@RequestParam(name = "eventType", required = false) String eventType) {
		List<Event> events = null;
		try {
			EventCriteria eventCriteria = new EventCriteria();
			eventCriteria.setOwnerName(owner);
			eventCriteria.setRepo(repo);
			if (eventType == null || eventType.isEmpty()) {
				events = repoEventsService.getRepoEvents(eventCriteria);
			} else {
				events = repoEventsService.getRepoEvents(eventCriteria).stream()
						.filter(event -> event.getType().equals(eventType)).collect(Collectors.toList());
			}
		} catch (ResourceNotFoundException rs) {
			LOGGER.error("Resource not found", rs);
			throw rs;
		} catch (SystemException se) {
			LOGGER.error("System error occured", se);
			throw se;
		} catch (Throwable th) {
			LOGGER.error("System error occured", th);
			throw new SystemException("System error occured", th);
		}

		return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	}

	@GetMapping(value = "/eventTypes")
	public ResponseEntity<List<EventType>> eventTypes() {
		try {
			return new ResponseEntity<List<EventType>>(repoEventsService.getRepoEventTypes(), HttpStatus.OK);
		} catch (SystemException se) {
			LOGGER.error("System error occured", se);
			throw se;
		} catch (Throwable th) {
			LOGGER.error("System error occured", th);
			throw new SystemException("System error occured", th);
		}

	}

}
