package com.travelassitant.microservice.usermanagementservice.pubsub;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.travelassitant.microservice.usermanagementservice.DAOs.UserDAO;
import com.travelassitant.microservice.usermanagementservice.bean.CarRental;
import com.travelassitant.microservice.usermanagementservice.bean.Country;
import com.travelassitant.microservice.usermanagementservice.bean.HotelInfo;
import com.travelassitant.microservice.usermanagementservice.bean.Search;
import com.travelassitant.microservice.usermanagementservice.bean.User;
import com.travelassitant.microservice.usermanagementservice.bean.Itinerary;

import org.springframework.integration.annotation.ServiceActivator;

@Service
public class PubSubService {

    @Autowired
    private PubSubTemplate pubSubTemplate;

    @Autowired
    private UserDAO userDAO;
    private ObjectMapper objectMapper = new ObjectMapper();

    public void publishMessage(User userinfo) {
        try {
            String message = objectMapper.writeValueAsString(userinfo);
            pubSubTemplate.publish("Hotel", message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void publishMessageToAirportService(Country newCountry) {
        try {
            String message = objectMapper.writeValueAsString(newCountry);
            pubSubTemplate.publish("airportTopic", message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void publishRemoveAirportMessage(String iataCode) {
        try {
            String message = objectMapper.writeValueAsString(iataCode);
            pubSubTemplate.publish("airportRemoveTopic", message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void publishMessageToFlightService(String message) {

        pubSubTemplate.publish("FlightError", message);

    }

    public void publishMessageToHotelService(String message) {
        pubSubTemplate.publish("HotelError", message);
    }

    public void publishMessageToCarRentalService(String message) {

        pubSubTemplate.publish("CarRentalError", message);

    }

    @ServiceActivator(inputChannel = "hotelsearchserviceInputChannel")
    public void subscribeMessage(String message) {
        try {
            HotelInfo hotelInfo = objectMapper.readValue(message, HotelInfo.class);

            String hotelId = userDAO.addBookedHotel(hotelInfo.getUserId(), hotelInfo);
            if (hotelId != null) {
                publishMessageToHotelService(hotelId);
            } else {
                String errorMessage = "Failed to save hotel";
                publishMessageToHotelService(errorMessage);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @ServiceActivator(inputChannel = "flightserviceInputChannel")
    public void subscribeMessageFromFlightService(String message) {
        try {
            Itinerary flightInfo = objectMapper.readValue(message, Itinerary.class);

            String flightId = userDAO.addBookedFlight(flightInfo.getUserId(), flightInfo);
            if (flightId != null && !flightId.isEmpty()) {
                publishMessageToFlightService(flightId);
            } else {
                String errorMessage = "Failed to save itinerary";
                publishMessageToFlightService(errorMessage);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @ServiceActivator(inputChannel = "carRentalserviceInputChannel")
    public void subscribeMessageFromCarRentalservice(String message) {
        try {
            CarRental carRentalInfo = objectMapper.readValue(message, CarRental.class);

            String carRentalId = userDAO.addRentedCar(carRentalInfo.getUserId(), carRentalInfo);
            if (carRentalId != null) {
                publishMessageToCarRentalService(carRentalId);
            } else {
                String errorMessage = "Failed to save car rental";
                publishMessageToCarRentalService(errorMessage);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @ServiceActivator(inputChannel = "recentSearchserviceInputChannel")
    public void subscribeMessageFromReentSearch(String message) {
        try {
            Search search = objectMapper.readValue(message, Search.class);
            userDAO.addSearch(search.getUserId(), search);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
