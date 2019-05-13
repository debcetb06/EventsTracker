package com.debasis.repoeventstracker.dao.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.debasis.repoeventstracker.constant.Constants;
import com.debasis.repoeventstracker.dao.RepoEventsDAO;
import com.debasis.repoeventstracker.exception.ServiceException;
import com.debasis.repoeventstracker.model.EventType;

@Repository
public class RepoEventsDAOImpl implements RepoEventsDAO {

	/**
	 * Event Types are hard coded now but once DB part is implemented this can be moved to DB.
	 */
	@Override
	public List<EventType> getEventTypes() throws ServiceException {
		List<EventType> eventTypes = Arrays.asList(Constants.EVENT_TYPES).stream().map(eventType -> new EventType(new Random().nextInt(), eventType))
				.collect(Collectors.toList());
		return eventTypes;

	}
}
