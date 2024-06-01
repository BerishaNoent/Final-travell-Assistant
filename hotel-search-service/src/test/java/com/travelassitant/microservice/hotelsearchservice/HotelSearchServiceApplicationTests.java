package com.travelassitant.microservice.hotelsearchservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;

import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travelassitant.microservice.hotelsearchservice.bean.HotelInfo;
import com.travelassitant.microservice.hotelsearchservice.config.JwtService;
import com.travelassitant.microservice.hotelsearchservice.pubSub.PubSubService;
import com.travelassitant.microservice.hotelsearchservice.requests.RequestBodytemp;
import com.travelassitant.microservice.hotelsearchservice.services.fetchDataService;

@SpringBootTest
@AutoConfigureMockMvc
class HotelSearchServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private JwtService jwtService;

	@MockBean
	private fetchDataService apiService;

	@MockBean
	private PubSubService pubSubService;

	@MockBean
	@Qualifier("hotelResultInputChannel")
	private PollableChannel hotelResultInputChannel;

	private UserDetails createUser(String username, String password, String... roles) {
		return User.withDefaultPasswordEncoder()
				.username(username)
				.password(password)
				.roles(roles)
				.build();
	}

	private String createToken(UserDetails userDetails) {
		return jwtService.generateToken(userDetails);
	}

	@Test
	public void testPublishHotel() throws Exception {

		when(pubSubService.publishHotel(any(HotelInfo.class))).thenReturn(null);
		Message message = new GenericMessage<>("Hotel already saved");
		when(hotelResultInputChannel.receive()).thenReturn(message);

		HotelInfo hotelInfo = new HotelInfo();
		hotelInfo.setName("Test Hotel");
		hotelInfo.setCity("Test Location");

		UserDetails userDetails = createUser("user", "password", "USER");

		String jwt = createToken(userDetails);

		mockMvc.perform(post("/hotel/publishHotel")
				.header("Authorization", "Bearer " + jwt)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(hotelInfo)))
				.andExpect(status().isConflict());
	}

	@Test
	public void testGetHotels() throws Exception {

		List<HotelInfo> hotelInfoList = new ArrayList<>();
		HotelInfo hotelInfo = new HotelInfo();
		hotelInfo.setName("Test Hotel");
		hotelInfo.setCity("Test Location");

		hotelInfoList.add(hotelInfo);

		RequestBodytemp requestBodytemp = new RequestBodytemp();
		when(apiService.aggregateData(requestBodytemp)).thenReturn(hotelInfoList);

		UserDetails userDetails = createUser("user", "password", "USER");

		String jwt = createToken(userDetails);

		mockMvc.perform(post("/hotel/aggregateData")
				.header("Authorization", "Bearer " + jwt)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(requestBodytemp)))
				.andExpect(status().isOk())
				.andExpect(content().json(objectMapper.writeValueAsString(hotelInfoList)));

	}
}