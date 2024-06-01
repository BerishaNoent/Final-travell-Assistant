package com.travelassitant.microservice.criteriabasedsearchservice.responses;

import java.util.List;
import java.util.Map;

public class APIResponseTripAdvisor {

    private FlightSearchData data;

    public FlightSearchData getData() {
        return data;
    }

    public void setData(FlightSearchData data) {
        this.data = data;
    }

    public static class FlightSearchData {
        private FlightSearchSession session;
        private boolean complete;
        private int numOfFilters;
        private int totalNumResults;
        private List<Flight> flights;

        public FlightSearchSession getSession() {
            return session;
        }

        public void setSession(FlightSearchSession session) {
            this.session = session;
        }

        public boolean isComplete() {
            return complete;
        }

        public void setComplete(boolean complete) {
            this.complete = complete;
        }

        public int getNumOfFilters() {
            return numOfFilters;
        }

        public void setNumOfFilters(int numOfFilters) {
            this.numOfFilters = numOfFilters;
        }

        public int getTotalNumResults() {
            return totalNumResults;
        }

        public void setTotalNumResults(int totalNumResults) {
            this.totalNumResults = totalNumResults;
        }

        public List<Flight> getFlights() {
            return flights;
        }

        public void setFlights(List<Flight> flights) {
            this.flights = flights;
        }
    }

    public static class FlightSearchSession {
        private String searchHash;
        private String pageLoadUid;
        private String searchId;
        private Map<String, String> filterSettings;

        public String getSearchHash() {
            return searchHash;
        }

        public void setSearchHash(String searchHash) {
            this.searchHash = searchHash;
        }

        public String getPageLoadUid() {
            return pageLoadUid;
        }

        public void setPageLoadUid(String pageLoadUid) {
            this.pageLoadUid = pageLoadUid;
        }

        public String getSearchId() {
            return searchId;
        }

        public void setSearchId(String searchId) {
            this.searchId = searchId;
        }

        public Map<String, String> getFilterSettings() {
            return filterSettings;
        }

        public void setFilterSettings(Map<String, String> filterSettings) {
            this.filterSettings = filterSettings;
        }
    }

    public static class Flight {
        private List<FlightSegment> segments;
        private List<PurchaseLink> purchaseLinks;
        private ItineraryTag itineraryTag;

        public List<FlightSegment> getSegments() {
            return segments;
        }

        public void setSegments(List<FlightSegment> segments) {
            this.segments = segments;
        }

        public List<PurchaseLink> getPurchaseLinks() {
            return purchaseLinks;
        }

        public void setPurchaseLinks(List<PurchaseLink> purchaseLinks) {
            this.purchaseLinks = purchaseLinks;
        }

        public ItineraryTag getItineraryTag() {
            return itineraryTag;
        }

        public void setItineraryTag(ItineraryTag itineraryTag) {
            this.itineraryTag = itineraryTag;
        }
    }

    public static class FlightSegment {
        private List<FlightLeg> legs;
        private List<Layover> layovers;

        public List<FlightLeg> getLegs() {
            return legs;
        }

        public void setLegs(List<FlightLeg> legs) {
            this.legs = legs;
        }

        public List<Layover> getLayovers() {
            return layovers;
        }

        public void setLayovers(List<Layover> layovers) {
            this.layovers = layovers;
        }
    }

    public static class FlightLeg {
        private String originStationCode;
        private boolean differentOriginStation;
        private String destinationStationCode;
        private boolean differentDestinationStation;
        private String departureDateTime;
        private String arrivalDateTime;
        private String classOfService;
        private String marketingCarrierCode;
        private String operatingCarrierCode;
        private String equipmentId;
        private List<Object> amenities;
        private int flightNumber;
        private int seatGuruEquipmentId;
        private String seatGuruAirlineUrl;
        private int numStops;
        private double distanceInKM;
        private boolean international;
        private boolean selfTransfer;
        private Carrier operatingCarrier;
        private Carrier marketingCarrier;

        public String getOriginStationCode() {
            return originStationCode;
        }

        public void setOriginStationCode(String originStationCode) {
            this.originStationCode = originStationCode;
        }

        public boolean isDifferentOriginStation() {
            return differentOriginStation;
        }

        public void setDifferentOriginStation(boolean differentOriginStation) {
            this.differentOriginStation = differentOriginStation;
        }

        public String getDestinationStationCode() {
            return destinationStationCode;
        }

        public void setDestinationStationCode(String destinationStationCode) {
            this.destinationStationCode = destinationStationCode;
        }

        public boolean isDifferentDestinationStation() {
            return differentDestinationStation;
        }

        public void setDifferentDestinationStation(boolean differentDestinationStation) {
            this.differentDestinationStation = differentDestinationStation;
        }

        public String getDepartureDateTime() {
            return departureDateTime;
        }

        public void setDepartureDateTime(String departureDateTime) {
            this.departureDateTime = departureDateTime;
        }

        public String getArrivalDateTime() {
            return arrivalDateTime;
        }

        public void setArrivalDateTime(String arrivalDateTime) {
            this.arrivalDateTime = arrivalDateTime;
        }

        public String getClassOfService() {
            return classOfService;
        }

        public void setClassOfService(String classOfService) {
            this.classOfService = classOfService;
        }

        public String getMarketingCarrierCode() {
            return marketingCarrierCode;
        }

        public void setMarketingCarrierCode(String marketingCarrierCode) {
            this.marketingCarrierCode = marketingCarrierCode;
        }

        public String getOperatingCarrierCode() {
            return operatingCarrierCode;
        }

        public void setOperatingCarrierCode(String operatingCarrierCode) {
            this.operatingCarrierCode = operatingCarrierCode;
        }

        public String getEquipmentId() {
            return equipmentId;
        }

        public void setEquipmentId(String equipmentId) {
            this.equipmentId = equipmentId;
        }

        public List<Object> getAmenities() {
            return amenities;
        }

        public void setAmenities(List<Object> amenities) {
            this.amenities = amenities;
        }

        public int getFlightNumber() {
            return flightNumber;
        }

        public void setFlightNumber(int flightNumber) {
            this.flightNumber = flightNumber;
        }

        public int getSeatGuruEquipmentId() {
            return seatGuruEquipmentId;
        }

        public void setSeatGuruEquipmentId(int seatGuruEquipmentId) {
            this.seatGuruEquipmentId = seatGuruEquipmentId;
        }

        public String getSeatGuruAirlineUrl() {
            return seatGuruAirlineUrl;
        }

        public void setSeatGuruAirlineUrl(String seatGuruAirlineUrl) {
            this.seatGuruAirlineUrl = seatGuruAirlineUrl;
        }

        public int getNumStops() {
            return numStops;
        }

        public void setNumStops(int numStops) {
            this.numStops = numStops;
        }

        public double getDistanceInKM() {
            return distanceInKM;
        }

        public void setDistanceInKM(double distanceInKM) {
            this.distanceInKM = distanceInKM;
        }

        public boolean isInternational() {
            return international;
        }

        public void setInternational(boolean international) {
            this.international = international;
        }

        public boolean isSelfTransfer() {
            return selfTransfer;
        }

        public void setSelfTransfer(boolean selfTransfer) {
            this.selfTransfer = selfTransfer;
        }

        public Carrier getOperatingCarrier() {
            return operatingCarrier;
        }

        public void setOperatingCarrier(Carrier operatingCarrier) {
            this.operatingCarrier = operatingCarrier;
        }

        public Carrier getMarketingCarrier() {
            return marketingCarrier;
        }

        public void setMarketingCarrier(Carrier marketingCarrier) {
            this.marketingCarrier = marketingCarrier;
        }

    }

    public static class Layover {
        private String durationType;
        private boolean hasStationChange;
        private int durationInMinutes;

        public String getDurationType() {
            return durationType;
        }

        public void setDurationType(String durationType) {
            this.durationType = durationType;
        }

        public boolean isHasStationChange() {
            return hasStationChange;
        }

        public void setHasStationChange(boolean hasStationChange) {
            this.hasStationChange = hasStationChange;
        }

        public int getDurationInMinutes() {
            return durationInMinutes;
        }

        public void setDurationInMinutes(int durationInMinutes) {
            this.durationInMinutes = durationInMinutes;
        }
    }

    public static class Carrier {
        private int locationId;
        private String code;
        private String logoUrl;
        private String displayName;

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public int getLocationId() {
            return locationId;
        }

        public void setLocationId(int locationId) {
            this.locationId = locationId;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

    }

    public static class PurchaseLink {
        private String purchaseLinkId;
        private String providerId;
        private PartnerSuppliedProvider partnerSuppliedProvider;
        private String commerceName;
        private String currency;
        private String originalCurrency;
        private int seatAvailability;
        private double taxesAndFees;
        private double taxesAndFeesPerPassenger;
        private double totalPrice;
        private double totalPricePerPassenger;
        private List<Object> fareBasisCodes;
        private List<PurchaseLink> containedPurchaseLinks;
        private Map<String, Object> partnerData;
        private boolean paid;
        private List<Object> fareAttributesList;
        private String url;

        public String getPurchaseLinkId() {
            return purchaseLinkId;
        }

        public void setPurchaseLinkId(String purchaseLinkId) {
            this.purchaseLinkId = purchaseLinkId;
        }

        public String getProviderId() {
            return providerId;
        }

        public void setProviderId(String providerId) {
            this.providerId = providerId;
        }

        public PartnerSuppliedProvider getPartnerSuppliedProvider() {
            return partnerSuppliedProvider;
        }

        public void setPartnerSuppliedProvider(PartnerSuppliedProvider partnerSuppliedProvider) {
            this.partnerSuppliedProvider = partnerSuppliedProvider;
        }

        public String getCommerceName() {
            return commerceName;
        }

        public void setCommerceName(String commerceName) {
            this.commerceName = commerceName;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getOriginalCurrency() {
            return originalCurrency;
        }

        public void setOriginalCurrency(String originalCurrency) {
            this.originalCurrency = originalCurrency;
        }

        public int getSeatAvailability() {
            return seatAvailability;
        }

        public void setSeatAvailability(int seatAvailability) {
            this.seatAvailability = seatAvailability;
        }

        public double getTaxesAndFees() {
            return taxesAndFees;
        }

        public void setTaxesAndFees(double taxesAndFees) {
            this.taxesAndFees = taxesAndFees;
        }

        public double getTaxesAndFeesPerPassenger() {
            return taxesAndFeesPerPassenger;
        }

        public void setTaxesAndFeesPerPassenger(double taxesAndFeesPerPassenger) {
            this.taxesAndFeesPerPassenger = taxesAndFeesPerPassenger;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public double getTotalPricePerPassenger() {
            return totalPricePerPassenger;
        }

        public void setTotalPricePerPassenger(double totalPricePerPassenger) {
            this.totalPricePerPassenger = totalPricePerPassenger;
        }

        public List<Object> getFareBasisCodes() {
            return fareBasisCodes;
        }

        public void setFareBasisCodes(List<Object> fareBasisCodes) {
            this.fareBasisCodes = fareBasisCodes;
        }

        public List<PurchaseLink> getContainedPurchaseLinks() {
            return containedPurchaseLinks;
        }

        public void setContainedPurchaseLinks(List<PurchaseLink> containedPurchaseLinks) {
            this.containedPurchaseLinks = containedPurchaseLinks;
        }

        public Map<String, Object> getPartnerData() {
            return partnerData;
        }

        public void setPartnerData(Map<String, Object> partnerData) {
            this.partnerData = partnerData;
        }

        public boolean isPaid() {
            return paid;
        }

        public void setPaid(boolean paid) {
            this.paid = paid;
        }

        public List<Object> getFareAttributesList() {
            return fareAttributesList;
        }

        public void setFareAttributesList(List<Object> fareAttributesList) {
            this.fareAttributesList = fareAttributesList;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class PartnerSuppliedProvider {
        private String id;
        private String displayName;
        private String logoUrl;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

    }

    public static class ItineraryTag {
        private String tag;
        private String type;

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}