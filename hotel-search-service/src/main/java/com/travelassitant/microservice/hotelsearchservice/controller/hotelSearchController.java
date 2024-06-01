package com.travelassitant.microservice.hotelsearchservice.controller;

import java.nio.charset.StandardCharsets;
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

import com.travelassitant.microservice.hotelsearchservice.bean.HotelInfo;
import com.travelassitant.microservice.hotelsearchservice.pubSub.PubSubService;
import com.travelassitant.microservice.hotelsearchservice.requests.RequestBodytemp;
import com.travelassitant.microservice.hotelsearchservice.services.fetchDataService;


@RestController
@RequestMapping("/hotel")
public class hotelSearchController {

    @Autowired
    private fetchDataService apiService;

    @Autowired
    private PubSubService pubSubService;

    @Autowired
    private PollableChannel hotelResultInputChannel;

    @PostMapping("/publishHotel")
    public ResponseEntity<String> publishMessage(@RequestBody HotelInfo hotelInfo) {
        System.out.println("Hotel Info: ");
        pubSubService.publishHotel(hotelInfo);
        Message<?> resultMessage = hotelResultInputChannel.receive();
        String message = "No response received";
        if (resultMessage != null) {
            Object payload = resultMessage.getPayload();
            if (payload instanceof byte[]) {
                message = new String((byte[]) payload, StandardCharsets.UTF_8);
            } else {
                message = payload.toString();
            }
            System.out.println("Message received: " + message);
            if ("Failed to save hotel".equals(message)) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message); // HTTP 500 Internal
                                                                                              // Server Error
            } else if ("Hotel already saved".equals(message)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(message); // HTTP 409 Conflict
            } else {
                return ResponseEntity.ok(message); // HTTP 200 OK
            }
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(message); // HTTP 204 No Content
        }
    }

    @PostMapping("/aggregateData")
    public ResponseEntity<List<HotelInfo>> getHotels(@RequestBody RequestBodytemp formData) throws Exception {
        List<HotelInfo> hotels = apiService.aggregateData(formData);

        if (hotels.isEmpty()) {

            HotelInfo hotel = new HotelInfo();
            hotel.setId("1");
            hotel.setUserId("User1");
            hotel.setName("Hotel Name");
            hotel.setMinPrice("100");
            hotel.setCity("City");
            hotel.setCountry("Country");
            hotel.setAddress("Address");
            hotel.setStarRating("5");
            hotel.setReviewRating(4.5);
            hotel.setReviewCount(100);
            hotel.setCheckInTime("14:00");
            hotel.setCheckOutTime("12:00");
            hotel.setHotelDescription("This is a hotel description.");

            hotels.add(hotel);

        } else {
        }

        return ResponseEntity.ok().body(hotels);
    }

    // @PostMapping("/aggregateData")
    // public ResponseEntity<List<HotelInfo>> getHotels(@RequestBody RequestBodytemp
    // formData) throws Exception {
    // return ResponseEntity.ok(apiService.aggregateData(formData));
    // }

}
