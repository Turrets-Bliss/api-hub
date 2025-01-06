package com.example.Spring_app;


import com.example.Spring_app.entity.AdditionalDetails;
import com.example.Spring_app.repository.AdditionalDetailsRepository;
import com.example.Spring_app.service.AdditionalDetailsService;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.*;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class AdditionalDetailsServiceTest {


    // getAllAdditionalDetails returns list of all AdditionalDetails entities
    @Test
    public void get_all_additional_details_returns_list() {
        // Arrange
        AdditionalDetailsRepository mockRepository = mock(AdditionalDetailsRepository.class);
        List<AdditionalDetails> expectedDetails = Arrays.asList(
            new AdditionalDetails(),
            new AdditionalDetails()
        );
        when(mockRepository.findAll()).thenReturn(expectedDetails);
    
        AdditionalDetailsService service = new AdditionalDetailsService();
        ReflectionTestUtils.setField(service, "additionalDetailsRepository", mockRepository);
    
        // Act
        List<AdditionalDetails> result = service.getAllAdditionalDetails();
    
        // Assert
        assertEquals(expectedDetails, result);
        verify(mockRepository).findAll();
    }

    // getAdditionalDetailsById returns empty Optional when ID does not exist
    @Test
    public void get_by_id_returns_empty_optional_when_not_found() {
        // Arrange
        AdditionalDetailsRepository mockRepository = mock(AdditionalDetailsRepository.class);
        Long nonExistentId = 999L;
        when(mockRepository.findById(nonExistentId)).thenReturn(Optional.empty());
    
        AdditionalDetailsService service = new AdditionalDetailsService();
        ReflectionTestUtils.setField(service, "additionalDetailsRepository", mockRepository);
    
        // Act
        Optional<AdditionalDetails> result = service.getAdditionalDetailsById(nonExistentId);
    
        // Assert
        assertTrue(result.isEmpty());
        verify(mockRepository).findById(nonExistentId);
    }

    // getAdditionalDetailsById returns Optional containing entity when ID exists
    @Test
    public void test_get_additional_details_by_id_returns_optional_when_id_exists() {
        AdditionalDetailsRepository mockRepository = Mockito.mock(AdditionalDetailsRepository.class);
        AdditionalDetailsService service = new AdditionalDetailsService();
        ReflectionTestUtils.setField(service, "additionalDetailsRepository", mockRepository);
    
        Long id = 1L;
        AdditionalDetails details = new AdditionalDetails();
        details.setId(id);
        Mockito.when(mockRepository.findById(id)).thenReturn(Optional.of(details));
    
        Optional<AdditionalDetails> result = service.getAdditionalDetailsById(id);
    
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(id, result.get().getId());
    }

    // saveAdditionalDetails persists new AdditionalDetails entity
    @Test
    public void test_save_additional_details_persists_new_entity() {
        AdditionalDetailsRepository mockRepository = Mockito.mock(AdditionalDetailsRepository.class);
        AdditionalDetailsService service = new AdditionalDetailsService();
        ReflectionTestUtils.setField(service, "additionalDetailsRepository", mockRepository);
    
        AdditionalDetails details = new AdditionalDetails();
        details.setFurnishedStatus("Furnished");
    
        Mockito.when(mockRepository.save(details)).thenReturn(details);
    
        AdditionalDetails result = service.saveAdditionalDetails(details);
    
        Assertions.assertNotNull(result);
        Assertions.assertEquals("Furnished", result.getFurnishedStatus());
    }


    // saveAdditionalDetails with null fields validates correctly
    @Test
    public void test_save_additional_details_with_null_fields() {
        AdditionalDetailsService service = new AdditionalDetailsService();
        AdditionalDetailsRepository repository = mock(AdditionalDetailsRepository.class);
        ReflectionTestUtils.setField(service, "additionalDetailsRepository", repository);

        AdditionalDetails details = new AdditionalDetails();
        details.setFurnishedStatus(null);
        details.setGreenRating(null);
        details.setPetFriendly(null);
        details.setCarParking(null);
        details.setTotalCarParkingSpaces(null);

        when(repository.save(any(AdditionalDetails.class))).thenReturn(details);

        AdditionalDetails savedDetails = service.saveAdditionalDetails(details);

        assertNotNull(savedDetails);
        assertNull(savedDetails.getFurnishedStatus());
        assertNull(savedDetails.getGreenRating());
        assertNull(savedDetails.getPetFriendly());
        assertNull(savedDetails.getCarParking());
        assertNull(savedDetails.getTotalCarParkingSpaces());
    }

    // deleteAdditionalDetails with non-existent ID handles gracefully
    @Test
    public void test_delete_additional_details_with_non_existent_id() {
        AdditionalDetailsService service = new AdditionalDetailsService();
        AdditionalDetailsRepository repository = mock(AdditionalDetailsRepository.class);
        ReflectionTestUtils.setField(service, "additionalDetailsRepository", repository);

        Long nonExistentId = 999L;
        doNothing().when(repository).deleteById(nonExistentId);

        service.deleteAdditionalDetails(nonExistentId);

        verify(repository, times(1)).deleteById(nonExistentId);
    }

    // saveAdditionalDetails with invalid data throws appropriate exception
    @Test
    public void test_save_additional_details_with_invalid_data() {
        AdditionalDetailsService service = new AdditionalDetailsService();
        AdditionalDetailsRepository repository = mock(AdditionalDetailsRepository.class);
        ReflectionTestUtils.setField(service, "additionalDetailsRepository", repository);

        AdditionalDetails invalidDetails = new AdditionalDetails();
        invalidDetails.setFurnishedStatus("InvalidStatus");

        when(repository.save(any(AdditionalDetails.class)))
            .thenThrow(new IllegalArgumentException("Invalid data"));

        assertThrows(IllegalArgumentException.class, () -> {
            service.saveAdditionalDetails(invalidDetails);
        });
    }
}