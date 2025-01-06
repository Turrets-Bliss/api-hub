package com.example.Spring_app.service;

import com.example.Spring_app.entity.PropertyDetails;
import com.example.Spring_app.repository.PropertyDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyDetailsService {
    @Autowired
    private PropertyDetailsRepository propertyDetailsRepository;

    public PropertyDetails createProperty(PropertyDetails propertyDetails) {
        return propertyDetailsRepository.save(propertyDetails);
    }

    public List<PropertyDetails> getAllProperties() {
        return propertyDetailsRepository.findAll();
    }

    public PropertyDetails getPropertyById(Long id) {
        return propertyDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));
    }

    public PropertyDetails updateProperty(Long id, PropertyDetails updatedDetails) {
        PropertyDetails existingProperty = getPropertyById(id);
        existingProperty.setDeveloper(updatedDetails.getDeveloper());
        existingProperty.setTotalTowers(updatedDetails.getTotalTowers());
        // Set other fields...
        return propertyDetailsRepository.save(existingProperty);
    }

    public void deleteProperty(Long id) {
        propertyDetailsRepository.deleteById(id);
    }
}

