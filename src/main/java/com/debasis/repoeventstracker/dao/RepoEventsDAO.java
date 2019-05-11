package com.debasis.repoeventstracker.dao;

import java.util.List;

import com.debasis.repoeventstracker.exception.ServiceException;


public interface RepoEventsDAO {

	public List<String> getEventTypes() throws ServiceException;
}
