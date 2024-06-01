package com.travelassitant.microservice.criteriabasedsearchservice.dbRepositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.travelassitant.microservice.criteriabasedsearchservice.bean.Country;

public interface AirportRepository extends MongoRepository<Country, String> {
}
