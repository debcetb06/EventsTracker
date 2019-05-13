package com.debasis.repoeventstracker;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.debasis.repoeventstracker.model.Event;
import com.debasis.repoeventstracker.model.EventType;
import com.debasis.repoeventstracker.service.RepoEventsService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class RepoEventsTrackerApplicationTests {

	
	
	@Autowired
	private MockMvc mvc;

	@MockBean
	private RepoEventsService mockRepservice;


	/**
	 * This test will test /api/v1/eventTypes test for Success scenario
	 * 
	 * @throws Exception
	 */
	@Test
	public void getAllEventTypes() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/v1/eventTypes").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	
	/**
	 * Below test case is use of mockito libaray to mock the RepoEventsService service
	 * @throws Exception
	 */
	@Test
	public void getEventTypes() throws Exception {
		EventType eventType = new EventType(1234, "CheckRunEvent");
		List<EventType> eventTypes = new ArrayList<>();
		eventTypes.add(eventType);
		
		Mockito.when(mockRepservice.getRepoEventTypes()).thenReturn(eventTypes);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/eventTypes")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();

		String expected = "[{\"id\":1234,\"eventType\":\"CheckRunEvent\"}]";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}	
	

	@Test
	public void getAllEventsWithoutParams() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/v1/events").contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.message", is("owner parameter is missing."))).andExpect(status().isBadRequest());
	}

	@Test
	public void getAllEventsWithoutRepoParam() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/v1/events").param("owner", "abcd")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.message", is("repo parameter is missing."))).andExpect(status().isBadRequest());
	}

	@Test
	public void getAllEventsWithParams() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/v1/events").param("owner", "debcetb06")
				.param("repo", "EventsTracker").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	/**
	 * Below test case is use of mockito library to mock the RepoEventsService service
	 * @throws Exception
	 */
	@Test
	public void getEvents() throws Exception {
		Event event = new Event();
		event.setId("12345");
		event.setType("pushEvent");
		List<Event> events = new ArrayList<>();
		events.add(event);
		
		Mockito.when(mockRepservice.getRepoEvents(Mockito.any())).thenReturn(events);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/events").param("owner", "debcetb06")
				.param("repo", "EventsTracker").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();

		String expected = "[{\"id\":\"12345\",\"type\":\"pushEvent\",\"actor\":null,\"public\":false,\"created_at\":null}]";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}	


}
