package com.debasis.repoeventstracker.dao;

import java.util.List;

import com.debasis.repoeventstracker.exception.ServiceException;
import com.debasis.repoeventstracker.model.EventType;


public interface RepoEventsDAO {

	public List<EventType> getEventTypes() throws ServiceException;
}
