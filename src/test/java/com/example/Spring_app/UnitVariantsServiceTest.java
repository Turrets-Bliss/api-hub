package com.example.Spring_app;

import com.example.Spring_app.entity.UnitVariants;
import com.example.Spring_app.repository.UnitVariantsRepository;
import com.example.Spring_app.service.UnitVariantsService;
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
class UnitVariantsServiceTest {

    @Mock
    private UnitVariantsRepository repository;

    @InjectMocks
    private UnitVariantsService service;

    @Test
    void testSaveUnitVariant() {
        // Arrange
        UnitVariants unitVariant = new UnitVariants();
        unitVariant.setId(1L);


        when(repository.save(unitVariant)).thenReturn(unitVariant);

        // Act
        UnitVariants result = service.saveUnitVariant(unitVariant);

        // Assert
        assertNotNull(result, "The saved UnitVariant should not be null");
        assertEquals(1L, result.getId(), "ID should match");

        verify(repository, times(1)).save(unitVariant);
    }

    @Test
    void testGetAllUnitVariants() {
        // Arrange
        UnitVariants variant1 = new UnitVariants();
        variant1.setId(1L);


        UnitVariants variant2 = new UnitVariants();
        variant2.setId(2L);


        when(repository.findAll()).thenReturn(Arrays.asList(variant1, variant2));

        // Act
        List<UnitVariants> result = service.getAllUnitVariants();

        // Assert
        assertNotNull(result, "The result should not be null");
        assertEquals(2, result.size(), "There should be 2 UnitVariants");

        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetUnitVariantById_Found() {
        // Arrange
        UnitVariants unitVariant = new UnitVariants();
        unitVariant.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(unitVariant));

        // Act
        Optional<UnitVariants> result = service.getUnitVariantById(1L);

        // Assert
        assertTrue(result.isPresent(), "The result should not be empty");
        assertEquals(1L, result.get().getId(), "ID should match");

        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testGetUnitVariantById_NotFound() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Optional<UnitVariants> result = service.getUnitVariantById(1L);

        // Assert
        assertFalse(result.isPresent(), "The result should be empty");
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testUpdateUnitVariant_Exists() {
        // Arrange
        UnitVariants unitVariant = new UnitVariants();
        unitVariant.setId(1L);

        when(repository.existsById(1L)).thenReturn(true);
        when(repository.save(unitVariant)).thenReturn(unitVariant);

        // Act
        UnitVariants result = service.updateUnitVariant(1L, unitVariant);

        // Assert
        assertNotNull(result, "The updated UnitVariant should not be null");
        assertEquals(1L, result.getId(), "ID should match");

        verify(repository, times(1)).existsById(1L);
        verify(repository, times(1)).save(unitVariant);
    }

    @Test
    void testUpdateUnitVariant_NotExists() {
        // Arrange
        UnitVariants unitVariant = new UnitVariants();

        when(repository.existsById(1L)).thenReturn(false);

        // Act
        UnitVariants result = service.updateUnitVariant(1L, unitVariant);

        // Assert
        assertNull(result, "The result should be null when the UnitVariant does not exist");
        verify(repository, times(1)).existsById(1L);
        verify(repository, never()).save(unitVariant);
    }

    @Test
    void testDeleteUnitVariant() {
        // Arrange
        Long id = 1L;
        doNothing().when(repository).deleteById(id);

        // Act
        service.deleteUnitVariant(id);

        // Assert
        verify(repository, times(1)).deleteById(id);
    }
}
