package com.travelassitant.microservice.usermanagementservice.DAOs;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travelassitant.microservice.usermanagementservice.bean.CarRental;
import com.travelassitant.microservice.usermanagementservice.dbRepositories.CarRentalRepository;

@Service
public class CarRentalDAO {
    @Autowired
    private CarRentalRepository carRentalRepository;

    public CarRental save(CarRental carRental) {
        String contentHash = carRental.calculateContentHash();

        CarRental existingCarRental = carRentalRepository.findByContentHash(contentHash);

        if (existingCarRental != null) {
            return existingCarRental;
        } else {
            carRental.setContentHash(contentHash);
            CarRental savedCarRental = carRentalRepository.save(carRental);

            return savedCarRental;
        }
    }

    public long getNumberOfCarRentals() {
        return carRentalRepository.count();
    }

    public List<CarRental> findAll() {
        return carRentalRepository.findAll();
    }

    public CarRental findOne(String id) {
        return carRentalRepository.findById(id).orElse(null);
    }

    public void delete(CarRental carRental) {
        carRentalRepository.delete(carRental);
    }

    public void deleteAll() {
        carRentalRepository.deleteAll();
    }
}
