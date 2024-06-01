package com.travelassitant.microservice.criteriabasedsearchservice.repositories;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.travelassitant.microservice.criteriabasedsearchservice.bean.Itinerary;
import com.travelassitant.microservice.criteriabasedsearchservice.request.RequestBodytemp;
import com.travelassitant.microservice.criteriabasedsearchservice.responses.APIResponseTripAdvisor;

@Repository
public class ApiRepository2 {

    public Map<String, Object> getFlightInfo(RequestBodytemp requestBody) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "08d94f2f42mshecc916a55f33eacp1e93bbjsn71558a283d3d");
        headers.set("X-RapidAPI-Host", "tripadvisor16.p.rapidapi.com");

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl("https://tripadvisor16.p.rapidapi.com/api/v1/flights/searchFlights")
                .queryParam("sourceAirportCode", requestBody.getOrigin())
                .queryParam("destinationAirportCode", requestBody.getDestination())
                .queryParam("date", requestBody.getDate())
                .queryParam("itineraryType", requestBody.isReturnTicket() ? "ROUND_TRIP" : "ONE_WAY")
                .queryParam("sortOrder", "PRICE")
                .queryParam("numAdults", requestBody.getAdults())
                .queryParam("numSeniors", requestBody.getChildren())
                .queryParam("classOfService", "ECONOMY");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<APIResponseTripAdvisor> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                APIResponseTripAdvisor.class);

        APIResponseTripAdvisor apiResponse = response.getBody();

        List<Itinerary> itineraries = mapApiResponseToFlightDetails(apiResponse, requestBody.getOriginName(),
                requestBody.getDestinationName());

        Map<String, Object> result = new HashMap<>();
        result.put("flightDetailsList", itineraries);

        return result;
    }

    public List<Itinerary> mapApiResponseToFlightDetails(APIResponseTripAdvisor apiResponse, String originName,
            String destinationName) {
        List<Itinerary> itineraryList = new ArrayList<>();

        for (APIResponseTripAdvisor.Flight flight : apiResponse.getData().getFlights()) {
            Itinerary itinerary = new Itinerary();

            itinerary.setOriginPlace(originName);
            itinerary.setDestinationPlace(destinationName);

            if (!flight.getPurchaseLinks().isEmpty()) {
                APIResponseTripAdvisor.PurchaseLink firstPurchaseLink = flight.getPurchaseLinks().get(0);
                if (firstPurchaseLink != null) {
                    String deepLink = firstPurchaseLink.getUrl();
                    itinerary.setDeeplink(deepLink);
                }
            }

            Itinerary.Price price = new Itinerary.Price();
            if (!flight.getPurchaseLinks().isEmpty()) {
                price.setAmount(flight.getPurchaseLinks().get(0).getTotalPrice());
                price.setUnit("USD");
                itinerary.setPrice(price);
            }

            List<Itinerary.Leg> itineraryLegs = new ArrayList<>();
            for (APIResponseTripAdvisor.FlightSegment segment : flight.getSegments()) {
                for (APIResponseTripAdvisor.FlightLeg leg : segment.getLegs()) {
                    List<Itinerary.Carrier> operatingCarriers = new ArrayList<>();
                    Itinerary.Leg itineraryLeg = new Itinerary.Leg();
                    itineraryLeg.setOriginPlace(leg.getOriginStationCode());
                    itineraryLeg.setDestinationPlace(leg.getDestinationStationCode());
                    Itinerary.Carrier itineraryCarrier = new Itinerary.Carrier();
                    itineraryCarrier.setName(leg.getOperatingCarrier().getDisplayName());
                    itineraryCarrier.setImageUrl(leg.getOperatingCarrier().getLogoUrl());

                    operatingCarriers.add(itineraryCarrier);

                    Itinerary.DateTime departureItineraryDateTime = new Itinerary.DateTime();
                    departureItineraryDateTime.setDateTime(leg.getDepartureDateTime());

                    Itinerary.DateTime arrivalItineraryDateTime = new Itinerary.DateTime();
                    arrivalItineraryDateTime.setDateTime(leg.getArrivalDateTime());

                    itineraryLeg.setDepartureDateTime(departureItineraryDateTime);
                    itineraryLeg.setArrivalDateTime(arrivalItineraryDateTime);
                    itineraryLeg.setOperatingCarriers(operatingCarriers);

                    itineraryLegs.add(itineraryLeg);
                }

                if (!itineraryLegs.isEmpty()) {
                    Itinerary.DateTime departureItineraryDateTime = itineraryLegs.get(0).getDepartureDateTime();
                    Itinerary.DateTime arrivalItineraryDateTime = itineraryLegs.get(itineraryLegs.size() - 1)
                            .getArrivalDateTime();

                    itinerary.setDepartureDateTime(departureItineraryDateTime);
                    itinerary.setArrivalDateTime(arrivalItineraryDateTime);
                }

                itinerary.setLegs(itineraryLegs);
                break;
            }

            if (!flight.getPurchaseLinks().isEmpty()) {
                APIResponseTripAdvisor.PurchaseLink purchaseLink = flight.getPurchaseLinks().get(0);
                Itinerary.Agent itineraryAgent = new Itinerary.Agent();
                itineraryAgent.setName(purchaseLink.getProviderId());
                itineraryAgent.setImageUrl(purchaseLink.getPartnerSuppliedProvider().getLogoUrl());
                List<Itinerary.Agent> agents = new ArrayList<>();
                agents.add(itineraryAgent);
                itinerary.setAgents(agents);
            }

            itineraryList.add(itinerary);
        }

        return itineraryList;
    }

}