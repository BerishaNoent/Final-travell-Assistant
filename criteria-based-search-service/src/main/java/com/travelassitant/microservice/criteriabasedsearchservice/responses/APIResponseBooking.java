package com.travelassitant.microservice.criteriabasedsearchservice.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.*;

public class APIResponseBooking {
    private long currentPage;
    private Data data;
    private String message;
    private long resultsPerPage;
    private boolean status;
    private long totalPages;
    private long totalResultCount;

    @JsonProperty("currentPage")
    public long getCurrentPage() {
        return currentPage;
    }

    @JsonProperty("currentPage")
    public void setCurrentPage(long value) {
        this.currentPage = value;
    }

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data value) {
        this.data = value;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String value) {
        this.message = value;
    }

    @JsonProperty("resultsPerPage")
    public long getResultsPerPage() {
        return resultsPerPage;
    }

    @JsonProperty("resultsPerPage")
    public void setResultsPerPage(long value) {
        this.resultsPerPage = value;
    }

    @JsonProperty("status")
    public boolean getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(boolean value) {
        this.status = value;
    }

    @JsonProperty("totalPages")
    public long getTotalPages() {
        return totalPages;
    }

    @JsonProperty("totalPages")
    public void setTotalPages(long value) {
        this.totalPages = value;
    }

    @JsonProperty("totalResultCount")
    public long getTotalResultCount() {
        return totalResultCount;
    }

    @JsonProperty("totalResultCount")
    public void setTotalResultCount(long value) {
        this.totalResultCount = value;
    }

    public static class Data {
        private String typename;
        private List<Object> availableFilters;
        private List<AvailableSortType> availableSortTypes;
        private List<Object> carrierCodes;
        private List<Object> carrierNames;
        private long filteredFlightsCount;
        private List<Flight> flights;
        private long flightsCount;
        private QuickSortPrices quickSortPrices;
        private ResultSetMetaData resultSetMetaData;
        private List<Route> routes;
        private String searchPath;
        private List<SponsoredTrip> sponsoredTrips;
        private List<Traveler> travelers;
        private List<Object> tripCampaigns;
        private String type;
        private boolean validWithVoucher;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("availableFilters")
        public List<Object> getAvailableFilters() {
            return availableFilters;
        }

        @JsonProperty("availableFilters")
        public void setAvailableFilters(List<Object> value) {
            this.availableFilters = value;
        }

        @JsonProperty("availableSortTypes")
        public List<AvailableSortType> getAvailableSortTypes() {
            return availableSortTypes;
        }

        @JsonProperty("availableSortTypes")
        public void setAvailableSortTypes(List<AvailableSortType> value) {
            this.availableSortTypes = value;
        }

        @JsonProperty("carrierCodes")
        public List<Object> getCarrierCodes() {
            return carrierCodes;
        }

        @JsonProperty("carrierCodes")
        public void setCarrierCodes(List<Object> value) {
            this.carrierCodes = value;
        }

        @JsonProperty("carrierNames")
        public List<Object> getCarrierNames() {
            return carrierNames;
        }

        @JsonProperty("carrierNames")
        public void setCarrierNames(List<Object> value) {
            this.carrierNames = value;
        }

        @JsonProperty("filteredFlightsCount")
        public long getFilteredFlightsCount() {
            return filteredFlightsCount;
        }

        @JsonProperty("filteredFlightsCount")
        public void setFilteredFlightsCount(long value) {
            this.filteredFlightsCount = value;
        }

        @JsonProperty("flights")
        public List<Flight> getFlights() {
            return flights;
        }

        @JsonProperty("flights")
        public void setFlights(List<Flight> value) {
            this.flights = value;
        }

        @JsonProperty("flightsCount")
        public long getFlightsCount() {
            return flightsCount;
        }

        @JsonProperty("flightsCount")
        public void setFlightsCount(long value) {
            this.flightsCount = value;
        }

        @JsonProperty("quickSortPrices")
        public QuickSortPrices getQuickSortPrices() {
            return quickSortPrices;
        }

        @JsonProperty("quickSortPrices")
        public void setQuickSortPrices(QuickSortPrices value) {
            this.quickSortPrices = value;
        }

        @JsonProperty("resultSetMetaData")
        public ResultSetMetaData getResultSetMetaData() {
            return resultSetMetaData;
        }

        @JsonProperty("resultSetMetaData")
        public void setResultSetMetaData(ResultSetMetaData value) {
            this.resultSetMetaData = value;
        }

        @JsonProperty("routes")
        public List<Route> getRoutes() {
            return routes;
        }

        @JsonProperty("routes")
        public void setRoutes(List<Route> value) {
            this.routes = value;
        }

        @JsonProperty("searchPath")
        public String getSearchPath() {
            return searchPath;
        }

        @JsonProperty("searchPath")
        public void setSearchPath(String value) {
            this.searchPath = value;
        }

        @JsonProperty("sponsoredTrips")
        public List<SponsoredTrip> getSponsoredTrips() {
            return sponsoredTrips;
        }

        @JsonProperty("sponsoredTrips")
        public void setSponsoredTrips(List<SponsoredTrip> value) {
            this.sponsoredTrips = value;
        }

        @JsonProperty("travelers")
        public List<Traveler> getTravelers() {
            return travelers;
        }

        @JsonProperty("travelers")
        public void setTravelers(List<Traveler> value) {
            this.travelers = value;
        }

        @JsonProperty("tripCampaigns")
        public List<Object> getTripCampaigns() {
            return tripCampaigns;
        }

        @JsonProperty("tripCampaigns")
        public void setTripCampaigns(List<Object> value) {
            this.tripCampaigns = value;
        }

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String value) {
            this.type = value;
        }

        @JsonProperty("validWithVoucher")
        public boolean getValidWithVoucher() {
            return validWithVoucher;
        }

        @JsonProperty("validWithVoucher")
        public void setValidWithVoucher(boolean value) {
            this.validWithVoucher = value;
        }
    }

    public static class AvailableSortType {
        private String typename;
        private String code;
        private String name;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("code")
        public String getCode() {
            return code;
        }

        @JsonProperty("code")
        public void setCode(String value) {
            this.code = value;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String value) {
            this.name = value;
        }
    }

    public static class Flight {
        private String typename;
        private List<AvailableExtraProduct> availableExtraProducts;
        private List<FlightBound> bounds;
        private String id;
        private IncludedCBaggage includedCabinBaggage;
        private IncludedCBaggage includedCheckedBaggage;
        private List<IncludedExtraProduct> includedExtraProducts;
        private boolean isVI;
        private List<PaymentMethodPrice> paymentMethodPrices;
        private String selectionKey;
        private String shareableUrl;
        private Object systems;
        private List<TravelerPrice> travelerPrices;
        private List<TravelerPricesWithoutPaymentDiscount> travelerPricesWithoutPaymentDiscounts;
        private List<String> tripCharacteristics;
        private String tripId;
        private List<String> tripTags;
        private List<TripTraveler> tripTravelers;
        private String type;
        private VoucherAmount voucherAmount;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("availableExtraProducts")
        public List<AvailableExtraProduct> getAvailableExtraProducts() {
            return availableExtraProducts;
        }

        @JsonProperty("availableExtraProducts")
        public void setAvailableExtraProducts(List<AvailableExtraProduct> value) {
            this.availableExtraProducts = value;
        }

        @JsonProperty("bounds")
        public List<FlightBound> getBounds() {
            return bounds;
        }

        @JsonProperty("bounds")
        public void setBounds(List<FlightBound> value) {
            this.bounds = value;
        }

        @JsonProperty("id")
        public String getid() {
            return id;
        }

        @JsonProperty("id")
        public void setid(String value) {
            this.id = value;
        }

        @JsonProperty("includedCabinBaggage")
        public IncludedCBaggage getIncludedCabinBaggage() {
            return includedCabinBaggage;
        }

        @JsonProperty("includedCabinBaggage")
        public void setIncludedCabinBaggage(IncludedCBaggage value) {
            this.includedCabinBaggage = value;
        }

        @JsonProperty("includedCheckedBaggage")
        public IncludedCBaggage getIncludedCheckedBaggage() {
            return includedCheckedBaggage;
        }

        @JsonProperty("includedCheckedBaggage")
        public void setIncludedCheckedBaggage(IncludedCBaggage value) {
            this.includedCheckedBaggage = value;
        }

        @JsonProperty("includedExtraProducts")
        public List<IncludedExtraProduct> getIncludedExtraProducts() {
            return includedExtraProducts;
        }

        @JsonProperty("includedExtraProducts")
        public void setIncludedExtraProducts(List<IncludedExtraProduct> value) {
            this.includedExtraProducts = value;
        }

        @JsonProperty("isVI")
        public boolean getIsVI() {
            return isVI;
        }

        @JsonProperty("isVI")
        public void setIsVI(boolean value) {
            this.isVI = value;
        }

        @JsonProperty("paymentMethodPrices")
        public List<PaymentMethodPrice> getPaymentMethodPrices() {
            return paymentMethodPrices;
        }

        @JsonProperty("paymentMethodPrices")
        public void setPaymentMethodPrices(List<PaymentMethodPrice> value) {
            this.paymentMethodPrices = value;
        }

        @JsonProperty("selectionKey")
        public String getSelectionKey() {
            return selectionKey;
        }

        @JsonProperty("selectionKey")
        public void setSelectionKey(String value) {
            this.selectionKey = value;
        }

        @JsonProperty("shareableUrl")
        public String getShareableUrl() {
            return shareableUrl;
        }

        @JsonProperty("shareableUrl")
        public void setShareableUrl(String value) {
            this.shareableUrl = value;
        }

        @JsonProperty("systems")
        public Object getSystems() {
            return systems;
        }

        @JsonProperty("systems")
        public void setSystems(Object value) {
            this.systems = value;
        }

        @JsonProperty("travelerPrices")
        public List<TravelerPrice> getTravelerPrices() {
            return travelerPrices;
        }

        @JsonProperty("travelerPrices")
        public void setTravelerPrices(List<TravelerPrice> value) {
            this.travelerPrices = value;
        }

        @JsonProperty("travelerPricesWithoutPaymentDiscounts")
        public List<TravelerPricesWithoutPaymentDiscount> getTravelerPricesWithoutPaymentDiscounts() {
            return travelerPricesWithoutPaymentDiscounts;
        }

        @JsonProperty("travelerPricesWithoutPaymentDiscounts")
        public void setTravelerPricesWithoutPaymentDiscounts(List<TravelerPricesWithoutPaymentDiscount> value) {
            this.travelerPricesWithoutPaymentDiscounts = value;
        }

        @JsonProperty("tripCharacteristics")
        public List<String> getTripCharacteristics() {
            return tripCharacteristics;
        }

        @JsonProperty("tripCharacteristics")
        public void setTripCharacteristics(List<String> value) {
            this.tripCharacteristics = value;
        }

        @JsonProperty("tripId")
        public String getTripId() {
            return tripId;
        }

        @JsonProperty("tripId")
        public void setTripId(String value) {
            this.tripId = value;
        }

        @JsonProperty("tripTags")
        public List<String> getTripTags() {
            return tripTags;
        }

        @JsonProperty("tripTags")
        public void setTripTags(List<String> value) {
            this.tripTags = value;
        }

        @JsonProperty("tripTravelers")
        public List<TripTraveler> getTripTravelers() {
            return tripTravelers;
        }

        @JsonProperty("tripTravelers")
        public void setTripTravelers(List<TripTraveler> value) {
            this.tripTravelers = value;
        }

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String value) {
            this.type = value;
        }

        @JsonProperty("voucherAmount")
        public VoucherAmount getVoucherAmount() {
            return voucherAmount;
        }

        @JsonProperty("voucherAmount")
        public void setVoucherAmount(VoucherAmount value) {
            this.voucherAmount = value;
        }
    }

    public static class AvailableExtraProduct {
        private String typename;
        private Configuration configuration;
        private String name;
        private String productId;
        private boolean selectedWithTrip;
        private SellSpecification sellSpecification;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("configuration")
        public Configuration getConfiguration() {
            return configuration;
        }

        @JsonProperty("configuration")
        public void setConfiguration(Configuration value) {
            this.configuration = value;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String value) {
            this.name = value;
        }

        @JsonProperty("productId")
        public String getProductId() {
            return productId;
        }

        @JsonProperty("productId")
        public void setProductId(String value) {
            this.productId = value;
        }

        @JsonProperty("selectedWithTrip")
        public boolean getSelectedWithTrip() {
            return selectedWithTrip;
        }

        @JsonProperty("selectedWithTrip")
        public void setSelectedWithTrip(boolean value) {
            this.selectedWithTrip = value;
        }

        @JsonProperty("sellSpecification")
        public SellSpecification getSellSpecification() {
            return sellSpecification;
        }

        @JsonProperty("sellSpecification")
        public void setSellSpecification(SellSpecification value) {
            this.sellSpecification = value;
        }
    }

    public static class Configuration {
        private String typename;
        private String productPreSelection;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("productPreSelection")
        public String getProductPreSelection() {
            return productPreSelection;
        }

        @JsonProperty("productPreSelection")
        public void setProductPreSelection(String value) {
            this.productPreSelection = value;
        }
    }

    public static class SellSpecification {
        private String typename;
        private List<SellPriceBaggage> sellPriceBaggage;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("sellPriceBaggage")
        public List<SellPriceBaggage> getSellPriceBaggage() {
            return sellPriceBaggage;
        }

        @JsonProperty("sellPriceBaggage")
        public void setSellPriceBaggage(List<SellPriceBaggage> value) {
            this.sellPriceBaggage = value;
        }
    }

    public static class SellPriceBaggage {
        private String typename;
        private long maxWeight;
        private long numberOfUnits;
        private SellPriceBaggagePrice price;
        private String weightUnit;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("maxWeight")
        public long getMaxWeight() {
            return maxWeight;
        }

        @JsonProperty("maxWeight")
        public void setMaxWeight(long value) {
            this.maxWeight = value;
        }

        @JsonProperty("numberOfUnits")
        public long getNumberOfUnits() {
            return numberOfUnits;
        }

        @JsonProperty("numberOfUnits")
        public void setNumberOfUnits(long value) {
            this.numberOfUnits = value;
        }

        @JsonProperty("price")
        public SellPriceBaggagePrice getPrice() {
            return price;
        }

        @JsonProperty("price")
        public void setPrice(SellPriceBaggagePrice value) {
            this.price = value;
        }

        @JsonProperty("weightUnit")
        public String getWeightUnit() {
            return weightUnit;
        }

        @JsonProperty("weightUnit")
        public void setWeightUnit(String value) {
            this.weightUnit = value;
        }
    }

    public static class SellPriceBaggagePrice {
        private String typename;
        private CarrierPromo price;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("price")
        public CarrierPromo getPrice() {
            return price;
        }

        @JsonProperty("price")
        public void setPrice(CarrierPromo value) {
            this.price = value;
        }
    }

    public static class CarrierPromo {
        private String typename;
        private Currency currency;
        private long value;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("currency")
        public Currency getCurrency() {
            return currency;
        }

        @JsonProperty("currency")
        public void setCurrency(Currency value) {
            this.currency = value;
        }

        @JsonProperty("value")
        public long getValue() {
            return value;
        }

        @JsonProperty("value")
        public void setValue(long value) {
            this.value = value;
        }
    }

    public static class Currency {
        private String typename;
        private String code;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("code")
        public String getCode() {
            return code;
        }

        @JsonProperty("code")
        public void setCode(String value) {
            this.code = value;
        }
    }

    public static class FlightBound {
        private String typename;
        private String boundId;
        private IncludedCBaggage includedCabinBaggage;
        private IncludedCBaggage includedCheckedBaggage;
        private List<PurpleSegment> segments;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("boundId")
        public String getBoundId() {
            return boundId;
        }

        @JsonProperty("boundId")
        public void setBoundId(String value) {
            this.boundId = value;
        }

        @JsonProperty("includedCabinBaggage")
        public IncludedCBaggage getIncludedCabinBaggage() {
            return includedCabinBaggage;
        }

        @JsonProperty("includedCabinBaggage")
        public void setIncludedCabinBaggage(IncludedCBaggage value) {
            this.includedCabinBaggage = value;
        }

        @JsonProperty("includedCheckedBaggage")
        public IncludedCBaggage getIncludedCheckedBaggage() {
            return includedCheckedBaggage;
        }

        @JsonProperty("includedCheckedBaggage")
        public void setIncludedCheckedBaggage(IncludedCBaggage value) {
            this.includedCheckedBaggage = value;
        }

        @JsonProperty("segments")
        public List<PurpleSegment> getSegments() {
            return segments;
        }

        @JsonProperty("segments")
        public void setSegments(List<PurpleSegment> value) {
            this.segments = value;
        }
    }

    public static class IncludedCBaggage {
        private String typename;
        private long pieces;
        private long weight;
        private String weightUnit;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("pieces")
        public long getPieces() {
            return pieces;
        }

        @JsonProperty("pieces")
        public void setPieces(long value) {
            this.pieces = value;
        }

        @JsonProperty("weight")
        public long getWeight() {
            return weight;
        }

        @JsonProperty("weight")
        public void setWeight(long value) {
            this.weight = value;
        }

        @JsonProperty("weightUnit")
        public String getWeightUnit() {
            return weightUnit;
        }

        @JsonProperty("weightUnit")
        public void setWeightUnit(String value) {
            this.weightUnit = value;
        }
    }

    public static class PurpleSegment {
        private String typename;
        private String aircraftType;
        private String arrivedAt;
        private String cabinClassName;
        private String departuredAt;
        private SegmentDestination destination;
        private long duration;
        private String equipmentCode;
        private String flightNumber;
        private IncludedCabinBaggage includedCabinBaggage;
        private IncludedCBaggage includedCheckedBaggage;
        private AvailableSortType marketingCarrier;
        private Long numberOfTechnicalStops;
        private AvailableSortType operatingCarrier;
        private Object operatingInformation;
        private SegmentDestination origin;
        private List<SegmentDetail> segmentDetails;
        private String segmentId;
        private List<String> types;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("aircraftType")
        public String getAircraftType() {
            return aircraftType;
        }

        @JsonProperty("aircraftType")
        public void setAircraftType(String value) {
            this.aircraftType = value;
        }

        @JsonProperty("arrivedAt")
        public String getArrivedAt() {
            return arrivedAt;
        }

        @JsonProperty("arrivedAt")
        public void setArrivedAt(String value) {
            this.arrivedAt = value;
        }

        @JsonProperty("cabinClassName")
        public String getCabinClassName() {
            return cabinClassName;
        }

        @JsonProperty("cabinClassName")
        public void setCabinClassName(String value) {
            this.cabinClassName = value;
        }

        @JsonProperty("departuredAt")
        public String getDeparturedAt() {
            return departuredAt;
        }

        @JsonProperty("departuredAt")
        public void setDeparturedAt(String value) {
            this.departuredAt = value;
        }

        @JsonProperty("destination")
        public SegmentDestination getDestination() {
            return destination;
        }

        @JsonProperty("destination")
        public void setDestination(SegmentDestination value) {
            this.destination = value;
        }

        @JsonProperty("duration")
        public long getDuration() {
            return duration;
        }

        @JsonProperty("duration")
        public void setDuration(long value) {
            this.duration = value;
        }

        @JsonProperty("equipmentCode")
        public String getEquipmentCode() {
            return equipmentCode;
        }

        @JsonProperty("equipmentCode")
        public void setEquipmentCode(String value) {
            this.equipmentCode = value;
        }

        @JsonProperty("flightNumber")
        public String getFlightNumber() {
            return flightNumber;
        }

        @JsonProperty("flightNumber")
        public void setFlightNumber(String value) {
            this.flightNumber = value;
        }

        @JsonProperty("includedCabinBaggage")
        public IncludedCabinBaggage getIncludedCabinBaggage() {
            return includedCabinBaggage;
        }

        @JsonProperty("includedCabinBaggage")
        public void setIncludedCabinBaggage(IncludedCabinBaggage value) {
            this.includedCabinBaggage = value;
        }

        @JsonProperty("includedCheckedBaggage")
        public IncludedCBaggage getIncludedCheckedBaggage() {
            return includedCheckedBaggage;
        }

        @JsonProperty("includedCheckedBaggage")
        public void setIncludedCheckedBaggage(IncludedCBaggage value) {
            this.includedCheckedBaggage = value;
        }

        @JsonProperty("marketingCarrier")
        public AvailableSortType getMarketingCarrier() {
            return marketingCarrier;
        }

        @JsonProperty("marketingCarrier")
        public void setMarketingCarrier(AvailableSortType value) {
            this.marketingCarrier = value;
        }

        @JsonProperty("numberOfTechnicalStops")
        public Long getNumberOfTechnicalStops() {
            return numberOfTechnicalStops;
        }

        @JsonProperty("numberOfTechnicalStops")
        public void setNumberOfTechnicalStops(Long value) {
            this.numberOfTechnicalStops = value;
        }

        @JsonProperty("operatingCarrier")
        public AvailableSortType getOperatingCarrier() {
            return operatingCarrier;
        }

        @JsonProperty("operatingCarrier")
        public void setOperatingCarrier(AvailableSortType value) {
            this.operatingCarrier = value;
        }

        @JsonProperty("operatingInformation")
        public Object getOperatingInformation() {
            return operatingInformation;
        }

        @JsonProperty("operatingInformation")
        public void setOperatingInformation(Object value) {
            this.operatingInformation = value;
        }

        @JsonProperty("origin")
        public SegmentDestination getOrigin() {
            return origin;
        }

        @JsonProperty("origin")
        public void setOrigin(SegmentDestination value) {
            this.origin = value;
        }

        @JsonProperty("segmentDetails")
        public List<SegmentDetail> getSegmentDetails() {
            return segmentDetails;
        }

        @JsonProperty("segmentDetails")
        public void setSegmentDetails(List<SegmentDetail> value) {
            this.segmentDetails = value;
        }

        @JsonProperty("segmentId")
        public String getSegmentId() {
            return segmentId;
        }

        @JsonProperty("segmentId")
        public void setSegmentId(String value) {
            this.segmentId = value;
        }

        @JsonProperty("types")
        public List<String> getTypes() {
            return types;
        }

        @JsonProperty("types")
        public void setTypes(List<String> value) {
            this.types = value;
        }
    }

    public static class SegmentDestination {
        private String typename;
        private String cityCode;
        private String cityName;
        private String code;
        private String name;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("cityCode")
        public String getCityCode() {
            return cityCode;
        }

        @JsonProperty("cityCode")
        public void setCityCode(String value) {
            this.cityCode = value;
        }

        @JsonProperty("cityName")
        public String getCityName() {
            return cityName;
        }

        @JsonProperty("cityName")
        public void setCityName(String value) {
            this.cityName = value;
        }

        @JsonProperty("code")
        public String getCode() {
            return code;
        }

        @JsonProperty("code")
        public void setCode(String value) {
            this.code = value;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String value) {
            this.name = value;
        }
    }

    public static class IncludedCabinBaggage {
        private String typename;
        private long pieces;
        private Long weight;
        private String weightUnit;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("pieces")
        public long getPieces() {
            return pieces;
        }

        @JsonProperty("pieces")
        public void setPieces(long value) {
            this.pieces = value;
        }

        @JsonProperty("weight")
        public Long getWeight() {
            return weight;
        }

        @JsonProperty("weight")
        public void setWeight(Long value) {
            this.weight = value;
        }

        @JsonProperty("weightUnit")
        public String getWeightUnit() {
            return weightUnit;
        }

        @JsonProperty("weightUnit")
        public void setWeightUnit(String value) {
            this.weightUnit = value;
        }
    }

    public static class SegmentDetail {
        private String typename;
        private long numberOfSeatsLeft;
        private String paxType;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("numberOfSeatsLeft")
        public long getNumberOfSeatsLeft() {
            return numberOfSeatsLeft;
        }

        @JsonProperty("numberOfSeatsLeft")
        public void setNumberOfSeatsLeft(long value) {
            this.numberOfSeatsLeft = value;
        }

        @JsonProperty("paxType")
        public String getPaxType() {
            return paxType;
        }

        @JsonProperty("paxType")
        public void setPaxType(String value) {
            this.paxType = value;
        }
    }

    public static class IncludedExtraProduct {
        private String typename;
        private String id;
        private Texts texts;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("id")
        public String getid() {
            return id;
        }

        @JsonProperty("id")
        public void setid(String value) {
            this.id = value;
        }

        @JsonProperty("texts")
        public Texts getTexts() {
            return texts;
        }

        @JsonProperty("texts")
        public void setTexts(Texts value) {
            this.texts = value;
        }
    }

    public static class Texts {
        private String typename;
        private String name;
        private Object productSummaryAlternativeName;
        private Object readMoreText;
        private Object receiptText;
        private String salesAbstract;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String value) {
            this.name = value;
        }

        @JsonProperty("productSummaryAlternativeName")
        public Object getProductSummaryAlternativeName() {
            return productSummaryAlternativeName;
        }

        @JsonProperty("productSummaryAlternativeName")
        public void setProductSummaryAlternativeName(Object value) {
            this.productSummaryAlternativeName = value;
        }

        @JsonProperty("readMoreText")
        public Object getReadMoreText() {
            return readMoreText;
        }

        @JsonProperty("readMoreText")
        public void setReadMoreText(Object value) {
            this.readMoreText = value;
        }

        @JsonProperty("receiptText")
        public Object getReceiptText() {
            return receiptText;
        }

        @JsonProperty("receiptText")
        public void setReceiptText(Object value) {
            this.receiptText = value;
        }

        @JsonProperty("salesAbstract")
        public String getSalesAbstract() {
            return salesAbstract;
        }

        @JsonProperty("salesAbstract")
        public void setSalesAbstract(String value) {
            this.salesAbstract = value;
        }
    }

    public static class PaymentMethodPrice {
        private String typename;
        private String name;
        private VoucherAmount price;
        private String type;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String value) {
            this.name = value;
        }

        @JsonProperty("price")
        public VoucherAmount getPrice() {
            return price;
        }

        @JsonProperty("price")
        public void setPrice(VoucherAmount value) {
            this.price = value;
        }

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String value) {
            this.type = value;
        }
    }

    public static class VoucherAmount {
        private String typename;
        private long value;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("value")
        public long getValue() {
            return value;
        }

        @JsonProperty("value")
        public void setValue(long value) {
            this.value = value;
        }
    }

    public static class TravelerPrice {
        private String typename;
        private String id;
        private TravelerPricePrice price;
        private List<Object> taxesAndFees;
        private String travelerId;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("id")
        public String getid() {
            return id;
        }

        @JsonProperty("id")
        public void setid(String value) {
            this.id = value;
        }

        @JsonProperty("price")
        public TravelerPricePrice getPrice() {
            return price;
        }

        @JsonProperty("price")
        public void setPrice(TravelerPricePrice value) {
            this.price = value;
        }

        @JsonProperty("taxesAndFees")
        public List<Object> getTaxesAndFees() {
            return taxesAndFees;
        }

        @JsonProperty("taxesAndFees")
        public void setTaxesAndFees(List<Object> value) {
            this.taxesAndFees = value;
        }

        @JsonProperty("travelerId")
        public String getTravelerId() {
            return travelerId;
        }

        @JsonProperty("travelerId")
        public void setTravelerId(String value) {
            this.travelerId = value;
        }
    }

    public static class TravelerPricePrice {
        private String typename;
        private Object markup;
        private CarrierPromo price;
        private VoucherAmount vat;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("markup")
        public Object getMarkup() {
            return markup;
        }

        @JsonProperty("markup")
        public void setMarkup(Object value) {
            this.markup = value;
        }

        @JsonProperty("price")
        public CarrierPromo getPrice() {
            return price;
        }

        @JsonProperty("price")
        public void setPrice(CarrierPromo value) {
            this.price = value;
        }

        @JsonProperty("vat")
        public VoucherAmount getVat() {
            return vat;
        }

        @JsonProperty("vat")
        public void setVat(VoucherAmount value) {
            this.vat = value;
        }
    }

    public static class TravelerPricesWithoutPaymentDiscount {
        private String typename;
        private TravelerPricePrice price;
        private List<Object> taxesAndFees;
        private String travelerId;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("price")
        public TravelerPricePrice getPrice() {
            return price;
        }

        @JsonProperty("price")
        public void setPrice(TravelerPricePrice value) {
            this.price = value;
        }

        @JsonProperty("taxesAndFees")
        public List<Object> getTaxesAndFees() {
            return taxesAndFees;
        }

        @JsonProperty("taxesAndFees")
        public void setTaxesAndFees(List<Object> value) {
            this.taxesAndFees = value;
        }

        @JsonProperty("travelerId")
        public String getTravelerId() {
            return travelerId;
        }

        @JsonProperty("travelerId")
        public void setTravelerId(String value) {
            this.travelerId = value;
        }
    }

    public static class TripTraveler {
        private String typename;
        private String ageType;
        private String id;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("ageType")
        public String getAgeType() {
            return ageType;
        }

        @JsonProperty("ageType")
        public void setAgeType(String value) {
            this.ageType = value;
        }

        @JsonProperty("id")
        public String getid() {
            return id;
        }

        @JsonProperty("id")
        public void setid(String value) {
            this.id = value;
        }
    }

    public static class QuickSortPrices {
        private String typename;
        private CarrierPromo carrierPromo;
        private CarrierPromo cheapTrip;
        private CarrierPromo recommendation;
        private CarrierPromo shortTrip;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("carrierPromo")
        public CarrierPromo getCarrierPromo() {
            return carrierPromo;
        }

        @JsonProperty("carrierPromo")
        public void setCarrierPromo(CarrierPromo value) {
            this.carrierPromo = value;
        }

        @JsonProperty("cheapTrip")
        public CarrierPromo getCheapTrip() {
            return cheapTrip;
        }

        @JsonProperty("cheapTrip")
        public void setCheapTrip(CarrierPromo value) {
            this.cheapTrip = value;
        }

        @JsonProperty("recommendation")
        public CarrierPromo getRecommendation() {
            return recommendation;
        }

        @JsonProperty("recommendation")
        public void setRecommendation(CarrierPromo value) {
            this.recommendation = value;
        }

        @JsonProperty("shortTrip")
        public CarrierPromo getShortTrip() {
            return shortTrip;
        }

        @JsonProperty("shortTrip")
        public void setShortTrip(CarrierPromo value) {
            this.shortTrip = value;
        }
    }

    public static class ResultSetMetaData {
        private String typename;
        private List<AvailableSortType> marketingCarriers;
        private ERange priceRange;
        private ERange travelTimeRange;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("marketingCarriers")
        public List<AvailableSortType> getMarketingCarriers() {
            return marketingCarriers;
        }

        @JsonProperty("marketingCarriers")
        public void setMarketingCarriers(List<AvailableSortType> value) {
            this.marketingCarriers = value;
        }

        @JsonProperty("priceRange")
        public ERange getPriceRange() {
            return priceRange;
        }

        @JsonProperty("priceRange")
        public void setPriceRange(ERange value) {
            this.priceRange = value;
        }

        @JsonProperty("travelTimeRange")
        public ERange getTravelTimeRange() {
            return travelTimeRange;
        }

        @JsonProperty("travelTimeRange")
        public void setTravelTimeRange(ERange value) {
            this.travelTimeRange = value;
        }
    }

    public static class ERange {
        private String typename;
        private long max;
        private long min;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("max")
        public long getMax() {
            return max;
        }

        @JsonProperty("max")
        public void setMax(long value) {
            this.max = value;
        }

        @JsonProperty("min")
        public long getMin() {
            return min;
        }

        @JsonProperty("min")
        public void setMin(long value) {
            this.min = value;
        }
    }

    public static class Route {
        private String typename;
        private String departureAt;
        private Object departureTimeOfDay;
        private RouteDestination destination;
        private RouteDestination origin;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("departureAt")
        public String getDepartureAt() {
            return departureAt;
        }

        @JsonProperty("departureAt")
        public void setDepartureAt(String value) {
            this.departureAt = value;
        }

        @JsonProperty("departureTimeOfDay")
        public Object getDepartureTimeOfDay() {
            return departureTimeOfDay;
        }

        @JsonProperty("departureTimeOfDay")
        public void setDepartureTimeOfDay(Object value) {
            this.departureTimeOfDay = value;
        }

        @JsonProperty("destination")
        public RouteDestination getDestination() {
            return destination;
        }

        @JsonProperty("destination")
        public void setDestination(RouteDestination value) {
            this.destination = value;
        }

        @JsonProperty("origin")
        public RouteDestination getOrigin() {
            return origin;
        }

        @JsonProperty("origin")
        public void setOrigin(RouteDestination value) {
            this.origin = value;
        }
    }

    public static class RouteDestination {
        private String typename;
        private String cityCode;
        private String cityName;
        private String code;
        private String continentCode;
        private String continentName;
        private String countryCode;
        private String countryName;
        private String name;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("cityCode")
        public String getCityCode() {
            return cityCode;
        }

        @JsonProperty("cityCode")
        public void setCityCode(String value) {
            this.cityCode = value;
        }

        @JsonProperty("cityName")
        public String getCityName() {
            return cityName;
        }

        @JsonProperty("cityName")
        public void setCityName(String value) {
            this.cityName = value;
        }

        @JsonProperty("code")
        public String getCode() {
            return code;
        }

        @JsonProperty("code")
        public void setCode(String value) {
            this.code = value;
        }

        @JsonProperty("continentCode")
        public String getContinentCode() {
            return continentCode;
        }

        @JsonProperty("continentCode")
        public void setContinentCode(String value) {
            this.continentCode = value;
        }

        @JsonProperty("continentName")
        public String getContinentName() {
            return continentName;
        }

        @JsonProperty("continentName")
        public void setContinentName(String value) {
            this.continentName = value;
        }

        @JsonProperty("countryCode")
        public String getCountryCode() {
            return countryCode;
        }

        @JsonProperty("countryCode")
        public void setCountryCode(String value) {
            this.countryCode = value;
        }

        @JsonProperty("countryName")
        public String getCountryName() {
            return countryName;
        }

        @JsonProperty("countryName")
        public void setCountryName(String value) {
            this.countryName = value;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String value) {
            this.name = value;
        }
    }

    public static class SponsoredTrip {
        private String typename;
        private List<AvailableExtraProduct> availableExtraProducts;
        private List<SponsoredTripBound> bounds;
        private String id;
        private IncludedCBaggage includedCabinBaggage;
        private IncludedCBaggage includedCheckedBaggage;
        private List<IncludedExtraProduct> includedExtraProducts;
        private boolean isVI;
        private List<PaymentMethodPrice> paymentMethodPrices;
        private String selectionKey;
        private String shareableUrl;
        private Object systems;
        private List<TravelerPrice> travelerPrices;
        private List<TravelerPricesWithoutPaymentDiscount> travelerPricesWithoutPaymentDiscounts;
        private List<String> tripCharacteristics;
        private String tripId;
        private List<String> tripTags;
        private List<TripTraveler> tripTravelers;
        private String type;
        private VoucherAmount voucherAmount;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("availableExtraProducts")
        public List<AvailableExtraProduct> getAvailableExtraProducts() {
            return availableExtraProducts;
        }

        @JsonProperty("availableExtraProducts")
        public void setAvailableExtraProducts(List<AvailableExtraProduct> value) {
            this.availableExtraProducts = value;
        }

        @JsonProperty("bounds")
        public List<SponsoredTripBound> getBounds() {
            return bounds;
        }

        @JsonProperty("bounds")
        public void setBounds(List<SponsoredTripBound> value) {
            this.bounds = value;
        }

        @JsonProperty("id")
        public String getid() {
            return id;
        }

        @JsonProperty("id")
        public void setid(String value) {
            this.id = value;
        }

        @JsonProperty("includedCabinBaggage")
        public IncludedCBaggage getIncludedCabinBaggage() {
            return includedCabinBaggage;
        }

        @JsonProperty("includedCabinBaggage")
        public void setIncludedCabinBaggage(IncludedCBaggage value) {
            this.includedCabinBaggage = value;
        }

        @JsonProperty("includedCheckedBaggage")
        public IncludedCBaggage getIncludedCheckedBaggage() {
            return includedCheckedBaggage;
        }

        @JsonProperty("includedCheckedBaggage")
        public void setIncludedCheckedBaggage(IncludedCBaggage value) {
            this.includedCheckedBaggage = value;
        }

        @JsonProperty("includedExtraProducts")
        public List<IncludedExtraProduct> getIncludedExtraProducts() {
            return includedExtraProducts;
        }

        @JsonProperty("includedExtraProducts")
        public void setIncludedExtraProducts(List<IncludedExtraProduct> value) {
            this.includedExtraProducts = value;
        }

        @JsonProperty("isVI")
        public boolean getIsVI() {
            return isVI;
        }

        @JsonProperty("isVI")
        public void setIsVI(boolean value) {
            this.isVI = value;
        }

        @JsonProperty("paymentMethodPrices")
        public List<PaymentMethodPrice> getPaymentMethodPrices() {
            return paymentMethodPrices;
        }

        @JsonProperty("paymentMethodPrices")
        public void setPaymentMethodPrices(List<PaymentMethodPrice> value) {
            this.paymentMethodPrices = value;
        }

        @JsonProperty("selectionKey")
        public String getSelectionKey() {
            return selectionKey;
        }

        @JsonProperty("selectionKey")
        public void setSelectionKey(String value) {
            this.selectionKey = value;
        }

        @JsonProperty("shareableUrl")
        public String getShareableUrl() {
            return shareableUrl;
        }

        @JsonProperty("shareableUrl")
        public void setShareableUrl(String value) {
            this.shareableUrl = value;
        }

        @JsonProperty("systems")
        public Object getSystems() {
            return systems;
        }

        @JsonProperty("systems")
        public void setSystems(Object value) {
            this.systems = value;
        }

        @JsonProperty("travelerPrices")
        public List<TravelerPrice> getTravelerPrices() {
            return travelerPrices;
        }

        @JsonProperty("travelerPrices")
        public void setTravelerPrices(List<TravelerPrice> value) {
            this.travelerPrices = value;
        }

        @JsonProperty("travelerPricesWithoutPaymentDiscounts")
        public List<TravelerPricesWithoutPaymentDiscount> getTravelerPricesWithoutPaymentDiscounts() {
            return travelerPricesWithoutPaymentDiscounts;
        }

        @JsonProperty("travelerPricesWithoutPaymentDiscounts")
        public void setTravelerPricesWithoutPaymentDiscounts(List<TravelerPricesWithoutPaymentDiscount> value) {
            this.travelerPricesWithoutPaymentDiscounts = value;
        }

        @JsonProperty("tripCharacteristics")
        public List<String> getTripCharacteristics() {
            return tripCharacteristics;
        }

        @JsonProperty("tripCharacteristics")
        public void setTripCharacteristics(List<String> value) {
            this.tripCharacteristics = value;
        }

        @JsonProperty("tripId")
        public String getTripId() {
            return tripId;
        }

        @JsonProperty("tripId")
        public void setTripId(String value) {
            this.tripId = value;
        }

        @JsonProperty("tripTags")
        public List<String> getTripTags() {
            return tripTags;
        }

        @JsonProperty("tripTags")
        public void setTripTags(List<String> value) {
            this.tripTags = value;
        }

        @JsonProperty("tripTravelers")
        public List<TripTraveler> getTripTravelers() {
            return tripTravelers;
        }

        @JsonProperty("tripTravelers")
        public void setTripTravelers(List<TripTraveler> value) {
            this.tripTravelers = value;
        }

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String value) {
            this.type = value;
        }

        @JsonProperty("voucherAmount")
        public VoucherAmount getVoucherAmount() {
            return voucherAmount;
        }

        @JsonProperty("voucherAmount")
        public void setVoucherAmount(VoucherAmount value) {
            this.voucherAmount = value;
        }
    }

    public static class SponsoredTripBound {
        private String typename;
        private String boundId;
        private IncludedCBaggage includedCabinBaggage;
        private IncludedCBaggage includedCheckedBaggage;
        private List<FluffySegment> segments;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("boundId")
        public String getBoundId() {
            return boundId;
        }

        @JsonProperty("boundId")
        public void setBoundId(String value) {
            this.boundId = value;
        }

        @JsonProperty("includedCabinBaggage")
        public IncludedCBaggage getIncludedCabinBaggage() {
            return includedCabinBaggage;
        }

        @JsonProperty("includedCabinBaggage")
        public void setIncludedCabinBaggage(IncludedCBaggage value) {
            this.includedCabinBaggage = value;
        }

        @JsonProperty("includedCheckedBaggage")
        public IncludedCBaggage getIncludedCheckedBaggage() {
            return includedCheckedBaggage;
        }

        @JsonProperty("includedCheckedBaggage")
        public void setIncludedCheckedBaggage(IncludedCBaggage value) {
            this.includedCheckedBaggage = value;
        }

        @JsonProperty("segments")
        public List<FluffySegment> getSegments() {
            return segments;
        }

        @JsonProperty("segments")
        public void setSegments(List<FluffySegment> value) {
            this.segments = value;
        }
    }

    public static class FluffySegment {
        private String typename;
        private String aircraftType;
        private String arrivedAt;
        private String cabinClassName;
        private String departuredAt;
        private SegmentDestination destination;
        private long duration;
        private String equipmentCode;
        private String flightNumber;
        private IncludedCBaggage includedCabinBaggage;
        private IncludedCBaggage includedCheckedBaggage;
        private AvailableSortType marketingCarrier;
        private Long numberOfTechnicalStops;
        private AvailableSortType operatingCarrier;
        private Object operatingInformation;
        private SegmentDestination origin;
        private List<SegmentDetail> segmentDetails;
        private String segmentId;
        private List<String> types;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("aircraftType")
        public String getAircraftType() {
            return aircraftType;
        }

        @JsonProperty("aircraftType")
        public void setAircraftType(String value) {
            this.aircraftType = value;
        }

        @JsonProperty("arrivedAt")
        public String getArrivedAt() {
            return arrivedAt;
        }

        @JsonProperty("arrivedAt")
        public void setArrivedAt(String value) {
            this.arrivedAt = value;
        }

        @JsonProperty("cabinClassName")
        public String getCabinClassName() {
            return cabinClassName;
        }

        @JsonProperty("cabinClassName")
        public void setCabinClassName(String value) {
            this.cabinClassName = value;
        }

        @JsonProperty("departuredAt")
        public String getDeparturedAt() {
            return departuredAt;
        }

        @JsonProperty("departuredAt")
        public void setDeparturedAt(String value) {
            this.departuredAt = value;
        }

        @JsonProperty("destination")
        public SegmentDestination getDestination() {
            return destination;
        }

        @JsonProperty("destination")
        public void setDestination(SegmentDestination value) {
            this.destination = value;
        }

        @JsonProperty("duration")
        public long getDuration() {
            return duration;
        }

        @JsonProperty("duration")
        public void setDuration(long value) {
            this.duration = value;
        }

        @JsonProperty("equipmentCode")
        public String getEquipmentCode() {
            return equipmentCode;
        }

        @JsonProperty("equipmentCode")
        public void setEquipmentCode(String value) {
            this.equipmentCode = value;
        }

        @JsonProperty("flightNumber")
        public String getFlightNumber() {
            return flightNumber;
        }

        @JsonProperty("flightNumber")
        public void setFlightNumber(String value) {
            this.flightNumber = value;
        }

        @JsonProperty("includedCabinBaggage")
        public IncludedCBaggage getIncludedCabinBaggage() {
            return includedCabinBaggage;
        }

        @JsonProperty("includedCabinBaggage")
        public void setIncludedCabinBaggage(IncludedCBaggage value) {
            this.includedCabinBaggage = value;
        }

        @JsonProperty("includedCheckedBaggage")
        public IncludedCBaggage getIncludedCheckedBaggage() {
            return includedCheckedBaggage;
        }

        @JsonProperty("includedCheckedBaggage")
        public void setIncludedCheckedBaggage(IncludedCBaggage value) {
            this.includedCheckedBaggage = value;
        }

        @JsonProperty("marketingCarrier")
        public AvailableSortType getMarketingCarrier() {
            return marketingCarrier;
        }

        @JsonProperty("marketingCarrier")
        public void setMarketingCarrier(AvailableSortType value) {
            this.marketingCarrier = value;
        }

        @JsonProperty("numberOfTechnicalStops")
        public Long getNumberOfTechnicalStops() {
            return numberOfTechnicalStops;
        }

        @JsonProperty("numberOfTechnicalStops")
        public void setNumberOfTechnicalStops(Long value) {
            this.numberOfTechnicalStops = value;
        }

        @JsonProperty("operatingCarrier")
        public AvailableSortType getOperatingCarrier() {
            return operatingCarrier;
        }

        @JsonProperty("operatingCarrier")
        public void setOperatingCarrier(AvailableSortType value) {
            this.operatingCarrier = value;
        }

        @JsonProperty("operatingInformation")
        public Object getOperatingInformation() {
            return operatingInformation;
        }

        @JsonProperty("operatingInformation")
        public void setOperatingInformation(Object value) {
            this.operatingInformation = value;
        }

        @JsonProperty("origin")
        public SegmentDestination getOrigin() {
            return origin;
        }

        @JsonProperty("origin")
        public void setOrigin(SegmentDestination value) {
            this.origin = value;
        }

        @JsonProperty("segmentDetails")
        public List<SegmentDetail> getSegmentDetails() {
            return segmentDetails;
        }

        @JsonProperty("segmentDetails")
        public void setSegmentDetails(List<SegmentDetail> value) {
            this.segmentDetails = value;
        }

        @JsonProperty("segmentId")
        public String getSegmentId() {
            return segmentId;
        }

        @JsonProperty("segmentId")
        public void setSegmentId(String value) {
            this.segmentId = value;
        }

        @JsonProperty("types")
        public List<String> getTypes() {
            return types;
        }

        @JsonProperty("types")
        public void setTypes(List<String> value) {
            this.types = value;
        }
    }

    public static class Traveler {
        private String typename;
        private String ageType;

        @JsonProperty("__typename")
        public String getTypename() {
            return typename;
        }

        @JsonProperty("__typename")
        public void setTypename(String value) {
            this.typename = value;
        }

        @JsonProperty("ageType")
        public String getAgeType() {
            return ageType;
        }

        @JsonProperty("ageType")
        public void setAgeType(String value) {
            this.ageType = value;
        }
    }
}
