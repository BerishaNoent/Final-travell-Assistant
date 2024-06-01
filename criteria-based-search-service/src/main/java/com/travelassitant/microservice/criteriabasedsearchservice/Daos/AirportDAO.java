package com.travelassitant.microservice.criteriabasedsearchservice.Daos;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.travelassitant.microservice.criteriabasedsearchservice.bean.Country;
import com.travelassitant.microservice.criteriabasedsearchservice.bean.Country.Airport;
import com.travelassitant.microservice.criteriabasedsearchservice.bean.Country.City;
import com.travelassitant.microservice.criteriabasedsearchservice.dbRepositories.AirportRepository;

import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.Iterator;

@Service
public class AirportDAO {

    @Autowired
    private AirportRepository airportRepository;

    public boolean addAirport(Country newCountry) {
        try {

            Optional<Country> existingCountry = airportRepository.findById(newCountry.getId());
            if (existingCountry.isPresent()) {
                List<City> cities = existingCountry.get().getCities();
                Optional<City> existingCity = cities.stream()
                        .filter(city -> city.getLocation().equals(newCountry.getCities().get(0).getLocation()))
                        .findFirst();
                if (existingCity.isPresent()) {

                    List<Airport> airports = existingCity.get().getAirports();
                    Optional<Airport> existingAirport = airports.stream()
                            .filter(airport -> airport.getIataCode()
                                    .equals(newCountry.getCities().get(0).getAirports().get(0).getIataCode()))
                            .findFirst();
                    if (!existingAirport.isPresent()) {
                        airports.addAll(newCountry.getCities().get(0).getAirports());
                    }
                } else {
                    cities.addAll(newCountry.getCities());
                }
                airportRepository.save(existingCountry.get());
            } else {
                airportRepository.save(newCountry);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeAirport(String iataCode) {
        try {
            List<Country> countries = airportRepository.findAll();
            for (Country country : countries) {
                for (City city : country.getCities()) {
                    Iterator<Airport> airportIterator = city.getAirports().iterator();
                    while (airportIterator.hasNext()) {
                        Airport airport = airportIterator.next();
                        if (airport.getIataCode().equals(iataCode)) {
                            airportIterator.remove();
                            airportRepository.save(country);
                            if (airportRepository.findById(country.getId()).isPresent()) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeCountry(String id) {
        try {

            if (airportRepository.findById(id).isPresent()) {

                airportRepository.deleteById(id);
                if (!airportRepository.findById(id).isPresent()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {

            return false;
        }
    }

    public List<Country> addAllAirports(List<Country> airports) {
        return airportRepository.saveAll(airports);
    }

    public List<Country> getAllAirports() {
        return airportRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
