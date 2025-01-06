package com.example.Spring_app;

import com.example.Spring_app.entity.NearbyLandmarks;
import com.example.Spring_app.repository.NearbyLandmarksRepository;
import com.example.Spring_app.service.NearbyLandmarksService;
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
class NearbyLandmarksServiceTest {

    @Mock
    private NearbyLandmarksRepository nearbyLandmarksRepository;

    @InjectMocks
    private NearbyLandmarksService nearbyLandmarksService;

    @Test
    void testGetAllLandmarks() {
        // Arrange
        NearbyLandmarks landmark1 = new NearbyLandmarks();
        landmark1.setId(1L);

        NearbyLandmarks landmark2 = new NearbyLandmarks();
        landmark2.setId(2L);

        when(nearbyLandmarksRepository.findAll()).thenReturn(Arrays.asList(landmark1, landmark2));

        // Act
        List<NearbyLandmarks> result = nearbyLandmarksService.getAllLandmarks();

        // Assert
        assertNotNull(result, "The result should not be null");
        assertEquals(2, result.size(), "There should be 2 landmarks");
        assertEquals(1L, result.get(0).getId(), "First landmark ID should match");
        assertEquals(2L, result.get(1).getId(), "Second landmark ID should match");
        verify(nearbyLandmarksRepository, times(1)).findAll();
    }

    @Test
    void testGetLandmarkById_Found() {
        // Arrange
        NearbyLandmarks landmark = new NearbyLandmarks();
        landmark.setId(1L);

        when(nearbyLandmarksRepository.findById(1L)).thenReturn(Optional.of(landmark));

        // Act
        Optional<NearbyLandmarks> result = nearbyLandmarksService.getLandmarkById(1L);

        // Assert
        assertTrue(result.isPresent(), "Landmark should be present");
        assertEquals(1L, result.get().getId(), "ID should match");
        verify(nearbyLandmarksRepository, times(1)).findById(1L);
    }

    @Test
    void testGetLandmarkById_NotFound() {
        // Arrange
        when(nearbyLandmarksRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Optional<NearbyLandmarks> result = nearbyLandmarksService.getLandmarkById(1L);

        // Assert
        assertFalse(result.isPresent(), "Landmark should not be present");
        verify(nearbyLandmarksRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveLandmark() {
        // Arrange
        NearbyLandmarks landmark = new NearbyLandmarks();
        landmark.setId(1L);

        when(nearbyLandmarksRepository.save(landmark)).thenReturn(landmark);

        // Act
        NearbyLandmarks result = nearbyLandmarksService.saveLandmark(landmark);

        // Assert
        assertNotNull(result, "Saved landmark should not be null");
        assertEquals(1L, result.getId(), "ID should match");
        verify(nearbyLandmarksRepository, times(1)).save(landmark);
    }

    @Test
    void testDeleteLandmark() {
        // Arrange
        Long id = 1L;
        doNothing().when(nearbyLandmarksRepository).deleteById(id);

        // Act
        nearbyLandmarksService.deleteLandmark(id);

        // Assert
        verify(nearbyLandmarksRepository, times(1)).deleteById(id);
    }
}
