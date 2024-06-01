package com.travelassitant.microservice.criteriabasedsearchservice.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.travelassitant.microservice.criteriabasedsearchservice.bean.Itinerary;
import com.travelassitant.microservice.criteriabasedsearchservice.bean.Itinerary.DateTime;
import com.travelassitant.microservice.criteriabasedsearchservice.pubsub.PubSubService;
import com.travelassitant.microservice.criteriabasedsearchservice.request.RequestBodytemp;
import com.travelassitant.microservice.criteriabasedsearchservice.services.fetchDataService;



@RestController
@RequestMapping("/flights")
public class flightsController {

    @Autowired
    private fetchDataService apiService;
 
    @Autowired
    private PubSubService pubSubService;
    @Autowired
    private PollableChannel flightSaveResultInputChannel;


@PostMapping("/publish")
public ResponseEntity<String> publishMessage(@RequestBody Itinerary itinerary) {
    System.out.println("Itinerary Info: " + itinerary.getArrivalDateTime().getHour());
    pubSubService.publishFlight(itinerary);
    Message<?> resultMessage = flightSaveResultInputChannel.receive(); // wait for 10 seconds
    String message = "No response received";
    if (resultMessage != null) {
        Object payload = resultMessage.getPayload();
        if (payload instanceof byte[]) {
            message = new String((byte[]) payload, StandardCharsets.UTF_8);
        } else {
            message = payload.toString();
        }
        System.out.println("Received message: " + message);
        if ("Failed to save itinerary".equals(message)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message); // HTTP 500 Internal Server Error
        } else if ("Flight already saved".equals(message)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message); // HTTP 409 Conflict
        } else {
            return ResponseEntity.ok(message); // HTTP 200 OK
        }
    } else {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(message); // HTTP 204 No Content
    }
}

    // @PostMapping("/aggregateData")
    // public ResponseEntity<List<Itinerary>> aggregateData(@RequestBody RequestBodytemp formData) throws IOException {  
    //     System.out.println(formData.toString());  
    //     List<Itinerary> data = apiService.aggregateData(formData);
    //     if (data.isEmpty()) {
    //         return ResponseEntity.notFound().build();
    //     } else {
    //         return ResponseEntity.ok().body(data);
    //     }
    // }

    @PostMapping("/aggregateData")
    public ResponseEntity<List<Itinerary>> aggregateData(@RequestBody RequestBodytemp formData) throws IOException {  
        System.out.println(formData.toString());  
    
        List<Itinerary> data = apiService.aggregateData(formData);
    
        if (data.isEmpty()) {
    
            Itinerary itinerary1 = new Itinerary();
            itinerary1.setOriginPlace("Origin 1");
            itinerary1.setDestinationPlace("Destination 1");
            DateTime departureDateTime1 = new DateTime();
            departureDateTime1.setDateTime("2022-01-01T10:30:00Z");
            itinerary1.setDepartureDateTime(departureDateTime1);
            DateTime arrivalDateTime1 = new DateTime();
            arrivalDateTime1.setDateTime("2022-01-01T12:30:00Z");
            itinerary1.setArrivalDateTime(arrivalDateTime1);

    
            Itinerary itinerary2 = new Itinerary();
            itinerary2.setOriginPlace("Origin 2");
            itinerary2.setDestinationPlace("Destination 2");
            DateTime departureDateTime2 = new DateTime();
            departureDateTime2.setDateTime("2022-01-02T10:30:00Z");
            itinerary2.setDepartureDateTime(departureDateTime2);
            DateTime arrivalDateTime2 = new DateTime();
            arrivalDateTime2.setDateTime("2022-01-02T12:30:00Z");
            itinerary2.setArrivalDateTime(arrivalDateTime2);

            data = Arrays.asList(itinerary1, itinerary2);
    
        } else {
           
        }
    
        return ResponseEntity.ok().body(data);
    }

}
