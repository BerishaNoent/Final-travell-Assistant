package com.travelassitant.microservice.criteriabasedsearchservice.repositories;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travelassitant.microservice.criteriabasedsearchservice.bean.CarRental;
import com.travelassitant.microservice.criteriabasedsearchservice.request.RequestBodytemp;
import com.travelassitant.microservice.criteriabasedsearchservice.responses.SkyScrapperCarRentalResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Repository
public class ApiRepositoryCarRental2 {

    public String getCityEntityId(String entityId) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "08d94f2f42mshecc916a55f33eacp1e93bbjsn71558a283d3d");
        headers.set("X-RapidAPI-Host", "sky-scrapper.p.rapidapi.com");

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl("https://sky-scrapper.p.rapidapi.com/api/v1/cars/searchLocation")
                .queryParam("query", entityId);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);

        String jsonResponse = response.getBody();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonResponse);

        for (JsonNode dataNode : rootNode.get("data")) {
            if (dataNode.get("class").asText().equals("City")) {
                return dataNode.get("entity_id").asText();
            }
        }

        return null;
    }

    public Map<String, Object> queryApi(RequestBodytemp requestBody) throws IOException {
        String entityId = getCityEntityId(requestBody.getDestinationName());

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "08d94f2f42mshecc916a55f33eacp1e93bbjsn71558a283d3d");
        headers.set("X-RapidAPI-Host", "sky-scrapper.p.rapidapi.com");

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl("https://sky-scrapper.p.rapidapi.com/api/v1/cars/searchCars")
                .queryParam("pickUpEntityId", entityId)
                .queryParam("pickUpDate", requestBody.getDate())
                .queryParam("pickUpTime", "10:00")
                .queryParam("currency", "USD")
                .queryParam("countryCode", "US")
                .queryParam("market", "en-US");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<SkyScrapperCarRentalResponse> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                SkyScrapperCarRentalResponse.class);

        SkyScrapperCarRentalResponse apiResponse = response.getBody();
        List<CarRental> carRentals = mapSkyScrapperResponseToCarRentals(apiResponse);

        Map<String, Object> result = new HashMap<>();
        result.put("CarRentals", carRentals);

        return result;
    }

    public List<CarRental> mapSkyScrapperResponseToCarRentals(SkyScrapperCarRentalResponse response) {
        List<CarRental> carRentals = new ArrayList<>();
        if (response != null && response.getData() != null && response.getData().getQuotes() != null) {
            for (SkyScrapperCarRentalResponse.Quote quote : response.getData().getQuotes()) {
                CarRental carRental = new CarRental();
                carRental.setSupplierName(quote.getVndr());
                carRental.setCarName(quote.getCarName());
                carRental.setTransmission(quote.getSipp());
                carRental.setSeats((int) quote.getSeat());
                DecimalFormat df = new DecimalFormat("#.000");
                carRental.setPrice(df.format(quote.getPrice()));
                carRental.setCurrency(quote.getPayType() != null ? quote.getPayType() : "$");
                if (quote.getVndrRating() != null) {
                    carRental.setRating(quote.getVndrRating().getOverallRating());
                } else {
                    carRental.setRating(0);
                }
                carRental.setSupplierImage(quote.getVndr());
                carRental.setCarImage(quote.getCarName());
                List<String> badges = new ArrayList<>();
                badges.add("Not available");
                carRental.setBadges(badges);
                carRental.setBaseDeposit("Not available");
                carRental.setSupplierAddress("Not available");
                carRental.setDeepLink(quote.getDplnk());
                carRentals.add(carRental);
            }
        }
        return carRentals;
    }

}
