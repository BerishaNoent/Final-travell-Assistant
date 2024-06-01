package com.travelassitant.microservice.usermanagementservice.DAOs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelassitant.microservice.usermanagementservice.bean.CarRental;
import com.travelassitant.microservice.usermanagementservice.bean.User;
import com.travelassitant.microservice.usermanagementservice.dbRepositories.RecentSearchRepository;
import com.travelassitant.microservice.usermanagementservice.dbRepositories.UserRepository;
import com.travelassitant.microservice.usermanagementservice.bean.HotelInfo;
import com.travelassitant.microservice.usermanagementservice.bean.Itinerary;
import com.travelassitant.microservice.usermanagementservice.bean.Search;

@Service
public class UserDAO {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRentalDAO carRentalRepository;

    @Autowired
    private HotelDAO hotelRepository;

    @Autowired
    private FlightDAO flightRepository;
    @Autowired
    private RecentSearchRepository recentSearchRepository;

    public long countUsers() {
        return userRepository.count();
    }

    public User save(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Username already taken");
        }
        return userRepository.save(user);
    }

    public User changeUsername(String oldUsername, String newUsername) {
        User user = userRepository.findByUsername(oldUsername)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Optional<User> userWithNewUsername = userRepository.findByUsername(newUsername);
        if (userWithNewUsername.isPresent()) {
            throw new RuntimeException("Username already taken");
        }

        user.setUsername(newUsername);
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public boolean delete(String id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<CarRental> findRentedCars(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }
        return user.getCarRentals().stream()
                .map(carRentalId -> carRentalRepository.findOne(carRentalId))
                .collect(Collectors.toList());
    }

    public String addRentedCar(String userId, CarRental carRental) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }

        carRental = carRentalRepository.save(carRental);

        if (carRental == null) {
            return null;
        }

        if (user.getCarRentals() != null && user.getCarRentals().contains(carRental.getId())) {
            return "Car rental already saved";
        }

        if (user.getCarRentals() == null) {
            user.setCarRentals(new ArrayList<>());
        }
        user.getCarRentals().add(carRental.getId());

        userRepository.save(user);

        return carRental.getId();
    }

    public boolean removeRentedCar(String userId, String carRentalId) {
        User user = userRepository.findById(userId).orElse(null);
        CarRental carRental = carRentalRepository.findOne(carRentalId);

        if (user == null || carRental == null) {
            return false;
        }

        user.getCarRentals().remove(carRentalId);

        userRepository.save(user);

        return true;
    }

    public boolean deleteAllCarRentals() {
        carRentalRepository.deleteAll();

        return true;
    }

    public List<HotelInfo> findBookedHotels(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }
        return user.getHotels().stream()
                .map(hotelId -> hotelRepository.findOne(hotelId))
                .collect(Collectors.toList());
    }

    public String addBookedHotel(String userId, HotelInfo hotel) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }

        hotel = hotelRepository.save(hotel);

        if (hotel == null) {
            return null;
        }

        if (user.getHotels() != null && user.getHotels().contains(hotel.getId())) {
            return "Hotel already saved";
        }
        if (user.getHotels() == null) {
            user.setHotels(new ArrayList<>());
        }
        user.getHotels().add(hotel.getId());

        userRepository.save(user);
        return hotel.getId();
    }

    public boolean removeBookedHotel(String userId, String hotelId) {
        User user = userRepository.findById(userId).orElse(null);
        HotelInfo hotel = hotelRepository.findOne(hotelId);

        if (user == null || hotel == null) {
            return false;
        }

        user.getHotels().remove(hotelId);

        userRepository.save(user);

        return true;
    }

    public List<Itinerary> findBookedFlights(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }
        return user.getFlights().stream()
                .map(flightId -> flightRepository.findOne(flightId))
                .collect(Collectors.toList());
    }

    public String addBookedFlight(String userId, Itinerary flight) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }


        flight = flightRepository.save(flight);

        if (flight == null) {

            return null;
        }

        if (user.getFlights() != null && user.getFlights().contains(flight.getId())) {
            return "Flight already saved";
        }

        if (user.getFlights() == null) {
            user.setFlights(new ArrayList<>());
        }
        user.getFlights().add(flight.getId());

        userRepository.save(user);

        flightRepository.save(flight);

        return flight.getId();
    }

    public boolean removeBookedFlight(String userId, String flightId) {
        User user = userRepository.findById(userId).orElse(null);
        Itinerary flight = flightRepository.findOne(flightId);

        if (user == null || flight == null) {
            return false;
        }

        user.getFlights().remove(flightId);

        userRepository.save(user);

        return true;
    }

    public List<Search> findSearchesByUser(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }
        return user.getSearches().stream()
                .map(searchId -> recentSearchRepository.findById(searchId).orElse(null))
                .collect(Collectors.toList());
    }

    public String addSearch(String userId, Search search) {

        User user = null;
        try {
            user = userRepository.findById(userId).orElse(null);
        } catch (Exception e) {
            return null;
        }
        Search savedSearch = recentSearchRepository.save(search);

        if (user.getSearches() == null) {
            user.setSearches(new ArrayList<>());
        }
        user.getSearches().add(savedSearch.getId());

        userRepository.save(user);
        recentSearchRepository.save(savedSearch);

        return savedSearch.getId();
    }

    public boolean removeSearch(String userId, String searchId) {
        User user = userRepository.findById(userId).orElse(null);
        Search search = recentSearchRepository.findById(searchId).orElse(null);

        if (user == null || search == null) {
            return false;
        }

        user.getSearches().remove(searchId);

        userRepository.save(user);

        return true;
    }
}
