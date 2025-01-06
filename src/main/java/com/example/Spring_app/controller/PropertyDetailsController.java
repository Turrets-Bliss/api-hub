package com.example.Spring_app.controller;

import com.example.Spring_app.entity.PropertyDetails;
import com.example.Spring_app.service.PropertyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyDetailsController {
    @Autowired
    private PropertyDetailsService propertyDetailsService;

    @PostMapping
    public ResponseEntity<PropertyDetails> createProperty(@RequestBody PropertyDetails propertyDetails) {
        return ResponseEntity.ok(propertyDetailsService.createProperty(propertyDetails));
    }

    @GetMapping
    public ResponseEntity<List<PropertyDetails>> getAllProperties() {
        return ResponseEntity.ok(propertyDetailsService.getAllProperties());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyDetails> getPropertyById(@PathVariable Long id) {
        return ResponseEntity.ok(propertyDetailsService.getPropertyById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyDetails> updateProperty(@PathVariable Long id, @RequestBody PropertyDetails propertyDetails) {
        return ResponseEntity.ok(propertyDetailsService.updateProperty(id, propertyDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        propertyDetailsService.deleteProperty(id);
        return ResponseEntity.noContent().build();
    }
}
