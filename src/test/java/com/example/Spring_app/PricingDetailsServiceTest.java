package com.example.Spring_app;

import com.example.Spring_app.entity.PricingDetails;
import com.example.Spring_app.repository.PricingDetailsRepository;
import com.example.Spring_app.service.PricingDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PricingDetailsServiceTest {

    @Mock
    private PricingDetailsRepository repository;

    @InjectMocks
    private PricingDetailsService service;

    @Test
    void testGetAllPricingDetails() {
        // Arrange
        PricingDetails details1 = new PricingDetails();
        details1.setId(1L);
        details1.setBasePricePerSqFt(BigDecimal.valueOf(1000.0));

        PricingDetails details2 = new PricingDetails();
        details2.setId(2L);
        details2.setBasePricePerSqFt(BigDecimal.valueOf(1200.0));

        when(repository.findAll()).thenReturn(Arrays.asList(details1, details2));

        // Act
        List<PricingDetails> result = service.getAllPricingDetails();

        // Assert
        assertNotNull(result, "The result should not be null");
        assertEquals(2, result.size(), "There should be 2 pricing details");
        assertEquals(BigDecimal.valueOf(1000.0), result.get(0).getBasePricePerSqFt(), "First base price should match");
        assertEquals(BigDecimal.valueOf(1200.0), result.get(1).getBasePricePerSqFt(), "Second base price should match");
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetPricingDetailsById_Found() {
        // Arrange
        PricingDetails details = new PricingDetails();
        details.setId(1L);
        details.setBasePricePerSqFt(BigDecimal.valueOf(1000.0));

        when(repository.findById(1L)).thenReturn(Optional.of(details));

        // Act
        PricingDetails result = service.getPricingDetailsById(1L);

        // Assert
        assertNotNull(result, "The result should not be null");
        assertEquals(1L, result.getId(), "ID should match");
        assertEquals(BigDecimal.valueOf(1000.0), result.getBasePricePerSqFt(), "Base price should match");
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testCreatePricingDetails() {
        // Arrange
        PricingDetails details = new PricingDetails();
        details.setId(1L);
        details.setBasePricePerSqFt(BigDecimal.valueOf(1000.0));

        when(repository.save(details)).thenReturn(details);

        // Act
        PricingDetails result = service.createPricingDetails(details);

        // Assert
        assertNotNull(result, "The saved details should not be null");
        assertEquals(1L, result.getId(), "ID should match");
        assertEquals(BigDecimal.valueOf(1000.0), result.getBasePricePerSqFt(), "Base price should match");
        verify(repository, times(1)).save(details);
    }

    @Test
    void testUpdatePricingDetails() {
        // Arrange
        PricingDetails existingDetails = new PricingDetails();
        existingDetails.setId(1L);
        existingDetails.setBasePricePerSqFt(BigDecimal.valueOf(1000.0));
        existingDetails.setMaintenanceChargesPerMonth(BigDecimal.valueOf(200.0));
        existingDetails.setBookingAmount(BigDecimal.valueOf(50000.0));

        PricingDetails updatedDetails = new PricingDetails();
        updatedDetails.setBasePricePerSqFt(BigDecimal.valueOf(1200.0));
        updatedDetails.setMaintenanceChargesPerMonth(BigDecimal.valueOf(250.0));
        updatedDetails.setBookingAmount(BigDecimal.valueOf(55000.0));

        when(repository.findById(1L)).thenReturn(Optional.of(existingDetails));
        when(repository.save(existingDetails)).thenReturn(existingDetails);

        // Act
        PricingDetails result = service.updatePricingDetails(1L, updatedDetails);

        // Assert
        assertNotNull(result, "The updated details should not be null");
        assertEquals(1L, result.getId(), "ID should match");
        assertEquals(BigDecimal.valueOf(1200.0), result.getBasePricePerSqFt(), "Updated base price should match");
        assertEquals(BigDecimal.valueOf(250.0), result.getMaintenanceChargesPerMonth(), "Updated maintenance charges should match");
        assertEquals(BigDecimal.valueOf(55000.0), result.getBookingAmount(), "Updated booking amount should match");
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(existingDetails);
    }
}
