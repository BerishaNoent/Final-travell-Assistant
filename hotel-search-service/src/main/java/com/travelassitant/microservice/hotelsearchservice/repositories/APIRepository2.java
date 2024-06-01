package com.travelassitant.microservice.hotelsearchservice.repositories;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import com.travelassitant.microservice.hotelsearchservice.responses.SkyScannerResponses.SkyScannerBookingHotel;

@Repository
public class APIRepository2 {

    public String getAirportEntityId(String endpoint) throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "08d94f2f42mshecc916a55f33eacp1e93bbjsn71558a283d3d");
        headers.set("X-RapidAPI-Host", "sky-scanner3.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        String url = "https://sky-scanner3.p.rapidapi.com/hotels/auto-complete";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("query", endpoint);

        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
                String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode data = root.path("data");

        for (JsonNode node : data) {
            if (node.has("class") && node.get("class").asText().equals("City")) {
                return node.get("entityId").asText();
            }
        }

        return null;
    }

    public Map<String, Object> getHotelInfo(RequestBodytemp requestBody) throws IOException {

        String entityId = getAirportEntityId(requestBody.getDestinationName());
        if (entityId == null) {
            System.out.println("Entity ID not found");
            return new HashMap<>();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate checkinDate = LocalDate.parse(requestBody.getDate(), formatter);
        LocalDate checkoutDate = checkinDate.plusDays(1);

        String checkin = checkinDate.format(formatter);
        String checkout = checkoutDate.format(formatter);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "08d94f2f42mshecc916a55f33eacp1e93bbjsn71558a283d3d");
        headers.set("X-RapidAPI-Host", "sky-scanner3.p.rapidapi.com");

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl("https://sky-scanner3.p.rapidapi.com/hotels/search")
                .queryParam("entityId", entityId)
                .queryParam("checkin", checkin)
                .queryParam("checkout", checkout);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<SkyScannerBookingHotel> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                SkyScannerBookingHotel.class);

        SkyScannerBookingHotel apiResponse = response.getBody();

        List<HotelInfo> hotels = mapSkyScannerBookingHotelToHotelInfo(apiResponse, requestBody.getDestinationName(),
                requestBody.getCountry());

        Map<String, Object> result = new HashMap<>();
        result.put("Hotels", hotels);

        return result;
    }

    public List<HotelInfo> mapSkyScannerBookingHotelToHotelInfo(SkyScannerBookingHotel skyScannerBookingHotel,
            String destinationName, String country) {
        List<HotelInfo> hotelInfos = new ArrayList<>();
        System.out.println("Hotel Cards: " + skyScannerBookingHotel.getData().getResults().getHotelCards());

        for (SkyScannerBookingHotel.HotelCard hotelCard : skyScannerBookingHotel.getData().getResults()
                .getHotelCards()) {
            HotelInfo hotelInfo = new HotelInfo();
            SkyScannerBookingHotel.Location location = skyScannerBookingHotel.getData().getResults().getSearchSummary()
                    .getLocation().get(0);

            hotelInfo.setId(hotelCard.getid());
            hotelInfo.setName(hotelCard.getName());
            hotelInfo.setAddress(location.getName());
            hotelInfo.setStarRating(hotelCard.getStars());
            hotelInfo.setCountry(country);
            hotelInfo.setCity(destinationName);
            hotelInfo.setHotelRank("Not Available");

            hotelInfo.setReviewRating(0);

            hotelInfo.setReviewCount(0);

            Map<String, String> photos = new HashMap<>();
            for (int i = 0; i < hotelCard.getImages().size(); i++) {
                photos.put("photo" + (i + 1), hotelCard.getImages().get(i));
            }
            hotelInfo.setPhotos(photos);
            hotelInfo.setLatitude(hotelCard.getCoordinates().getLatitude());
            hotelInfo.setLongitude(hotelCard.getCoordinates().getLongitude());
            hotelInfo.setMinPrice(hotelCard.getLowestPrice().getPrice());
            if (!hotelCard.getImages().isEmpty()) {
                hotelInfo.setImageUrl(hotelCard.getImages().get(0));
            }

            hotelInfos.add(hotelInfo);
        }

        return hotelInfos;
    }

}
