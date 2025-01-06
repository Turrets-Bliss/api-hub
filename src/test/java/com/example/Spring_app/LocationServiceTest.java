package com.example.Spring_app;

import com.example.Spring_app.entity.Location;
import com.example.Spring_app.repository.LocationRepository;
import com.example.Spring_app.service.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LocationServiceTest {

    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private LocationService locationService;

    private Location location;

    @BeforeEach
    void setUp() {
        // Set up the Location object before each test
        location = new Location();
        location.setCity("New York");
        location.setState("NY");
        location.setAddress("123 Main St");
        location.setLatitude(40.7128);
        location.setLongitude(-74.0060);
    }

    @Test
    void testCreateLocation() {
        // Mock the save operation
        when(locationRepository.save(location)).thenReturn(location);

        Location createdLocation = locationService.createLocation(location);

        assertNotNull(createdLocation, "Created location should not be null");
        assertEquals("New York", createdLocation.getCity(), "City should match");
        assertEquals("NY", createdLocation.getState(), "State should match");
        verify(locationRepository, times(1)).save(location);
    }

    @Test
    void testGetLocationById() {
        // Mock the findById operation
        when(locationRepository.findById(1L)).thenReturn(Optional.of(location));

        Location foundLocation = locationService.getLocationById(1L);

        assertNotNull(foundLocation, "Location should be found");
        assertEquals("New York", foundLocation.getCity(), "City should match");
        assertEquals("NY", foundLocation.getState(), "State should match");
        verify(locationRepository, times(1)).findById(1L);
    }

    @Test
    void testGetLocationByIdNotFound() {
        // Mock the findById operation when not found
        when(locationRepository.findById(999L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            locationService.getLocationById(999L);
        });

        assertEquals("Location not found", exception.getMessage(), "Exception message should match");
        verify(locationRepository, times(1)).findById(999L);
    }

    @Test
    void testGetAllLocations() {
        // Mock the findAll operation
        when(locationRepository.findAll()).thenReturn(List.of(location));

        List<Location> locations = locationService.getAllLocations();

        assertNotNull(locations, "Locations list should not be null");
        assertEquals(1, locations.size(), "There should be one location");
        verify(locationRepository, times(1)).findAll();
    }

    @Test
    void testUpdateLocation() {
        // Mock the findById operation
        Location updatedLocation = new Location();
        updatedLocation.setCity("Los Angeles");
        updatedLocation.setState("CA");
        updatedLocation.setAddress("456 Elm St");
        updatedLocation.setLatitude(34.0522);
        updatedLocation.setLongitude(-118.2437);

        when(locationRepository.findById(1L)).thenReturn(Optional.of(location));
        when(locationRepository.save(location)).thenReturn(location);

        Location result = locationService.updateLocation(1L, updatedLocation);

        assertNotNull(result, "Updated location should not be null");
        assertEquals("Los Angeles", result.getCity(), "City should be updated");
        assertEquals("CA", result.getState(), "State should be updated");
        verify(locationRepository, times(1)).findById(1L);
        verify(locationRepository, times(1)).save(location);
    }

    @Test
    void testDeleteLocation() {
        // Mock the delete operation
        doNothing().when(locationRepository).deleteById(1L);

        locationService.deleteLocation(1L);

        verify(locationRepository, times(1)).deleteById(1L);
    }
}
