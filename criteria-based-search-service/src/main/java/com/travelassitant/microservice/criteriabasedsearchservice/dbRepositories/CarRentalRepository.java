package com.travelassitant.microservice.criteriabasedsearchservice.dbRepositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.travelassitant.microservice.criteriabasedsearchservice.bean.CarRental;

public interface CarRentalRepository extends MongoRepository<CarRental, String> {
}