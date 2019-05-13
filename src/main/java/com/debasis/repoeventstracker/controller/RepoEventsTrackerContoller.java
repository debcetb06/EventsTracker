package com.debasis.repoeventstracker.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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


/**
 * <p>This RepoEventsTrackerContoller API provides the details of events from the repositories</p>
 * @author Debasis Panda
 *
 */
@RestController
@RequestMapping("api/v1")
@Validated
public class RepoEventsTrackerContoller {

	@Autowired
	private RepoEventsService repoEventsService;

	private static final Logger LOGGER = LogManager.getLogger(RepoEventsTrackerContoller.class);

	/**
	 * <p>events API method is used to provide the details events happened.
	 * @param owner - owner name will be validated as part of request parameter or else 400 bad request will be thrown
	 * @param repo  - repo name will be validated as part of request parameter or else 400 bad request will be thrown
	 * @param eventType - eventType parameter will be used as part of filter criteria to to filter the events
	 * @return list of events if status is 200,
	 *                                        or else provide 400, 500 , 404 based on exception.
	 */
	@GetMapping(value = "/events")
	public ResponseEntity<List<Event>> events(
								@Valid @NotBlank @RequestParam(name = "owner", required = true) String owner,
								@Valid @NotBlank @RequestParam(name = "repo", required = true) String repo,
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
		} 
		/*Below exception will be catched by Global exception handler <class>ExceptionHandlerControllerAdvice</class> and Rest service response will be 404, resource not found*/
		catch (ResourceNotFoundException rs) {
			LOGGER.error("Resource not found", rs);
			throw rs;
		} 
		/*Below exception will be catched by Global exception handler <class>ExceptionHandlerControllerAdvice</class> and Rest service response will be 500, Internal server occurred*/
		catch (SystemException se) {
			LOGGER.error("System error occured", se);
			throw se;
		} 
		/*Below exception will be catched by Global exception handler <class>ExceptionHandlerControllerAdvice</class> and Rest service response will be 500, Internal server occurred*/
		catch (Throwable th) {
			LOGGER.error("System error occured", th);
			throw new SystemException("System error occured", th);
		}

		return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	}

	/**
	 * <p>eventTypes</p> will provide event types
	 * @return list of event Types
	 */
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
