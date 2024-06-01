package com.travelassitant.microservice.hotelsearchservice.responses.SkyScannerResponses;

import java.util.List;

import com.fasterxml.jackson.annotation.*;

public class SkyScannerHotelSearch {
    private Data data;
    private Meta meta;
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

    @JsonProperty("meta")
    public Meta getMeta() {
        return meta;
    }

    @JsonProperty("meta")
    public void setMeta(Meta value) {
        this.meta = value;
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
        private Results results;
        private Status status;
        private Object error;

        @JsonProperty("results")
        public Results getResults() {
            return results;
        }

        @JsonProperty("results")
        public void setResults(Results value) {
            this.results = value;
        }

        @JsonProperty("status")
        public Status getStatus() {
            return status;
        }

        @JsonProperty("status")
        public void setStatus(Status value) {
            this.status = value;
        }

        @JsonProperty("error")
        public Object getError() {
            return error;
        }

        @JsonProperty("error")
        public void setError(Object value) {
            this.error = value;
        }
    }

    public static class Results {
        private String priceType;
        private String pricePolicy;
        private SearchSummary searchSummary;
        private MapBoundary mapBoundary;
        private HotelsRegion hotelsRegion;
        private List<HotelCard> hotelCards;
        private List<Filter> filters;
        private List<HotelsCoordinate> hotelsCoordinates;
        private List<SortOption> sortOptions;
        private List<Object> travelInfos;
        private List<String> partnerList;

        @JsonProperty("priceType")
        public String getPriceType() {
            return priceType;
        }

        @JsonProperty("priceType")
        public void setPriceType(String value) {
            this.priceType = value;
        }

        @JsonProperty("pricePolicy")
        public String getPricePolicy() {
            return pricePolicy;
        }

        @JsonProperty("pricePolicy")
        public void setPricePolicy(String value) {
            this.pricePolicy = value;
        }

        @JsonProperty("searchSummary")
        public SearchSummary getSearchSummary() {
            return searchSummary;
        }

        @JsonProperty("searchSummary")
        public void setSearchSummary(SearchSummary value) {
            this.searchSummary = value;
        }

        @JsonProperty("mapBoundary")
        public MapBoundary getMapBoundary() {
            return mapBoundary;
        }

        @JsonProperty("mapBoundary")
        public void setMapBoundary(MapBoundary value) {
            this.mapBoundary = value;
        }

        @JsonProperty("hotelsRegion")
        public HotelsRegion getHotelsRegion() {
            return hotelsRegion;
        }

        @JsonProperty("hotelsRegion")
        public void setHotelsRegion(HotelsRegion value) {
            this.hotelsRegion = value;
        }

        @JsonProperty("hotelCards")
        public List<HotelCard> getHotelCards() {
            return hotelCards;
        }

        @JsonProperty("hotelCards")
        public void setHotelCards(List<HotelCard> value) {
            this.hotelCards = value;
        }

        @JsonProperty("filters")
        public List<Filter> getFilters() {
            return filters;
        }

        @JsonProperty("filters")
        public void setFilters(List<Filter> value) {
            this.filters = value;
        }

        @JsonProperty("hotelsCoordinates")
        public List<HotelsCoordinate> getHotelsCoordinates() {
            return hotelsCoordinates;
        }

        @JsonProperty("hotelsCoordinates")
        public void setHotelsCoordinates(List<HotelsCoordinate> value) {
            this.hotelsCoordinates = value;
        }

        @JsonProperty("sortOptions")
        public List<SortOption> getSortOptions() {
            return sortOptions;
        }

        @JsonProperty("sortOptions")
        public void setSortOptions(List<SortOption> value) {
            this.sortOptions = value;
        }

        @JsonProperty("travelInfos")
        public List<Object> getTravelInfos() {
            return travelInfos;
        }

        @JsonProperty("travelInfos")
        public void setTravelInfos(List<Object> value) {
            this.travelInfos = value;
        }

        @JsonProperty("partnerList")
        public List<String> getPartnerList() {
            return partnerList;
        }

        @JsonProperty("partnerList")
        public void setPartnerList(List<String> value) {
            this.partnerList = value;
        }
    }

    public static class Filter {
        private String type;
        private String title;
        private List<Value> values;

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String value) {
            this.type = value;
        }

        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        @JsonProperty("title")
        public void setTitle(String value) {
            this.title = value;
        }

        @JsonProperty("values")
        public List<Value> getValues() {
            return values;
        }

        @JsonProperty("values")
        public void setValues(List<Value> value) {
            this.values = value;
        }
    }

    public static class Value {
        private String id;
        private String label;
        private Long minPrice;
        private Long maxPrice;
        private Long count;
        private String uniqueId;
        private String icon;
        private String poiType;
        private String poiName;
        private List<PoiOption> poiOptions;

        @JsonProperty("id")
        public String getid() {
            return id;
        }

        @JsonProperty("id")
        public void setid(String value) {
            this.id = value;
        }

        @JsonProperty("label")
        public String getLabel() {
            return label;
        }

        @JsonProperty("label")
        public void setLabel(String value) {
            this.label = value;
        }

        @JsonProperty("minPrice")
        public Long getMinPrice() {
            return minPrice;
        }

        @JsonProperty("minPrice")
        public void setMinPrice(Long value) {
            this.minPrice = value;
        }

        @JsonProperty("maxPrice")
        public Long getMaxPrice() {
            return maxPrice;
        }

        @JsonProperty("maxPrice")
        public void setMaxPrice(Long value) {
            this.maxPrice = value;
        }

        @JsonProperty("count")
        public Long getCount() {
            return count;
        }

        @JsonProperty("count")
        public void setCount(Long value) {
            this.count = value;
        }

        @JsonProperty("uniqueId")
        public String getUniqueId() {
            return uniqueId;
        }

        @JsonProperty("uniqueId")
        public void setUniqueId(String value) {
            this.uniqueId = value;
        }

        @JsonProperty("icon")
        public String getIcon() {
            return icon;
        }

        @JsonProperty("icon")
        public void setIcon(String value) {
            this.icon = value;
        }

        @JsonProperty("poiType")
        public String getPoiType() {
            return poiType;
        }

        @JsonProperty("poiType")
        public void setPoiType(String value) {
            this.poiType = value;
        }

        @JsonProperty("poiName")
        public String getPoiName() {
            return poiName;
        }

        @JsonProperty("poiName")
        public void setPoiName(String value) {
            this.poiName = value;
        }

        @JsonProperty("poiOptions")
        public List<PoiOption> getPoiOptions() {
            return poiOptions;
        }

        @JsonProperty("poiOptions")
        public void setPoiOptions(List<PoiOption> value) {
            this.poiOptions = value;
        }
    }

    public static class PoiOption {
        private long id;
        private String name;
        private String type;
        private List<Double> coordinate;
        private String image;
        private String subType;

        @JsonProperty("id")
        public long getid() {
            return id;
        }

        @JsonProperty("id")
        public void setid(long value) {
            this.id = value;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String value) {
            this.name = value;
        }

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String value) {
            this.type = value;
        }

        @JsonProperty("coordinate")
        public List<Double> getCoordinate() {
            return coordinate;
        }

        @JsonProperty("coordinate")
        public void setCoordinate(List<Double> value) {
            this.coordinate = value;
        }

        @JsonProperty("image")
        public String getImage() {
            return image;
        }

        @JsonProperty("image")
        public void setImage(String value) {
            this.image = value;
        }

        @JsonProperty("subType")
        public String getSubType() {
            return subType;
        }

        @JsonProperty("subType")
        public void setSubType(String value) {
            this.subType = value;
        }
    }

    public static class HotelCard {
        private String id;
        private String name;
        private String stars;
        private String distance;
        private String relevantPoiDistance;
        private Coordinates coordinates;
        private boolean pivot;
        private List<String> images;
        private ReviewsSummary reviewsSummary;
        private List<ConfidentMessage> confidentMessages;
        private Object minPriceDbookRoomId;
        private Object minPriceDbookPartnerId;
        private boolean inbound;
        private LowestPrice lowestPrice;
        private List<Object> otherPrices;
        private boolean isUpSorted;
        private String hotelId;

        @JsonProperty("id")
        public String getid() {
            return id;
        }

        @JsonProperty("id")
        public void setid(String value) {
            this.id = value;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String value) {
            this.name = value;
        }

        @JsonProperty("stars")
        public String getStars() {
            return stars;
        }

        @JsonProperty("stars")
        public void setStars(String value) {
            this.stars = value;
        }

        @JsonProperty("distance")
        public String getDistance() {
            return distance;
        }

        @JsonProperty("distance")
        public void setDistance(String value) {
            this.distance = value;
        }

        @JsonProperty("relevantPoiDistance")
        public String getRelevantPoiDistance() {
            return relevantPoiDistance;
        }

        @JsonProperty("relevantPoiDistance")
        public void setRelevantPoiDistance(String value) {
            this.relevantPoiDistance = value;
        }

        @JsonProperty("coordinates")
        public Coordinates getCoordinates() {
            return coordinates;
        }

        @JsonProperty("coordinates")
        public void setCoordinates(Coordinates value) {
            this.coordinates = value;
        }

        @JsonProperty("pivot")
        public boolean getPivot() {
            return pivot;
        }

        @JsonProperty("pivot")
        public void setPivot(boolean value) {
            this.pivot = value;
        }

        @JsonProperty("images")
        public List<String> getImages() {
            return images;
        }

        @JsonProperty("images")
        public void setImages(List<String> value) {
            this.images = value;
        }

        @JsonProperty("reviewsSummary")
        public ReviewsSummary getReviewsSummary() {
            return reviewsSummary;
        }

        @JsonProperty("reviewsSummary")
        public void setReviewsSummary(ReviewsSummary value) {
            this.reviewsSummary = value;
        }

        @JsonProperty("confidentMessages")
        public List<ConfidentMessage> getConfidentMessages() {
            return confidentMessages;
        }

        @JsonProperty("confidentMessages")
        public void setConfidentMessages(List<ConfidentMessage> value) {
            this.confidentMessages = value;
        }

        @JsonProperty("minPriceDbookRoomId")
        public Object getMinPriceDbookRoomId() {
            return minPriceDbookRoomId;
        }

        @JsonProperty("minPriceDbookRoomId")
        public void setMinPriceDbookRoomId(Object value) {
            this.minPriceDbookRoomId = value;
        }

        @JsonProperty("minPriceDbookPartnerId")
        public Object getMinPriceDbookPartnerId() {
            return minPriceDbookPartnerId;
        }

        @JsonProperty("minPriceDbookPartnerId")
        public void setMinPriceDbookPartnerId(Object value) {
            this.minPriceDbookPartnerId = value;
        }

        @JsonProperty("inbound")
        public boolean getInbound() {
            return inbound;
        }

        @JsonProperty("inbound")
        public void setInbound(boolean value) {
            this.inbound = value;
        }

        @JsonProperty("lowestPrice")
        public LowestPrice getLowestPrice() {
            return lowestPrice;
        }

        @JsonProperty("lowestPrice")
        public void setLowestPrice(LowestPrice value) {
            this.lowestPrice = value;
        }

        @JsonProperty("otherPrices")
        public List<Object> getOtherPrices() {
            return otherPrices;
        }

        @JsonProperty("otherPrices")
        public void setOtherPrices(List<Object> value) {
            this.otherPrices = value;
        }

        @JsonProperty("isUpSorted")
        public boolean getIsUpSorted() {
            return isUpSorted;
        }

        @JsonProperty("isUpSorted")
        public void setIsUpSorted(boolean value) {
            this.isUpSorted = value;
        }

        @JsonProperty("hotelId")
        public String getHotelId() {
            return hotelId;
        }

        @JsonProperty("hotelId")
        public void setHotelId(String value) {
            this.hotelId = value;
        }
    }

    public static class ConfidentMessage {
        private String type;
        private double score;
        private String icon;
        private String message;

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String value) {
            this.type = value;
        }

        @JsonProperty("score")
        public double getScore() {
            return score;
        }

        @JsonProperty("score")
        public void setScore(double value) {
            this.score = value;
        }

        @JsonProperty("icon")
        public String getIcon() {
            return icon;
        }

        @JsonProperty("icon")
        public void setIcon(String value) {
            this.icon = value;
        }

        @JsonProperty("message")
        public String getMessage() {
            return message;
        }

        @JsonProperty("message")
        public void setMessage(String value) {
            this.message = value;
        }
    }

    public static class Coordinates {
        private double latitude;
        private double longitude;

        @JsonProperty("latitude")
        public double getLatitude() {
            return latitude;
        }

        @JsonProperty("latitude")
        public void setLatitude(double value) {
            this.latitude = value;
        }

        @JsonProperty("longitude")
        public double getLongitude() {
            return longitude;
        }

        @JsonProperty("longitude")
        public void setLongitude(double value) {
            this.longitude = value;
        }
    }

    public static class LowestPrice {
        private String price;
        private long rawPrice;
        private String partnerId;
        private String partnerType;
        private String partnerName;
        private String partnerLogo;
        private boolean isOfficial;
        private String funnelType;
        private Object cug;
        private Object discount;
        private List<Object> amenities;

        @JsonProperty("price")
        public String getPrice() {
            return price;
        }

        @JsonProperty("price")
        public void setPrice(String value) {
            this.price = value;
        }

        @JsonProperty("rawPrice")
        public long getRawPrice() {
            return rawPrice;
        }

        @JsonProperty("rawPrice")
        public void setRawPrice(long value) {
            this.rawPrice = value;
        }

        @JsonProperty("partnerId")
        public String getPartnerId() {
            return partnerId;
        }

        @JsonProperty("partnerId")
        public void setPartnerId(String value) {
            this.partnerId = value;
        }

        @JsonProperty("partnerType")
        public String getPartnerType() {
            return partnerType;
        }

        @JsonProperty("partnerType")
        public void setPartnerType(String value) {
            this.partnerType = value;
        }

        @JsonProperty("partnerName")
        public String getPartnerName() {
            return partnerName;
        }

        @JsonProperty("partnerName")
        public void setPartnerName(String value) {
            this.partnerName = value;
        }

        @JsonProperty("partnerLogo")
        public String getPartnerLogo() {
            return partnerLogo;
        }

        @JsonProperty("partnerLogo")
        public void setPartnerLogo(String value) {
            this.partnerLogo = value;
        }

        @JsonProperty("isOfficial")
        public boolean getIsOfficial() {
            return isOfficial;
        }

        @JsonProperty("isOfficial")
        public void setIsOfficial(boolean value) {
            this.isOfficial = value;
        }

        @JsonProperty("funnelType")
        public String getFunnelType() {
            return funnelType;
        }

        @JsonProperty("funnelType")
        public void setFunnelType(String value) {
            this.funnelType = value;
        }

        @JsonProperty("cug")
        public Object getCug() {
            return cug;
        }

        @JsonProperty("cug")
        public void setCug(Object value) {
            this.cug = value;
        }

        @JsonProperty("discount")
        public Object getDiscount() {
            return discount;
        }

        @JsonProperty("discount")
        public void setDiscount(Object value) {
            this.discount = value;
        }

        @JsonProperty("amenities")
        public List<Object> getAmenities() {
            return amenities;
        }

        @JsonProperty("amenities")
        public void setAmenities(List<Object> value) {
            this.amenities = value;
        }
    }

    public static class ReviewsSummary {
        private double score;
        private String imageUrl;
        private String scoreDesc;
        private long total;
        private String mostPopularWith;

        @JsonProperty("score")
        public double getScore() {
            return score;
        }

        @JsonProperty("score")
        public void setScore(double value) {
            this.score = value;
        }

        @JsonProperty("imageUrl")
        public String getImageUrl() {
            return imageUrl;
        }

        @JsonProperty("imageUrl")
        public void setImageUrl(String value) {
            this.imageUrl = value;
        }

        @JsonProperty("scoreDesc")
        public String getScoreDesc() {
            return scoreDesc;
        }

        @JsonProperty("scoreDesc")
        public void setScoreDesc(String value) {
            this.scoreDesc = value;
        }

        @JsonProperty("total")
        public long getTotal() {
            return total;
        }

        @JsonProperty("total")
        public void setTotal(long value) {
            this.total = value;
        }

        @JsonProperty("mostPopularWith")
        public String getMostPopularWith() {
            return mostPopularWith;
        }

        @JsonProperty("mostPopularWith")
        public void setMostPopularWith(String value) {
            this.mostPopularWith = value;
        }
    }

    public static class HotelsCoordinate {
        private String id;
        private double latitude;
        private double longitude;
        private String price;

        @JsonProperty("id")
        public String getid() {
            return id;
        }

        @JsonProperty("id")
        public void setid(String value) {
            this.id = value;
        }

        @JsonProperty("latitude")
        public double getLatitude() {
            return latitude;
        }

        @JsonProperty("latitude")
        public void setLatitude(double value) {
            this.latitude = value;
        }

        @JsonProperty("longitude")
        public double getLongitude() {
            return longitude;
        }

        @JsonProperty("longitude")
        public void setLongitude(double value) {
            this.longitude = value;
        }

        @JsonProperty("price")
        public String getPrice() {
            return price;
        }

        @JsonProperty("price")
        public void setPrice(String value) {
            this.price = value;
        }
    }

    public static class HotelsRegion {
        private double latitude;
        private double longitude;
        private double longitudeDelta;
        private double latitudeDelta;

        @JsonProperty("latitude")
        public double getLatitude() {
            return latitude;
        }

        @JsonProperty("latitude")
        public void setLatitude(double value) {
            this.latitude = value;
        }

        @JsonProperty("longitude")
        public double getLongitude() {
            return longitude;
        }

        @JsonProperty("longitude")
        public void setLongitude(double value) {
            this.longitude = value;
        }

        @JsonProperty("longitudeDelta")
        public double getLongitudeDelta() {
            return longitudeDelta;
        }

        @JsonProperty("longitudeDelta")
        public void setLongitudeDelta(double value) {
            this.longitudeDelta = value;
        }

        @JsonProperty("latitudeDelta")
        public double getLatitudeDelta() {
            return latitudeDelta;
        }

        @JsonProperty("latitudeDelta")
        public void setLatitudeDelta(double value) {
            this.latitudeDelta = value;
        }
    }

    public static class MapBoundary {
        private double north;
        private double east;
        private double south;
        private double west;

        @JsonProperty("north")
        public double getNorth() {
            return north;
        }

        @JsonProperty("north")
        public void setNorth(double value) {
            this.north = value;
        }

        @JsonProperty("east")
        public double getEast() {
            return east;
        }

        @JsonProperty("east")
        public void setEast(double value) {
            this.east = value;
        }

        @JsonProperty("south")
        public double getSouth() {
            return south;
        }

        @JsonProperty("south")
        public void setSouth(double value) {
            this.south = value;
        }

        @JsonProperty("west")
        public double getWest() {
            return west;
        }

        @JsonProperty("west")
        public void setWest(double value) {
            this.west = value;
        }
    }

    public static class SearchSummary {
        private long total;
        private long filteredTotal;
        private long inboundTotal;
        private String resultsSummary;
        private String sortBy;
        private Entity entity;
        private List<Location> location;

        @JsonProperty("total")
        public long getTotal() {
            return total;
        }

        @JsonProperty("total")
        public void setTotal(long value) {
            this.total = value;
        }

        @JsonProperty("filteredTotal")
        public long getFilteredTotal() {
            return filteredTotal;
        }

        @JsonProperty("filteredTotal")
        public void setFilteredTotal(long value) {
            this.filteredTotal = value;
        }

        @JsonProperty("inboundTotal")
        public long getInboundTotal() {
            return inboundTotal;
        }

        @JsonProperty("inboundTotal")
        public void setInboundTotal(long value) {
            this.inboundTotal = value;
        }

        @JsonProperty("resultsSummary")
        public String getResultsSummary() {
            return resultsSummary;
        }

        @JsonProperty("resultsSummary")
        public void setResultsSummary(String value) {
            this.resultsSummary = value;
        }

        @JsonProperty("sortBy")
        public String getSortBy() {
            return sortBy;
        }

        @JsonProperty("sortBy")
        public void setSortBy(String value) {
            this.sortBy = value;
        }

        @JsonProperty("entity")
        public Entity getEntity() {
            return entity;
        }

        @JsonProperty("entity")
        public void setEntity(Entity value) {
            this.entity = value;
        }

        @JsonProperty("location")
        public List<Location> getLocation() {
            return location;
        }

        @JsonProperty("location")
        public void setLocation(List<Location> value) {
            this.location = value;
        }
    }

    public static class Entity {
        private String entityId;
        private String entityType;
        private String name;
        private Coordinates coordinates;
        private String levelOfEntityType;

        @JsonProperty("entityId")
        public String getEntityId() {
            return entityId;
        }

        @JsonProperty("entityId")
        public void setEntityId(String value) {
            this.entityId = value;
        }

        @JsonProperty("entityType")
        public String getEntityType() {
            return entityType;
        }

        @JsonProperty("entityType")
        public void setEntityType(String value) {
            this.entityType = value;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String value) {
            this.name = value;
        }

        @JsonProperty("coordinates")
        public Coordinates getCoordinates() {
            return coordinates;
        }

        @JsonProperty("coordinates")
        public void setCoordinates(Coordinates value) {
            this.coordinates = value;
        }

        @JsonProperty("levelOfEntityType")
        public String getLevelOfEntityType() {
            return levelOfEntityType;
        }

        @JsonProperty("levelOfEntityType")
        public void setLevelOfEntityType(String value) {
            this.levelOfEntityType = value;
        }
    }

    public static class Location {
        private String entityId;
        private String entityType;
        private String name;

        @JsonProperty("entityId")
        public String getEntityId() {
            return entityId;
        }

        @JsonProperty("entityId")
        public void setEntityId(String value) {
            this.entityId = value;
        }

        @JsonProperty("entityType")
        public String getEntityType() {
            return entityType;
        }

        @JsonProperty("entityType")
        public void setEntityType(String value) {
            this.entityType = value;
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

    public static class SortOption {
        private String optionName;
        private String type;

        @JsonProperty("optionName")
        public String getOptionName() {
            return optionName;
        }

        @JsonProperty("optionName")
        public void setOptionName(String value) {
            this.optionName = value;
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

    public static class Status {
        private long completionPercentage;
        private String searchId;
        private String requestId;
        private String fastSearchStatus;
        private String finalStatus;

        @JsonProperty("completionPercentage")
        public long getCompletionPercentage() {
            return completionPercentage;
        }

        @JsonProperty("completionPercentage")
        public void setCompletionPercentage(long value) {
            this.completionPercentage = value;
        }

        @JsonProperty("searchId")
        public String getSearchId() {
            return searchId;
        }

        @JsonProperty("searchId")
        public void setSearchId(String value) {
            this.searchId = value;
        }

        @JsonProperty("requestId")
        public String getRequestId() {
            return requestId;
        }

        @JsonProperty("requestId")
        public void setRequestId(String value) {
            this.requestId = value;
        }

        @JsonProperty("fastSearchStatus")
        public String getFastSearchStatus() {
            return fastSearchStatus;
        }

        @JsonProperty("fastSearchStatus")
        public void setFastSearchStatus(String value) {
            this.fastSearchStatus = value;
        }

        @JsonProperty("finalStatus")
        public String getFinalStatus() {
            return finalStatus;
        }

        @JsonProperty("finalStatus")
        public void setFinalStatus(String value) {
            this.finalStatus = value;
        }
    }

    public static class Meta {
        private long currentPage;
        private long limit;
        private long totalRecords;
        private long totalPage;

        @JsonProperty("currentPage")
        public long getCurrentPage() {
            return currentPage;
        }

        @JsonProperty("currentPage")
        public void setCurrentPage(long value) {
            this.currentPage = value;
        }

        @JsonProperty("limit")
        public long getLimit() {
            return limit;
        }

        @JsonProperty("limit")
        public void setLimit(long value) {
            this.limit = value;
        }

        @JsonProperty("totalRecords")
        public long getTotalRecords() {
            return totalRecords;
        }

        @JsonProperty("totalRecords")
        public void setTotalRecords(long value) {
            this.totalRecords = value;
        }

        @JsonProperty("totalPage")
        public long getTotalPage() {
            return totalPage;
        }

        @JsonProperty("totalPage")
        public void setTotalPage(long value) {
            this.totalPage = value;
        }
    }
}
