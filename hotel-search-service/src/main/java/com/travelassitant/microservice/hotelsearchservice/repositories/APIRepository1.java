package com.travelassitant.microservice.hotelsearchservice.repositories;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.travelassitant.microservice.hotelsearchservice.bean.HotelInfo;
import com.travelassitant.microservice.hotelsearchservice.requests.RequestBodytemp;
import com.travelassitant.microservice.hotelsearchservice.responses.BookingHotel;

@Repository
public class APIRepository1 {

    public String getDestinationId(String destinationName) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "08d94f2f42mshecc916a55f33eacp1e93bbjsn71558a283d3d");
        headers.set("X-RapidAPI-Host", "booking-com15.p.rapidapi.com");

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl("https://booking-com15.p.rapidapi.com/api/v1/hotels/searchDestination")
                .queryParam("query", destinationName);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    entity,
                    String.class);

            if (response.getStatusCodeValue() != 200) {
                throw new Exception("Failed to get destination info");
            }

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());
            JsonNode data = root.path("data");

            for (JsonNode destination : data) {
                if (destinationName.equalsIgnoreCase(destination.path("name").asText())) {
                    return destination.path("dest_id").asText();
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Map<String, Object> getHotelInfo(RequestBodytemp requestBody) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "08d94f2f42mshecc916a55f33eacp1e93bbjsn71558a283d3d");
        headers.set("X-RapidAPI-Host", "booking-com15.p.rapidapi.com");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate checkinDate = LocalDate.parse(requestBody.getDate(), formatter);
        LocalDate checkoutDate = checkinDate.plusDays(1);

        String destId = getDestinationId(requestBody.getDestinationName());
        if (destId == null) {
            return Collections.emptyMap();
        }

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl("https://booking-com15.p.rapidapi.com/api/v1/hotels/searchHotels")
                .queryParam("dest_id", destId)
                .queryParam("search_type", "CITY")
                .queryParam("arrival_date", checkinDate)
                .queryParam("departure_date", checkoutDate);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<BookingHotel> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    entity,
                    BookingHotel.class);

            if (response.getStatusCodeValue() != 200) {
                throw new Exception("Failed to get hotel info");
            }

            List<HotelInfo> hotels = mapBookingHotelToHotelInfo(response.getBody(), requestBody.getDestinationName(),
                    requestBody.getCountry());

            Map<String, Object> result = new HashMap<>();
            result.put("Hotels", hotels);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }

    public List<HotelInfo> mapBookingHotelToHotelInfo(BookingHotel bookingHotel, String country, String city) {
        List<HotelInfo> hotelInfos = new ArrayList<>();

        for (BookingHotel.Hotel hotel : bookingHotel.getData().getHotels()) {
            HotelInfo hotelInfo = new HotelInfo();

            hotelInfo.setId(String.valueOf(hotel.getProperty().getid()));
            hotelInfo.setName(hotel.getProperty().getName());
            hotelInfo.setCity(city);
            hotelInfo.setCountry(country);

            hotelInfo.setStarRating("0");
            hotelInfo.setReviewRating(hotel.getProperty().getReviewScore());
            hotelInfo.setReviewCount(hotel.getProperty().getReviewCount());
            hotelInfo.setCheckInTime(hotel.getProperty().getCheckin().getFromTime().toString());
            hotelInfo.setCheckOutTime(hotel.getProperty().getCheckout().getUntilTime().toString());
            Map<String, String> photos = new HashMap<>();
            for (int i = 0; i < hotel.getProperty().getPhotoUrls().size(); i++) {
                photos.put("photo" + (i + 1), hotel.getProperty().getPhotoUrls().get(i));
            }
            hotelInfo.setPhotos(photos);
            hotelInfo.setLatitude(hotel.getProperty().getLatitude());
            hotelInfo.setLongitude(hotel.getProperty().getLongitude());
            hotelInfo.setHotelRank(String.valueOf(hotel.getProperty().getRankingPosition()));
            hotelInfo.setMinPrice(String.valueOf(hotel.getProperty().getPriceBreakdown().getGrossPrice().getValue()));
            if (!hotel.getProperty().getPhotoUrls().isEmpty()) {
                hotelInfo.setImageUrl(hotel.getProperty().getPhotoUrls().get(0));
            }
            hotelInfos.add(hotelInfo);
        }

        return hotelInfos;
    }

}
