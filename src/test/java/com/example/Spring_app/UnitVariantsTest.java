package com.example.Spring_app;

import com.example.Spring_app.entity.PropertyDetails;
import com.example.Spring_app.entity.UnitVariants;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

class UnitVariantsTest {

    @Test
    void testUnitVariantsEntity() {
        // Create a new instance of PropertyDetails
        PropertyDetails propertyDetails = new PropertyDetails();
        propertyDetails.setId(1L);  // Mock PropertyDetails for the relationship

        // Create a new instance of UnitVariants
        UnitVariants unitVariant = new UnitVariants();

        // Set values using setters
        unitVariant.setId(1L);
        unitVariant.setUnitType("2BHK");
        unitVariant.setSizeSqFt(1200);
        unitVariant.setPrice(new BigDecimal("500000.00"));
        unitVariant.setPropertyDetails(propertyDetails); // Set the related PropertyDetails

        // Validate getters
        assertEquals(1L, unitVariant.getId(), "ID should match the set value");
        assertEquals("2BHK", unitVariant.getUnitType(), "Unit type should match the set value");
        assertEquals(1200, unitVariant.getSizeSqFt(), "Size should match the set value");
        assertEquals(new BigDecimal("500000.00"), unitVariant.getPrice(), "Price should match the set value");
        assertEquals(propertyDetails, unitVariant.getPropertyDetails(), "PropertyDetails should match the set value");
    }

    @Test
    void testUnitVariantsPricePrecision() {
        // Create a new instance of UnitVariants
        UnitVariants unitVariant = new UnitVariants();

        // Set values with scale of 2 and rounding mode
        BigDecimal price = new BigDecimal("123456789.123456").setScale(2, BigDecimal.ROUND_HALF_UP);
        unitVariant.setPrice(price);

        // Validate price precision (the scale should be 2, so rounding is expected)
        assertEquals(new BigDecimal("123456789.12"), unitVariant.getPrice(), "Price should round to 2 decimal places");
    }

}
