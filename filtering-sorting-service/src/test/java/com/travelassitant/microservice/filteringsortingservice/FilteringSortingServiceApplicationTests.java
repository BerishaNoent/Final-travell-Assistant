package com.travelassitant.microservice.filteringsortingservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travelassitant.microservice.filteringsortingservice.Bean.CarRental;
import com.travelassitant.microservice.filteringsortingservice.Bean.HotelInfo;
import com.travelassitant.microservice.filteringsortingservice.Bean.Itinerary;
import com.travelassitant.microservice.filteringsortingservice.Bean.Itinerary.Price;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class FilteringSortingServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testHotelFiltering() throws Exception {
        
        HotelInfo hotel1 = new HotelInfo();
        hotel1.setMinPrice("100");
        hotel1.setStarRating("3");

        HotelInfo hotel2 = new HotelInfo();
        hotel2.setMinPrice("200");
        hotel2.setStarRating("4");

        HotelInfo hotel3 = new HotelInfo();
        hotel3.setMinPrice("300");
        hotel3.setStarRating("5");

        List<HotelInfo> hotels = Arrays.asList(hotel1, hotel2, hotel3);

        
        mockMvc.perform(post("/filtering")
                .param("minPrice", "200.0")
                .param("starRating", "4")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(hotels)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(hotel2))));
    }

	@Test
    void testSortHotels() throws Exception {
    
        HotelInfo hotel1 = new HotelInfo();
        hotel1.setMinPrice("100");
        hotel1.setStarRating("3");

        HotelInfo hotel2 = new HotelInfo();
        hotel2.setMinPrice("200");
        hotel2.setStarRating("4");

        HotelInfo hotel3 = new HotelInfo();
        hotel3.setMinPrice("300");
        hotel3.setStarRating("5");

        List<HotelInfo> hotels = Arrays.asList(hotel1, hotel2, hotel3);

        
        mockMvc.perform(post("/sortHotels")
                .param("sortField", "price")
                .param("sortOrder", "desc")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(hotels)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(hotel3, hotel2, hotel1))));
    }

	@Test
    void testSortCars() throws Exception {
        
        CarRental car1 = new CarRental();
        car1.setPrice("100");

        CarRental car2 = new CarRental();
        car2.setPrice("200");

        CarRental car3 = new CarRental();
        car3.setPrice("300");

        List<CarRental> cars = Arrays.asList(car1, car2, car3);

    
        mockMvc.perform(post("/sortCar")
                .param("sort", "desc")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cars)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(car3, car2, car1))));
    }

	@Test
    void testFilteringCar() throws Exception {
        
        CarRental car1 = new CarRental();
        car1.setPrice("100");
        car1.setRating(3.0);
        car1.setTransmission("Manual");
        car1.setSeats(2);

        CarRental car2 = new CarRental();
        car2.setPrice("200");
        car2.setRating(4.0);
        car2.setTransmission("Automatic");
        car2.setSeats(4);

        CarRental car3 = new CarRental();
        car3.setPrice("300");
        car3.setRating(5.0);
        car3.setTransmission("Automatic");
        car3.setSeats(5);

        List<CarRental> cars = Arrays.asList(car1, car2, car3);

        
        mockMvc.perform(post("/filteringCar")
                .param("rating", "4.0")
                .param("transmission", "Automatic")
                .param("seats", "4")
                .param("price", "300.0")
				.contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cars)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(car2, car3))));
    }

	 @Test
    void testFilteringFlights() throws Exception {
    
        Itinerary itinerary1 = new Itinerary();
        Price price1 = new Price();
        price1.setAmount(100.0);
        itinerary1.setPrice(price1);

        Itinerary itinerary2 = new Itinerary();
        Price price2 = new Price();
        price2.setAmount(200.0);
        itinerary2.setPrice(price2);

        Itinerary itinerary3 = new Itinerary();
        Price price3 = new Price();
        price3.setAmount(300.0);
        itinerary3.setPrice(price3);

        List<Itinerary> itineraries = Arrays.asList(itinerary1, itinerary2, itinerary3);

        
        mockMvc.perform(post("/filteringFlights")
                .param("maxPrice", "200.0")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(itineraries)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(itinerary1, itinerary2))));
    }

	@Test
void testSortingItineraries() throws Exception {
    
    Itinerary itinerary1 = new Itinerary();
    Price price1 = new Price();
    price1.setAmount(100.0);
    itinerary1.setPrice(price1);
    Itinerary.DateTime departureDateTime1 = new Itinerary.DateTime();
    departureDateTime1.setYear(2022);
    departureDateTime1.setMonth(1);
    departureDateTime1.setDay(1);
    departureDateTime1.setHour(10);
    departureDateTime1.setMinute(0);
    departureDateTime1.setSecond(0);
    itinerary1.setDepartureDateTime(departureDateTime1);
    Itinerary.DateTime arrivalDateTime1 = new Itinerary.DateTime();
    arrivalDateTime1.setYear(2022);
    arrivalDateTime1.setMonth(1);
    arrivalDateTime1.setDay(1);
    arrivalDateTime1.setHour(12);
    arrivalDateTime1.setMinute(0);
    arrivalDateTime1.setSecond(0);
    itinerary1.setArrivalDateTime(arrivalDateTime1);

    Itinerary itinerary2 = new Itinerary();
    Price price2 = new Price();
    price2.setAmount(200.0);
    itinerary2.setPrice(price2);
    Itinerary.DateTime departureDateTime2 = new Itinerary.DateTime();
    departureDateTime2.setYear(2022);
    departureDateTime2.setMonth(1);
    departureDateTime2.setDay(1);
    departureDateTime2.setHour(9);
    departureDateTime2.setMinute(0);
    departureDateTime2.setSecond(0);
    itinerary2.setDepartureDateTime(departureDateTime2);
    Itinerary.DateTime arrivalDateTime2 = new Itinerary.DateTime();
    arrivalDateTime2.setYear(2022);
    arrivalDateTime2.setMonth(1);
    arrivalDateTime2.setDay(1);
    arrivalDateTime2.setHour(11);
    arrivalDateTime2.setMinute(0);
    arrivalDateTime2.setSecond(0);
    itinerary2.setArrivalDateTime(arrivalDateTime2);

    List<Itinerary> itineraries = Arrays.asList(itinerary1, itinerary2);

    
    mockMvc.perform(post("/sortFlights")
            .param("sortBy", "duration")
            .param("sortOrder", "asc")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(itineraries)))
            .andExpect(status().isOk())
            .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(itinerary2, itinerary1))));
}
}