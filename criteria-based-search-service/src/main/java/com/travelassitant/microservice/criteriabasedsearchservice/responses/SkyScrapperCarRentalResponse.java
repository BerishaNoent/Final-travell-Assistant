package com.travelassitant.microservice.criteriabasedsearchservice.responses;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

public class SkyScrapperCarRentalResponse {
    private boolean status;
    private long timestamp;
    private Data data;

    @JsonProperty("status")
    public boolean getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(boolean value) {
        this.status = value;
    }

    @JsonProperty("timestamp")
    public long getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(long value) {
        this.timestamp = value;
    }

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data value) {
        this.data = value;
    }

    public static class Data {
        private List<Quote> quotes;
        private long quotesCount;

        private Providers providers;
        private Query query;

        @JsonProperty("quotes")
        public List<Quote> getQuotes() {
            return quotes;
        }

        @JsonProperty("quotes")
        public void setQuotes(List<Quote> value) {
            this.quotes = value;
        }

        @JsonProperty("quotes_count")
        public long getQuotesCount() {
            return quotesCount;
        }

        @JsonProperty("quotes_count")
        public void setQuotesCount(long value) {
            this.quotesCount = value;
        }

        @JsonProperty("providers")
        public Providers getProviders() {
            return providers;
        }

        @JsonProperty("providers")
        public void setProviders(Providers value) {
            this.providers = value;
        }

        @JsonProperty("query")
        public Query getQuery() {
            return query;
        }

        @JsonProperty("query")
        public void setQuery(Query value) {
            this.query = value;
        }

    }

    public static class Providers {
        private Map<String, Acrc> providers;

        public Acrc getProvider(String name) {
            return providers.get(name);
        }

        public void setProvider(String name, Acrc provider) {
            providers.put(name, provider);
        }
    }

    public static class Acrc {
        private double rating;
        private boolean optimisedForMobile;
        private long reviews;
        private boolean facilitatedBookingEnabled;
        private String providerName;
        private boolean errored;
        private boolean inProgress;

        @JsonProperty("rating")
        public double getRating() {
            return rating;
        }

        @JsonProperty("rating")
        public void setRating(double value) {
            this.rating = value;
        }

        @JsonProperty("optimised_for_mobile")
        public boolean getOptimisedForMobile() {
            return optimisedForMobile;
        }

        @JsonProperty("optimised_for_mobile")
        public void setOptimisedForMobile(boolean value) {
            this.optimisedForMobile = value;
        }

        @JsonProperty("reviews")
        public long getReviews() {
            return reviews;
        }

        @JsonProperty("reviews")
        public void setReviews(long value) {
            this.reviews = value;
        }

        @JsonProperty("facilitated_booking_enabled")
        public boolean getFacilitatedBookingEnabled() {
            return facilitatedBookingEnabled;
        }

        @JsonProperty("facilitated_booking_enabled")
        public void setFacilitatedBookingEnabled(boolean value) {
            this.facilitatedBookingEnabled = value;
        }

        @JsonProperty("provider_name")
        public String getProviderName() {
            return providerName;
        }

        @JsonProperty("provider_name")
        public void setProviderName(String value) {
            this.providerName = value;
        }

        @JsonProperty("errored")
        public boolean getErrored() {
            return errored;
        }

        @JsonProperty("errored")
        public void setErrored(boolean value) {
            this.errored = value;
        }

        @JsonProperty("in_progress")
        public boolean getInProgress() {
            return inProgress;
        }

        @JsonProperty("in_progress")
        public void setInProgress(boolean value) {
            this.inProgress = value;
        }
    }

    public static class Query {
        private String lang;
        private String doDt;
        private String ccy;
        private long age;
        private String puDt;
        private String ucy;
        private String chnl;

        @JsonProperty("lang")
        public String getLang() {
            return lang;
        }

        @JsonProperty("lang")
        public void setLang(String value) {
            this.lang = value;
        }

        @JsonProperty("do_dt")
        public String getDoDt() {
            return doDt;
        }

        @JsonProperty("do_dt")
        public void setDoDt(String value) {
            this.doDt = value;
        }

        @JsonProperty("ccy")
        public String getCcy() {
            return ccy;
        }

        @JsonProperty("ccy")
        public void setCcy(String value) {
            this.ccy = value;
        }

        @JsonProperty("age")
        public long getAge() {
            return age;
        }

        @JsonProperty("age")
        public void setAge(long value) {
            this.age = value;
        }

        @JsonProperty("pu_dt")
        public String getPuDt() {
            return puDt;
        }

        @JsonProperty("pu_dt")
        public void setPuDt(String value) {
            this.puDt = value;
        }

        @JsonProperty("ucy")
        public String getUcy() {
            return ucy;
        }

        @JsonProperty("ucy")
        public void setUcy(String value) {
            this.ucy = value;
        }

        @JsonProperty("chnl")
        public String getChnl() {
            return chnl;
        }

        @JsonProperty("chnl")
        public void setChnl(String value) {
            this.chnl = value;
        }
    }

    public static class Quote {
        private String fuelPol;
        private String sipp;
        private long puRnid;
        private String guid;
        private String bookingPanelOptionguid;
        private String pickupType;
        private String pu;
        private double score;
        private double newScore;
        private long vndrid;
        private String vndr;
        private String quoteDo;
        private long bags;
        private double price;
        private String payType;
        private String prvid;
        private String carName;
        private String originalCarName;
        private String group;
        private String dplnk;
        private long doRnid;
        private String pickupMethod;
        private String fuelType;
        private String officeid;
        private long seat;
        private VndrRating vndrRating;

        @JsonProperty("fuel_pol")
        public String getFuelPol() {
            return fuelPol;
        }

        @JsonProperty("fuel_pol")
        public void setFuelPol(String value) {
            this.fuelPol = value;
        }

        @JsonProperty("sipp")
        public String getSipp() {
            return sipp;
        }

        @JsonProperty("sipp")
        public void setSipp(String value) {
            this.sipp = value;
        }

        @JsonProperty("pu_rn_id")
        public long getPuRnid() {
            return puRnid;
        }

        @JsonProperty("pu_rn_id")
        public void setPuRnid(long value) {
            this.puRnid = value;
        }

        @JsonProperty("guid")
        public String getguid() {
            return guid;
        }

        @JsonProperty("guid")
        public void setguid(String value) {
            this.guid = value;
        }

        @JsonProperty("booking_panel_option_guid")
        public String getBookingPanelOptionguid() {
            return bookingPanelOptionguid;
        }

        @JsonProperty("booking_panel_option_guid")
        public void setBookingPanelOptionguid(String value) {
            this.bookingPanelOptionguid = value;
        }

        @JsonProperty("pickup_type")
        public String getPickupType() {
            return pickupType;
        }

        @JsonProperty("pickup_type")
        public void setPickupType(String value) {
            this.pickupType = value;
        }

        @JsonProperty("pu")
        public String getPu() {
            return pu;
        }

        @JsonProperty("pu")
        public void setPu(String value) {
            this.pu = value;
        }

        @JsonProperty("score")
        public double getScore() {
            return score;
        }

        @JsonProperty("score")
        public void setScore(double value) {
            this.score = value;
        }

        @JsonProperty("new_score")
        public double getNewScore() {
            return newScore;
        }

        @JsonProperty("new_score")
        public void setNewScore(double value) {
            this.newScore = value;
        }

        @JsonProperty("vndr_id")
        public long getVndrid() {
            return vndrid;
        }

        @JsonProperty("vndr_id")
        public void setVndrid(long value) {
            this.vndrid = value;
        }

        @JsonProperty("vndr")
        public String getVndr() {
            return vndr;
        }

        @JsonProperty("vndr")
        public void setVndr(String value) {
            this.vndr = value;
        }

        @JsonProperty("do")
        public String getQuoteDo() {
            return quoteDo;
        }

        @JsonProperty("do")
        public void setQuoteDo(String value) {
            this.quoteDo = value;
        }

        @JsonProperty("bags")
        public long getBags() {
            return bags;
        }

        @JsonProperty("bags")
        public void setBags(long value) {
            this.bags = value;
        }

        @JsonProperty("price")
        public double getPrice() {
            return price;
        }

        @JsonProperty("price")
        public void setPrice(double value) {
            this.price = value;
        }

        @JsonProperty("pay_type")
        public String getPayType() {
            return payType;
        }

        @JsonProperty("pay_type")
        public void setPayType(String value) {
            this.payType = value;
        }

        @JsonProperty("prv_id")
        public String getPrvid() {
            return prvid;
        }

        @JsonProperty("prv_id")
        public void setPrvid(String value) {
            this.prvid = value;
        }

        @JsonProperty("car_name")
        public String getCarName() {
            return carName;
        }

        @JsonProperty("car_name")
        public void setCarName(String value) {
            this.carName = value;
        }

        @JsonProperty("original_car_name")
        public String getOriginalCarName() {
            return originalCarName;
        }

        @JsonProperty("original_car_name")
        public void setOriginalCarName(String value) {
            this.originalCarName = value;
        }

        @JsonProperty("group")
        public String getGroup() {
            return group;
        }

        @JsonProperty("group")
        public void setGroup(String value) {
            this.group = value;
        }

        @JsonProperty("dplnk")
        public String getDplnk() {
            return dplnk;
        }

        @JsonProperty("dplnk")
        public void setDplnk(String value) {
            this.dplnk = value;
        }

        @JsonProperty("do_rn_id")
        public long getDoRnid() {
            return doRnid;
        }

        @JsonProperty("do_rn_id")
        public void setDoRnid(long value) {
            this.doRnid = value;
        }

        @JsonProperty("pickup_method")
        public String getPickupMethod() {
            return pickupMethod;
        }

        @JsonProperty("pickup_method")
        public void setPickupMethod(String value) {
            this.pickupMethod = value;
        }

        @JsonProperty("fuel_type")
        public String getFuelType() {
            return fuelType;
        }

        @JsonProperty("fuel_type")
        public void setFuelType(String value) {
            this.fuelType = value;
        }

        @JsonProperty("office_id")
        public String getOfficeid() {
            return officeid;
        }

        @JsonProperty("office_id")
        public void setOfficeid(String value) {
            this.officeid = value;
        }

        @JsonProperty("seat")
        public long getSeat() {
            return seat;
        }

        @JsonProperty("seat")
        public void setSeat(long value) {
            this.seat = value;
        }

        @JsonProperty("vndr_rating")
        public VndrRating getVndrRating() {
            return vndrRating;
        }

        @JsonProperty("vndr_rating")
        public void setVndrRating(VndrRating value) {
            this.vndrRating = value;
        }
    }

    public static class VndrRating {
        private double overallRating;
        private double carCondition;
        private double carsKeptClean;
        private double easyPickup;
        private double service;
        private String ratingType;
        private String ratingDesc;

        @JsonProperty("overall_rating")
        public double getOverallRating() {
            return overallRating;
        }

        @JsonProperty("overall_rating")
        public void setOverallRating(double value) {
            this.overallRating = value;
        }

        @JsonProperty("car_condition")
        public double getCarCondition() {
            return carCondition;
        }

        @JsonProperty("car_condition")
        public void setCarCondition(double value) {
            this.carCondition = value;
        }

        @JsonProperty("cars_kept_clean")
        public double getCarsKeptClean() {
            return carsKeptClean;
        }

        @JsonProperty("cars_kept_clean")
        public void setCarsKeptClean(double value) {
            this.carsKeptClean = value;
        }

        @JsonProperty("easy_pickup")
        public double getEasyPickup() {
            return easyPickup;
        }

        @JsonProperty("easy_pickup")
        public void setEasyPickup(double value) {
            this.easyPickup = value;
        }

        @JsonProperty("service")
        public double getService() {
            return service;
        }

        @JsonProperty("service")
        public void setService(double value) {
            this.service = value;
        }

        @JsonProperty("rating_type")
        public String getRatingType() {
            return ratingType;
        }

        @JsonProperty("rating_type")
        public void setRatingType(String value) {
            this.ratingType = value;
        }

        @JsonProperty("rating_desc")
        public String getRatingDesc() {
            return ratingDesc;
        }

        @JsonProperty("rating_desc")
        public void setRatingDesc(String value) {
            this.ratingDesc = value;
        }
    }

}