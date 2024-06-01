package com.travelassitant.microservice.usermanagementservice.dbRepositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.travelassitant.microservice.usermanagementservice.bean.CarRental;

public interface CarRentalRepository extends MongoRepository<CarRental, String> {
    CarRental findByContentHash(String contentHash);
    long count();
}
