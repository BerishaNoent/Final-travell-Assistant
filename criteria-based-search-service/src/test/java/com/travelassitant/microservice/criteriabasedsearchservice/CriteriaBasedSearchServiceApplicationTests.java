package com.travelassitant.microservice.criteriabasedsearchservice;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travelassitant.microservice.criteriabasedsearchservice.Daos.AirportDAO;
import com.travelassitant.microservice.criteriabasedsearchservice.bean.CarRental;
import com.travelassitant.microservice.criteriabasedsearchservice.bean.Country;
import com.travelassitant.microservice.criteriabasedsearchservice.bean.Itinerary;
import com.travelassitant.microservice.criteriabasedsearchservice.bean.Search;
import com.travelassitant.microservice.criteriabasedsearchservice.config.JwtService;
import com.travelassitant.microservice.criteriabasedsearchservice.pubsub.PubSubService;
import com.travelassitant.microservice.criteriabasedsearchservice.request.RequestBodytemp;
import com.travelassitant.microservice.criteriabasedsearchservice.services.fetchDataService;

@SpringBootTest
@AutoConfigureMockMvc
class CriteriaBasedSearchServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private fetchDataService apiService;

	@MockBean
	private PubSubService pubSubService;

	@MockBean
	private AirportDAO airportDAO;

	@MockBean
	@Qualifier("carRentalResultInputChannel")
	private PollableChannel carRentalResultInputChannel;

	@MockBean
	@Qualifier("flightSaveResultInputChannel")
	private PollableChannel flightSaveResultInputChannel;

	private UserDetails createUser(String username, String password, String... authorities) {
		return User.withDefaultPasswordEncoder()
				.username(username)
				.password(password)
				.authorities(authorities)
				.build();
	}

	private String createToken(UserDetails userDetails) {
		return jwtService.generateToken(userDetails);
	}

	@Test
	public void testPublishMessage() throws Exception {
		CarRental newCarRental = new CarRental();
		newCarRental.setId("1");

		when(pubSubService.publishCarRental(any(CarRental.class))).thenReturn(null);

		Message resultMessage = new GenericMessage<>("Car rental saved");

		when(carRentalResultInputChannel.receive()).thenReturn(resultMessage);

		UserDetails userDetails = createUser("user", "password", "ADMIN");

		String jwt = createToken(userDetails);

		mockMvc.perform(post("/publish")
				.header("Authorization", "Bearer " + jwt)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(newCarRental)))
				.andExpect(status().isOk());

	}

	@Test
	public void testAggregateData() throws Exception {
		RequestBodytemp requestBodytemp = new RequestBodytemp();
		requestBodytemp.setOrigin("origin");

		List<CarRental> carRentals = new ArrayList<>();

		when(apiService.CarRentals(requestBodytemp)).thenReturn(carRentals);

		UserDetails userDetails = createUser("user", "password", "ADMIN");

		String jwt = createToken(userDetails);

		mockMvc.perform(post("/aggregateData")
				.header("Authorization", "Bearer " + jwt)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(requestBodytemp)))
				.andExpect(status().isNotFound());
	}

	@Test
	public void testGetAirports() throws Exception {
		List<Country> countries = new ArrayList<>();
		Country country = new Country();
		country.setId("1");
		country.setName("Test Country");
		countries.add(country);

		when(airportDAO.getAllAirports()).thenReturn(countries);

		UserDetails userDetails = createUser("user", "password", "ADMIN");

		String jwt = createToken(userDetails);

		mockMvc.perform(get("/getAirports")
				.header("Authorization", "Bearer " + jwt))
				.andExpect(status().isOk())
				.andExpect(content().string(objectMapper.writeValueAsString(countries)));
	}

	@Test
	public void testPublishRecentSearch() throws Exception {
		Search search = new Search();
		search.setId("Test Id");

		when(pubSubService.publishRecentSearch(any(Search.class))).thenReturn("Published successfully");

		UserDetails userDetails = createUser("user", "password", "ADMIN");

		String jwt = createToken(userDetails);

		mockMvc.perform(post("/publish")
				.header("Authorization", "Bearer " + jwt)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(search)))
				.andExpect(status().isOk())
				.andExpect(content().string("Published successfully"));
	}

	@Test
	public void testPublishFlight() throws Exception {
		Itinerary itinerary = new Itinerary();
		itinerary.setId("test ID");

		when(pubSubService.publishFlight(any(Itinerary.class))).thenReturn(null);

		Message resultMessage = new GenericMessage<>("Failed to save itinerary");


		when(flightSaveResultInputChannel.receive()).thenReturn(resultMessage);


		UserDetails userDetails = createUser("user", "password", "ADMIN");


		String jwt = createToken(userDetails);

		mockMvc.perform(post("/publish")
				.header("Authorization", "Bearer " + jwt)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(itinerary)));

	}

}