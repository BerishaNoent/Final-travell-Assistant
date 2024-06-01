package com.travelassitant.microservice.criteriabasedsearchservice.responses;

import java.util.List;
import java.util.Map;

public class ApiResponse {
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public static class Content {
        private Results results;

        public Results getResults() {
            return results;
        }

        public void setResults(Results results) {
            this.results = results;
        }
    }

    public static class Results {
        private Map<String, Leg> legs;
        private Map<String, Itinerary> itineraries;
        private Map<String, Place> places;
        private Map<String, Carrier> carriers;
        private Map<String, Agent> agents;

        public Map<String, Leg> getLegs() {
            return legs;
        }

        public void setLegs(Map<String, Leg> legs) {
            this.legs = legs;
        }

        public Map<String, Itinerary> getItineraries() {
            return itineraries;
        }

        public void setItineraries(Map<String, Itinerary> itineraries) {
            this.itineraries = itineraries;
        }

        public Map<String, Place> getPlaces() {
            return places;
        }

        public void setPlaces(Map<String, Place> places) {
            this.places = places;
        }

        public Map<String, Carrier> getCarriers() {
            return carriers;
        }

        public void setCarriers(Map<String, Carrier> carriers) {
            this.carriers = carriers;
        }

        public Map<String, Agent> getAgents() {
            return agents;
        }

        public void setAgents(Map<String, Agent> agents) {
            this.agents = agents;
        }
    }

    public static class Itinerary {
        private List<PricingOption> pricingOptions;
        private List<String> legIds;
        private List<String> agentIds;

        public List<PricingOption> getPricingOptions() {
            return pricingOptions;
        }

        public void setPricingOptions(List<PricingOption> pricingOptions) {
            this.pricingOptions = pricingOptions;
        }

        public List<String> getLegIds() {
            return legIds;
        }

        public void setLegIds(List<String> legIds) {
            this.legIds = legIds;
        }

        public List<String> getAgentIds() {
            return agentIds;
        }

        public void setAgentIds(List<String> agentIds) {
            this.agentIds = agentIds;
        }
    }

    public static class PricingOption {
        private Price price;
        private List<Item> items;
        private List<String> agentIds;

        public Price getPrice() {
            return price;
        }

        public void setPrice(Price price) {
            this.price = price;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }

        public List<String> getAgentIds() {
            return agentIds;
        }

        public void setAgentIds(List<String> agentIds) {
            this.agentIds = agentIds;
        }
    }

    public static class Price {
        private double amount;
        private String unit;

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }
    }

    public static class Item {
        private String deepLink;
        private String agentId;
        private Price price;

        public String getDeepLink() {
            return deepLink;
        }

        public void setDeepLink(String deepLink) {
            this.deepLink = deepLink;
        }

        public Price getPrice() {
            return price;
        }

        public void setPrice(Price price) {
            this.price = price;
        }

        public String getAgentId() {
            return agentId;
        }

        public void setAgentId(String agentId) {
            this.agentId = agentId;
        }
    }

    public static class Place {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Carrier {
        private String name;
        private String imageUrl;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }

    public static class Agent {
        private String name;
        private String imageUrl;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }

    public static class Leg {
        private String id;
        private String originPlaceId;
        private String destinationPlaceId;
        private DateTime departureDateTime;
        private DateTime arrivalDateTime;
        private int durationInMinutes;
        private int stopCount;
        private List<String> marketingCarrierIds;
        private List<String> operatingCarrierIds;
        private List<String> segmentIds;
        private String aircraftType;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOriginPlaceId() {
            return originPlaceId;
        }

        public void setOriginPlaceId(String originPlaceId) {
            this.originPlaceId = originPlaceId;
        }

        public String getDestinationPlaceId() {
            return destinationPlaceId;
        }

        public void setDestinationPlaceId(String destinationPlaceId) {
            this.destinationPlaceId = destinationPlaceId;
        }

        public DateTime getDepartureDateTime() {
            return departureDateTime;
        }

        public void setDepartureDateTime(DateTime departureDateTime) {
            this.departureDateTime = departureDateTime;
        }

        public DateTime getArrivalDateTime() {
            return arrivalDateTime;
        }

        public void setArrivalDateTime(DateTime arrivalDateTime) {
            this.arrivalDateTime = arrivalDateTime;
        }

        public int getDurationInMinutes() {
            return durationInMinutes;
        }

        public void setDurationInMinutes(int durationInMinutes) {
            this.durationInMinutes = durationInMinutes;
        }

        public int getStopCount() {
            return stopCount;
        }

        public void setStopCount(int stopCount) {
            this.stopCount = stopCount;
        }

        public List<String> getMarketingCarrierIds() {
            return marketingCarrierIds;
        }

        public void setMarketingCarrierIds(List<String> marketingCarrierIds) {
            this.marketingCarrierIds = marketingCarrierIds;
        }

        public List<String> getOperatingCarrierIds() {
            return operatingCarrierIds;
        }

        public void setOperatingCarrierIds(List<String> operatingCarrierIds) {
            this.operatingCarrierIds = operatingCarrierIds;
        }

        public List<String> getSegmentIds() {
            return segmentIds;
        }

        public void setSegmentIds(List<String> segmentIds) {
            this.segmentIds = segmentIds;
        }

        public String getAircraftType() {
            return aircraftType;
        }

        public void setAircraftType(String aircraftType) {
            this.aircraftType = aircraftType;
        }
    }

    public static class DateTime {
        private int year;
        private int month;
        private int day;
        private int hour;
        private int minute;
        private int second;

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }
    }
}
