package com.travelassitant.microservice.usermanagementservice.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "countries")
public class Country {
    @Id
    private String id;
    private String name;
    @JsonProperty("Cities")
    private List<City> cities = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public static class City {
        @JsonProperty("Location")
        private String location;
        @JsonProperty("Airport")
        private String airport;
        @JsonProperty("IATA_Code")
        private String iataCode;
        @JsonProperty("Airports")
        private List<Airport> airports = new ArrayList<>();

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getAirport() {
            return airport;
        }

        public void setAirport(String airport) {
            this.airport = airport;
        }

        public String getIataCode() {
            return iataCode;
        }

        public void setIataCode(String iataCode) {
            this.iataCode = iataCode;
        }

        public List<Airport> getAirports() {
            return airports;
        }

        public void setAirports(List<Airport> airports) {
            this.airports = airports;
        }
    }

    public static class Airport {
        @JsonProperty("Name")
        private String name;
        @JsonProperty("IATA_Code")
        private String iataCode;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIataCode() {
            return iataCode;
        }

        public void setIataCode(String iataCode) {
            this.iataCode = iataCode;
        }
    }
}