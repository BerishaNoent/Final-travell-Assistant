package com.travelassitant.microservice.usermanagementservice.DAOs;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travelassitant.microservice.usermanagementservice.bean.HotelInfo;
import com.travelassitant.microservice.usermanagementservice.dbRepositories.HotelRepository;

@Service
public class HotelDAO {
    @Autowired
    private HotelRepository hotelRepository;

    public HotelInfo save(HotelInfo hotel) {
        String contentHash = hotel.calculateContentHash();

        HotelInfo existingHotel = hotelRepository.findByContentHash(contentHash);

        if (existingHotel != null) {
            return existingHotel;
        } else {
            hotel.setContentHash(contentHash);
            HotelInfo savedHotel = hotelRepository.save(hotel);

            return savedHotel;
        }
    }

    public long getNumberOfHotels() {
        return hotelRepository.count();
    }

    public List<HotelInfo> findAll() {
        return hotelRepository.findAll();
    }

    public HotelInfo findOne(String id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public void delete(HotelInfo hotel) {
        hotelRepository.delete(hotel);
    }
}
