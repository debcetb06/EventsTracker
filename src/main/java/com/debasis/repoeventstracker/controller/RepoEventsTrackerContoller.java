package com.debasis.repoeventstracker.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.debasis.repoeventstracker.exception.SystemException;
import com.debasis.repoeventstracker.model.Event;
import com.debasis.repoeventstracker.model.EventCriteria;
import com.debasis.repoeventstracker.service.RepoEventsService;

@RestController
@RequestMapping("api/v1")
public class RepoEventsTrackerContoller {

	@Autowired
	private RepoEventsService repoEventsService;

	private static final Logger LOGGER = LogManager.getLogger(RepoEventsTrackerContoller.class);

	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public ResponseEntity<List<Event>> events() {
		List<Event> events = null;
		try {
			//To Do  - Below hard coding will be removed
			EventCriteria eventCriteria = new EventCriteria();
			eventCriteria.setOwnerName("debcetb06");
			eventCriteria.setRepo("RepoEventTracker");
			events = repoEventsService.getRepoEvents(eventCriteria);
		} catch (SystemException se) {
            LOGGER.error("System error occured", se);
            throw se;
		}
		catch(Throwable th){
			LOGGER.error("System error occured", th);
            throw new SystemException("System error occured", th);
		}

		return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/eventTypes", method = RequestMethod.GET)
	public ResponseEntity<List<String>> eventTypes() {
		try {
			return new ResponseEntity<List<String>>(repoEventsService.getRepoEventTypes(), HttpStatus.OK);
		} catch (SystemException se) {
            LOGGER.error("System error occured", se);
            throw se;
		}
		catch(Throwable th){
			LOGGER.error("System error occured", th);
            throw new SystemException("System error occured", th);
		}

		
	}

}
