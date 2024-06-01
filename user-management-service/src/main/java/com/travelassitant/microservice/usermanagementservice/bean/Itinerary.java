package com.travelassitant.microservice.usermanagementservice.bean;

import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.security.MessageDigest;

@Document
public class Itinerary {
    @Id
    @JsonProperty("Id")
    private String id;
    private String originPlace;
    private String destinationPlace;
    private DateTime departureDateTime;
    private DateTime arrivalDateTime;

    private List<Leg> legs;
    private List<Agent> agents;
    private List<Carrier> carriers;
    private Price price;
    private String deeplink;
    private String userId;
    private String contentHash;

    public String calculateContentHash() {
        StringBuilder content = new StringBuilder();
        content.append(originPlace);
        content.append(destinationPlace);
        content.append(deeplink);

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(content.toString().getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getContentHash() {
        return contentHash;
    }

    public void setContentHash(String contentHash) {
        this.contentHash = contentHash;
    }

    public List<Carrier> getCarriers() {
        return carriers;
    }

    public void setCarriers(List<Carrier> carriers) {
        this.carriers = carriers;
    }

    public String getOriginPlace() {
        return originPlace;
    }

    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }

    public String getDestinationPlace() {
        return destinationPlace;
    }

    public void setDestinationPlace(String destinationPlace) {
        this.destinationPlace = destinationPlace;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public Itinerary() {
        this.legs = new ArrayList<>();
        this.agents = new ArrayList<>();
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
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

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

    public static class Segment {
        private String originPlace;
        private String destinationPlace;
        private DateTime departureDateTime;
        private DateTime arrivalDateTime;
        private Carrier operatingCarrier;

        public String getOriginPlace() {
            return originPlace;
        }

        public void setOriginPlace(String originPlace) {
            this.originPlace = originPlace;
        }

        public String getDestinationPlace() {
            return destinationPlace;
        }

        public void setDestinationPlace(String destinationPlace) {
            this.destinationPlace = destinationPlace;
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

        public Carrier getOperatingCarrier() {
            return operatingCarrier;
        }

        public void setOperatingCarrier(Carrier operatingCarrier) {
            this.operatingCarrier = operatingCarrier;
        }

    }

    public static class Leg {
        private String originPlace;
        private int stopCount;
        private String destinationPlace;
        private DateTime departureDateTime;
        private DateTime arrivalDateTime;

        private List<Carrier> operatingCarriers;

        private List<Segment> segments;

        public int getStopCount() {
            return stopCount;
        }

        public void setStopCount(int stopCount) {
            this.stopCount = stopCount;
        }

        public List<Segment> getSegments() {
            return segments;
        }

        public void setSegments(List<Segment> segments) {
            this.segments = segments;
        }

        public Leg() {
        }

        public String getOriginPlace() {
            return originPlace;
        }

        public void setOriginPlace(String originPlace) {
            this.originPlace = originPlace;
        }

        public String getDestinationPlace() {
            return destinationPlace;
        }

        public void setDestinationPlace(String destinationPlace) {
            this.destinationPlace = destinationPlace;
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

        public List<Carrier> getOperatingCarriers() {
            return operatingCarriers;
        }

        public void setOperatingCarriers(List<Carrier> operatingCarriers) {
            this.operatingCarriers = operatingCarriers;
        }
    }

    public static class DateTime {
        private int year;
        private int month;
        private int day;
        private int hour;
        private int minute;
        private int second;

        @Override
        public String toString() {
            return "DateTime [year=" + year + ", month=" + month + ", day=" + day + ", hour=" + hour + ", minute="
                    + minute + ", second=" + second + "]";
        }

        public void setDateTime(String dateTimeStr) {
            ZonedDateTime zdt = ZonedDateTime.parse(dateTimeStr, DateTimeFormatter.ISO_DATE_TIME);
            this.year = zdt.getYear();
            this.month = zdt.getMonthValue();
            this.day = zdt.getDayOfMonth();
            this.hour = zdt.getHour();
            this.minute = zdt.getMinute();
            this.second = zdt.getSecond();
        }

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

        public String getHour() {
            return String.format("%02d", hour);
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
