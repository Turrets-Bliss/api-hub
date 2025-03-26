package com.example.Spring_app.controller;

import com.example.Spring_app.dto.PropertyRequest;
import com.example.Spring_app.entity.PropertyDetails;
import com.example.Spring_app.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    // Create a new user (takes userId as input)
    @PostMapping("/user")
    public String createUser(@RequestParam UUID userId) {
        return propertyService.createUser(userId);
    }

    @DeleteMapping("/user")
    public String deleteUser(@RequestParam UUID userId) {
        return propertyService.deleteUser(userId);
    }

    // ✅ NEW: Public endpoint to fetch all properties (No input required)
    @GetMapping("/catalog")
    public ResponseEntity<List<PropertyDetails>> getAllPropertiesForLandingPage(@RequestParam UUID userId) {
        return ResponseEntity.ok(propertyService.getAllProperties(userId));
    }

    // Create a new property for a user
    @PostMapping("/create")
    public ResponseEntity<String> createProperty(
            @RequestParam UUID userId,
            @RequestBody PropertyRequest request) {
        return ResponseEntity.ok(propertyService.createProperty(userId, request));
    }

    // Get details of a specific property
    @GetMapping("/property")
    public ResponseEntity<PropertyRequest> getProperty(
            @RequestParam UUID userId,
            @RequestParam Long propertyId) {
        return ResponseEntity.ok(propertyService.getProperty(userId, propertyId));
    }

    // Get all properties for a specific user
    @GetMapping("/userproperty")
    public ResponseEntity<List<PropertyDetails>> getAllProperties(@RequestParam UUID userId) {
        return ResponseEntity.ok(propertyService.getAllProperties(userId));
    }

    // Update a property
    @PutMapping("/update")
    public ResponseEntity<String> updateProperty(
            @RequestParam UUID userId,
            @RequestParam Long propertyId,
            @RequestBody PropertyRequest request) {
        return ResponseEntity.ok(propertyService.updateProperty(propertyId, userId, request));
    }

    // Delete a property
    @DeleteMapping("/remove")
    public ResponseEntity<String> deleteProperty(
            @RequestParam UUID userId,
            @RequestParam Long propertyId) {
        return ResponseEntity.ok(propertyService.deleteProperty(userId, propertyId));
    }
}
