package com.travelassitant.microservice.usermanagementservice.dbRepositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.travelassitant.microservice.usermanagementservice.bean.Itinerary;

public interface FlightRepository extends MongoRepository<Itinerary, String> {
    Itinerary findByContentHash(String contentHash);
    long count();
}
