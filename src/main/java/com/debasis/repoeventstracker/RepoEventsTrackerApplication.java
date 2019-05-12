package com.debasis.repoeventstracker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAspectJAutoProxy
public class RepoEventsTrackerApplication {

	public static void main(String[] args) {
		final Logger LOGGER = LogManager.getLogger(RepoEventsTrackerApplication.class);
		SpringApplication.run(RepoEventsTrackerApplication.class, args);
		LOGGER.info("RepoEventsTrackerApplication Started Successfuly...");
	}
	
	 @Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }

}
