package com.example.Spring_app;


import com.example.Spring_app.dto.PropertyRequest;
import com.example.Spring_app.entity.AdditionalData;
import com.example.Spring_app.entity.Amenities;
import com.example.Spring_app.entity.PricingDetails;
import com.example.Spring_app.entity.PropertyDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PropertyRequestTest {

    private PropertyRequest propertyRequest;

    @BeforeEach
    void setUp() {
        propertyRequest = new PropertyRequest();
    }

    @Test
    void testPropertyDetailsGetterSetter() {
        PropertyDetails propertyDetails = new PropertyDetails();
        propertyRequest.setPropertyDetails(propertyDetails);
        assertEquals(propertyDetails, propertyRequest.getPropertyDetails());
    }

    @Test
    void testAdditionalDataGetterSetter() {
        AdditionalData additionalData = new AdditionalData();
        propertyRequest.setAdditionalData(additionalData);
        assertEquals(additionalData, propertyRequest.getAdditionalData());
    }

    @Test
    void testPricingDetailsGetterSetter() {
        PricingDetails pricingDetails = new PricingDetails();
        propertyRequest.setPricingDetails(pricingDetails);
        assertEquals(pricingDetails, propertyRequest.getPricingDetails());
    }

    @Test
    void testAmenitiesGetterSetter() {
        Amenities amenities = new Amenities();
        propertyRequest.setAmenities(amenities);
        assertEquals(amenities, propertyRequest.getAmenities());
    }

    // Edge Cases

    @Test
    void testNullValues() {
        propertyRequest.setPropertyDetails(null);
        propertyRequest.setAdditionalData(null);
        propertyRequest.setPricingDetails(null);
        propertyRequest.setAmenities(null);

        assertNull(propertyRequest.getPropertyDetails());
        assertNull(propertyRequest.getAdditionalData());
        assertNull(propertyRequest.getPricingDetails());
        assertNull(propertyRequest.getAmenities());
    }

    @Test
    void testEmptyObjectsAssignment() {
        propertyRequest.setPropertyDetails(new PropertyDetails());
        propertyRequest.setAdditionalData(new AdditionalData());
        propertyRequest.setPricingDetails(new PricingDetails());
        propertyRequest.setAmenities(new Amenities());

        assertNotNull(propertyRequest.getPropertyDetails());
        assertNotNull(propertyRequest.getAdditionalData());
        assertNotNull(propertyRequest.getPricingDetails());
        assertNotNull(propertyRequest.getAmenities());
    }


}
