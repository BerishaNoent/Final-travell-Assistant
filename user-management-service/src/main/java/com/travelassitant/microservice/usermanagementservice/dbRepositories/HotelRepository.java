package com.travelassitant.microservice.usermanagementservice.dbRepositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.travelassitant.microservice.usermanagementservice.bean.HotelInfo;

public interface HotelRepository extends MongoRepository<HotelInfo, String> {
    HotelInfo findByContentHash(String contentHash);
    long count();
}