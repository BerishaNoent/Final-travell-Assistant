package com.travelassitant.microservice.criteriabasedsearchservice.Daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelassitant.microservice.criteriabasedsearchservice.bean.CarRental;
import com.travelassitant.microservice.criteriabasedsearchservice.dbRepositories.CarRentalRepository;

@Service
public class CarRentalDao {

    @Autowired
    private CarRentalRepository carRentalRepository;

    public CarRental saveCarRental(CarRental carRental) {
        return carRentalRepository.save(carRental);
    }

    public boolean deleteCarRental(String id) {
        if (carRentalRepository.existsById(id)) {
            carRentalRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public CarRental getCarRental(String id) {
        return carRentalRepository.findById(id).orElse(null);
    }

    public List<CarRental> getAllCarRentals() {
        return carRentalRepository.findAll();
    }
}