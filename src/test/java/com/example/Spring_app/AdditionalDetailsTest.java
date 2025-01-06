package com.example.Spring_app;

import com.example.Spring_app.entity.AdditionalDetails;
import com.example.Spring_app.repository.AdditionalDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AdditionalDetailsTest {

    @Autowired
    private AdditionalDetailsRepository repository;

    private AdditionalDetails additionalDetails;

    @BeforeEach
    void setUp() {
        // Initializing the AdditionalDetails entity before each test
        additionalDetails = new AdditionalDetails();
        additionalDetails.setFurnishedStatus("Semi-furnished");
        additionalDetails.setGreenRating("IGBC Certified");
        additionalDetails.setPetFriendly(true);
        additionalDetails.setCarParking("Covered");
        additionalDetails.setTotalCarParkingSpaces(2);
    }

    @Test
    void testSaveAdditionalDetails() {
        // Save the AdditionalDetails entity and check if it's saved correctly
        AdditionalDetails savedDetails = repository.save(additionalDetails);

        assertNotNull(savedDetails.getId(), "ID should not be null after saving.");
        assertEquals("Semi-furnished", savedDetails.getFurnishedStatus(), "Furnished status should match the saved value.");
        assertEquals("IGBC Certified", savedDetails.getGreenRating(), "Green rating should match the saved value.");
    }

    @Test
    void testFindAdditionalDetailsById() {
        // Save the entity first
        AdditionalDetails savedDetails = repository.save(additionalDetails);

        // Fetch it by ID
        AdditionalDetails foundDetails = repository.findById(savedDetails.getId()).orElse(null);

        assertNotNull(foundDetails, "The additional details should be found.");
        assertEquals(savedDetails.getFurnishedStatus(), foundDetails.getFurnishedStatus(), "The furnished status should match.");
        assertEquals(savedDetails.getGreenRating(), foundDetails.getGreenRating(), "The green rating should match.");
    }

    @Test
    void testUpdateAdditionalDetails() {
        // Save the entity first
        AdditionalDetails savedDetails = repository.save(additionalDetails);

        // Update the details
        savedDetails.setFurnishedStatus("Fully-furnished");
        savedDetails.setGreenRating("LEED Certified");
        savedDetails.setPetFriendly(false);
        savedDetails.setCarParking("Open");
        savedDetails.setTotalCarParkingSpaces(3);

        AdditionalDetails updatedDetails = repository.save(savedDetails);

        // Verify that the details are updated
        assertEquals("Fully-furnished", updatedDetails.getFurnishedStatus(), "The furnished status should be updated.");
        assertEquals("LEED Certified", updatedDetails.getGreenRating(), "The green rating should be updated.");
        assertFalse(updatedDetails.getPetFriendly(), "Pet friendly status should be updated.");
        assertEquals("Open", updatedDetails.getCarParking(), "Car parking status should be updated.");
        assertEquals(3, updatedDetails.getTotalCarParkingSpaces(), "Total car parking spaces should be updated.");
    }

    @Test
    void testDeleteAdditionalDetails() {
        // Save the entity first
        AdditionalDetails savedDetails = repository.save(additionalDetails);

        // Delete the entity
        repository.deleteById(savedDetails.getId());

        // Verify that the entity is deleted
        AdditionalDetails foundDetails = repository.findById(savedDetails.getId()).orElse(null);
        assertNull(foundDetails, "The additional details should be deleted.");
    }

    @Test
    void testFindAllAdditionalDetails() {
        // Save multiple additional details entries
        AdditionalDetails details1 = new AdditionalDetails();
        details1.setFurnishedStatus("Semi-furnished");
        details1.setGreenRating("BEE Certified");
        details1.setPetFriendly(true);
        details1.setCarParking("Covered");
        details1.setTotalCarParkingSpaces(1);
        repository.save(details1);

        AdditionalDetails details2 = new AdditionalDetails();
        details2.setFurnishedStatus("Fully-furnished");
        details2.setGreenRating("IGBC Certified");
        details2.setPetFriendly(false);
        details2.setCarParking("Open");
        details2.setTotalCarParkingSpaces(2);
        repository.save(details2);

        // Retrieve all additional details
        Iterable<AdditionalDetails> detailsList = repository.findAll();

        assertNotNull(detailsList, "The additional details list should not be null.");
        assertTrue(detailsList.iterator().hasNext(), "The additional details list should have at least one element.");
    }
}
