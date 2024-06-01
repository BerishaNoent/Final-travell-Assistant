package com.travelassitant.microservice.usermanagementservice.dbRepositories;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.travelassitant.microservice.usermanagementservice.bean.Search;

public interface RecentSearchRepository extends MongoRepository<Search, String> {
    @Aggregation(pipeline = {
        "{ $group: { _id: '$destination', count: { $sum: 1 } } }",
        "{ $sort: { count: -1 } }",
        "{ $project: { _id: 0, destination: '$_id' } }",
        "{ $limit: 3 }"
    })
    List<String> findTop3Destinations();
}
