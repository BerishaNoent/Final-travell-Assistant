package com.travelassitant.microservice.usermanagementservice.dbRepositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.travelassitant.microservice.usermanagementservice.bean.User;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);

    long count();

}
