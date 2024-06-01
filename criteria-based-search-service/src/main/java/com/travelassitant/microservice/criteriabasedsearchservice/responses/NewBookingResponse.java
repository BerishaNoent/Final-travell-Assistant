package com.travelassitant.microservice.criteriabasedsearchservice.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;

public class NewBookingResponse {
    private Data data;
    private boolean status;
    private String message;

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data value) {
        this.data = value;
    }

    @JsonProperty("status")
    public boolean getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(boolean value) {
        this.status = value;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String value) {
        this.message = value;
    }

    public static class Data {
        private String provider;
        private List<Filter> filter;
        private List<Sort> sort;
        private long count;
        private Meta meta;
        private boolean isGeniusLocation;
        private String type;
        private List<SearchResult> searchResults;
        private Object discountBanner;
        private String searchKey;
        private String title;
        private DataContent content;

        @JsonProperty("provider")
        public String getProvider() {
            return provider;
        }

        @JsonProperty("provider")
        public void setProvider(String value) {
            this.provider = value;
        }

        @JsonProperty("filter")
        public List<Filter> getFilter() {
            return filter;
        }

        @JsonProperty("filter")
        public void setFilter(List<Filter> value) {
            this.filter = value;
        }

        @JsonProperty("sort")
        public List<Sort> getSort() {
            return sort;
        }

        @JsonProperty("sort")
        public void setSort(List<Sort> value) {
            this.sort = value;
        }

        @JsonProperty("count")
        public long getCount() {
            return count;
        }

        @JsonProperty("count")
        public void setCount(long value) {
            this.count = value;
        }

        @JsonProperty("meta")
        public Meta getMeta() {
            return meta;
        }

        @JsonProperty("meta")
        public void setMeta(Meta value) {
            this.meta = value;
        }

        @JsonProperty("is_genius_location")
        public boolean getIsGeniusLocation() {
            return isGeniusLocation;
        }

        @JsonProperty("is_genius_location")
        public void setIsGeniusLocation(boolean value) {
            this.isGeniusLocation = value;
        }

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String value) {
            this.type = value;
        }

        @JsonProperty("search_results")
        public List<SearchResult> getSearchResults() {
            return searchResults;
        }

        @JsonProperty("search_results")
        public void setSearchResults(List<SearchResult> value) {
            this.searchResults = value;
        }

        @JsonProperty("discount_banner")
        public Object getDiscountBanner() {
            return discountBanner;
        }

        @JsonProperty("discount_banner")
        public void setDiscountBanner(Object value) {
            this.discountBanner = value;
        }

        @JsonProperty("search_key")
        public String getSearchKey() {
            return searchKey;
        }

        @JsonProperty("search_key")
        public void setSearchKey(String value) {
            this.searchKey = value;
        }

        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        @JsonProperty("title")
        public void setTitle(String value) {
            this.title = value;
        }

        @JsonProperty("content")
        public DataContent getContent() {
            return content;
        }

        @JsonProperty("content")
        public void setContent(DataContent value) {
            this.content = value;
        }
    }

    public static class DataContent {
        private Object dsaBanner;
        private Object discountBanner;

        @JsonProperty("dsaBanner")
        public Object getdsaBanner() {
            return dsaBanner;
        }

        @JsonProperty("dsaBanner")
        public void setdsaBanner(Object value) {
            this.dsaBanner = value;
        }

        @JsonProperty("discountBanner")
        public Object getDiscountBanner() {
            return discountBanner;
        }

        @JsonProperty("discountBanner")
        public void setDiscountBanner(Object value) {
            this.discountBanner = value;
        }
    }

    public static class Filter {
        private List<Category> categories;
        private Layout layout;
        private String title;
        private String id;
        private String type;

        @JsonProperty("categories")
        public List<Category> getCategories() {
            return categories;
        }

        @JsonProperty("categories")
        public void setCategories(List<Category> value) {
            this.categories = value;
        }

        @JsonProperty("layout")
        public Layout getLayout() {
            return layout;
        }

        @JsonProperty("layout")
        public void setLayout(Layout value) {
            this.layout = value;
        }

        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        @JsonProperty("title")
        public void setTitle(String value) {
            this.title = value;
        }

        @JsonProperty("id")
        public String getid() {
            return id;
        }

        @JsonProperty("id")
        public void setid(String value) {
            this.id = value;
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

    public static class Category {
        private String name;
        private String id;

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String value) {
            this.name = value;
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

    public static class Layout {
        private Long collapsedCount;
        private String isCollapsed;
        private String isCollapsable;
        private String layoutType;

        @JsonProperty("collapsed_count")
        public Long getCollapsedCount() {
            return collapsedCount;
        }

        @JsonProperty("collapsed_count")
        public void setCollapsedCount(Long value) {
            this.collapsedCount = value;
        }

        @JsonProperty("is_collapsed")
        public String getIsCollapsed() {
            return isCollapsed;
        }

        @JsonProperty("is_collapsed")
        public void setIsCollapsed(String value) {
            this.isCollapsed = value;
        }

        @JsonProperty("is_collapsable")
        public String getIsCollapsable() {
            return isCollapsable;
        }

        @JsonProperty("is_collapsable")
        public void setIsCollapsable(String value) {
            this.isCollapsable = value;
        }

        @JsonProperty("layout_type")
        public String getLayoutType() {
            return layoutType;
        }

        @JsonProperty("layout_type")
        public void setLayoutType(String value) {
            this.layoutType = value;
        }
    }

    public static class Meta {
        private long responseCode;

        @JsonProperty("response_code")
        public long getResponseCode() {
            return responseCode;
        }

        @JsonProperty("response_code")
        public void setResponseCode(long value) {
            this.responseCode = value;
        }
    }

    public static class SearchResult {
        private PricingInfo pricingInfo;
        private List<Object> appliedDiscountTypes;
        private List<Object> freebies;
        private RouteInfo routeInfo;
        private RatingInfo ratingInfo;
        private SearchResultContent content;
        private String payWhenText;
        private FeeInfo feeInfo;
        private Accessibility accessibility;
        private SupplierInfo supplierInfo;
        private String forwardurl;
        private VehicleInfo vehicleInfo;

        @JsonProperty("pricing_info")
        public PricingInfo getPricingInfo() {
            return pricingInfo;
        }

        @JsonProperty("pricing_info")
        public void setPricingInfo(PricingInfo value) {
            this.pricingInfo = value;
        }

        @JsonProperty("applied_discount_types")
        public List<Object> getAppliedDiscountTypes() {
            return appliedDiscountTypes;
        }

        @JsonProperty("applied_discount_types")
        public void setAppliedDiscountTypes(List<Object> value) {
            this.appliedDiscountTypes = value;
        }

        @JsonProperty("freebies")
        public List<Object> getFreebies() {
            return freebies;
        }

        @JsonProperty("freebies")
        public void setFreebies(List<Object> value) {
            this.freebies = value;
        }

        @JsonProperty("route_info")
        public RouteInfo getRouteInfo() {
            return routeInfo;
        }

        @JsonProperty("route_info")
        public void setRouteInfo(RouteInfo value) {
            this.routeInfo = value;
        }

        @JsonProperty("rating_info")
        public RatingInfo getRatingInfo() {
            return ratingInfo;
        }

        @JsonProperty("rating_info")
        public void setRatingInfo(RatingInfo value) {
            this.ratingInfo = value;
        }

        @JsonProperty("content")
        public SearchResultContent getContent() {
            return content;
        }

        @JsonProperty("content")
        public void setContent(SearchResultContent value) {
            this.content = value;
        }

        @JsonProperty("pay_when_text")
        public String getPayWhenText() {
            return payWhenText;
        }

        @JsonProperty("pay_when_text")
        public void setPayWhenText(String value) {
            this.payWhenText = value;
        }

        @JsonProperty("fee_info")
        public FeeInfo getFeeInfo() {
            return feeInfo;
        }

        @JsonProperty("fee_info")
        public void setFeeInfo(FeeInfo value) {
            this.feeInfo = value;
        }

        @JsonProperty("accessibility")
        public Accessibility getAccessibility() {
            return accessibility;
        }

        @JsonProperty("accessibility")
        public void setAccessibility(Accessibility value) {
            this.accessibility = value;
        }

        @JsonProperty("supplier_info")
        public SupplierInfo getSupplierInfo() {
            return supplierInfo;
        }

        @JsonProperty("supplier_info")
        public void setSupplierInfo(SupplierInfo value) {
            this.supplierInfo = value;
        }

        @JsonProperty("forward_url")
        public String getForwardurl() {
            return forwardurl;
        }

        @JsonProperty("forward_url")
        public void setForwardurl(String value) {
            this.forwardurl = value;
        }

        @JsonProperty("vehicle_info")
        public VehicleInfo getVehicleInfo() {
            return vehicleInfo;
        }

        @JsonProperty("vehicle_info")
        public void setVehicleInfo(VehicleInfo value) {
            this.vehicleInfo = value;
        }
    }

    public static class Accessibility {
        private String pickUpLocation;
        private String supplierRating;
        private String fuelPolicy;
        private String transmission;

        @JsonProperty("pick_up_location")
        public String getPickUpLocation() {
            return pickUpLocation;
        }

        @JsonProperty("pick_up_location")
        public void setPickUpLocation(String value) {
            this.pickUpLocation = value;
        }

        @JsonProperty("supplier_rating")
        public String getSupplierRating() {
            return supplierRating;
        }

        @JsonProperty("supplier_rating")
        public void setSupplierRating(String value) {
            this.supplierRating = value;
        }

        @JsonProperty("fuel_policy")
        public String getFuelPolicy() {
            return fuelPolicy;
        }

        @JsonProperty("fuel_policy")
        public void setFuelPolicy(String value) {
            this.fuelPolicy = value;
        }

        @JsonProperty("transmission")
        public String getTransmission() {
            return transmission;
        }

        @JsonProperty("transmission")
        public void setTransmission(String value) {
            this.transmission = value;
        }
    }

    public static class SearchResultContent {
        private Supplier supplier;
        private List<Object> badges;

        @JsonProperty("supplier")
        public Supplier getSupplier() {
            return supplier;
        }

        @JsonProperty("supplier")
        public void setSupplier(Supplier value) {
            this.supplier = value;
        }

        @JsonProperty("badges")
        public List<Object> getBadges() {
            return badges;
        }

        @JsonProperty("badges")
        public void setBadges(List<Object> value) {
            this.badges = value;
        }
    }

    public static class Supplier {
        private String imageUrl;
        private String name;
        private Rating rating;

        @JsonProperty("imageUrl")
        public String getImageUrl() {
            return imageUrl;
        }

        @JsonProperty("imageUrl")
        public void setImageUrl(String value) {
            this.imageUrl = value;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String value) {
            this.name = value;
        }

        @JsonProperty("rating")
        public Rating getRating() {
            return rating;
        }

        @JsonProperty("rating")
        public void setRating(Rating value) {
            this.rating = value;
        }
    }

    public static class Rating {
        private String subtitle;
        private String average;
        private LocalisedRating localisedRating;
        private String title;

        @JsonProperty("subtitle")
        public String getSubtitle() {
            return subtitle;
        }

        @JsonProperty("subtitle")
        public void setSubtitle(String value) {
            this.subtitle = value;
        }

        @JsonProperty("average")
        public String getAverage() {
            return average;
        }

        @JsonProperty("average")
        public void setAverage(String value) {
            this.average = value;
        }

        @JsonProperty("localisedRating")
        public LocalisedRating getLocalisedRating() {
            return localisedRating;
        }

        @JsonProperty("localisedRating")
        public void setLocalisedRating(LocalisedRating value) {
            this.localisedRating = value;
        }

        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        @JsonProperty("title")
        public void setTitle(String value) {
            this.title = value;
        }
    }

    public static class LocalisedRating {
        private String displayValue;
        private double rawValue;

        @JsonProperty("displayValue")
        public String getDisplayValue() {
            return displayValue;
        }

        @JsonProperty("displayValue")
        public void setDisplayValue(String value) {
            this.displayValue = value;
        }

        @JsonProperty("rawValue")
        public double getRawValue() {
            return rawValue;
        }

        @JsonProperty("rawValue")
        public void setRawValue(double value) {
            this.rawValue = value;
        }
    }

    public static class FeeInfo {
        private long fee;
        private String currency;
        private long tax;
        private String type;

        @JsonProperty("fee")
        public long getFee() {
            return fee;
        }

        @JsonProperty("fee")
        public void setFee(long value) {
            this.fee = value;
        }

        @JsonProperty("currency")
        public String getCurrency() {
            return currency;
        }

        @JsonProperty("currency")
        public void setCurrency(String value) {
            this.currency = value;
        }

        @JsonProperty("tax")
        public long getTax() {
            return tax;
        }

        @JsonProperty("tax")
        public void setTax(long value) {
            this.tax = value;
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

    public static class PricingInfo {
        private double basePrice;
        private double price;
        private String baseCurrency;
        private FeeBreakdown feeBreakdown;
        private double driveAwayPrice;
        private Object driveAwayPriceBefore;
        private double baseDeposit;
        private boolean driveAwayPriceIsApprox;
        private double deposit;
        private String currency;
        private long quoteAllowed;
        private long discount;
        private String payWhen;

        @JsonProperty("base_price")
        public double getBasePrice() {
            return basePrice;
        }

        @JsonProperty("base_price")
        public void setBasePrice(double value) {
            this.basePrice = value;
        }

        @JsonProperty("price")
        public double getPrice() {
            return price;
        }

        @JsonProperty("price")
        public void setPrice(double value) {
            this.price = value;
        }

        @JsonProperty("base_currency")
        public String getBaseCurrency() {
            return baseCurrency;
        }

        @JsonProperty("base_currency")
        public void setBaseCurrency(String value) {
            this.baseCurrency = value;
        }

        @JsonProperty("fee_breakdown")
        public FeeBreakdown getFeeBreakdown() {
            return feeBreakdown;
        }

        @JsonProperty("fee_breakdown")
        public void setFeeBreakdown(FeeBreakdown value) {
            this.feeBreakdown = value;
        }

        @JsonProperty("drive_away_price")
        public double getDriveAwayPrice() {
            return driveAwayPrice;
        }

        @JsonProperty("drive_away_price")
        public void setDriveAwayPrice(double value) {
            this.driveAwayPrice = value;
        }

        @JsonProperty("drive_away_price_before")
        public Object getDriveAwayPriceBefore() {
            return driveAwayPriceBefore;
        }

        @JsonProperty("drive_away_price_before")
        public void setDriveAwayPriceBefore(Object value) {
            this.driveAwayPriceBefore = value;
        }

        @JsonProperty("base_deposit")
        public double getBaseDeposit() {
            return baseDeposit;
        }

        @JsonProperty("base_deposit")
        public void setBaseDeposit(double value) {
            this.baseDeposit = value;
        }

        @JsonProperty("drive_away_price_is_approx")
        public boolean getDriveAwayPriceIsApprox() {
            return driveAwayPriceIsApprox;
        }

        @JsonProperty("drive_away_price_is_approx")
        public void setDriveAwayPriceIsApprox(boolean value) {
            this.driveAwayPriceIsApprox = value;
        }

        @JsonProperty("deposit")
        public double getDeposit() {
            return deposit;
        }

        @JsonProperty("deposit")
        public void setDeposit(double value) {
            this.deposit = value;
        }

        @JsonProperty("currency")
        public String getCurrency() {
            return currency;
        }

        @JsonProperty("currency")
        public void setCurrency(String value) {
            this.currency = value;
        }

        @JsonProperty("quote_allowed")
        public long getQuoteAllowed() {
            return quoteAllowed;
        }

        @JsonProperty("quote_allowed")
        public void setQuoteAllowed(long value) {
            this.quoteAllowed = value;
        }

        @JsonProperty("discount")
        public long getDiscount() {
            return discount;
        }

        @JsonProperty("discount")
        public void setDiscount(long value) {
            this.discount = value;
        }

        @JsonProperty("pay_when")
        public String getPayWhen() {
            return payWhen;
        }

        @JsonProperty("pay_when")
        public void setPayWhen(String value) {
            this.payWhen = value;
        }
    }

    public static class FeeBreakdown {
        private FuelPolicy fuelPolicy;
        private List<KnownFee> knownFees;

        @JsonProperty("fuel_policy")
        public FuelPolicy getFuelPolicy() {
            return fuelPolicy;
        }

        @JsonProperty("fuel_policy")
        public void setFuelPolicy(FuelPolicy value) {
            this.fuelPolicy = value;
        }

        @JsonProperty("known_fees")
        public List<KnownFee> getKnownFees() {
            return knownFees;
        }

        @JsonProperty("known_fees")
        public void setKnownFees(List<KnownFee> value) {
            this.knownFees = value;
        }
    }

    public static class FuelPolicy {
        private String type;
        private long amount;
        private String currency;

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String value) {
            this.type = value;
        }

        @JsonProperty("amount")
        public long getAmount() {
            return amount;
        }

        @JsonProperty("amount")
        public void setAmount(long value) {
            this.amount = value;
        }

        @JsonProperty("currency")
        public String getCurrency() {
            return currency;
        }

        @JsonProperty("currency")
        public void setCurrency(String value) {
            this.currency = value;
        }
    }

    public static class KnownFee {
        private String type;
        private String currency;
        private Long isTaxIncluded;
        private Double amount;
        private Double minAmount;
        private Double maxAmount;
        private long isAlwaysPayable;
        private DistanceAllowed distanceAllowed;

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String value) {
            this.type = value;
        }

        @JsonProperty("currency")
        public String getCurrency() {
            return currency;
        }

        @JsonProperty("currency")
        public void setCurrency(String value) {
            this.currency = value;
        }

        @JsonProperty("is_tax_included")
        public Long getIsTaxIncluded() {
            return isTaxIncluded;
        }

        @JsonProperty("is_tax_included")
        public void setIsTaxIncluded(Long value) {
            this.isTaxIncluded = value;
        }

        @JsonProperty("amount")
        public Double getAmount() {
            return amount;
        }

        @JsonProperty("amount")
        public void setAmount(Double value) {
            this.amount = value;
        }

        @JsonProperty("min_amount")
        public Double getMinAmount() {
            return minAmount;
        }

        @JsonProperty("min_amount")
        public void setMinAmount(Double value) {
            this.minAmount = value;
        }

        @JsonProperty("max_amount")
        public Double getMaxAmount() {
            return maxAmount;
        }

        @JsonProperty("max_amount")
        public void setMaxAmount(Double value) {
            this.maxAmount = value;
        }

        @JsonProperty("is_always_payable")
        public long getIsAlwaysPayable() {
            return isAlwaysPayable;
        }

        @JsonProperty("is_always_payable")
        public void setIsAlwaysPayable(long value) {
            this.isAlwaysPayable = value;
        }

        @JsonProperty("distance_allowed")
        public DistanceAllowed getDistanceAllowed() {
            return distanceAllowed;
        }

        @JsonProperty("distance_allowed")
        public void setDistanceAllowed(DistanceAllowed value) {
            this.distanceAllowed = value;
        }
    }

    public static class DistanceAllowed {
        private long isUnlimited;
        private Object value;
        private Object perDuration;
        private long iskm;

        @JsonProperty("is_unlimited")
        public long getIsUnlimited() {
            return isUnlimited;
        }

        @JsonProperty("is_unlimited")
        public void setIsUnlimited(long value) {
            this.isUnlimited = value;
        }

        @JsonProperty("value")
        public Object getValue() {
            return value;
        }

        @JsonProperty("value")
        public void setValue(Object value) {
            this.value = value;
        }

        @JsonProperty("per_duration")
        public Object getPerDuration() {
            return perDuration;
        }

        @JsonProperty("per_duration")
        public void setPerDuration(Object value) {
            this.perDuration = value;
        }

        @JsonProperty("is_km")
        public long getIskm() {
            return iskm;
        }

        @JsonProperty("is_km")
        public void setIskm(long value) {
            this.iskm = value;
        }
    }

    public static class RatingInfo {
        private long noOfRatings;
        private double location;
        private double pickupTime;
        private double cleanliness;
        private double condition;
        private double average;
        private String averageText;
        private double dropoffTime;
        private double valueForMoney;
        private double efficiency;

        @JsonProperty("no_of_ratings")
        public long getNoOfRatings() {
            return noOfRatings;
        }

        @JsonProperty("no_of_ratings")
        public void setNoOfRatings(long value) {
            this.noOfRatings = value;
        }

        @JsonProperty("location")
        public double getLocation() {
            return location;
        }

        @JsonProperty("location")
        public void setLocation(double value) {
            this.location = value;
        }

        @JsonProperty("pickup_time")
        public double getPickupTime() {
            return pickupTime;
        }

        @JsonProperty("pickup_time")
        public void setPickupTime(double value) {
            this.pickupTime = value;
        }

        @JsonProperty("cleanliness")
        public double getCleanliness() {
            return cleanliness;
        }

        @JsonProperty("cleanliness")
        public void setCleanliness(double value) {
            this.cleanliness = value;
        }

        @JsonProperty("condition")
        public double getCondition() {
            return condition;
        }

        @JsonProperty("condition")
        public void setCondition(double value) {
            this.condition = value;
        }

        @JsonProperty("average")
        public double getAverage() {
            return average;
        }

        @JsonProperty("average")
        public void setAverage(double value) {
            this.average = value;
        }

        @JsonProperty("average_text")
        public String getAverageText() {
            return averageText;
        }

        @JsonProperty("average_text")
        public void setAverageText(String value) {
            this.averageText = value;
        }

        @JsonProperty("dropoff_time")
        public double getDropoffTime() {
            return dropoffTime;
        }

        @JsonProperty("dropoff_time")
        public void setDropoffTime(double value) {
            this.dropoffTime = value;
        }

        @JsonProperty("value_for_money")
        public double getValueForMoney() {
            return valueForMoney;
        }

        @JsonProperty("value_for_money")
        public void setValueForMoney(double value) {
            this.valueForMoney = value;
        }

        @JsonProperty("efficiency")
        public double getEfficiency() {
            return efficiency;
        }

        @JsonProperty("efficiency")
        public void setEfficiency(double value) {
            this.efficiency = value;
        }
    }

    public static class RouteInfo {
        private Dropoff pickup;
        private Dropoff dropoff;

        @JsonProperty("pickup")
        public Dropoff getPickup() {
            return pickup;
        }

        @JsonProperty("pickup")
        public void setPickup(Dropoff value) {
            this.pickup = value;
        }

        @JsonProperty("dropoff")
        public Dropoff getDropoff() {
            return dropoff;
        }

        @JsonProperty("dropoff")
        public void setDropoff(Dropoff value) {
            this.dropoff = value;
        }
    }

    public static class Dropoff {
        private String locationType;
        private String longitude;
        private String countryCode;
        private String address;
        private String country;
        private String icon;
        private String locationid;
        private String name;
        private String latitude;
        private String city;

        @JsonProperty("location_type")
        public String getLocationType() {
            return locationType;
        }

        @JsonProperty("location_type")
        public void setLocationType(String value) {
            this.locationType = value;
        }

        @JsonProperty("longitude")
        public String getLongitude() {
            return longitude;
        }

        @JsonProperty("longitude")
        public void setLongitude(String value) {
            this.longitude = value;
        }

        @JsonProperty("country_code")
        public String getCountryCode() {
            return countryCode;
        }

        @JsonProperty("country_code")
        public void setCountryCode(String value) {
            this.countryCode = value;
        }

        @JsonProperty("address")
        public String getAddress() {
            return address;
        }

        @JsonProperty("address")
        public void setAddress(String value) {
            this.address = value;
        }

        @JsonProperty("country")
        public String getCountry() {
            return country;
        }

        @JsonProperty("country")
        public void setCountry(String value) {
            this.country = value;
        }

        @JsonProperty("icon")
        public String getIcon() {
            return icon;
        }

        @JsonProperty("icon")
        public void setIcon(String value) {
            this.icon = value;
        }

        @JsonProperty("location_id")
        public String getLocationid() {
            return locationid;
        }

        @JsonProperty("location_id")
        public void setLocationid(String value) {
            this.locationid = value;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String value) {
            this.name = value;
        }

        @JsonProperty("latitude")
        public String getLatitude() {
            return latitude;
        }

        @JsonProperty("latitude")
        public void setLatitude(String value) {
            this.latitude = value;
        }

        @JsonProperty("city")
        public String getCity() {
            return city;
        }

        @JsonProperty("city")
        public void setCity(String value) {
            this.city = value;
        }
    }

    public static class SupplierInfo {
        private String locationType;
        private boolean mayRequireCreditCardGuarantee;
        private String longitude;
        private String dropoffInstructions;
        private String address;
        private String logourl;
        private String pickupInstructions;
        private String name;
        private String latitude;

        @JsonProperty("location_type")
        public String getLocationType() {
            return locationType;
        }

        @JsonProperty("location_type")
        public void setLocationType(String value) {
            this.locationType = value;
        }

        @JsonProperty("may_require_credit_card_guarantee")
        public boolean getMayRequireCreditCardGuarantee() {
            return mayRequireCreditCardGuarantee;
        }

        @JsonProperty("may_require_credit_card_guarantee")
        public void setMayRequireCreditCardGuarantee(boolean value) {
            this.mayRequireCreditCardGuarantee = value;
        }

        @JsonProperty("longitude")
        public String getLongitude() {
            return longitude;
        }

        @JsonProperty("longitude")
        public void setLongitude(String value) {
            this.longitude = value;
        }

        @JsonProperty("dropoff_instructions")
        public String getDropoffInstructions() {
            return dropoffInstructions;
        }

        @JsonProperty("dropoff_instructions")
        public void setDropoffInstructions(String value) {
            this.dropoffInstructions = value;
        }

        @JsonProperty("address")
        public String getAddress() {
            return address;
        }

        @JsonProperty("address")
        public void setAddress(String value) {
            this.address = value;
        }

        @JsonProperty("logo_url")
        public String getLogourl() {
            return logourl;
        }

        @JsonProperty("logo_url")
        public void setLogourl(String value) {
            this.logourl = value;
        }

        @JsonProperty("pickup_instructions")
        public String getPickupInstructions() {
            return pickupInstructions;
        }

        @JsonProperty("pickup_instructions")
        public void setPickupInstructions(String value) {
            this.pickupInstructions = value;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String value) {
            this.name = value;
        }

        @JsonProperty("latitude")
        public String getLatitude() {
            return latitude;
        }

        @JsonProperty("latitude")
        public void setLatitude(String value) {
            this.latitude = value;
        }
    }

    public static class VehicleInfo {
        private String vid;
        private Suitcases suitcases;
        private String imageThumbnailurl;
        private String seats;
        private String label;
        private String fuelPolicy;
        private long aircon;
        private String doors;
        private String fuelType;
        private Object specialOfferText;
        private String group;
        private String transmission;
        private long cmaCompliant;
        private String fuelPolicyDescription;
        private long freeCancellation;
        private long unlimitedMileage;
        private long airbags;
        private String imageurl;
        private String mileage;
        private String insurancePackage;
        private String vName;

        @JsonProperty("v_id")
        public String getVid() {
            return vid;
        }

        @JsonProperty("v_id")
        public void setVid(String value) {
            this.vid = value;
        }

        @JsonProperty("suitcases")
        public Suitcases getSuitcases() {
            return suitcases;
        }

        @JsonProperty("suitcases")
        public void setSuitcases(Suitcases value) {
            this.suitcases = value;
        }

        @JsonProperty("image_thumbnail_url")
        public String getImageThumbnailurl() {
            return imageThumbnailurl;
        }

        @JsonProperty("image_thumbnail_url")
        public void setImageThumbnailurl(String value) {
            this.imageThumbnailurl = value;
        }

        @JsonProperty("seats")
        public String getSeats() {
            return seats;
        }

        @JsonProperty("seats")
        public void setSeats(String value) {
            this.seats = value;
        }

        @JsonProperty("label")
        public String getLabel() {
            return label;
        }

        @JsonProperty("label")
        public void setLabel(String value) {
            this.label = value;
        }

        @JsonProperty("fuel_policy")
        public String getFuelPolicy() {
            return fuelPolicy;
        }

        @JsonProperty("fuel_policy")
        public void setFuelPolicy(String value) {
            this.fuelPolicy = value;
        }

        @JsonProperty("aircon")
        public long getAircon() {
            return aircon;
        }

        @JsonProperty("aircon")
        public void setAircon(long value) {
            this.aircon = value;
        }

        @JsonProperty("doors")
        public String getDoors() {
            return doors;
        }

        @JsonProperty("doors")
        public void setDoors(String value) {
            this.doors = value;
        }

        @JsonProperty("fuel_type")
        public String getFuelType() {
            return fuelType;
        }

        @JsonProperty("fuel_type")
        public void setFuelType(String value) {
            this.fuelType = value;
        }

        @JsonProperty("special_offer_text")
        public Object getSpecialOfferText() {
            return specialOfferText;
        }

        @JsonProperty("special_offer_text")
        public void setSpecialOfferText(Object value) {
            this.specialOfferText = value;
        }

        @JsonProperty("group")
        public String getGroup() {
            return group;
        }

        @JsonProperty("group")
        public void setGroup(String value) {
            this.group = value;
        }

        @JsonProperty("transmission")
        public String getTransmission() {
            return transmission;
        }

        @JsonProperty("transmission")
        public void setTransmission(String value) {
            this.transmission = value;
        }

        @JsonProperty("cma_compliant")
        public long getCmaCompliant() {
            return cmaCompliant;
        }

        @JsonProperty("cma_compliant")
        public void setCmaCompliant(long value) {
            this.cmaCompliant = value;
        }

        @JsonProperty("fuel_policy_description")
        public String getFuelPolicyDescription() {
            return fuelPolicyDescription;
        }

        @JsonProperty("fuel_policy_description")
        public void setFuelPolicyDescription(String value) {
            this.fuelPolicyDescription = value;
        }

        @JsonProperty("free_cancellation")
        public long getFreeCancellation() {
            return freeCancellation;
        }

        @JsonProperty("free_cancellation")
        public void setFreeCancellation(long value) {
            this.freeCancellation = value;
        }

        @JsonProperty("unlimited_mileage")
        public long getUnlimitedMileage() {
            return unlimitedMileage;
        }

        @JsonProperty("unlimited_mileage")
        public void setUnlimitedMileage(long value) {
            this.unlimitedMileage = value;
        }

        @JsonProperty("airbags")
        public long getAirbags() {
            return airbags;
        }

        @JsonProperty("airbags")
        public void setAirbags(long value) {
            this.airbags = value;
        }

        @JsonProperty("image_url")
        public String getImageurl() {
            return imageurl;
        }

        @JsonProperty("image_url")
        public void setImageurl(String value) {
            this.imageurl = value;
        }

        @JsonProperty("mileage")
        public String getMileage() {
            return mileage;
        }

        @JsonProperty("mileage")
        public void setMileage(String value) {
            this.mileage = value;
        }

        @JsonProperty("insurance_package")
        public String getInsurancePackage() {
            return insurancePackage;
        }

        @JsonProperty("insurance_package")
        public void setInsurancePackage(String value) {
            this.insurancePackage = value;
        }

        @JsonProperty("v_name")
        public String getVName() {
            return vName;
        }

        @JsonProperty("v_name")
        public void setVName(String value) {
            this.vName = value;
        }
    }

    public static class Suitcases {
        private String big;
        private String small;

        @JsonProperty("big")
        public String getBig() {
            return big;
        }

        @JsonProperty("big")
        public void setBig(String value) {
            this.big = value;
        }

        @JsonProperty("small")
        public String getSmall() {
            return small;
        }

        @JsonProperty("small")
        public void setSmall(String value) {
            this.small = value;
        }
    }

    public static class Sort {
        private String identifier;
        private String titleTag;
        private String name;

        @JsonProperty("identifier")
        public String getIdentifier() {
            return identifier;
        }

        @JsonProperty("identifier")
        public void setIdentifier(String value) {
            this.identifier = value;
        }

        @JsonProperty("title_tag")
        public String getTitleTag() {
            return titleTag;
        }

        @JsonProperty("title_tag")
        public void setTitleTag(String value) {
            this.titleTag = value;
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
}