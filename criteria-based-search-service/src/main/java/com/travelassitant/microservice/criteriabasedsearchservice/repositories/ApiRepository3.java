package com.travelassitant.microservice.criteriabasedsearchservice.repositories;

import java.io.IOException;
import java.time.LocalDateTime;
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

import com.travelassitant.microservice.criteriabasedsearchservice.bean.Itinerary;
import com.travelassitant.microservice.criteriabasedsearchservice.request.RequestBodytemp;
import com.travelassitant.microservice.criteriabasedsearchservice.responses.APIResponseBooking;

@Repository
public class ApiRepository3 {

    public Map<String, Object> getFlightInfo(RequestBodytemp requestBody) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "08d94f2f42mshecc916a55f33eacp1e93bbjsn71558a283d3d");
        headers.set("X-RapidAPI-Host", "booking-com18.p.rapidapi.com");

        UriComponentsBuilder builder;
        if (requestBody.isReturnTicket()) {
            builder = UriComponentsBuilder.fromHttpUrl("https://booking-com18.p.rapidapi.com/flights/search-return")
                    .queryParam("fromId", requestBody.getOrigin())
                    .queryParam("toId", requestBody.getDestination())
                    .queryParam("departureDate", requestBody.getDate())
                    .queryParam("returnDate", requestBody.getReturnDate());
        } else {
            builder = UriComponentsBuilder.fromHttpUrl("https://booking-com18.p.rapidapi.com/flights/search-oneway")
                    .queryParam("fromId", requestBody.getOrigin())
                    .queryParam("toId", requestBody.getDestination())
                    .queryParam("departureDate", requestBody.getDate());
        }

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<APIResponseBooking> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                APIResponseBooking.class);

        APIResponseBooking apiResponse = response.getBody();

        List<Itinerary> itineraries = mapApiResponseToItineraryDetails(apiResponse, requestBody.getOriginName(),
                requestBody.getDestinationName());

        Map<String, Object> result = new HashMap<>();
        result.put("flightDetailsList", itineraries);

        return result;
    }

    public List<Itinerary> mapApiResponseToItineraryDetails(APIResponseBooking apiResponse, String destinationName,
            String originName) {
        List<Itinerary> itineraries = new ArrayList<>();

        if (apiResponse.getData().getFlights() != null) {
            for (APIResponseBooking.Flight flight : apiResponse.getData().getFlights()) {
                Itinerary itinerary = new Itinerary();
                itinerary.setDeeplink(flight.getShareableUrl());
                itinerary.setOriginPlace(originName);
                itinerary.setDestinationPlace(destinationName);

                if (flight.getTravelerPrices() != null && !flight.getTravelerPrices().isEmpty()) {
                    double priceValue = flight.getTravelerPrices().get(0).getPrice().getPrice().getValue();
                    Itinerary.Price price = new Itinerary.Price();
                    price.setAmount(priceValue);
                    itinerary.setPrice(price);
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                List<Itinerary.Leg> legs = new ArrayList<>();

                for (APIResponseBooking.FlightBound bound : flight.getBounds()) {
                    for (APIResponseBooking.PurpleSegment segment : bound.getSegments()) {
                        if (!"TripSegment".equals(segment.getTypename())) {
                            continue;
                        }
                        Itinerary.Leg leg = new Itinerary.Leg();
                        Itinerary.Carrier carrier = new Itinerary.Carrier();
                        carrier.setName(segment.getOperatingCarrier().getName());

                        List<Itinerary.Carrier> carriers = new ArrayList<>();
                        carriers.add(carrier);

                        leg.setOperatingCarriers(carriers);

                        if (segment.getOrigin() != null) {
                            leg.setOriginPlace(segment.getOrigin().getCityName());
                            leg.setDestinationPlace(segment.getDestination().getCityName());
                        }

                        LocalDateTime departureDateTime = null;
                        if (segment.getDeparturedAt() != null) {
                            departureDateTime = LocalDateTime.parse(segment.getDeparturedAt(), formatter);
                        }

                        LocalDateTime arrivalDateTime = null;
                        if (segment.getArrivedAt() != null) {
                            arrivalDateTime = LocalDateTime.parse(segment.getArrivedAt(), formatter);
                        }

                        leg.setDepartureDateTime(createItineraryDateTime(departureDateTime));
                        leg.setArrivalDateTime(createItineraryDateTime(arrivalDateTime));

                        legs.add(leg);
                    }
                }

                if (!legs.isEmpty()) {
                    itinerary.setLegs(legs);
                    itinerary.setDepartureDateTime(legs.get(0).getDepartureDateTime());
                    itinerary.setArrivalDateTime(legs.get(legs.size() - 1).getArrivalDateTime());

                }

                itineraries.add(itinerary);
            }
        }

        return itineraries;
    }

    private Itinerary.DateTime createItineraryDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }

        Itinerary.DateTime dateTimeItinerary = new Itinerary.DateTime();
        dateTimeItinerary.setYear(dateTime.getYear());
        dateTimeItinerary.setMonth(dateTime.getMonthValue());
        dateTimeItinerary.setDay(dateTime.getDayOfMonth());
        dateTimeItinerary.setHour(dateTime.getHour());
        dateTimeItinerary.setMinute(dateTime.getMinute());

        return dateTimeItinerary;
    }
}
