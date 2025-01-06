package com.example.Spring_app;

import com.example.Spring_app.entity.Amenities;
import com.example.Spring_app.repository.AmenitiesRepository;
import com.example.Spring_app.service.AmenitiesService;
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
class AmenitiesServiceTest {

    @Mock
    private AmenitiesRepository amenitiesRepository;

    @InjectMocks
    private AmenitiesService amenitiesService;

    @Test
    void testGetAllAmenities() {
        // Arrange
        Amenities amenity1 = new Amenities();
        amenity1.setId(1L);
        amenity1.setName("Swimming Pool");

        Amenities amenity2 = new Amenities();
        amenity2.setId(2L);
        amenity2.setName("Gym");

        when(amenitiesRepository.findAll()).thenReturn(Arrays.asList(amenity1, amenity2));

        // Act
        List<Amenities> amenities = amenitiesService.getAllAmenities();

        // Assert
        assertNotNull(amenities, "Amenities list should not be null");
        assertEquals(2, amenities.size(), "Amenities list size should be 2");
        assertEquals("Swimming Pool", amenities.get(0).getName(), "First amenity name should match");
        assertEquals("Gym", amenities.get(1).getName(), "Second amenity name should match");
        verify(amenitiesRepository, times(1)).findAll();
    }

    @Test
    void testGetAmenityById_Found() {
        // Arrange
        Amenities amenity = new Amenities();
        amenity.setId(1L);
        amenity.setName("Swimming Pool");

        when(amenitiesRepository.findById(1L)).thenReturn(Optional.of(amenity));

        // Act
        Optional<Amenities> result = amenitiesService.getAmenityById(1L);

        // Assert
        assertTrue(result.isPresent(), "Amenity should be present");
        assertEquals("Swimming Pool", result.get().getName(), "Amenity name should match");
        verify(amenitiesRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAmenityById_NotFound() {
        // Arrange
        when(amenitiesRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Optional<Amenities> result = amenitiesService.getAmenityById(1L);

        // Assert
        assertFalse(result.isPresent(), "Amenity should not be present");
        verify(amenitiesRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveAmenity() {
        // Arrange
        Amenities amenity = new Amenities();
        amenity.setId(1L);
        amenity.setName("Swimming Pool");

        when(amenitiesRepository.save(amenity)).thenReturn(amenity);

        // Act
        Amenities savedAmenity = amenitiesService.saveAmenity(amenity);

        // Assert
        assertNotNull(savedAmenity, "Saved amenity should not be null");
        assertEquals("Swimming Pool", savedAmenity.getName(), "Saved amenity name should match");
        verify(amenitiesRepository, times(1)).save(amenity);
    }

    @Test
    void testDeleteAmenity() {
        // Arrange
        Long amenityId = 1L;
        doNothing().when(amenitiesRepository).deleteById(amenityId);

        // Act
        amenitiesService.deleteAmenity(amenityId);

        // Assert
        verify(amenitiesRepository, times(1)).deleteById(amenityId);
    }
}
