package com.travelassitant.microservice.criteriabasedsearchservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travelassitant.microservice.criteriabasedsearchservice.Daos.AirportDAO;
import com.travelassitant.microservice.criteriabasedsearchservice.bean.Country;
import com.travelassitant.microservice.criteriabasedsearchservice.bean.Search;
import com.travelassitant.microservice.criteriabasedsearchservice.pubsub.PubSubService;

@RestController
public class criteriaBasedSearchController {

    @Autowired
    private PubSubService pubSubService;
    @Autowired
    private AirportDAO airportDAO;

    @PostMapping("/addAirport")
    public ResponseEntity<Void> addAirport(@RequestBody List<Country> airports) {
        airportDAO.addAllAirports(airports);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAirports")
    public ResponseEntity<List<Country>> getAirports() {
        List<Country> airports = airportDAO.getAllAirports();
        return ResponseEntity.ok(airports);
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody Search search) {
        String result = pubSubService.publishRecentSearch(search);
        return ResponseEntity.ok(result);
    }

}