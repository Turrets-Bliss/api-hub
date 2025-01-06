package com.example.Spring_app;

import com.example.Spring_app.entity.Amenities;
import com.example.Spring_app.repository.AmenitiesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AmenitiesTest {

    @Autowired
    private AmenitiesRepository repository;

    private Amenities amenity;

    @BeforeEach
    void setUp() {
        // Initializing the Amenities entity before each test
        amenity = new Amenities();
        amenity.setName("Swimming Pool");
    }

    @Test
    void testSaveAmenity() {
        // Save the Amenities entity and check if it's saved correctly
        Amenities savedAmenity = repository.save(amenity);

        assertNotNull(savedAmenity.getId(), "ID should not be null after saving.");
        assertEquals("Swimming Pool", savedAmenity.getName(), "Name should match the saved value.");
    }

    @Test
    void testFindAmenityById() {
        // Save the entity first
        Amenities savedAmenity = repository.save(amenity);

        // Fetch it by ID
        Amenities foundAmenity = repository.findById(savedAmenity.getId()).orElse(null);

        assertNotNull(foundAmenity, "The amenity should be found.");
        assertEquals(savedAmenity.getName(), foundAmenity.getName(), "The found amenity should have the same name.");
    }

    @Test
    void testUpdateAmenity() {
        // Save the entity first
        Amenities savedAmenity = repository.save(amenity);

        // Update the name
        savedAmenity.setName("Fitness Center");
        Amenities updatedAmenity = repository.save(savedAmenity);

        assertEquals("Fitness Center", updatedAmenity.getName(), "The name should be updated.");
    }

    @Test
    void testDeleteAmenity() {
        // Save the entity first
        Amenities savedAmenity = repository.save(amenity);

        // Delete the entity
        repository.deleteById(savedAmenity.getId());

        // Verify that the entity is deleted
        Amenities foundAmenity = repository.findById(savedAmenity.getId()).orElse(null);
        assertNull(foundAmenity, "The amenity should be deleted.");
    }

    @Test
    void testFindAllAmenities() {
        // Save multiple amenities
        Amenities amenity1 = new Amenities();
        amenity1.setName("Swimming Pool");
        repository.save(amenity1);

        Amenities amenity2 = new Amenities();
        amenity2.setName("Gym");
        repository.save(amenity2);

        // Retrieve all amenities
        Iterable<Amenities> amenities = repository.findAll();
        assertNotNull(amenities, "Amenities list should not be null.");
        assertTrue(amenities.iterator().hasNext(), "Amenities list should have at least one element.");
    }
}
