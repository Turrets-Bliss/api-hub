package com.example.Spring_app.service;

import com.example.Spring_app.entity.Location;
import com.example.Spring_app.repository.LocationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationById(Long id) {
        return locationRepository.findById(id).orElseThrow(() -> new RuntimeException("Location not found"));
    }

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location updateLocation(Long id, Location updatedLocation) {
        Location existing = getLocationById(id);
        existing.setCity(updatedLocation.getCity());
        existing.setState(updatedLocation.getState());
        existing.setAddress(updatedLocation.getAddress());
        existing.setLatitude(updatedLocation.getLatitude());
        existing.setLongitude(updatedLocation.getLongitude());
        return locationRepository.save(existing);
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}