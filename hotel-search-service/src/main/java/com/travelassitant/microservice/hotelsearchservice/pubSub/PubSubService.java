
package com.travelassitant.microservice.hotelsearchservice.pubSub;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.travelassitant.microservice.hotelsearchservice.bean.HotelInfo;

@Service
public class PubSubService {

    @Autowired
    private PubSubTemplate pubSubTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    public String publishHotel(HotelInfo hotelInfo) {
        try {
            String message = objectMapper.writeValueAsString(hotelInfo);
            pubSubTemplate.publish("Hotel", message);
            return "Message published successfully";
        } catch (Exception e) {
            return "Failed to publish message: " + e.getMessage();
        }
    }
}