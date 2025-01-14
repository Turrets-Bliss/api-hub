package com.example.Spring_app.controller;

import com.example.Spring_app.dto.PropertyRequest;
import com.example.Spring_app.service.PropertyService;
import com.example.Spring_app.entity.PropertyDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public String createProperty(@RequestBody PropertyRequest request) {
        return propertyService.createProperty(request);
    }

    @GetMapping("/{id}")
    public PropertyRequest getProperty(@PathVariable Long id) {
        return propertyService.getProperty(id);
    }

    @GetMapping
    public List<PropertyDetails> getAllProperties() {
        return propertyService.getAllProperties();
    }

    @PutMapping("/{id}")
    public String updateProperty(@PathVariable Long id, @RequestBody PropertyRequest request) {
        return propertyService.updateProperty(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteProperty(@PathVariable Long id) {
        return propertyService.deleteProperty(id);
    }
}
