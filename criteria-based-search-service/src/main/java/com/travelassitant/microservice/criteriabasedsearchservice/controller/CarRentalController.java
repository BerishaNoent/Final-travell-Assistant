package com.travelassitant.microservice.criteriabasedsearchservice.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelassitant.microservice.criteriabasedsearchservice.Daos.CarRentalDao;
import com.travelassitant.microservice.criteriabasedsearchservice.bean.CarRental;
import com.travelassitant.microservice.criteriabasedsearchservice.pubsub.PubSubService;
import com.travelassitant.microservice.criteriabasedsearchservice.request.RequestBodytemp;
import com.travelassitant.microservice.criteriabasedsearchservice.services.fetchDataService;

@RestController
@RequestMapping("/carRentals")
public class CarRentalController {

    @Autowired
    private fetchDataService apiService;
    @Autowired
    private CarRentalDao carRentalDao;
    @Autowired
    private PubSubService pubSubService;
    @Autowired
    private PollableChannel carRentalResultInputChannel;

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody CarRental carRental) {
        System.out.println("Car Rental Info: ");
        pubSubService.publishCarRental(carRental);
        Message<?> resultMessage = carRentalResultInputChannel.receive();
        String message = "No response received";
        if (resultMessage != null) {
            Object payload = resultMessage.getPayload();
            if (payload instanceof byte[]) {
                message = new String((byte[]) payload, StandardCharsets.UTF_8);
            } else {
                message = payload.toString();
            }
            System.out.println("Received message: " + message);
            if ("Failed to save car rental".equals(message)) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message); // HTTP 500 Internal
                                                                                              // Server Error
            } else if ("Car rental already saved".equals(message)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(message); // HTTP 409 Conflict
            } else {
                return ResponseEntity.ok(message); // HTTP 200 OK
            }
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(message); // HTTP 204 No Content
        }
    }

    // @PostMapping("/aggregateData")
    // public ResponseEntity<List<CarRental>> carrental(@RequestBody RequestBodytemp
    // formData) throws IOException {
    // List<CarRental> data = apiService.CarRentals(formData);

    // if (data.isEmpty()) {
    // System.out.println("CarRentals result is empty. Returning 404 Not Found.");
    // return ResponseEntity.notFound().build();
    // } else {
    // System.out.println("CarRentals result is not empty. Returning 200 OK with
    // data: " + data);
    // return ResponseEntity.ok().body(data);
    // }
    // }

    @PostMapping("/aggregateData")
    public ResponseEntity<List<CarRental>> carrental(@RequestBody RequestBodytemp formData) throws IOException {
        List<CarRental> data = apiService.CarRentals(formData);

        if (data.isEmpty()) {

            CarRental carRental1 = new CarRental();
            carRental1.setId("1");
            carRental1.setSupplierName("Supplier 1");
            carRental1.setPrice("100");
            carRental1.setCurrency("USD");
            carRental1.setCarName("Car 1");

            CarRental carRental2 = new CarRental();
            carRental2.setId("2");
            carRental2.setSupplierName("Supplier 2");
            carRental2.setPrice("100");
            carRental2.setCurrency("USD");
            carRental2.setCarName("Car 2");

            data = Arrays.asList(carRental1, carRental2);

        } else {

        }

        return ResponseEntity.ok().body(data);
    }

    @GetMapping("/getCarRental/{id}")
    public ResponseEntity<CarRental> getCarRental(@PathVariable String id) {
        CarRental carRental = carRentalDao.getCarRental(id);
        if (carRental != null) {
            return ResponseEntity.ok(carRental);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/deleteCarRental/{id}")
    public ResponseEntity<Void> deleteCarRental(@PathVariable String id) {
        boolean isRemoved = carRentalDao.deleteCarRental(id);
        if (isRemoved) {
            return ResponseEntity.noContent().build(); // HTTP 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found
        }
    }

    @GetMapping("/allCarRentals")
    public ResponseEntity<List<CarRental>> getAllCarRentals() {
        List<CarRental> carRentals = carRentalDao.getAllCarRentals();
        if (!carRentals.isEmpty()) {
            return ResponseEntity.ok(carRentals);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}
