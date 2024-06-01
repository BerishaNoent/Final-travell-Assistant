package com.travelassitant.microservice.criteriabasedsearchservice.bean;

public class Search {
    private String id;
    private String userId;
    private String origin;
    private String destination;
    private String date;
    private boolean returnTicket;
    private String returnOrigin;
    private String returnDestination;
    private String returnDate;
    private int adults;
    private int children;

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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isReturnTicket() {
        return returnTicket;
    }

    public void setReturnTicket(boolean returnTicket) {
        this.returnTicket = returnTicket;
    }

    public String getReturnOrigin() {
        return returnOrigin;
    }

    public void setReturnOrigin(String returnOrigin) {
        this.returnOrigin = returnOrigin;
    }

    public String getReturnDestination() {
        return returnDestination;
    }

    public void setReturnDestination(String returnDestination) {
        this.returnDestination = returnDestination;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Search [id=" + id + ", userId=" + userId + ", origin=" + origin
                + ", destination=" + destination + ", date=" + date + ", returnTicket=" + returnTicket
                + ", returnOrigin=" + returnOrigin + ", returnDestination=" + returnDestination + ", returnDate="
                + returnDate + ", adults=" + adults + ", children=" + children + "]";
    }

}