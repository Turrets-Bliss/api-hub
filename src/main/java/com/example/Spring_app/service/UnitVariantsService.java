package com.example.Spring_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Spring_app.entity.UnitVariants;
import com.example.Spring_app.repository.UnitVariantsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UnitVariantsService {

    @Autowired
    private UnitVariantsRepository unitVariantsRepository;

    // Create a new UnitVariant
    public UnitVariants saveUnitVariant(UnitVariants unitVariant) {
        return unitVariantsRepository.save(unitVariant);
    }

    // Get all UnitVariants
    public List<UnitVariants> getAllUnitVariants() {
        return unitVariantsRepository.findAll();
    }

    // Get a UnitVariant by ID
    public Optional<UnitVariants> getUnitVariantById(Long id) {
        return unitVariantsRepository.findById(id);
    }

    // Update an existing UnitVariant
    public UnitVariants updateUnitVariant(Long id, UnitVariants unitVariant) {
        if (unitVariantsRepository.existsById(id)) {
            unitVariant.setId(id);
            return unitVariantsRepository.save(unitVariant);
        }
        return null;  // or throw an exception if needed
    }

    // Delete a UnitVariant by ID
    public void deleteUnitVariant(Long id) {
        unitVariantsRepository.deleteById(id);
    }
}
