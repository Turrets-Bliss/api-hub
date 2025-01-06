package com.example.Spring_app;

import com.example.Spring_app.entity.Location;
import com.example.Spring_app.repository.LocationRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void testLocationEntity() {
        // Create a new Location instance
        Location location = new Location();

        // Set values using setters
        location.setCity("New York");
        location.setState("NY");
        location.setAddress("123 Main St");
        location.setLatitude(40.7128);
        location.setLongitude(-74.0060);

        // Validate getters
        assertEquals("New York", location.getCity(), "City should match the set value");
        assertEquals("NY", location.getState(), "State should match the set value");
        assertEquals("123 Main St", location.getAddress(), "Address should match the set value");
        assertEquals(40.7128, location.getLatitude(), "Latitude should match the set value");
        assertEquals(-74.0060, location.getLongitude(), "Longitude should match the set value");

        // Validate ID (should be null initially)
        assertNull(location.getId(), "ID should be null initially");

        // Test the ID setter and getter
        location.setId(1L);
        assertEquals(1L, location.getId(), "ID should match the set value");
    }
}
