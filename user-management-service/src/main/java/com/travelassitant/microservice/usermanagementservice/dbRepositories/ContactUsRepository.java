package com.travelassitant.microservice.usermanagementservice.dbRepositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.travelassitant.microservice.usermanagementservice.bean.ContactUs;

public interface ContactUsRepository extends MongoRepository<ContactUs, String> {
}
