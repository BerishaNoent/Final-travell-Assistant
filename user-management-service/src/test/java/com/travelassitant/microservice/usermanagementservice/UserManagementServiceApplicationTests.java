package com.travelassitant.microservice.usermanagementservice;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;

import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.Arrays;
import java.util.List;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.travelassitant.microservice.usermanagementservice.DAOs.CarRentalDAO;
import com.travelassitant.microservice.usermanagementservice.DAOs.ContactUsDAO;
import com.travelassitant.microservice.usermanagementservice.DAOs.FlightDAO;
import com.travelassitant.microservice.usermanagementservice.DAOs.HotelDAO;
import com.travelassitant.microservice.usermanagementservice.DAOs.RecentSearchDao;
import com.travelassitant.microservice.usermanagementservice.DAOs.UserDAO;
import com.travelassitant.microservice.usermanagementservice.Services.MailService;
import com.travelassitant.microservice.usermanagementservice.bean.Country;
import com.travelassitant.microservice.usermanagementservice.bean.Itinerary;
import com.travelassitant.microservice.usermanagementservice.config.JwtService;
import com.travelassitant.microservice.usermanagementservice.dbRepositories.ContactUsRepository;
import com.travelassitant.microservice.usermanagementservice.dbRepositories.UserRepository;
import com.travelassitant.microservice.usermanagementservice.pubsub.PubSubService;
import static org.hamcrest.Matchers.containsString;


@SpringBootTest
@AutoConfigureMockMvc
class UserManagementServiceApplicationTests {

	@Mock
    private MongoTemplate mongoTemplate;

    @MockBean
    private ContactUsDAO contactUsDAO;

	@Mock
    private ContactUsRepository contactUsRepository;
	@Mock
	private UserRepository userRepository;
	@MockBean
	private FlightDAO flightDao;

	@MockBean
	private RecentSearchDao recentSearchDao;

	@MockBean
	private HotelDAO hotelDao;

	@MockBean
	private CarRentalDAO carRentalDao;
  
	@MockBean
    private UserDAO userDao;

	@Autowired
    private MockMvc mockMvc;

	@MockBean
	private MailService mailService;

	@Autowired
    private ObjectMapper objectMapper;

	@Autowired
	private JwtService jwtService;

    @MockBean
    private PubSubService pubSubService;

    @MockBean
	@Qualifier("airportSaveResultInputChannel")
    private PollableChannel airportSaveResultInputChannel;

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
public void testPublishMessageToAirportService() throws Exception {
    // Create a Country object
    Country newCountry = new Country();
    newCountry.setId("1");
    newCountry.setName("Test Country");
    

    // Mock the pubSubService.publishMessageToAirportService method
    doNothing().when(pubSubService).publishMessageToAirportService(any(Country.class));

    // Create a Message object
    Message resultMessage = new GenericMessage<>("Failed to save country");

    // Mock the airportSaveResultInputChannel.receive method to return the Message object
    when(airportSaveResultInputChannel.receive()).thenReturn(resultMessage);

    // Create a user
    UserDetails userDetails = createUser("user", "password", "ADMIN");

    // Create a JWT
    String jwt = createToken(userDetails);

    // Perform a POST request to /publishAirport
    mockMvc.perform(post("/publishAirport")
        .header("Authorization", "Bearer " + jwt)
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(newCountry)))
        .andExpect(status().isOk());
}

@Test
public void testRemoveAirport() throws Exception {
    // Mock the pubSubService.publishRemoveAirportMessage method
    doNothing().when(pubSubService).publishRemoveAirportMessage(anyString());

    // Create a Message object for a successful removal
    Message successMessage = new GenericMessage<>("Airport was successfully removed.");

    // Mock the airportSaveResultInputChannel.receive method to return the success message
    when(airportSaveResultInputChannel.receive()).thenReturn(successMessage);

    // Create a user
    UserDetails userDetails = createUser("user", "password", "ADMIN");

    // Create a JWT
    String jwt = createToken(userDetails);

    // Perform a DELETE request to /removeAirport/{iataCode} and expect a 200 OK status
    mockMvc.perform(delete("/removeAirport/{iataCode}", "TEST")
        .header("Authorization", "Bearer " + jwt))
        .andExpect(status().isOk())
        .andExpect(content().string("Airport was successfully removed."));

    // Create a Message object for a failed removal
    Message failureMessage = new GenericMessage<>("Failed to remove airport");

    // Mock the airportSaveResultInputChannel.receive method to return the failure message
    when(airportSaveResultInputChannel.receive()).thenReturn(failureMessage);

    // Perform a DELETE request to /removeAirport/{iataCode} and expect a 500 Internal Server Error status
    mockMvc.perform(delete("/removeAirport/{iataCode}", "TEST")
        .header("Authorization", "Bearer " + jwt))
        .andExpect(status().isInternalServerError())
        .andExpect(content().string("Failed to remove airport"));
}

@Test
public void testMailerMethod() throws Exception {
    // Mock the mailService.sendSimpleMessage method
    doNothing().when(mailService).sendSimpleMessage(anyString(), anyString(), anyString());

    // Create a user
    UserDetails userDetails = createUser("user", "password", "ADMIN");

    // Create a JWT
    String jwt = createToken(userDetails);

    // Perform a POST request to /sendMail
    mockMvc.perform(post("/sendMail")
        .header("Authorization", "Bearer " + jwt)
        .param("email", "test@example.com")
        .param("text", "Test message"))
        .andExpect(status().isOk());
}

// @Test
// public void testFindAll() throws Exception {
//     setup();

// 	List<ContactUs> returnedContactUsList = contactUsDAO.findAll();

//     // Verify the results
//     assertEquals(contactUsList.size(), returnedContactUsList.size());

    
// }

@Test
public void testDeleteAllCarRentals() throws Exception {
    when(userDao.deleteAllCarRentals()).thenReturn(true);

    // Create a user
    UserDetails userDetails = createUser("user", "password", "ADMIN");

    // Create a JWT
    String jwt = createToken(userDetails);

    mockMvc.perform(delete("/carRentals")
        .header("Authorization", "Bearer " + jwt))
        .andExpect(status().isNoContent());

    Mockito.verify(userDao).deleteAllCarRentals();
}

@Test
public void testDeleteMessage() throws Exception {
    String id = "123";
    doNothing().when(contactUsDAO).deleteById(id);

    // Create a user
    UserDetails userDetails = createUser("user", "password", "ADMIN");

    // Create a JWT
    String jwt = createToken(userDetails);

    mockMvc.perform(delete("/contactus/{id}", id)
        .header("Authorization", "Bearer " + jwt))
        .andExpect(status().isOk());

    Mockito.verify(contactUsDAO).deleteById(id);
}

@Test
public void testDeleteMessageFailure() throws Exception {
    String id = "123";
    doThrow(new RuntimeException("Test exception")).when(contactUsDAO).deleteById(id);

    // Create a user
    UserDetails userDetails = createUser("user", "password", "ADMIN");

    // Create a JWT
    String jwt = createToken(userDetails);

    mockMvc.perform(delete("/contactus/{id}", id)
        .header("Authorization", "Bearer " + jwt))
        .andExpect(status().isInternalServerError())
        .andExpect(content().string(containsString("An error occurred: Test exception")));

    Mockito.verify(contactUsDAO).deleteById(id);
}


@Test
public void testGetAllFlights() throws Exception {
    when(flightDao.findAll()).thenReturn(Arrays.asList(new Itinerary(), new Itinerary()));

    // Create a user
    UserDetails userDetails = createUser("user", "password", "ADMIN");

    // Create a JWT
    String jwt = createToken(userDetails);

    mockMvc.perform(get("/flights")
        .header("Authorization", "Bearer " + jwt))
        .andExpect(status().isOk());

    Mockito.verify(flightDao).findAll();
}

// @Test
// public void testGetUser() throws Exception {
// 	com.travelassitant.microservice.usermanagementservice.bean.User testUser = new com.travelassitant.microservice.usermanagementservice.bean.User("1"); // Assuming User class has a constructor that takes an id
//     when(userDao.findOne("1")).thenReturn(testUser); // Changed this line

//     // Create a user
//     UserDetails userDetails = createUser("user", "password", "ADMIN");

//     // Create a JWT
//     String jwt = createToken(userDetails);

//     mockMvc.perform(get("/users/1")
//         .header("Authorization", "Bearer " + jwt))
//         .andExpect(status().isOk());

//     Mockito.verify(userDao).findOne("1");
// }

@Test
public void testDeleteUser() throws Exception {
    when(userDao.delete("1")).thenReturn(true);

    // Create a user
    UserDetails userDetails = createUser("user", "password", "ADMIN");

    // Create a JWT
    String jwt = createToken(userDetails);

    mockMvc.perform(delete("/users/1")
        .header("Authorization", "Bearer " + jwt))
        .andExpect(status().isNoContent());

    Mockito.verify(userDao).delete("1");
}
// @Test
// public void testGetFlights() throws Exception {
//     String id = "123";
//     List<Itinerary> flights = new ArrayList<>();
//     flights.add(new Itinerary());
//     when(userDao.findBookedFlights(id)).thenReturn(flights);

//     mockMvc.perform(get("/users/{id}/flights", id))
//         .andExpect(status().isOk())
//         .andExpect(jsonPath("$", hasSize(1)));

//     Mockito.verify(userDao).findBookedFlights(id);
// }

// @Test
// public void testChangeUsername() throws Exception {
//     // Create a user
//     UserDetails userDetails = createUser("user", "password", "ADMIN");

//     // Create a JWT
//     String jwt = createToken(userDetails);
    
//     ChangeUsernameRequest request = new ChangeUsernameRequest("oldUsername", "newUsername");
//     com.travelassitant.microservice.usermanagementservice.bean.User user = new com.travelassitant.microservice.usermanagementservice.bean.User();
//     user.setUsername("oldUsername");

//     // Mock the userRepository to return the user when the old username is found and the new username is not taken
//     when(userRepository.findByUsername(request.getOldUsername())).thenReturn(Optional.of(user));
//     when(userRepository.findByUsername(request.getNewUsername())).thenReturn(Optional.empty());

//     // Mock the userDao to call the real changeUsername method
//     when(userDao.changeUsername(request.getOldUsername(), request.getNewUsername())).thenCallRealMethod();

//     mockMvc.perform(put("/users/username")
//     .header("Authorization", "Bearer " + jwt)
//     .contentType(MediaType.APPLICATION_JSON)
//     .content(objectMapper.writeValueAsString(request)))
//     .andExpect(status().isOk())
//     ;

//     Mockito.verify(userRepository).save(any(com.travelassitant.microservice.usermanagementservice.bean.User.class));
// }

@Test
public void testGetMostSearchedDestinations() throws Exception {
	List<String> destinations = Arrays.asList("Paris", "London", "New York");
	when(recentSearchDao.getMostSearchedDestinations()).thenReturn(destinations);

	UserDetails userDetails = createUser("user", "password", "ADMIN");

    // Create a JWT
    String jwt = createToken(userDetails);

	mockMvc.perform(get("/searches/top-destinations")
	.header("Authorization", "Bearer " + jwt))
		.andExpect(status().isOk());

	Mockito.verify(recentSearchDao).getMostSearchedDestinations();
	Mockito.verify(recentSearchDao).getMostSearchedDestinations();
    Mockito.verify(recentSearchDao).getMostSearchedDestinations();
}
@Test
public void testGetNumberOfCarRentals() throws Exception {
    long count = 10L;
    when(carRentalDao.getNumberOfCarRentals()).thenReturn(count);

	UserDetails userDetails = createUser("user", "password", "ADMIN");

    // Create a JWT
    String jwt = createToken(userDetails);

    mockMvc.perform(get("/car-rentals/count")
	.header("Authorization", "Bearer " + jwt))
        .andExpect(status().isOk());

    Mockito.verify(carRentalDao).getNumberOfCarRentals();
}

@Test
public void testGetNumberOfHotels() throws Exception {
    long count = 20L;
    when(hotelDao.getNumberOfHotels()).thenReturn(count);

	UserDetails userDetails = createUser("user", "password", "ADMIN");

    // Create a JWT
    String jwt = createToken(userDetails);

    mockMvc.perform(get("/hotels/count")
	.header("Authorization", "Bearer " + jwt))
        .andExpect(status().isOk())
		.andExpect(content().string(String.valueOf(count)));

    Mockito.verify(hotelDao).getNumberOfHotels();
}

@Test
public void testGetNumberOfFlights() throws Exception {
    long count = 30L;
    when(flightDao.getNumberOfFlights()).thenReturn(count);

	UserDetails userDetails = createUser("user", "password", "ADMIN");

    // Create a JWT
    String jwt = createToken(userDetails);

    mockMvc.perform(get("/flights/count")
	.header("Authorization", "Bearer " + jwt))
        .andExpect(status().isOk())
        .andExpect(content().string(String.valueOf(count)));

    Mockito.verify(flightDao).getNumberOfFlights();
}

    }
