package com.example.Spring_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.Spring_app.entity.NearbyLandmarks;


class NearbyLandmarksTest {

    @Test
    void testNearbyLandmarksEntity() {
        // Create a new NearbyLandmarks instance
        NearbyLandmarks landmarks = new NearbyLandmarks();

        // Set values using setters
        landmarks.setSchool("ABC High School");
        landmarks.setHospital("XYZ Hospital");
        landmarks.setShoppingMall("Central Mall");
        landmarks.setMetroStation("Downtown Metro");
        landmarks.setAirport("City Airport");

        // Validate getters
        assertEquals("ABC High School", landmarks.getSchool(), "School should match the set value");
        assertEquals("XYZ Hospital", landmarks.getHospital(), "Hospital should match the set value");
        assertEquals("Central Mall", landmarks.getShoppingMall(), "Shopping Mall should match the set value");
        assertEquals("Downtown Metro", landmarks.getMetroStation(), "Metro Station should match the set value");
        assertEquals("City Airport", landmarks.getAirport(), "Airport should match the set value");

        // Validate ID (should be null initially)
        assertNull(landmarks.getId(), "ID should be null initially");

        // Test the ID setter and getter
        landmarks.setId(1L);
        assertEquals(1L, landmarks.getId(), "ID should match the set value");
    }
}
