package com.travelassitant.microservice.filteringsortingservice.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelassitant.microservice.filteringsortingservice.Bean.CarRental;
import com.travelassitant.microservice.filteringsortingservice.Bean.Itinerary;
import com.travelassitant.microservice.filteringsortingservice.Bean.HotelInfo;

@RestController
public class FilteringController {

    @GetMapping("/test")
    public String test() {
        return "Test successful";
    }

    @PostMapping("/filtering")
    public ResponseEntity<List<HotelInfo>> filtering(@RequestBody List<HotelInfo> hotels,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) String starRating) {
        Stream<HotelInfo> hotelStream = hotels.stream();

        if (minPrice != null && minPrice > 0) {
            hotelStream = hotelStream.filter(hotel -> Double.parseDouble(hotel.getMinPrice()) >= minPrice);
        }
        if (starRating != null && !starRating.isEmpty()) {
            hotelStream = hotelStream.filter(hotel -> starRating.equals(hotel.getStarRating()));
        }

        List<HotelInfo> filteredHotels = hotelStream.collect(Collectors.toList());

        return new ResponseEntity<>(filteredHotels, HttpStatus.OK);
    }

    @PostMapping("/filteringCar")
    public ResponseEntity<List<CarRental>> filtering(@RequestBody List<CarRental> cars,
            @RequestParam(required = false) Double rating,
            @RequestParam(required = false) String transmission,
            @RequestParam(required = false) Integer seats,
            @RequestParam(required = false) Double price) {
        Stream<CarRental> carStream = cars.stream();

        if (rating != null && rating > 0) {
            carStream = carStream.filter(car -> car.getRating() >= rating);
        }
        if (transmission != null && !transmission.isEmpty()) {
            carStream = carStream.filter(car -> transmission.equals(car.getTransmission()));
        }
        if (seats != null && seats > 0) {
            carStream = carStream.filter(car -> car.getSeats() >= seats);
        }
        if (price != null && price > 0) {
            carStream = carStream.filter(car -> Double.parseDouble(car.getPrice()) <= price);
        }

        List<CarRental> filteredCars = carStream.collect(Collectors.toList());

        return new ResponseEntity<>(filteredCars, HttpStatus.OK);
    }

    @PostMapping("/filteringFlights")
    public ResponseEntity<List<Itinerary>> filteringItineraries(@RequestBody List<Itinerary> itineraries,
            @RequestParam(required = false) Double maxPrice) {
        List<Itinerary> filteredItineraries = itineraries.stream()
                .filter(itinerary -> {
                    if (maxPrice != null && itinerary.getPrice() != null
                            && itinerary.getPrice().getAmount() > maxPrice) {
                        return false;
                    }
                    return true;
                })
                .collect(Collectors.toList());

        return new ResponseEntity<>(filteredItineraries, HttpStatus.OK);
    }

    @PostMapping("/sortFlights")
    public ResponseEntity<List<Itinerary>> sortingItineraries(@RequestBody List<Itinerary> itineraries,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String sortOrder) {
        System.out.println("Sort by: " + sortBy + " Sort order: " + sortOrder);
        if (sortBy != null && sortOrder != null) {
            itineraries.sort((itinerary1, itinerary2) -> {
                if (sortBy.equalsIgnoreCase("duration")) {
                    long duration1 = Duration.between(
                            LocalDateTime.of(itinerary1.getDepartureDateTime().getYear(),
                                    itinerary1.getDepartureDateTime().getMonth(),
                                    itinerary1.getDepartureDateTime().getDay(),
                                    Integer.parseInt(itinerary1.getDepartureDateTime().getHour()),
                                    itinerary1.getDepartureDateTime().getMinute()),
                            LocalDateTime.of(itinerary1.getArrivalDateTime().getYear(),
                                    itinerary1.getArrivalDateTime().getMonth(),
                                    itinerary1.getArrivalDateTime().getDay(),
                                    Integer.parseInt(itinerary1.getArrivalDateTime().getHour()),
                                    itinerary1.getArrivalDateTime().getMinute()))
                            .toMinutes();
                    long duration2 = Duration.between(
                            LocalDateTime.of(itinerary2.getDepartureDateTime().getYear(),
                                    itinerary2.getDepartureDateTime().getMonth(),
                                    itinerary2.getDepartureDateTime().getDay(),
                                    Integer.parseInt(itinerary2.getDepartureDateTime().getHour()),
                                    itinerary2.getDepartureDateTime().getMinute()),
                            LocalDateTime.of(itinerary2.getArrivalDateTime().getYear(),
                                    itinerary2.getArrivalDateTime().getMonth(),
                                    itinerary2.getArrivalDateTime().getDay(),
                                    Integer.parseInt(itinerary2.getArrivalDateTime().getHour()),
                                    itinerary2.getArrivalDateTime().getMinute()))
                            .toMinutes();
                    return sortOrder.equalsIgnoreCase("asc") ? Long.compare(duration1, duration2)
                            : Long.compare(duration2, duration1);
                } else if (sortBy.equalsIgnoreCase("price")) {
                    double price1 = itinerary1.getPrice().getAmount();
                    double price2 = itinerary2.getPrice().getAmount();
                    return sortOrder.equalsIgnoreCase("asc") ? Double.compare(price1, price2)
                            : Double.compare(price2, price1);
                } else {
                    return 0;
                }
            });
        }

        return new ResponseEntity<>(itineraries, HttpStatus.OK);
    }

    @PostMapping("/sortHotels")
    public ResponseEntity<List<HotelInfo>> sortHotels(@RequestBody List<HotelInfo> hotels,
            @RequestParam(required = false) String sortField,
            @RequestParam(required = false) String sortOrder) {
        System.out.println("Sort field: " + sortField);
        System.out.println("Sort order: " + sortOrder);
        Stream<HotelInfo> hotelStream = hotels.stream();

        if (sortField != null && sortOrder != null) {
            if (sortField.equals("price")) {
                hotelStream = sortOrder.equals("asc")
                        ? hotelStream.sorted(Comparator
                                .comparingDouble(hotel -> Double.parseDouble(((HotelInfo) hotel).getMinPrice())))
                        : hotelStream.sorted(Comparator
                                .comparingDouble(hotel -> Double.parseDouble(((HotelInfo) hotel).getMinPrice()))
                                .reversed());
            } else if (sortField.equals("starRating")) {
                hotelStream = sortOrder.equals("asc")
                        ? hotelStream.sorted(Comparator.comparing(HotelInfo::getStarRating))
                        : hotelStream.sorted(Comparator.comparing(HotelInfo::getStarRating).reversed());
            }
        }

        List<HotelInfo> sortedHotels = hotelStream.collect(Collectors.toList());

        return new ResponseEntity<>(sortedHotels, HttpStatus.OK);
    }

    @PostMapping("/sortCar")
    public ResponseEntity<List<CarRental>> sortCars(@RequestBody List<CarRental> cars,
            @RequestParam(required = false) String sort) {
        if (sort != null) {
            cars.sort((car1, car2) -> {
                Double price1 = Double.parseDouble(car1.getPrice());
                Double price2 = Double.parseDouble(car2.getPrice());
                return sort.equalsIgnoreCase("asc") ? Double.compare(price1, price2) : Double.compare(price2, price1);
            });
        }

        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

}