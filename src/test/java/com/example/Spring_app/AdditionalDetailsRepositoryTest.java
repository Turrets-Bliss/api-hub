package com.example.Spring_app;

import com.example.Spring_app.entity.AdditionalDetails;
import com.example.Spring_app.repository.AdditionalDetailsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AdditionalDetailsRepositoryTest {

    @Autowired
    private AdditionalDetailsRepository repository;

    @Test
    void saveAndFindAdditionalDetails() {
        AdditionalDetails details = new AdditionalDetails();
        details.setFurnishedStatus("Semi-furnished");
        details.setGreenRating("IGBC Certified");
        details.setPetFriendly(true);
        details.setCarParking("Covered");
        details.setTotalCarParkingSpaces(2);

        AdditionalDetails saved = repository.save(details);
        Optional<AdditionalDetails> found = repository.findById(saved.getId());

        assertTrue(found.isPresent());
        assertEquals("Semi-furnished", found.get().getFurnishedStatus());
        assertEquals("IGBC Certified", found.get().getGreenRating());
    }

    @Test
    void deleteAdditionalDetails() {
        AdditionalDetails details = new AdditionalDetails();
        details.setFurnishedStatus("Furnished");
        details.setGreenRating("LEED Certified");
        details.setPetFriendly(true);
        details.setCarParking("Uncovered");
        details.setTotalCarParkingSpaces(1);

        AdditionalDetails saved = repository.save(details);
        repository.deleteById(saved.getId());
        Optional<AdditionalDetails> found = repository.findById(saved.getId());

        assertFalse(found.isPresent());
    }
}
