package com.debasis.repoeventstracker.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.debasis.repoeventstracker.constant.Constants;
import com.debasis.repoeventstracker.dao.RepoEventsDAO;
import com.debasis.repoeventstracker.exception.ServiceException;

@Repository
public class RepoEventsDAOImpl implements RepoEventsDAO {

	@Override
	public List<String> getEventTypes() throws ServiceException {
		// TODO Auto-generated method stub
		return Arrays.asList(Constants.EVENT_TYPES);
	}

}
