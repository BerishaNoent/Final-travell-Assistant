package com.travelassitant.microservice.hotelsearchservice.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travelassitant.microservice.hotelsearchservice.bean.HotelInfo;
import com.travelassitant.microservice.hotelsearchservice.repositories.APIRepository1;
import com.travelassitant.microservice.hotelsearchservice.repositories.APIRepository2;
import com.travelassitant.microservice.hotelsearchservice.requests.RequestBodytemp;

@Component
public class fetchDataService {

    @Autowired
    private APIRepository1 apiRepository1;
    @Autowired
    private APIRepository2 apiRepository2;

    public List<HotelInfo> aggregateData(RequestBodytemp requestBody) throws Exception {
        Map<String, Object> result1 = apiRepository1.getHotelInfo(requestBody);
        System.out.println("Result from apiRepository1: " + result1);

        Map<String, Object> result2 = apiRepository2.getHotelInfo(requestBody);
        System.out.println("Result from apiRepository2: " + result2);

        List<HotelInfo> hotels1 = (List<HotelInfo>) result1.get("Hotels");
        List<HotelInfo> hotels2 = (List<HotelInfo>) result2.get("Hotels");

        List<HotelInfo> combinedResult = new ArrayList<>();

        if (hotels1 != null && !hotels1.isEmpty()) {
            combinedResult.addAll(hotels1);
        }
        if (hotels2 != null && !hotels2.isEmpty()) {
            combinedResult.addAll(hotels2);
        }

        return combinedResult;
    }

    public String getEntityId(File jsonFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(jsonFile, Map.class);

        List<Map<String, Object>> data = (List<Map<String, Object>>) map.get("data");
        if (!data.isEmpty()) {
            Map<String, Object> firstObject = data.get(0);
            return (String) firstObject.get("entityId");
        }

        return null;
    }

}
