package com.example.Spring_app.service;

import com.example.Spring_app.entity.Amenities;
import com.example.Spring_app.repository.AmenitiesRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class AmenitiesService {

    @Autowired
    private AmenitiesRepository amenitiesRepository;

    public List<Amenities> getAllAmenities() {
        return amenitiesRepository.findAll();
    }

    public Optional<Amenities> getAmenityById(Long id) {
        return amenitiesRepository.findById(id);
    }

    public Amenities saveAmenity(Amenities amenity) {
        return amenitiesRepository.save(amenity);
    }

    public void deleteAmenity(Long id) {
        amenitiesRepository.deleteById(id);
    }
}
