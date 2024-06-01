package com.travelassitant.microservice.usermanagementservice.controllers;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelassitant.microservice.usermanagementservice.DAOs.CarRentalDAO;
import com.travelassitant.microservice.usermanagementservice.DAOs.ContactUsDAO;
import com.travelassitant.microservice.usermanagementservice.DAOs.FlightDAO;
import com.travelassitant.microservice.usermanagementservice.DAOs.HotelDAO;
import com.travelassitant.microservice.usermanagementservice.DAOs.RecentSearchDao;
import com.travelassitant.microservice.usermanagementservice.DAOs.UserDAO;
import com.travelassitant.microservice.usermanagementservice.Services.MailService;
import com.travelassitant.microservice.usermanagementservice.bean.CarRental;
import com.travelassitant.microservice.usermanagementservice.bean.ChangeUsernameRequest;
import com.travelassitant.microservice.usermanagementservice.bean.ContactUs;
import com.travelassitant.microservice.usermanagementservice.bean.Country;
import com.travelassitant.microservice.usermanagementservice.bean.HotelInfo;
import com.travelassitant.microservice.usermanagementservice.bean.Itinerary;
import com.travelassitant.microservice.usermanagementservice.bean.Search;
import com.travelassitant.microservice.usermanagementservice.bean.User;
import com.travelassitant.microservice.usermanagementservice.pubsub.PubSubService;

@RestController

public class UserController {

    @Autowired
    private UserDAO userDao;
    @Autowired
    private FlightDAO flightDao;
    @Autowired
    private HotelDAO hotelDao;
    @Autowired
    private CarRentalDAO carRentalDao;
    @Autowired
    private PubSubService pubSubService;
    @Autowired
    private MailService mailService;
    @Autowired
    private ContactUsDAO contactUsDAO;
    @Autowired
    private RecentSearchDao recentSearchDao;

    @Autowired
    private PollableChannel airportSaveResultInputChannel;

    @PostMapping("/publishAirport")
    public ResponseEntity<String> publishMessageToAirportService(@RequestBody Country newCountry) {
        System.out.println("kbjkjqkjkj");
        pubSubService.publishMessageToAirportService(newCountry);
        Message<?> resultMessage = airportSaveResultInputChannel.receive(); // wait for 10 seconds
        String message = "No response received";
        if (resultMessage != null) {
            Object payload = resultMessage.getPayload();
            if (payload instanceof byte[]) {
                message = new String((byte[]) payload, StandardCharsets.UTF_8);
            } else {
                message = payload.toString();
            }
            if ("Failed to save airport.".equals(message)) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message); // HTTP 500 Internal
                                                                                              // Server Error
            } else {
                return ResponseEntity.ok().body(message); // HTTP 200 OK
            }
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(message); // HTTP 204 No Content
        }
    }

    @DeleteMapping("/removeAirport/{iataCode}")
    public ResponseEntity<String> removeAirport(@PathVariable String iataCode) {
        System.out.println(iataCode);
        pubSubService.publishRemoveAirportMessage(iataCode);
        Message<?> resultMessage = airportSaveResultInputChannel.receive(); // wait for 10 seconds
        String message = "No response received";
        if (resultMessage != null) {
            Object payload = resultMessage.getPayload();
            if (payload instanceof byte[]) {
                message = new String((byte[]) payload, StandardCharsets.UTF_8);
            } else {
                message = payload.toString();
            }
            if ("Failed to remove airport".equals(message)) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message); // HTTP 500 Internal
                                                                                              // Server Error
            } else {
                return ResponseEntity.ok().body(message); // HTTP 200 OK
            }
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(message); // HTTP 204 No Content
        }
    }

    @PostMapping("/sendMail")
    public ResponseEntity<Void> someMethod(@RequestParam String email, @RequestParam String text) {
        String subject = "Response to Your Inquiry";
        String message = "Hello,\n\nThank you for reaching out to us. We appreciate your patience while we were reviewing your inquiry.\n\n"
                + text
                + "\n\nIf you have any other questions, feel free to ask. We're here to help!\n\nBest Regards,\nTravellingAssistant team";
        mailService.sendSimpleMessage(email, subject, message);
        return ResponseEntity.ok().build(); // HTTP 200 OK
    }

    @PutMapping("/contactus/markAllAsRead")
    public ResponseEntity<?> markAllMessagesAsRead() {
        try {
            contactUsDAO.markAllAsRead();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/carRentals")
    public ResponseEntity<Void> deleteAllCarRentals() {
        boolean isRemoved = userDao.deleteAllCarRentals();
        if (isRemoved) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/contactus/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable String id) {
        try {
            contactUsDAO.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/users/{id}/hotels")
    public ResponseEntity<List<HotelInfo>> getUserHotels(@PathVariable String id) {
        List<HotelInfo> hotels = userDao.findBookedHotels(id);
        if (hotels != null && !hotels.isEmpty()) {
            return ResponseEntity.ok(hotels); // HTTP 200 OK
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found
        }
    }

    @GetMapping("/users/{id}/carRentals")
    public ResponseEntity<List<CarRental>> getUserCarRentals(@PathVariable String id) {
        List<CarRental> carRentals = userDao.findRentedCars(id);
        if (carRentals != null && !carRentals.isEmpty()) {
            return ResponseEntity.ok(carRentals); // HTTP 200 OK
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found
        }
    }

    @GetMapping("/users/{id}/recentSearches")
    public ResponseEntity<List<Search>> getUserRecentSearches(@PathVariable String id) {
        List<Search> searches = userDao.findSearchesByUser(id);
        if (searches != null && !searches.isEmpty()) {
            return ResponseEntity.ok(searches); // HTTP 200 OK
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userDao.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/flights")
    public ResponseEntity<List<Itinerary>> getAllFlights() {
        List<Itinerary> flights = flightDao.findAll();
        return ResponseEntity.ok(flights); // HTTP 200 OK
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User user = userDao.findOne(id);
        if (user != null) {
            return ResponseEntity.ok(user); // HTTP 200 OK
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        boolean isRemoved = userDao.delete(id);
        if (isRemoved) {
            return ResponseEntity.noContent().build(); // HTTP 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found
        }
    }

    @GetMapping("/users/{id}/flights")
    public ResponseEntity<List<Itinerary>> getFlights(@PathVariable String id) {
        List<Itinerary> flights = userDao.findBookedFlights(id);
        if (flights != null && !flights.isEmpty()) {
            return ResponseEntity.ok(flights); // HTTP 200 OK
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found
        }
    }

    @PutMapping("/users/username")
    public ResponseEntity<?> changeUsername(@RequestBody ChangeUsernameRequest request) {
        System.out.println("New username: " + request.getNewUsername());
        System.out.println("old username: " + request.getOldUsername());
        try {
            User updatedUser = userDao.changeUsername(request.getOldUsername(), request.getNewUsername());
            // print the new username
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/searches/top-destinations")
    public ResponseEntity<List<String>> getMostSearchedDestinations() {
        List<String> destinations = recentSearchDao.getMostSearchedDestinations();
        return ResponseEntity.ok(destinations);
    }

    @GetMapping("/car-rentals/count")
    public ResponseEntity<Long> getNumberOfCarRentals() {
        long count = carRentalDao.getNumberOfCarRentals();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/hotels/count")
    public ResponseEntity<Long> getNumberOfHotels() {
        long count = hotelDao.getNumberOfHotels();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/flights/count")
    public ResponseEntity<Long> getNumberOfFlights() {
        long count = flightDao.getNumberOfFlights();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/messages")
    public ResponseEntity<List<ContactUs>> getMessages() {
        List<ContactUs> messages = contactUsDAO.findAll();
        return ResponseEntity.ok(messages); // HTTP 200 OK
    }

    @PostMapping("/addMessage")
    public ResponseEntity<ContactUs> addMessage(@RequestBody ContactUs contactUs) {
        ContactUs savedMessage = contactUsDAO.save(contactUs);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMessage); // HTTP 201 Created
    }

    @DeleteMapping("/users/{userId}/rentals/{carRentalId}")
    public ResponseEntity<?> removeRentedCar(@PathVariable String userId, @PathVariable String carRentalId) {
        boolean result = userDao.removeRentedCar(userId, carRentalId);

        if (result) {
            return ResponseEntity.ok().body("Car Rental removed successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/users/{userId}/hotels/{hotelId}")
    public ResponseEntity<?> removeBookedHotel(@PathVariable String userId, @PathVariable String hotelId) {
        boolean result = userDao.removeBookedHotel(userId, hotelId);

        if (result) {
            return ResponseEntity.ok().body("Hotel removed successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/users/{userId}/flights/{flightId}")
    public ResponseEntity<?> removeBookedFlight(@PathVariable String userId, @PathVariable String flightId) {
        boolean result = userDao.removeBookedFlight(userId, flightId);

        if (result) {
            return ResponseEntity.ok().body("Flight saved removed successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/users/{userId}/searches/{searchId}")
    public ResponseEntity<?> removeSearch(@PathVariable String userId, @PathVariable String searchId) {
        boolean result = userDao.removeSearch(userId, searchId);

        if (result) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
