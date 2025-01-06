package com.example.Spring_app.controller;

import com.example.Spring_app.entity.Amenities;
import com.example.Spring_app.service.AmenitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/amenities")
public class AmenitiesController {

    @Autowired
    private AmenitiesService amenitiesService;

    @GetMapping
    public List<Amenities> getAllAmenities() {
        return amenitiesService.getAllAmenities();
    }

    @GetMapping("/{id}")
    public Optional<Amenities> getAmenityById(@PathVariable Long id) {
        return amenitiesService.getAmenityById(id);
    }

    @PostMapping
    public Amenities createAmenity(@RequestBody Amenities amenity) {
        return amenitiesService.saveAmenity(amenity);
    }

    @DeleteMapping("/{id}")
    public void deleteAmenity(@PathVariable Long id) {
        amenitiesService.deleteAmenity(id);
    }
}