package com.example.Spring_app;

import com.example.Spring_app.entity.PropertyDetails;

import com.example.Spring_app.entity.PricingDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;

class PropertyDetailsTest {

    private PropertyDetails property;

    @BeforeEach
    void setUp() {
        property = new PropertyDetails();
    }

    @Test
    void testSetAndGetPropertyTitle() {
        property.setPropertyTitle("Luxury Villa");
        assertEquals("Luxury Villa", property.getPropertyTitle());
    }

    @Test
    void testSetAndGetLotSize() {
        property.setLotSize(new BigDecimal("5000"));
        assertEquals(new BigDecimal("5000"), property.getLotSize());
    }

    @Test
    void testSetAndGetNegativeLotSize() {
        property.setLotSize(new BigDecimal("-100"));
        assertEquals(new BigDecimal("-100"), property.getLotSize());
    }

    @Test
    void testSetAndGetNullLotSize() {
        property.setLotSize(null);
        assertNull(property.getLotSize());
    }

    @Test
    void testSetAndGetAvailableFrom() {
        Date date = new Date();
        property.setAvailableFrom(date);
        assertEquals(date, property.getAvailableFrom());
    }

    @Test
    void testSetAndGetNegativeBedrooms() {
        property.setBedrooms(-1);
        assertEquals(-1, property.getBedrooms());
    }

    @Test
    void testSetAndGetNullBedrooms() {
        property.setBedrooms(null);
        assertNull(property.getBedrooms());
    }

    @Test
    void testSetAndGetStructureType() {
        property.setStructureType("Single Family");
        assertEquals("Single Family", property.getStructureType());
    }

    @Test
    void testSetAndGetNullStructureType() {
        property.setStructureType(null);
        assertNull(property.getStructureType());
    }

    @Test
    void testSetAndGetFloors() {
        property.setFloors(3);
        assertEquals(3, property.getFloors());
    }

    @Test
    void testSetAndGetNegativeFloors() {
        property.setFloors(-2);
        assertEquals(-2, property.getFloors());
    }

    @Test
    void testSetAndGetNullFloors() {
        property.setFloors(null);
        assertNull(property.getFloors());
    }

    @Test
    void testSetAndGetLatitudeLongitude() {
        property.setLatitude(new BigDecimal("45.12345"));
        property.setLongitude(new BigDecimal("-93.12345"));
        assertEquals(new BigDecimal("45.12345"), property.getLatitude());
        assertEquals(new BigDecimal("-93.12345"), property.getLongitude());
    }

    @Test
    void testSetAndGetNegativeLatitudeLongitude() {
        property.setLatitude(new BigDecimal("-90"));
        property.setLongitude(new BigDecimal("-180"));
        assertEquals(new BigDecimal("-90"), property.getLatitude());
        assertEquals(new BigDecimal("-180"), property.getLongitude());
    }

    @Test
    void testSetAndGetNullLatitudeLongitude() {
        property.setLatitude(null);
        property.setLongitude(null);
        assertNull(property.getLatitude());
        assertNull(property.getLongitude());
    }

}
