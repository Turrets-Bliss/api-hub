package com.example.Spring_app;

import com.example.Spring_app.entity.LegalInformation;
import com.example.Spring_app.repository.LegalInformationRepository;
import com.example.Spring_app.service.LegalInformationService;
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
class LegalInformationServiceTest {

    @Mock
    private LegalInformationRepository legalInformationRepository;

    @InjectMocks
    private LegalInformationService legalInformationService;

    @Test
    void testGetAllLegalInformation() {
        // Arrange
        LegalInformation info1 = new LegalInformation();
        info1.setId(1L);

        LegalInformation info2 = new LegalInformation();
        info2.setId(2L);

        when(legalInformationRepository.findAll()).thenReturn(Arrays.asList(info1, info2));

        // Act
        List<LegalInformation> result = legalInformationService.getAllLegalInformation();

        // Assert
        assertNotNull(result, "The result should not be null");
        assertEquals(2, result.size(), "There should be 2 legal information entries");
        assertEquals(1L, result.get(0).getId(), "First legal information ID should match");
        assertEquals(2L, result.get(1).getId(), "Second legal information ID should match");
        verify(legalInformationRepository, times(1)).findAll();
    }

    @Test
    void testGetLegalInformationById_Found() {
        // Arrange
        LegalInformation info = new LegalInformation();
        info.setId(1L);

        when(legalInformationRepository.findById(1L)).thenReturn(Optional.of(info));

        // Act
        Optional<LegalInformation> result = legalInformationService.getLegalInformationById(1L);

        // Assert
        assertTrue(result.isPresent(), "Legal information should be present");
        assertEquals(1L, result.get().getId(), "ID should match the expected value");
        verify(legalInformationRepository, times(1)).findById(1L);
    }

    @Test
    void testGetLegalInformationById_NotFound() {
        // Arrange
        when(legalInformationRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Optional<LegalInformation> result = legalInformationService.getLegalInformationById(1L);

        // Assert
        assertFalse(result.isPresent(), "Legal information should not be present");
        verify(legalInformationRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveLegalInformation() {
        // Arrange
        LegalInformation info = new LegalInformation();
        info.setId(1L);

        when(legalInformationRepository.save(info)).thenReturn(info);

        // Act
        LegalInformation result = legalInformationService.saveLegalInformation(info);

        // Assert
        assertNotNull(result, "Saved legal information should not be null");
        assertEquals(1L, result.getId(), "ID should match the saved value");
        verify(legalInformationRepository, times(1)).save(info);
    }

    @Test
    void testDeleteLegalInformation() {
        // Arrange
        Long id = 1L;
        doNothing().when(legalInformationRepository).deleteById(id);

        // Act
        legalInformationService.deleteLegalInformation(id);

        // Assert
        verify(legalInformationRepository, times(1)).deleteById(id);
    }
}
