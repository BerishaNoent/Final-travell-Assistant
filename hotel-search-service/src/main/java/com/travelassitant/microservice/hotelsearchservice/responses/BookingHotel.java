package com.travelassitant.microservice.hotelsearchservice.responses;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingHotel {
    private boolean status;
    private String message;
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

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String value) {
        this.message = value;
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
        private List<Hotel> hotels;
        private List<Meta> meta;
        private List<Appear> appear;

        @JsonProperty("hotels")
        public List<Hotel> getHotels() {
            return hotels;
        }

        @JsonProperty("hotels")
        public void setHotels(List<Hotel> value) {
            this.hotels = value;
        }

        @JsonProperty("meta")
        public List<Meta> getMeta() {
            return meta;
        }

        @JsonProperty("meta")
        public void setMeta(List<Meta> value) {
            this.meta = value;
        }

        @JsonProperty("appear")
        public List<Appear> getAppear() {
            return appear;
        }

        @JsonProperty("appear")
        public void setAppear(List<Appear> value) {
            this.appear = value;
        }
    }

    public static class Appear {
        private AppearComponent component;
        private String id;
        private String contentUrl;

        @JsonProperty("component")
        public AppearComponent getComponent() {
            return component;
        }

        @JsonProperty("component")
        public void setComponent(AppearComponent value) {
            this.component = value;
        }

        @JsonProperty("id")
        public String getid() {
            return id;
        }

        @JsonProperty("id")
        public void setid(String value) {
            this.id = value;
        }

        @JsonProperty("contentUrl")
        public String getContentUrl() {
            return contentUrl;
        }

        @JsonProperty("contentUrl")
        public void setContentUrl(String value) {
            this.contentUrl = value;
        }
    }

    public static class AppearComponent {
        private PurpleProps props;

        @JsonProperty("props")
        public PurpleProps getProps() {
            return props;
        }

        @JsonProperty("props")
        public void setProps(PurpleProps value) {
            this.props = value;
        }
    }

    public static class PurpleProps {
        private Boolean fill;
        private Content content;
        private String title;
        private String text;

        @JsonProperty("fill")
        public Boolean getFill() {
            return fill;
        }

        @JsonProperty("fill")
        public void setFill(Boolean value) {
            this.fill = value;
        }

        @JsonProperty("content")
        public Content getContent() {
            return content;
        }

        @JsonProperty("content")
        public void setContent(Content value) {
            this.content = value;
        }

        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        @JsonProperty("title")
        public void setTitle(String value) {
            this.title = value;
        }

        @JsonProperty("text")
        public String getText() {
            return text;
        }

        @JsonProperty("text")
        public void setText(String value) {
            this.text = value;
        }
    }

    public static class Content {
        private ContentProps props;

        @JsonProperty("props")
        public ContentProps getProps() {
            return props;
        }

        @JsonProperty("props")
        public void setProps(ContentProps value) {
            this.props = value;
        }
    }

    public static class ContentProps {
        private boolean fitContentWidth;
        private List<PurpleItem> items;

        @JsonProperty("fitContentWidth")
        public boolean getFitContentWidth() {
            return fitContentWidth;
        }

        @JsonProperty("fitContentWidth")
        public void setFitContentWidth(boolean value) {
            this.fitContentWidth = value;
        }

        @JsonProperty("items")
        public List<PurpleItem> getItems() {
            return items;
        }

        @JsonProperty("items")
        public void setItems(List<PurpleItem> value) {
            this.items = value;
        }
    }

    public static class PurpleItem {
        private FluffyProps props;

        @JsonProperty("props")
        public FluffyProps getProps() {
            return props;
        }

        @JsonProperty("props")
        public void setProps(FluffyProps value) {
            this.props = value;
        }
    }

    public static class FluffyProps {
        private PropsComponent component;

        @JsonProperty("component")
        public PropsComponent getComponent() {
            return component;
        }

        @JsonProperty("component")
        public void setComponent(PropsComponent value) {
            this.component = value;
        }
    }

    public static class PropsComponent {
        private TentacledProps props;

        @JsonProperty("props")
        public TentacledProps getProps() {
            return props;
        }

        @JsonProperty("props")
        public void setProps(TentacledProps value) {
            this.props = value;
        }
    }

    public static class TentacledProps {
        private String spacing;
        private List<FluffyItem> items;
        private String accessibilityLabel;
        private String icon;
        private String tertiaryTintedColor;
        private String variant;

        @JsonProperty("spacing")
        public String getSpacing() {
            return spacing;
        }

        @JsonProperty("spacing")
        public void setSpacing(String value) {
            this.spacing = value;
        }

        @JsonProperty("items")
        public List<FluffyItem> getItems() {
            return items;
        }

        @JsonProperty("items")
        public void setItems(List<FluffyItem> value) {
            this.items = value;
        }

        @JsonProperty("accessibilityLabel")
        public String getAccessibilityLabel() {
            return accessibilityLabel;
        }

        @JsonProperty("accessibilityLabel")
        public void setAccessibilityLabel(String value) {
            this.accessibilityLabel = value;
        }

        @JsonProperty("icon")
        public String getIcon() {
            return icon;
        }

        @JsonProperty("icon")
        public void setIcon(String value) {
            this.icon = value;
        }

        @JsonProperty("tertiaryTintedColor")
        public String getTertiaryTintedColor() {
            return tertiaryTintedColor;
        }

        @JsonProperty("tertiaryTintedColor")
        public void setTertiaryTintedColor(String value) {
            this.tertiaryTintedColor = value;
        }

        @JsonProperty("variant")
        public String getVariant() {
            return variant;
        }

        @JsonProperty("variant")
        public void setVariant(String value) {
            this.variant = value;
        }
    }

    public static class FluffyItem {
        private StickyProps props;

        @JsonProperty("props")
        public StickyProps getProps() {
            return props;
        }

        @JsonProperty("props")
        public void setProps(StickyProps value) {
            this.props = value;
        }
    }

    public static class StickyProps {
        private List<Text> text;

        @JsonProperty("text")
        public List<Text> getText() {
            return text;
        }

        @JsonProperty("text")
        public void setText(List<Text> value) {
            this.text = value;
        }
    }

    public static class Text {
        private String text;
        private String font;
        private String color;
        private List<LinkAction> linkActions;

        @JsonProperty("text")
        public String getText() {
            return text;
        }

        @JsonProperty("text")
        public void setText(String value) {
            this.text = value;
        }

        @JsonProperty("font")
        public String getFont() {
            return font;
        }

        @JsonProperty("font")
        public void setFont(String value) {
            this.font = value;
        }

        @JsonProperty("color")
        public String getColor() {
            return color;
        }

        @JsonProperty("color")
        public void setColor(String value) {
            this.color = value;
        }

        @JsonProperty("linkActions")
        public List<LinkAction> getLinkActions() {
            return linkActions;
        }

        @JsonProperty("linkActions")
        public void setLinkActions(List<LinkAction> value) {
            this.linkActions = value;
        }
    }

    public static class LinkAction {
        private LinkActionProps props;

        @JsonProperty("props")
        public LinkActionProps getProps() {
            return props;
        }

        @JsonProperty("props")
        public void setProps(LinkActionProps value) {
            this.props = value;
        }
    }

    public static class LinkActionProps {
        private String url;

        @JsonProperty("url")
        public String geturl() {
            return url;
        }

        @JsonProperty("url")
        public void seturl(String value) {
            this.url = value;
        }
    }

    public static class Hotel {
        private String accessibilityLabel;
        private Property property;

        @JsonProperty("accessibilityLabel")
        public String getAccessibilityLabel() {
            return accessibilityLabel;
        }

        @JsonProperty("accessibilityLabel")
        public void setAccessibilityLabel(String value) {
            this.accessibilityLabel = value;
        }

        @JsonProperty("property")
        public Property getProperty() {
            return property;
        }

        @JsonProperty("property")
        public void setProperty(Property value) {
            this.property = value;
        }
    }

    public static class Property {
        private String reviewScoreWord;
        private long accuratePropertyClass;
        private long reviewCount;
        private long ufi;
        private Boolean isPreferred;
        private boolean isFirstPage;
        private Check checkin;
        private long qualityClass;
        private long rankingPosition;
        private double reviewScore;
        private String countryCode;
        private long propertyClass;
        private List<String> photoUrls;
        private LocalDate checkoutDate;
        private long position;
        private double latitude;
        private Check checkout;
        private PriceBreakdown priceBreakdown;
        private long optOutFromGalleryChanges;
        private String wishlistName;
        private List<String> blockIds;
        private String currency;
        private LocalDate checkinDate;
        private long id;
        private long mainPhotoId;
        private String name;
        private double longitude;
        private Boolean isPreferredPlus;

        @JsonProperty("reviewScoreWord")
        public String getReviewScoreWord() {
            return reviewScoreWord;
        }

        @JsonProperty("reviewScoreWord")
        public void setReviewScoreWord(String value) {
            this.reviewScoreWord = value;
        }

        @JsonProperty("accuratePropertyClass")
        public long getAccuratePropertyClass() {
            return accuratePropertyClass;
        }

        @JsonProperty("accuratePropertyClass")
        public void setAccuratePropertyClass(long value) {
            this.accuratePropertyClass = value;
        }

        @JsonProperty("reviewCount")
        public long getReviewCount() {
            return reviewCount;
        }

        @JsonProperty("reviewCount")
        public void setReviewCount(long value) {
            this.reviewCount = value;
        }

        @JsonProperty("ufi")
        public long getUfi() {
            return ufi;
        }

        @JsonProperty("ufi")
        public void setUfi(long value) {
            this.ufi = value;
        }

        @JsonProperty("isPreferred")
        public Boolean getIsPreferred() {
            return isPreferred;
        }

        @JsonProperty("isPreferred")
        public void setIsPreferred(Boolean value) {
            this.isPreferred = value;
        }

        @JsonProperty("isFirstPage")
        public boolean getIsFirstPage() {
            return isFirstPage;
        }

        @JsonProperty("isFirstPage")
        public void setIsFirstPage(boolean value) {
            this.isFirstPage = value;
        }

        @JsonProperty("checkin")
        public Check getCheckin() {
            return checkin;
        }

        @JsonProperty("checkin")
        public void setCheckin(Check value) {
            this.checkin = value;
        }

        @JsonProperty("qualityClass")
        public long getQualityClass() {
            return qualityClass;
        }

        @JsonProperty("qualityClass")
        public void setQualityClass(long value) {
            this.qualityClass = value;
        }

        @JsonProperty("rankingPosition")
        public long getRankingPosition() {
            return rankingPosition;
        }

        @JsonProperty("rankingPosition")
        public void setRankingPosition(long value) {
            this.rankingPosition = value;
        }

        @JsonProperty("reviewScore")
        public double getReviewScore() {
            return reviewScore;
        }

        @JsonProperty("reviewScore")
        public void setReviewScore(double value) {
            this.reviewScore = value;
        }

        @JsonProperty("countryCode")
        public String getCountryCode() {
            return countryCode;
        }

        @JsonProperty("countryCode")
        public void setCountryCode(String value) {
            this.countryCode = value;
        }

        @JsonProperty("propertyClass")
        public long getPropertyClass() {
            return propertyClass;
        }

        @JsonProperty("propertyClass")
        public void setPropertyClass(long value) {
            this.propertyClass = value;
        }

        @JsonProperty("photoUrls")
        public List<String> getPhotoUrls() {
            return photoUrls;
        }

        @JsonProperty("photoUrls")
        public void setPhotoUrls(List<String> value) {
            this.photoUrls = value;
        }

        @JsonProperty("checkoutDate")
        public LocalDate getCheckoutDate() {
            return checkoutDate;
        }

        @JsonProperty("checkoutDate")
        public void setCheckoutDate(LocalDate value) {
            this.checkoutDate = value;
        }

        @JsonProperty("position")
        public long getPosition() {
            return position;
        }

        @JsonProperty("position")
        public void setPosition(long value) {
            this.position = value;
        }

        @JsonProperty("latitude")
        public double getLatitude() {
            return latitude;
        }

        @JsonProperty("latitude")
        public void setLatitude(double value) {
            this.latitude = value;
        }

        @JsonProperty("checkout")
        public Check getCheckout() {
            return checkout;
        }

        @JsonProperty("checkout")
        public void setCheckout(Check value) {
            this.checkout = value;
        }

        @JsonProperty("priceBreakdown")
        public PriceBreakdown getPriceBreakdown() {
            return priceBreakdown;
        }

        @JsonProperty("priceBreakdown")
        public void setPriceBreakdown(PriceBreakdown value) {
            this.priceBreakdown = value;
        }

        @JsonProperty("optOutFromGalleryChanges")
        public long getOptOutFromGalleryChanges() {
            return optOutFromGalleryChanges;
        }

        @JsonProperty("optOutFromGalleryChanges")
        public void setOptOutFromGalleryChanges(long value) {
            this.optOutFromGalleryChanges = value;
        }

        @JsonProperty("wishlistName")
        public String getWishlistName() {
            return wishlistName;
        }

        @JsonProperty("wishlistName")
        public void setWishlistName(String value) {
            this.wishlistName = value;
        }

        @JsonProperty("blockIds")
        public List<String> getBlockIds() {
            return blockIds;
        }

        @JsonProperty("blockIds")
        public void setBlockIds(List<String> value) {
            this.blockIds = value;
        }

        @JsonProperty("currency")
        public String getCurrency() {
            return currency;
        }

        @JsonProperty("currency")
        public void setCurrency(String value) {
            this.currency = value;
        }

        @JsonProperty("checkinDate")
        public LocalDate getCheckinDate() {
            return checkinDate;
        }

        @JsonProperty("checkinDate")
        public void setCheckinDate(LocalDate value) {
            this.checkinDate = value;
        }

        @JsonProperty("id")
        public long getid() {
            return id;
        }

        @JsonProperty("id")
        public void setid(long value) {
            this.id = value;
        }

        @JsonProperty("mainPhotoId")
        public long getMainPhotoId() {
            return mainPhotoId;
        }

        @JsonProperty("mainPhotoId")
        public void setMainPhotoId(long value) {
            this.mainPhotoId = value;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String value) {
            this.name = value;
        }

        @JsonProperty("longitude")
        public double getLongitude() {
            return longitude;
        }

        @JsonProperty("longitude")
        public void setLongitude(double value) {
            this.longitude = value;
        }

        @JsonProperty("isPreferredPlus")
        public Boolean getIsPreferredPlus() {
            return isPreferredPlus;
        }

        @JsonProperty("isPreferredPlus")
        public void setIsPreferredPlus(Boolean value) {
            this.isPreferredPlus = value;
        }
    }

    public static class Check {
        private String untilTime;
        private String fromTime;

        @JsonProperty("untilTime")
        public String getUntilTime() {
            return untilTime;
        }

        @JsonProperty("untilTime")
        public void setUntilTime(String value) {
            this.untilTime = value;
        }

        @JsonProperty("fromTime")
        public String getFromTime() {
            return fromTime;
        }

        @JsonProperty("fromTime")
        public void setFromTime(String value) {
            this.fromTime = value;
        }
    }

    public static class PriceBreakdown {
        private List<Object> benefitBadges;
        private Price grossPrice;
        private List<Object> taxExceptions;
        private Price strikethroughPrice;

        @JsonProperty("benefitBadges")
        public List<Object> getBenefitBadges() {
            return benefitBadges;
        }

        @JsonProperty("benefitBadges")
        public void setBenefitBadges(List<Object> value) {
            this.benefitBadges = value;
        }

        @JsonProperty("grossPrice")
        public Price getGrossPrice() {
            return grossPrice;
        }

        @JsonProperty("grossPrice")
        public void setGrossPrice(Price value) {
            this.grossPrice = value;
        }

        @JsonProperty("taxExceptions")
        public List<Object> getTaxExceptions() {
            return taxExceptions;
        }

        @JsonProperty("taxExceptions")
        public void setTaxExceptions(List<Object> value) {
            this.taxExceptions = value;
        }

        @JsonProperty("strikethroughPrice")
        public Price getStrikethroughPrice() {
            return strikethroughPrice;
        }

        @JsonProperty("strikethroughPrice")
        public void setStrikethroughPrice(Price value) {
            this.strikethroughPrice = value;
        }
    }

    public static class Price {
        private String currency;
        private double value;

        @JsonProperty("currency")
        public String getCurrency() {
            return currency;
        }

        @JsonProperty("currency")
        public void setCurrency(String value) {
            this.currency = value;
        }

        @JsonProperty("value")
        public double getValue() {
            return value;
        }

        @JsonProperty("value")
        public void setValue(double value) {
            this.value = value;
        }
    }

    public static class Meta {
        private String title;

        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        @JsonProperty("title")
        public void setTitle(String value) {
            this.title = value;
        }
    }
}