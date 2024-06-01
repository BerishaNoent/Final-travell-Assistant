package com.travelassitant.microservice.hotelsearchservice.responses;

import java.util.Map;

public class PriceLineAPIResponse {
    private GetHotelHotelDetails getHotelHotelDetails;

    public GetHotelHotelDetails getGetHotelHotelDetails() {
        return getHotelHotelDetails;
    }

    public void setGetHotelHotelDetails(GetHotelHotelDetails getHotelHotelDetails) {
        this.getHotelHotelDetails = getHotelHotelDetails;
    }

    public static class GetHotelHotelDetails {
        private Result results;

        public Result getResults() {
            return results;
        }

        public void setResults(Result results) {
            this.results = results;
        }
    }

    public static class Result {
        private String status;
        private int status_code;
        private String time;
        // private HotelData hotel_data;
        private Map<String, Hotel> hotel_data;

        public Map<String, Hotel> getHotel_data() {
            return hotel_data;
        }

        public void setHotel_data(Map<String, Hotel> hotel_data) {
            this.hotel_data = hotel_data;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getStatus_code() {
            return status_code;
        }

        public void setStatus_code(int status_code) {
            this.status_code = status_code;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    public static class Hotel {
        private String id;
        private boolean active;
        private String name;
        private String property_type;
        private int property_type_id;
        private int semi_opq_enabled;
        private String star_rating;
        private double review_rating;
        private String review_rating_desc;
        private int review_count;
        private int rating_count;
        private String review_source;
        private String booking_review_url;
        private String agoda_review_url;
        private String agoda_url;
        private String booking_url;
        private String priceline_url;
        private StaticLowRate static_low_rate;
        private String thumbnail;
        private ThumbnailHQ thumbnail_hq;
        private City city;
        private Address address;
        private Geo geo;
        private HotelChain hotel_chain;
        private String check_in_time;
        private String check_out_time;
        private String language;
        private String hotel_description;
        private String room_count;
        private HotelRank hotel_rank;
        private RankData rank_data;
        private Map<String, Amenity> amenity_data;
        private ReviewScoreData review_score_data;
        private Neighborhood neighborhood;
        private Map<String, Review> review_data;
        private int cug_enabled;
        private CheckInInformation check_in_information;
        private Map<String, String> photo_data;
        private Map<String, RecentSale> recent_sales_data;
        private Object[] promo_data;
        private Object[] nearby_data;
        private ImportantInformation important_information;
        private GuestScoreCategories guest_score_categories;
        private PluginData plugin_data;
        private Map<String, Warning> warning_data;

        public Map<String, RecentSale> getRecent_sales_data() {
            return recent_sales_data;
        }

        public void setRecent_sales_data(Map<String, RecentSale> recent_sales_data) {
            this.recent_sales_data = recent_sales_data;
        }

        public Object[] getPromo_data() {
            return promo_data;
        }

        public void setPromo_data(Object[] promo_data) {
            this.promo_data = promo_data;
        }

        public Object[] getNearby_data() {
            return nearby_data;
        }

        public void setNearby_data(Object[] nearby_data) {
            this.nearby_data = nearby_data;
        }

        public ImportantInformation getImportant_information() {
            return important_information;
        }

        public void setImportant_information(ImportantInformation important_information) {
            this.important_information = important_information;
        }

        public GuestScoreCategories getGuest_score_categories() {
            return guest_score_categories;
        }

        public void setGuest_score_categories(GuestScoreCategories guest_score_categories) {
            this.guest_score_categories = guest_score_categories;
        }

        public PluginData getPlugin_data() {
            return plugin_data;
        }

        public void setPlugin_data(PluginData plugin_data) {
            this.plugin_data = plugin_data;
        }

        public Map<String, Warning> getWarning_data() {
            return warning_data;
        }

        public void setWarning_data(Map<String, Warning> warning_data) {
            this.warning_data = warning_data;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProperty_type() {
            return property_type;
        }

        public void setProperty_type(String property_type) {
            this.property_type = property_type;
        }

        public int getProperty_type_id() {
            return property_type_id;
        }

        public void setProperty_type_id(int property_type_id) {
            this.property_type_id = property_type_id;
        }

        public int getSemi_opq_enabled() {
            return semi_opq_enabled;
        }

        public void setSemi_opq_enabled(int semi_opq_enabled) {
            this.semi_opq_enabled = semi_opq_enabled;
        }

        public String getStar_rating() {
            return star_rating;
        }

        public void setStar_rating(String star_rating) {
            this.star_rating = star_rating;
        }

        public double getReview_rating() {
            return review_rating;
        }

        public void setReview_rating(double review_rating) {
            this.review_rating = review_rating;
        }

        public String getReview_rating_desc() {
            return review_rating_desc;
        }

        public void setReview_rating_desc(String review_rating_desc) {
            this.review_rating_desc = review_rating_desc;
        }

        public int getReview_count() {
            return review_count;
        }

        public void setReview_count(int review_count) {
            this.review_count = review_count;
        }

        public int getRating_count() {
            return rating_count;
        }

        public void setRating_count(int rating_count) {
            this.rating_count = rating_count;
        }

        public String getReview_source() {
            return review_source;
        }

        public void setReview_source(String review_source) {
            this.review_source = review_source;
        }

        public String getBooking_review_url() {
            return booking_review_url;
        }

        public void setBooking_review_url(String booking_review_url) {
            this.booking_review_url = booking_review_url;
        }

        public String getAgoda_review_url() {
            return agoda_review_url;
        }

        public void setAgoda_review_url(String agoda_review_url) {
            this.agoda_review_url = agoda_review_url;
        }

        public String getAgoda_url() {
            return agoda_url;
        }

        public void setAgoda_url(String agoda_url) {
            this.agoda_url = agoda_url;
        }

        public String getBooking_url() {
            return booking_url;
        }

        public void setBooking_url(String booking_url) {
            this.booking_url = booking_url;
        }

        public String getPriceline_url() {
            return priceline_url;
        }

        public void setPriceline_url(String priceline_url) {
            this.priceline_url = priceline_url;
        }

        public StaticLowRate getStatic_low_rate() {
            return static_low_rate;
        }

        public void setStatic_low_rate(StaticLowRate static_low_rate) {
            this.static_low_rate = static_low_rate;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public ThumbnailHQ getThumbnail_hq() {
            return thumbnail_hq;
        }

        public void setThumbnail_hq(ThumbnailHQ thumbnail_hq) {
            this.thumbnail_hq = thumbnail_hq;
        }

        public City getCity() {
            return city;
        }

        public void setCity(City city) {
            this.city = city;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public Geo getGeo() {
            return geo;
        }

        public void setGeo(Geo geo) {
            this.geo = geo;
        }

        public HotelChain getHotel_chain() {
            return hotel_chain;
        }

        public void setHotel_chain(HotelChain hotel_chain) {
            this.hotel_chain = hotel_chain;
        }

        public String getCheck_in_time() {
            return check_in_time;
        }

        public void setCheck_in_time(String check_in_time) {
            this.check_in_time = check_in_time;
        }

        public String getCheck_out_time() {
            return check_out_time;
        }

        public void setCheck_out_time(String check_out_time) {
            this.check_out_time = check_out_time;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getHotel_description() {
            return hotel_description;
        }

        public void setHotel_description(String hotel_description) {
            this.hotel_description = hotel_description;
        }

        public String getRoom_count() {
            return room_count;
        }

        public void setRoom_count(String room_count) {
            this.room_count = room_count;
        }

        public HotelRank getHotel_rank() {
            return hotel_rank;
        }

        public void setHotel_rank(HotelRank hotel_rank) {
            this.hotel_rank = hotel_rank;
        }

        public RankData getRank_data() {
            return rank_data;
        }

        public void setRank_data(RankData rank_data) {
            this.rank_data = rank_data;
        }

        public Map<String, Amenity> getAmenity_data() {
            return amenity_data;
        }

        public void setAmenity_data(Map<String, Amenity> amenity_data) {
            this.amenity_data = amenity_data;
        }

        public ReviewScoreData getReview_score_data() {
            return review_score_data;
        }

        public void setReview_score_data(ReviewScoreData review_score_data) {
            this.review_score_data = review_score_data;
        }

        public Neighborhood getNeighborhood() {
            return neighborhood;
        }

        public void setNeighborhood(Neighborhood neighborhood) {
            this.neighborhood = neighborhood;
        }

        public Map<String, Review> getReview_data() {
            return review_data;
        }

        public void setReview_data(Map<String, Review> review_data) {
            this.review_data = review_data;
        }

        public int getCug_enabled() {
            return cug_enabled;
        }

        public void setCug_enabled(int cug_enabled) {
            this.cug_enabled = cug_enabled;
        }

        public CheckInInformation getCheck_in_information() {
            return check_in_information;
        }

        public void setCheck_in_information(CheckInInformation check_in_information) {
            this.check_in_information = check_in_information;
        }

        public Map<String, String> getPhoto_data() {
            return photo_data;
        }

        public void setPhoto_data(Map<String, String> photo_data) {
            this.photo_data = photo_data;
        }

        // }
    }

    public static class StaticLowRate {
        private String source_currency;
        private String source_symbol;
        private double source_price;
        private String display_currency;
        private String display_symbol;
        private double display_price;

        // getters and setters
        public String getSource_currency() {
            return source_currency;
        }

        public void setSource_currency(String source_currency) {
            this.source_currency = source_currency;
        }

        public String getSource_symbol() {
            return source_symbol;
        }

        public void setSource_symbol(String source_symbol) {
            this.source_symbol = source_symbol;
        }

        public double getSource_price() {
            return source_price;
        }

        public void setSource_price(double source_price) {
            this.source_price = source_price;
        }

        public String getDisplay_currency() {
            return display_currency;
        }

        public void setDisplay_currency(String display_currency) {
            this.display_currency = display_currency;
        }

        public String getDisplay_symbol() {
            return display_symbol;
        }

        public void setDisplay_symbol(String display_symbol) {
            this.display_symbol = display_symbol;
        }

        public double getDisplay_price() {
            return display_price;
        }

        public void setDisplay_price(double display_price) {
            this.display_price = display_price;
        }
    }

    public static class ThumbnailHQ {
        private String hundred_fifty_square;
        private String three_hundred_square;

        // getters and setters
        public String getHundred_fifty_square() {
            return hundred_fifty_square;
        }

        public void setHundred_fifty_square(String hundred_fifty_square) {
            this.hundred_fifty_square = hundred_fifty_square;
        }

        public String getThree_hundred_square() {
            return three_hundred_square;
        }

        public void setThree_hundred_square(String three_hundred_square) {
            this.three_hundred_square = three_hundred_square;
        }
    }

    public static class City {
        private String id;
        private String name;

        // getters and setters
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
    }

    public static class Address {
        private String city_name;
        private String address_line_one;
        private String state_code;
        private String state_name;
        private String country_code;
        private String country_name;
        private String zip;

        // getters and setters
        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getAddress_line_one() {
            return address_line_one;
        }

        public void setAddress_line_one(String address_line_one) {
            this.address_line_one = address_line_one;
        }

        public String getState_code() {
            return state_code;
        }

        public void setState_code(String state_code) {
            this.state_code = state_code;
        }

        public String getState_name() {
            return state_name;
        }

        public void setState_name(String state_name) {
            this.state_name = state_name;
        }

        public String getCountry_code() {
            return country_code;
        }

        public void setCountry_code(String country_code) {
            this.country_code = country_code;
        }

        public String getCountry_name() {
            return country_name;
        }

        public void setCountry_name(String country_name) {
            this.country_name = country_name;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }
    }

    public static class Geo {
        private double latitude;
        private double longitude;

        // getters and setters
        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }

    public static class HotelChain {
        private String id;
        private String name;
        private String chain_codes_b;
        private String chain_codes_t;

        // getters and setters
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

        public String getChain_codes_b() {
            return chain_codes_b;
        }

        public void setChain_codes_b(String chain_codes_b) {
            this.chain_codes_b = chain_codes_b;
        }

        public String getChain_codes_t() {
            return chain_codes_t;
        }

        public void setChain_codes_t(String chain_codes_t) {
            this.chain_codes_t = chain_codes_t;
        }
    }

    public static class HotelRank {
        private int rank;
        private int reviewed_hotel;
        private double hmi_score;
        private Object rank_score;

        // getters and setters
        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getReviewed_hotel() {
            return reviewed_hotel;
        }

        public void setReviewed_hotel(int reviewed_hotel) {
            this.reviewed_hotel = reviewed_hotel;
        }

        public double getHmi_score() {
            return hmi_score;
        }

        public void setHmi_score(double hmi_score) {
            this.hmi_score = hmi_score;
        }

        public Object getRank_score() {
            return rank_score;
        }

        public void setRank_score(Object rank_score) {
            this.rank_score = rank_score;
        }
    }

    public static class RankData {
        private String rank;
        private String rank_beta;

        // getters and setters
        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public String getRank_beta() {
            return rank_beta;
        }

        public void setRank_beta(String rank_beta) {
            this.rank_beta = rank_beta;
        }
    }

    public static class Amenity {
        private String id;
        private String name;

        // getters and setters
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
    }

    public static class ReviewScoreData {
        private String cleanliness_score;
        // getters and setters

        public String getCleanliness_score() {
            return cleanliness_score;
        }

        public void setCleanliness_score(String cleanliness_score) {
            this.cleanliness_score = cleanliness_score;
        }
    }

    public static class Neighborhood {
        private String id;
        private String name;

        // getters and setters
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
    }

    public static class Review {
        private String inventory;
        private String user_name;
        private String good_description;
        private String bad_description;
        private String review_text;
        private String average_rating;
        private String average_rating_description;
        private String traveller_type_name;
        private String creation_date;

        // getters and setters
        public String getInventory() {
            return inventory;
        }

        public void setInventory(String inventory) {
            this.inventory = inventory;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getGood_description() {
            return good_description;
        }

        public void setGood_description(String good_description) {
            this.good_description = good_description;
        }

        public String getBad_description() {
            return bad_description;
        }

        public void setBad_description(String bad_description) {
            this.bad_description = bad_description;
        }

        public String getReview_text() {
            return review_text;
        }

        public void setReview_text(String review_text) {
            this.review_text = review_text;
        }

        public String getAverage_rating() {
            return average_rating;
        }

        public void setAverage_rating(String average_rating) {
            this.average_rating = average_rating;
        }

        public String getAverage_rating_description() {
            return average_rating_description;
        }

        public void setAverage_rating_description(String average_rating_description) {
            this.average_rating_description = average_rating_description;
        }

        public String getTraveller_type_name() {
            return traveller_type_name;
        }

        public void setTraveller_type_name(String traveller_type_name) {
            this.traveller_type_name = traveller_type_name;
        }

        public String getCreation_date() {
            return creation_date;
        }

        public void setCreation_date(String creation_date) {
            this.creation_date = creation_date;
        }
    }

    public static class CheckInInformation {
        private boolean standard_check_in;
        // getters and setters

        public boolean isStandard_check_in() {
            return standard_check_in;
        }

        public void setStandard_check_in(boolean standard_check_in) {
            this.standard_check_in = standard_check_in;
        }
    }

    public static class RecentSale {
        private String city_id;
        private String hotel_id;
        private String rate;
        private String creation_date_time;
        private String creation_date_time_iso8601;
        private String time_from_last;

        // getters and setters
        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getHotel_id() {
            return hotel_id;
        }

        public void setHotel_id(String hotel_id) {
            this.hotel_id = hotel_id;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getCreation_date_time() {
            return creation_date_time;
        }

        public void setCreation_date_time(String creation_date_time) {
            this.creation_date_time = creation_date_time;
        }

        public String getCreation_date_time_iso8601() {
            return creation_date_time_iso8601;
        }

        public void setCreation_date_time_iso8601(String creation_date_time_iso8601) {
            this.creation_date_time_iso8601 = creation_date_time_iso8601;
        }

        public String getTime_from_last() {
            return time_from_last;
        }

        public void setTime_from_last(String time_from_last) {
            this.time_from_last = time_from_last;
        }
    }

    public static class ImportantInformation {
        private Map<String, Policy> policy_data;
        // getters and setters

        public Map<String, Policy> getPolicy_data() {
            return policy_data;
        }

        public void setPolicy_data(Map<String, Policy> policy_data) {
            this.policy_data = policy_data;
        }
    }

    public static class Policy {
        private String title;
        private Map<String, String> paragraph_data;

        // getters and setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Map<String, String> getParagraph_data() {
            return paragraph_data;
        }

        public void setParagraph_data(Map<String, String> paragraph_data) {
            this.paragraph_data = paragraph_data;
        }
    }

    public static class GuestScoreCategories {
        private String staff;
        private String cleanliness;
        private String location;

        // getters and setters
        public String getStaff() {
            return staff;
        }

        public void setStaff(String staff) {
            this.staff = staff;
        }

        public String getCleanliness() {
            return cleanliness;
        }

        public void setCleanliness(String cleanliness) {
            this.cleanliness = cleanliness;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }

    public static class PluginData {
        private Map<String, PetFriendly> pet_friendly_data;
        // getters and setters

        public Map<String, PetFriendly> getPet_friendly_data() {
            return pet_friendly_data;
        }

        public void setPet_friendly_data(Map<String, PetFriendly> pet_friendly_data) {
            this.pet_friendly_data = pet_friendly_data;
        }
    }

    public static class PetFriendly {
        private String plugin_id;
        private String plugin_name;
        private String hotelid_ppn;
        private String policy;
        private String policy_verified;
        private String enable;
        private String creation_date_time;

        // getters and setters
        public String getPlugin_id() {
            return plugin_id;
        }

        public void setPlugin_id(String plugin_id) {
            this.plugin_id = plugin_id;
        }

        public String getPlugin_name() {
            return plugin_name;
        }

        public void setPlugin_name(String plugin_name) {
            this.plugin_name = plugin_name;
        }

        public String getHotelid_ppn() {
            return hotelid_ppn;
        }

        public void setHotelid_ppn(String hotelid_ppn) {
            this.hotelid_ppn = hotelid_ppn;
        }

        public String getPolicy() {
            return policy;
        }

        public void setPolicy(String policy) {
            this.policy = policy;
        }

        public String getPolicy_verified() {
            return policy_verified;
        }

        public void setPolicy_verified(String policy_verified) {
            this.policy_verified = policy_verified;
        }

        public String getEnable() {
            return enable;
        }

        public void setEnable(String enable) {
            this.enable = enable;
        }

        public String getCreation_date_time() {
            return creation_date_time;
        }

        public void setCreation_date_time(String creation_date_time) {
            this.creation_date_time = creation_date_time;
        }
    }

    public static class Warning {
        private String status;
        private String status_code;
        private String status_message;

        // getters and setters
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStatus_code() {
            return status_code;
        }

        public void setStatus_code(String status_code) {
            this.status_code = status_code;
        }

        public String getStatus_message() {
            return status_message;
        }

        public void setStatus_message(String status_message) {
            this.status_message = status_message;
        }
    }

}
