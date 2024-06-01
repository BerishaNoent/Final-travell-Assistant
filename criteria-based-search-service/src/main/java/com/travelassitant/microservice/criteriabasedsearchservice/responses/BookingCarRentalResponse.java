package com.travelassitant.microservice.criteriabasedsearchservice.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.*;

public class BookingCarRentalResponse {
    private Data data;

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data value) {
        this.data = value;
    }

    public static class Data {
        private long count;
        private Object discountBanner;
        private boolean isGeniusLocation;
        private String provider;
        private String searchKey;
        private List<SearchResult> searchResults;
        private String title;
        private String type;

        @JsonProperty("count")
        public long getCount() {
            return count;
        }

        @JsonProperty("count")
        public void setCount(long value) {
            this.count = value;
        }

        @JsonProperty("discount_banner")
        public Object getDiscountBanner() {
            return discountBanner;
        }

        @JsonProperty("discount_banner")
        public void setDiscountBanner(Object value) {
            this.discountBanner = value;
        }

        @JsonProperty("is_genius_location")
        public boolean getIsGeniusLocation() {
            return isGeniusLocation;
        }

        @JsonProperty("is_genius_location")
        public void setIsGeniusLocation(boolean value) {
            this.isGeniusLocation = value;
        }

        @JsonProperty("provider")
        public String getProvider() {
            return provider;
        }

        @JsonProperty("provider")
        public void setProvider(String value) {
            this.provider = value;
        }

        @JsonProperty("search_key")
        public String getSearchKey() {
            return searchKey;
        }

        @JsonProperty("search_key")
        public void setSearchKey(String value) {
            this.searchKey = value;
        }

        @JsonProperty("search_results")
        public List<SearchResult> getSearchResults() {
            return searchResults;
        }

        @JsonProperty("search_results")
        public void setSearchResults(List<SearchResult> value) {
            this.searchResults = value;
        }

        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        @JsonProperty("title")
        public void setTitle(String value) {
            this.title = value;
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

    public static class SearchResult {
        private Accessibility accessibility;
        private List<Object> appliedDiscountTypes;
        private SearchResultContent content;
        private String forwardurl;
        private List<String> freebies;
        private String payWhenText;
        private PricingInfo pricingInfo;
        private SupplierInfo supplierInfo;
        private VehicleInfo vehicleInfo;

        @JsonProperty("accessibility")
        public Accessibility getAccessibility() {
            return accessibility;
        }

        @JsonProperty("accessibility")
        public void setAccessibility(Accessibility value) {
            this.accessibility = value;
        }

        @JsonProperty("applied_discount_types")
        public List<Object> getAppliedDiscountTypes() {
            return appliedDiscountTypes;
        }

        @JsonProperty("applied_discount_types")
        public void setAppliedDiscountTypes(List<Object> value) {
            this.appliedDiscountTypes = value;
        }

        @JsonProperty("content")
        public SearchResultContent getContent() {
            return content;
        }

        @JsonProperty("content")
        public void setContent(SearchResultContent value) {
            this.content = value;
        }

        @JsonProperty("forward_url")
        public String getForwardurl() {
            return forwardurl;
        }

        @JsonProperty("forward_url")
        public void setForwardurl(String value) {
            this.forwardurl = value;
        }

        @JsonProperty("freebies")
        public List<String> getFreebies() {
            return freebies;
        }

        @JsonProperty("freebies")
        public void setFreebies(List<String> value) {
            this.freebies = value;
        }

        @JsonProperty("pay_when_text")
        public String getPayWhenText() {
            return payWhenText;
        }

        @JsonProperty("pay_when_text")
        public void setPayWhenText(String value) {
            this.payWhenText = value;
        }

        @JsonProperty("pricing_info")
        public PricingInfo getPricingInfo() {
            return pricingInfo;
        }

        @JsonProperty("pricing_info")
        public void setPricingInfo(PricingInfo value) {
            this.pricingInfo = value;
        }

        @JsonProperty("supplier_info")
        public SupplierInfo getSupplierInfo() {
            return supplierInfo;
        }

        @JsonProperty("supplier_info")
        public void setSupplierInfo(SupplierInfo value) {
            this.supplierInfo = value;
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
        private String fuelPolicy;
        private String pickUpLocation;
        private String supplierRating;
        private String transmission;

        @JsonProperty("fuel_policy")
        public String getFuelPolicy() {
            return fuelPolicy;
        }

        @JsonProperty("fuel_policy")
        public void setFuelPolicy(String value) {
            this.fuelPolicy = value;
        }

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
        private List<Badge> badges;
        private Supplier supplier;

        @JsonProperty("badges")
        public List<Badge> getBadges() {
            return badges;
        }

        @JsonProperty("badges")
        public void setBadges(List<Badge> value) {
            this.badges = value;
        }

        @JsonProperty("supplier")
        public Supplier getSupplier() {
            return supplier;
        }

        @JsonProperty("supplier")
        public void setSupplier(Supplier value) {
            this.supplier = value;
        }
    }

    public static class Badge {
        private String text;
        private String type;
        private String variation;

        @JsonProperty("text")
        public String getText() {
            return text;
        }

        @JsonProperty("text")
        public void setText(String value) {
            this.text = value;
        }

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String value) {
            this.type = value;
        }

        @JsonProperty("variation")
        public String getVariation() {
            return variation;
        }

        @JsonProperty("variation")
        public void setVariation(String value) {
            this.variation = value;
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
        private String average;

        @JsonProperty("average")
        public String getAverage() {
            return average;
        }

        @JsonProperty("average")
        public void setAverage(String value) {
            this.average = value;
        }

    }

    public static class PricingInfo {
        private String baseCurrency;
        private Double baseDeposit;
        private Double basePrice;
        private String currency;
        private Double deposit;
        private Long discount;
        private double driveAwayPrice;
        private Object driveAwayPriceBefore;
        private boolean driveAwayPriceIsApprox;
        private String payWhen;
        private Double price;
        private long quoteAllowed;

        @JsonProperty("base_currency")
        public String getBaseCurrency() {
            return baseCurrency;
        }

        @JsonProperty("base_currency")
        public void setBaseCurrency(String value) {
            this.baseCurrency = value;
        }

        @JsonProperty("base_deposit")
        public Double getBaseDeposit() {
            return baseDeposit;
        }

        @JsonProperty("base_deposit")
        public void setBaseDeposit(Double value) {
            this.baseDeposit = value;
        }

        @JsonProperty("base_price")
        public Double getBasePrice() {
            return basePrice;
        }

        @JsonProperty("base_price")
        public void setBasePrice(Double value) {
            this.basePrice = value;
        }

        @JsonProperty("currency")
        public String getCurrency() {
            return currency;
        }

        @JsonProperty("currency")
        public void setCurrency(String value) {
            this.currency = value;
        }

        @JsonProperty("deposit")
        public Double getDeposit() {
            return deposit;
        }

        @JsonProperty("deposit")
        public void setDeposit(Double value) {
            this.deposit = value;
        }

        @JsonProperty("discount")
        public Long getDiscount() {
            return discount;
        }

        @JsonProperty("discount")
        public void setDiscount(Long value) {
            this.discount = value;
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

        @JsonProperty("drive_away_price_is_approx")
        public boolean getDriveAwayPriceIsApprox() {
            return driveAwayPriceIsApprox;
        }

        @JsonProperty("drive_away_price_is_approx")
        public void setDriveAwayPriceIsApprox(boolean value) {
            this.driveAwayPriceIsApprox = value;
        }

        @JsonProperty("pay_when")
        public String getPayWhen() {
            return payWhen;
        }

        @JsonProperty("pay_when")
        public void setPayWhen(String value) {
            this.payWhen = value;
        }

        @JsonProperty("price")
        public Double getPrice() {
            return price;
        }

        @JsonProperty("price")
        public void setPrice(Double value) {
            this.price = value;
        }

        @JsonProperty("quote_allowed")
        public long getQuoteAllowed() {
            return quoteAllowed;
        }

        @JsonProperty("quote_allowed")
        public void setQuoteAllowed(long value) {
            this.quoteAllowed = value;
        }
    }

    public static class SupplierInfo {
        private String address;
        private String dropoffInstructions;
        private String latitude;
        private String locationType;
        private String logourl;
        private String longitude;
        private boolean mayRequireCreditCardGuarantee;
        private String name;
        private String pickupInstructions;

        @JsonProperty("address")
        public String getAddress() {
            return address;
        }

        @JsonProperty("address")
        public void setAddress(String value) {
            this.address = value;
        }

        @JsonProperty("dropoff_instructions")
        public String getDropoffInstructions() {
            return dropoffInstructions;
        }

        @JsonProperty("dropoff_instructions")
        public void setDropoffInstructions(String value) {
            this.dropoffInstructions = value;
        }

        @JsonProperty("latitude")
        public String getLatitude() {
            return latitude;
        }

        @JsonProperty("latitude")
        public void setLatitude(String value) {
            this.latitude = value;
        }

        @JsonProperty("location_type")
        public String getLocationType() {
            return locationType;
        }

        @JsonProperty("location_type")
        public void setLocationType(String value) {
            this.locationType = value;
        }

        @JsonProperty("logo_url")
        public String getLogourl() {
            return logourl;
        }

        @JsonProperty("logo_url")
        public void setLogourl(String value) {
            this.logourl = value;
        }

        @JsonProperty("longitude")
        public String getLongitude() {
            return longitude;
        }

        @JsonProperty("longitude")
        public void setLongitude(String value) {
            this.longitude = value;
        }

        @JsonProperty("may_require_credit_card_guarantee")
        public boolean getMayRequireCreditCardGuarantee() {
            return mayRequireCreditCardGuarantee;
        }

        @JsonProperty("may_require_credit_card_guarantee")
        public void setMayRequireCreditCardGuarantee(boolean value) {
            this.mayRequireCreditCardGuarantee = value;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String value) {
            this.name = value;
        }

        @JsonProperty("pickup_instructions")
        public String getPickupInstructions() {
            return pickupInstructions;
        }

        @JsonProperty("pickup_instructions")
        public void setPickupInstructions(String value) {
            this.pickupInstructions = value;
        }
    }

    public static class VehicleInfo {
        private long airbags;
        private long aircon;
        private long cmaCompliant;
        private String doors;
        private long freeCancellation;
        private String fuelPolicy;
        private String fuelPolicyDescription;
        private String fuelType;
        private String group;
        private String imageThumbnailurl;
        private String imageurl;
        private String insurancePackage;
        private String label;
        private String mileage;
        private String seats;
        private String specialOfferText;
        private String transmission;
        private long unlimitedMileage;
        private String vid;
        private String vName;

        @JsonProperty("airbags")
        public long getAirbags() {
            return airbags;
        }

        @JsonProperty("airbags")
        public void setAirbags(long value) {
            this.airbags = value;
        }

        @JsonProperty("aircon")
        public long getAircon() {
            return aircon;
        }

        @JsonProperty("aircon")
        public void setAircon(long value) {
            this.aircon = value;
        }

        @JsonProperty("cma_compliant")
        public long getCmaCompliant() {
            return cmaCompliant;
        }

        @JsonProperty("cma_compliant")
        public void setCmaCompliant(long value) {
            this.cmaCompliant = value;
        }

        @JsonProperty("doors")
        public String getDoors() {
            return doors;
        }

        @JsonProperty("doors")
        public void setDoors(String value) {
            this.doors = value;
        }

        @JsonProperty("free_cancellation")
        public long getFreeCancellation() {
            return freeCancellation;
        }

        @JsonProperty("free_cancellation")
        public void setFreeCancellation(long value) {
            this.freeCancellation = value;
        }

        @JsonProperty("fuel_policy")
        public String getFuelPolicy() {
            return fuelPolicy;
        }

        @JsonProperty("fuel_policy")
        public void setFuelPolicy(String value) {
            this.fuelPolicy = value;
        }

        @JsonProperty("fuel_policy_description")
        public String getFuelPolicyDescription() {
            return fuelPolicyDescription;
        }

        @JsonProperty("fuel_policy_description")
        public void setFuelPolicyDescription(String value) {
            this.fuelPolicyDescription = value;
        }

        @JsonProperty("fuel_type")
        public String getFuelType() {
            return fuelType;
        }

        @JsonProperty("fuel_type")
        public void setFuelType(String value) {
            this.fuelType = value;
        }

        @JsonProperty("group")
        public String getGroup() {
            return group;
        }

        @JsonProperty("group")
        public void setGroup(String value) {
            this.group = value;
        }

        @JsonProperty("image_thumbnail_url")
        public String getImageThumbnailurl() {
            return imageThumbnailurl;
        }

        @JsonProperty("image_thumbnail_url")
        public void setImageThumbnailurl(String value) {
            this.imageThumbnailurl = value;
        }

        @JsonProperty("image_url")
        public String getImageurl() {
            return imageurl;
        }

        @JsonProperty("image_url")
        public void setImageurl(String value) {
            this.imageurl = value;
        }

        @JsonProperty("insurance_package")
        public String getInsurancePackage() {
            return insurancePackage;
        }

        @JsonProperty("insurance_package")
        public void setInsurancePackage(String value) {
            this.insurancePackage = value;
        }

        @JsonProperty("label")
        public String getLabel() {
            return label;
        }

        @JsonProperty("label")
        public void setLabel(String value) {
            this.label = value;
        }

        @JsonProperty("mileage")
        public String getMileage() {
            return mileage;
        }

        @JsonProperty("mileage")
        public void setMileage(String value) {
            this.mileage = value;
        }

        @JsonProperty("seats")
        public String getSeats() {
            return seats;
        }

        @JsonProperty("seats")
        public void setSeats(String value) {
            this.seats = value;
        }

        @JsonProperty("special_offer_text")
        public String getSpecialOfferText() {
            return specialOfferText;
        }

        @JsonProperty("special_offer_text")
        public void setSpecialOfferText(String value) {
            this.specialOfferText = value;
        }

        @JsonProperty("transmission")
        public String getTransmission() {
            return transmission;
        }

        @JsonProperty("transmission")
        public void setTransmission(String value) {
            this.transmission = value;
        }

        @JsonProperty("unlimited_mileage")
        public long getUnlimitedMileage() {
            return unlimitedMileage;
        }

        @JsonProperty("unlimited_mileage")
        public void setUnlimitedMileage(long value) {
            this.unlimitedMileage = value;
        }

        @JsonProperty("v_id")
        public String getVid() {
            return vid;
        }

        @JsonProperty("v_id")
        public void setVid(String value) {
            this.vid = value;
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

}