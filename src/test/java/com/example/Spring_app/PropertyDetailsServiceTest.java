package com.example.Spring_app;


import com.example.Spring_app.entity.PropertyDetails;
import com.example.Spring_app.repository.PropertyDetailsRepository;
import com.example.Spring_app.service.PropertyDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PropertyDetailsServiceTest {

    @Mock
    private PropertyDetailsRepository repository;

    @InjectMocks
    private PropertyDetailsService service;

    @Test
    void testCreateProperty() {
        // Arrange
        PropertyDetails propertyDetails = new PropertyDetails();
        propertyDetails.setId(1L);
        propertyDetails.setDeveloper("Developer A");

        when(repository.save(propertyDetails)).thenReturn(propertyDetails);

        // Act
        PropertyDetails result = service.createProperty(propertyDetails);

        // Assert
        assertNotNull(result, "The created property should not be null");
        assertEquals(1L, result.getId(), "ID should match");
        assertEquals("Developer A", result.getDeveloper(), "Developer should match");
        verify(repository, times(1)).save(propertyDetails);
    }

    @Test
    void testGetAllProperties() {
        // Arrange
        PropertyDetails property1 = new PropertyDetails();
        property1.setId(1L);
        property1.setDeveloper("Developer A");

        PropertyDetails property2 = new PropertyDetails();
        property2.setId(2L);
        property2.setDeveloper("Developer B");

        when(repository.findAll()).thenReturn(Arrays.asList(property1, property2));

        // Act
        List<PropertyDetails> result = service.getAllProperties();

        // Assert
        assertNotNull(result, "The result should not be null");
        assertEquals(2, result.size(), "There should be 2 properties");
        assertEquals("Developer A", result.get(0).getDeveloper(), "First property developer should match");
        assertEquals("Developer B", result.get(1).getDeveloper(), "Second property developer should match");
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetPropertyById_Found() {
        // Arrange
        PropertyDetails propertyDetails = new PropertyDetails();
        propertyDetails.setId(1L);
        propertyDetails.setDeveloper("Developer A");

        when(repository.findById(1L)).thenReturn(Optional.of(propertyDetails));

        // Act
        PropertyDetails result = service.getPropertyById(1L);

        // Assert
        assertNotNull(result, "The result should not be null");
        assertEquals(1L, result.getId(), "ID should match");
        assertEquals("Developer A", result.getDeveloper(), "Developer should match");
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testGetPropertyById_NotFound() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> service.getPropertyById(1L));
        assertEquals("Property not found", exception.getMessage(), "Exception message should match");
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testUpdateProperty() {
        // Arrange
        PropertyDetails existingProperty = new PropertyDetails();
        existingProperty.setId(1L);
        existingProperty.setDeveloper("Developer A");
        existingProperty.setTotalTowers(5);

        PropertyDetails updatedDetails = new PropertyDetails();
        updatedDetails.setDeveloper("Developer B");
        updatedDetails.setTotalTowers(7);

        when(repository.findById(1L)).thenReturn(Optional.of(existingProperty));
        when(repository.save(existingProperty)).thenReturn(existingProperty);

        // Act
        PropertyDetails result = service.updateProperty(1L, updatedDetails);

        // Assert
        assertNotNull(result, "The updated property should not be null");
        assertEquals("Developer B", result.getDeveloper(), "Updated developer should match");
        assertEquals(7, result.getTotalTowers(), "Updated total towers should match");
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(existingProperty);
    }

    @Test
    void testDeleteProperty() {
        // Arrange
        Long id = 1L;
        doNothing().when(repository).deleteById(id);

        // Act
        service.deleteProperty(id);

        // Assert
        verify(repository, times(1)).deleteById(id);
    }
}
