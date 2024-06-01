package com.travelassitant.microservice.criteriabasedsearchservice.pubsub;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.travelassitant.microservice.criteriabasedsearchservice.Daos.AirportDAO;
import com.travelassitant.microservice.criteriabasedsearchservice.bean.CarRental;
import com.travelassitant.microservice.criteriabasedsearchservice.bean.Country;
import com.travelassitant.microservice.criteriabasedsearchservice.bean.Search;
import com.travelassitant.microservice.criteriabasedsearchservice.bean.Itinerary;

import org.springframework.integration.annotation.ServiceActivator;

@Service
public class PubSubService {

    @Autowired
    private PubSubTemplate pubSubTemplate;
    @Autowired
    private AirportDAO airportDAO;
    private ObjectMapper objectMapper = new ObjectMapper();

    public String publishFlight(Itinerary flight) {
        try {
            String message = objectMapper.writeValueAsString(flight);
            pubSubTemplate.publish("flights", message);
            return "Message published successfully";
        } catch (Exception e) {
            return "Failed to publish message: " + e.getMessage();
        }
    }

    public String publishCarRental(CarRental carRental) {
        try {
            String message = objectMapper.writeValueAsString(carRental);
            pubSubTemplate.publish("carReantal", message);
            return "Message published successfully";
        } catch (Exception e) {
            return "Failed to publish message: " + e.getMessage();
        }
    }

    public String publishRecentSearch(Search search) {
        try {
            String message = objectMapper.writeValueAsString(search);
            pubSubTemplate.publish("RecentSearch", message);
            return "Message published successfully";
        } catch (Exception e) {
            return "Failed to publish message: " + e.getMessage();
        }
    }

    public String publishMessageToAirportService(String successMessage) {
        try {
            pubSubTemplate.publish("AirportError", successMessage);
            return "Message published successfully";
        } catch (Exception e) {
            return "Failed to publish message: " + e.getMessage();
        }
    }

    @ServiceActivator(inputChannel = "airportInputChannel")
    public void subscribeMessage(String message) {
        try {
            Country newCountry = objectMapper.readValue(message, Country.class);

            boolean airportId = airportDAO.addAirport(newCountry);
            if (airportId) {
                String successMessage = "Airport was successfully saved.";
                publishMessageToAirportService(successMessage);
            } else {
                String errorMessage = "Failed to save airport.";
                publishMessageToAirportService(errorMessage);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @ServiceActivator(inputChannel = "airportRemoveInputChannel")
    public void subscribeRemoveAirportMessage(String message) {
        message = message.replace("\"", "");
        boolean isRemoved = airportDAO.removeAirport(message);
        if (isRemoved) {
            String successMessage = "Airport with IATA code was successfully removed.";
            publishMessageToAirportService(successMessage);
        } else {
            String errorMessage = "Failed to remove airport";
            publishMessageToAirportService(errorMessage);
        }
    }
}
