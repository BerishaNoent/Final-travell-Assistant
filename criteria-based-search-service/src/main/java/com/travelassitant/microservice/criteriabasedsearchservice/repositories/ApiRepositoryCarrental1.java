package com.travelassitant.microservice.criteriabasedsearchservice.repositories;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.travelassitant.microservice.criteriabasedsearchservice.bean.CarRental;
import com.travelassitant.microservice.criteriabasedsearchservice.request.RequestBodytemp;
import com.travelassitant.microservice.criteriabasedsearchservice.responses.NewBookingResponse;

@Repository
public class ApiRepositoryCarrental1 {


    public Map<String, Object> getCoordinatesAndIdByIataCode(String iataCode) {
        Map<String, Object> result = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-RapidAPI-Key", "08d94f2f42mshecc916a55f33eacp1e93bbjsn71558a283d3d");
            headers.set("X-RapidAPI-Host", "booking-com18.p.rapidapi.com");
    
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://booking-com18.p.rapidapi.com/car/auto-complete")
                .queryParam("query", iataCode);
    
            HttpEntity<?> entity = new HttpEntity<>(headers);
    
            ResponseEntity<Map> response = restTemplate.exchange(
                builder.toUriString(), 
                HttpMethod.GET, 
                entity,
                Map.class
            );
    
            List<Map<String, Object>> data = (List<Map<String, Object>>) response.getBody().get("data");
            for (Map<String, Object> item : data) {
                if (item.get("type").equals("airport") && item.get("iata_code").equals(iataCode)) {
                    Map<String, Double> itemCoordinates = (Map<String, Double>) item.get("coordinates");
                    result = new HashMap<>();
                    result.put("latitude", itemCoordinates.get("latitude"));
                    result.put("longitude", itemCoordinates.get("longitude"));
                    result.put("id", item.get("id"));
                    break;
                }
            }
        } catch (Exception e) {
        }
    
        return result;
    }


    public Map<String, Object> queryApi(RequestBodytemp requestBody) throws IOException {
        Map<String, Object> coordinatesAndId = getCoordinatesAndIdByIataCode(requestBody.getDestination());
        if (coordinatesAndId == null) {
            return new HashMap<>(); 
        }
    
        double pickUpLatitude = (Double) coordinatesAndId.get("latitude");
        double pickUpLongitude = (Double) coordinatesAndId.get("longitude");
    
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "08d94f2f42mshecc916a55f33eacp1e93bbjsn71558a283d3d");
        headers.set("X-RapidAPI-Host", "booking-com15.p.rapidapi.com");
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate pickUpDate = LocalDate.parse(requestBody.getDate(), formatter);
        LocalDate dropOffDate = pickUpDate.plusDays(1);
        String dropOffDateString = dropOffDate.format(formatter);
    
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://booking-com15.p.rapidapi.com/api/v1/cars/searchCarRentals")
            .queryParam("pick_up_latitude", pickUpLatitude)
            .queryParam("pick_up_longitude", pickUpLongitude)
            .queryParam("drop_off_latitude", pickUpLatitude)
            .queryParam("drop_off_longitude", pickUpLongitude)
            .queryParam("pick_up_date", pickUpDate.format(formatter))
            .queryParam("drop_off_date", dropOffDateString)
            .queryParam("pick_up_time", "10:00")
            .queryParam("drop_off_time", "10:00")
            .queryParam("driver_age", "30")
            .queryParam("currency_code", "USD");
    
        HttpEntity<?> entity = new HttpEntity<>(headers);
    
        ResponseEntity<NewBookingResponse> response = restTemplate.exchange(
            builder.toUriString(), 
            HttpMethod.GET, 
            entity,
            NewBookingResponse.class
        );
    
        NewBookingResponse apiResponse = response.getBody();
        List<CarRental> carRentals = mapResponseToCarRentals(apiResponse);
    
        Map<String, Object> result = new HashMap<>();
        result.put("CarRentals", carRentals);
    
        return result;
    }

public List<CarRental> mapResponseToCarRentals(NewBookingResponse response) {
    List<CarRental> carRentals = new ArrayList<>();

    for (NewBookingResponse.SearchResult searchResult : response.getData().getSearchResults()) {
        CarRental carRental = new CarRental();

        carRental.setSupplierName(searchResult.getSupplierInfo().getName());
        carRental.setSupplierImage(searchResult.getSupplierInfo().getLogourl());
        carRental.setSupplierAddress(searchResult.getSupplierInfo().getAddress());
        carRental.setRating(searchResult.getRatingInfo().getAverage());

        List<String> badges = searchResult.getContent().getBadges().stream()
                                  .map(Object::toString)
                                  .collect(Collectors.toList());
                                    
        carRental.setBadges(badges);

        carRental.setCarName(searchResult.getVehicleInfo().getVName());
        carRental.setTransmission(searchResult.getVehicleInfo().getTransmission());
        carRental.setSeats(Integer.parseInt(searchResult.getVehicleInfo().getSeats()));
        carRental.setCarImage(searchResult.getVehicleInfo().getImageurl());
        carRental.setPrice(Double.toString(searchResult.getPricingInfo().getPrice()));
        carRental.setCurrency(searchResult.getPricingInfo().getCurrency());
        carRental.setBaseDeposit(Double.toString(searchResult.getPricingInfo().getBaseDeposit()));
        carRental.setDeepLink(searchResult.getForwardurl());

        carRentals.add(carRental);
    }

    return carRentals;
}

    }

