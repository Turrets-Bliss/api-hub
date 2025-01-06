package com.example.Spring_app;

import com.example.Spring_app.entity.LegalInformation;
import com.example.Spring_app.repository.LegalInformationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LegalInformationTest {

    @Autowired
    private LegalInformationRepository repository;

    private LegalInformation legalInformation;

    @BeforeEach
    void setUp() {
        // Initializing the LegalInformation entity before each test
        legalInformation = new LegalInformation();
        legalInformation.setReraNumber("RERA12345");
        legalInformation.setApprovals("Approved by local authority");
    }

    @Test
    void testSaveLegalInformation() {
        // Save the LegalInformation entity and check if it's saved correctly
        LegalInformation savedLegalInfo = repository.save(legalInformation);

        assertNotNull(savedLegalInfo.getId(), "ID should not be null after saving.");
        assertEquals("RERA12345", savedLegalInfo.getReraNumber(), "RERA number should match the saved value.");
        assertEquals("Approved by local authority", savedLegalInfo.getApprovals(), "Approvals should match the saved value.");
    }

    @Test
    void testFindLegalInformationById() {
        // Save the entity first
        LegalInformation savedLegalInfo = repository.save(legalInformation);

        // Fetch it by ID
        LegalInformation foundLegalInfo = repository.findById(savedLegalInfo.getId()).orElse(null);

        assertNotNull(foundLegalInfo, "The legal information should be found.");
        assertEquals(savedLegalInfo.getReraNumber(), foundLegalInfo.getReraNumber(), "The RERA number should match.");
        assertEquals(savedLegalInfo.getApprovals(), foundLegalInfo.getApprovals(), "The approvals should match.");
    }

    @Test
    void testUpdateLegalInformation() {
        // Save the entity first
        LegalInformation savedLegalInfo = repository.save(legalInformation);

        // Update the legal information details
        savedLegalInfo.setReraNumber("RERA67890");
        savedLegalInfo.setApprovals("Approved by government authority");

        LegalInformation updatedLegalInfo = repository.save(savedLegalInfo);

        // Verify that the details are updated
        assertEquals("RERA67890", updatedLegalInfo.getReraNumber(), "The RERA number should be updated.");
        assertEquals("Approved by government authority", updatedLegalInfo.getApprovals(), "The approvals should be updated.");
    }

    @Test
    void testDeleteLegalInformation() {
        // Save the entity first
        LegalInformation savedLegalInfo = repository.save(legalInformation);

        // Delete the entity
        repository.deleteById(savedLegalInfo.getId());

        // Verify that the entity is deleted
        LegalInformation foundLegalInfo = repository.findById(savedLegalInfo.getId()).orElse(null);
        assertNull(foundLegalInfo, "The legal information should be deleted.");
    }

    @Test
    void testFindAllLegalInformation() {
        // Save multiple legal information entries
        LegalInformation legalInfo1 = new LegalInformation();
        legalInfo1.setReraNumber("RERA12345");
        legalInfo1.setApprovals("Approved by local authority");
        repository.save(legalInfo1);

        LegalInformation legalInfo2 = new LegalInformation();
        legalInfo2.setReraNumber("RERA67890");
        legalInfo2.setApprovals("Approved by government authority");
        repository.save(legalInfo2);

        // Retrieve all legal information
        Iterable<LegalInformation> legalInfoList = repository.findAll();

        assertNotNull(legalInfoList, "The legal information list should not be null.");
        assertTrue(legalInfoList.iterator().hasNext(), "The legal information list should have at least one element.");
    }
}
