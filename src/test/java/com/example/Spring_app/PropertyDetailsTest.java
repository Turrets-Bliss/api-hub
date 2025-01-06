package com.example.Spring_app;


import com.example.Spring_app.entity.PropertyDetails;

import com.example.Spring_app.entity.UnitVariants;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PropertyDetailsTest {


    // Create PropertyDetails instance with all valid fields and verify getters/setters
    @Test
    public void test_property_details_valid_fields() {
        PropertyDetails propertyDetails = new PropertyDetails();
    
        propertyDetails.setId(1L);
        propertyDetails.setPropertyType("Apartment");
        propertyDetails.setDeveloper("ABC Builders");
        propertyDetails.setTotalTowers(2);
        propertyDetails.setTotalUnits(100);
        propertyDetails.setTotalFloors(10);
        propertyDetails.setPossessionDate(LocalDate.of(2024, 12, 31));
    
        List<UnitVariants> units = new ArrayList<>();
        UnitVariants unit = new UnitVariants();
        unit.setUnitType("2BHK");
        units.add(unit);
        propertyDetails.setUnitVariants(units);

        assertEquals(Long.valueOf(1L), propertyDetails.getId());
        assertEquals("Apartment", propertyDetails.getPropertyType());
        assertEquals("ABC Builders", propertyDetails.getDeveloper());
        assertEquals(Integer.valueOf(2), propertyDetails.getTotalTowers());
        assertEquals(Integer.valueOf(100), propertyDetails.getTotalUnits());
        assertEquals(Integer.valueOf(10), propertyDetails.getTotalFloors());
        assertEquals(LocalDate.of(2024, 12, 31), propertyDetails.getPossessionDate());
        assertEquals(1, propertyDetails.getUnitVariants().size());
    }

    // Create PropertyDetails with null values for non-nullable fields
    @Test
    public void test_property_details_null_fields() {
        PropertyDetails propertyDetails = new PropertyDetails();
    
        propertyDetails.setId(null);
        propertyDetails.setPropertyType(null);
        propertyDetails.setDeveloper(null);
        propertyDetails.setTotalTowers(null);
        propertyDetails.setTotalUnits(null);
        propertyDetails.setTotalFloors(null);
        propertyDetails.setPossessionDate(null);
        propertyDetails.setUnitVariants(null);
    
        assertNull(propertyDetails.getId());
        assertNull(propertyDetails.getPropertyType());
        assertNull(propertyDetails.getDeveloper());
        assertNull(propertyDetails.getTotalTowers());
        assertNull(propertyDetails.getTotalUnits());
        assertNull(propertyDetails.getTotalFloors());
        assertNull(propertyDetails.getPossessionDate());
        assertNull(propertyDetails.getUnitVariants());
    }
}