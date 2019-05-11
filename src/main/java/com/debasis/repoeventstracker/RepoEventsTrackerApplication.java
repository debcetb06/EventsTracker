package com.debasis.repoeventstracker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RepoEventsTrackerApplication {

	public static void main(String[] args) {
		final Logger LOGGER = LogManager.getLogger(RepoEventsTrackerApplication.class);
		SpringApplication.run(RepoEventsTrackerApplication.class, args);
		LOGGER.info("RepoEventsTrackerApplication Started Successfuly...");
	}

}
