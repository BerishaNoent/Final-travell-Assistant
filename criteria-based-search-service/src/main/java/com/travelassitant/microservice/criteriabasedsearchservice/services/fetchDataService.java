package com.travelassitant.microservice.criteriabasedsearchservice.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travelassitant.microservice.criteriabasedsearchservice.bean.CarRental;
import com.travelassitant.microservice.criteriabasedsearchservice.bean.Itinerary;
import com.travelassitant.microservice.criteriabasedsearchservice.repositories.ApiRepository2;
import com.travelassitant.microservice.criteriabasedsearchservice.repositories.ApiRepository3;
import com.travelassitant.microservice.criteriabasedsearchservice.repositories.ApiRepositoryCarRental2;
import com.travelassitant.microservice.criteriabasedsearchservice.repositories.ApiRepositoryCarrental1;
import com.travelassitant.microservice.criteriabasedsearchservice.request.RequestBodytemp;

@Component
public class fetchDataService {

    @Autowired
    private ApiRepository2 apiRepository2;
    @Autowired
    private ApiRepository3 apiRepository3;
    @Autowired
    private ApiRepositoryCarrental1 apiRepositoryCarrental1;
    @Autowired
    private ApiRepositoryCarRental2 apiRepositoryCarrental2;

    public List<Itinerary> aggregateData(RequestBodytemp requestBodytemp) throws IOException {

        
    Map<String, Object> result2 = apiRepository2.getFlightInfo(requestBodytemp);
    Map<String, Object> result3 = apiRepository3.getFlightInfo(requestBodytemp);

    List<Itinerary> flightDetailsList3 = (List<Itinerary>) result3.get("flightDetailsList");
    List<Itinerary> flightDetailsList2 = (List<Itinerary>) result2.get("flightDetailsList");

    List<Itinerary> combinedResult = new ArrayList<>();

    if(flightDetailsList3 != null){
    combinedResult.addAll(flightDetailsList3);
    }
    if (flightDetailsList2 != null) {
    combinedResult.addAll(flightDetailsList2);
}
if (!combinedResult.isEmpty()) {
    Itinerary firstItinerary = combinedResult.get(0);
}
    return combinedResult;

}
    

    public List<CarRental> CarRentals(RequestBodytemp formData) throws IOException {
        Map<String, Object> result1 = apiRepositoryCarrental1.queryApi(formData);
        

        Map<String, Object> result2 = apiRepositoryCarrental2.queryApi(formData);
    
        List<CarRental> carRentals1 = (List<CarRental>) result1.get("CarRentals");
        List<CarRental> carRentals2 = (List<CarRental>) result2.get("CarRentals");
    
        List<CarRental> combinedResult = new ArrayList<>();
        if (carRentals1 != null && !carRentals1.isEmpty()) {
            combinedResult.addAll(carRentals1);
        }
        if (carRentals2 != null && !carRentals2.isEmpty()) {
            combinedResult.addAll(carRentals2);
        }
    
        return combinedResult;
    }
}