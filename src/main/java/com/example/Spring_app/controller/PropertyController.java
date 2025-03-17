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

    // Create a new user
    // Create a new user (takes userId as input)
    @PostMapping("/user")
    public String createUser(@RequestBody UUID userId) {
        return propertyService.createUser(userId);
    }

    @DeleteMapping("/user/{userId}")
    public String deleteUser(@PathVariable UUID userId) {
        return propertyService.deleteUser(userId);
    }

    // Create a new property for a user
    @PostMapping("/{userId}")
    public ResponseEntity<String> createProperty(@PathVariable UUID userId, @RequestBody PropertyRequest request) {
        return ResponseEntity.ok(propertyService.createProperty(userId, request));
    }

    // Get details of a specific property
    @GetMapping("/{userId}/{propertyId}")
    public ResponseEntity<PropertyRequest> getProperty(@PathVariable UUID userId, @PathVariable Long propertyId) {
        return ResponseEntity.ok(propertyService.getProperty(userId, propertyId));
    }

    // Get all properties for a specific user
    @GetMapping("/{userId}")
    public ResponseEntity<List<PropertyDetails>> getAllProperties(@PathVariable UUID userId) {
        return ResponseEntity.ok(propertyService.getAllProperties(userId));
    }

    // Update a property
    @PutMapping("/{userId}/{propertyId}")
    public ResponseEntity<String> updateProperty(
            @PathVariable UUID userId,
            @PathVariable Long propertyId,
            @RequestBody PropertyRequest request) {
        return ResponseEntity.ok(propertyService.updateProperty(propertyId, userId, request));
    }

    // Delete a property
    @DeleteMapping("/{userId}/{propertyId}")
    public ResponseEntity<String> deleteProperty(@PathVariable UUID userId, @PathVariable Long propertyId) {
        return ResponseEntity.ok(propertyService.deleteProperty(userId, propertyId));
    }
}
