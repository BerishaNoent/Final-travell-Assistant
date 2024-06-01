package com.travelassitant.microservice.usermanagementservice.DAOs;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travelassitant.microservice.usermanagementservice.bean.Itinerary;
import com.travelassitant.microservice.usermanagementservice.dbRepositories.FlightRepository;

@Service
public class FlightDAO {
    @Autowired
    private FlightRepository flightRepository;

    public Itinerary save(Itinerary flight) {
        String contentHash = flight.calculateContentHash();

        Itinerary existingFlight = flightRepository.findByContentHash(contentHash);

        if (existingFlight != null) {
            return existingFlight;
        } else {
            flight.setContentHash(contentHash);
            Itinerary savedFlight = flightRepository.save(flight);

            return savedFlight;
        }
    }

    public long getNumberOfFlights() {
        return flightRepository.count();
    }

    public List<Itinerary> findAll() {
        return flightRepository.findAll();
    }

    public Itinerary findOne(String id) {
        return flightRepository.findById(id).orElse(null);
    }

    public void delete(Itinerary flight) {
        flightRepository.delete(flight);
    }
}
