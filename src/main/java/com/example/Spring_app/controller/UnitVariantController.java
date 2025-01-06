package com.example.Spring_app.controller;

import com.example.Spring_app.entity.UnitVariants;
import com.example.Spring_app.service.UnitVariantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/unit-variants")
public class UnitVariantController {

    @Autowired
    private UnitVariantsService unitVariantService;

    // Create a new UnitVariant
    @PostMapping
    public ResponseEntity<UnitVariants> createUnitVariant(@RequestBody UnitVariants unitVariant) {
        UnitVariants savedUnitVariant = unitVariantService.saveUnitVariant(unitVariant);
        return ResponseEntity.ok(savedUnitVariant);
    }

    // Get all UnitVariants
    @GetMapping
    public ResponseEntity<List<UnitVariants>> getAllUnitVariants() {
        List<UnitVariants> unitVariants = unitVariantService.getAllUnitVariants();
        return ResponseEntity.ok(unitVariants);
    }

    // Get a UnitVariant by ID
    @GetMapping("/{id}")
    public ResponseEntity<UnitVariants> getUnitVariantById(@PathVariable Long id) {
        Optional<UnitVariants> unitVariant = unitVariantService.getUnitVariantById(id);
        return unitVariant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a UnitVariant
    @PutMapping("/{id}")
    public ResponseEntity<UnitVariants> updateUnitVariant(@PathVariable Long id, @RequestBody UnitVariants unitVariant) {
        UnitVariants updatedUnitVariant = unitVariantService.updateUnitVariant(id, unitVariant);
        return updatedUnitVariant != null ? ResponseEntity.ok(updatedUnitVariant) : ResponseEntity.notFound().build();
    }

    // Delete a UnitVariant by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnitVariant(@PathVariable Long id) {
        unitVariantService.deleteUnitVariant(id);
        return ResponseEntity.noContent().build();
    }
}
