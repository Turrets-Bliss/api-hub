package com.example.Spring_app;

import com.example.Spring_app.entity.Amenities;
import com.example.Spring_app.entity.PropertyDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AmenitiesTest {

    private Amenities amenities;
    private PropertyDetails propertyDetails;

    @BeforeEach
    void setUp() {
        amenities = new Amenities();
        propertyDetails = new PropertyDetails();
    }

    @Test
    void testIdGetterAndSetter() {
        amenities.setId(1L);
        assertEquals(1L, amenities.getId());
    }

    @Test
    void testPropertyGetterAndSetter() {
        amenities.setProperty(propertyDetails);
        assertEquals(propertyDetails, amenities.getProperty());
    }

    @Test
    void testBooleanFieldsDefaultToNull() {
        assertNull(amenities.getPool());
        assertNull(amenities.getGym());
        assertNull(amenities.getFireplace());
        assertNull(amenities.getEquippedKitchen());
    }

    @Test
    void testSettingAllFieldsToTrue() {
        amenities.setPool(true);
        amenities.setGym(true);
        amenities.setFireplace(true);
        amenities.setEquippedKitchen(true);
        amenities.setLaundry(true);
        amenities.setMediaRoom(true);
        amenities.setHotBath(true);
        amenities.setBasketballCourt(true);
        amenities.setBackYard(true);
        amenities.setFrontYard(true);
        amenities.setGarageAttached(true);
        amenities.setHeating(true);
        amenities.setWater(true);
        amenities.setElectricity(true);
        amenities.setVentilation(true);
        amenities.setCentralAir(true);
        amenities.setNaturalGas(true);
        amenities.setElevator(true);
        amenities.setChairAccessible(true);
        amenities.setWifi(true);
        amenities.setWasherAndDryer(true);
        amenities.setSmokeDetectors(true);

        assertTrue(amenities.getPool());
        assertTrue(amenities.getGym());
        assertTrue(amenities.getFireplace());
        assertTrue(amenities.getEquippedKitchen());
        assertTrue(amenities.getLaundry());
        assertTrue(amenities.getMediaRoom());
        assertTrue(amenities.getHotBath());
        assertTrue(amenities.getBasketballCourt());
        assertTrue(amenities.getBackYard());
        assertTrue(amenities.getFrontYard());
        assertTrue(amenities.getGarageAttached());
        assertTrue(amenities.getHeating());
        assertTrue(amenities.getWater());
        assertTrue(amenities.getElectricity());
        assertTrue(amenities.getVentilation());
        assertTrue(amenities.getCentralAir());
        assertTrue(amenities.getNaturalGas());
        assertTrue(amenities.getElevator());
        assertTrue(amenities.getChairAccessible());
        assertTrue(amenities.getWifi());
        assertTrue(amenities.getWasherAndDryer());
        assertTrue(amenities.getSmokeDetectors());
    }

    @Test
    void testSettingAllFieldsToFalse() {
        amenities.setPool(false);
        amenities.setGym(false);
        amenities.setFireplace(false);
        amenities.setEquippedKitchen(false);
        amenities.setLaundry(false);
        amenities.setMediaRoom(false);
        amenities.setHotBath(false);
        amenities.setBasketballCourt(false);
        amenities.setBackYard(false);
        amenities.setFrontYard(false);
        amenities.setGarageAttached(false);
        amenities.setHeating(false);
        amenities.setWater(false);
        amenities.setElectricity(false);
        amenities.setVentilation(false);
        amenities.setCentralAir(false);
        amenities.setNaturalGas(false);
        amenities.setElevator(false);
        amenities.setChairAccessible(false);
        amenities.setWifi(false);
        amenities.setWasherAndDryer(false);
        amenities.setSmokeDetectors(false);

        assertFalse(amenities.getPool());
        assertFalse(amenities.getGym());
        assertFalse(amenities.getFireplace());
        assertFalse(amenities.getEquippedKitchen());
        assertFalse(amenities.getLaundry());
        assertFalse(amenities.getMediaRoom());
        assertFalse(amenities.getHotBath());
        assertFalse(amenities.getBasketballCourt());
        assertFalse(amenities.getBackYard());
        assertFalse(amenities.getFrontYard());
        assertFalse(amenities.getGarageAttached());
        assertFalse(amenities.getHeating());
        assertFalse(amenities.getWater());
        assertFalse(amenities.getElectricity());
        assertFalse(amenities.getVentilation());
        assertFalse(amenities.getCentralAir());
        assertFalse(amenities.getNaturalGas());
        assertFalse(amenities.getElevator());
        assertFalse(amenities.getChairAccessible());
        assertFalse(amenities.getWifi());
        assertFalse(amenities.getWasherAndDryer());
        assertFalse(amenities.getSmokeDetectors());
    }

    @Test
    void testEdgeCaseMixOfTrueAndFalse() {
        amenities.setPool(true);
        amenities.setGym(false);
        amenities.setFireplace(true);
        amenities.setEquippedKitchen(false);

        assertTrue(amenities.getPool());
        assertFalse(amenities.getGym());
        assertTrue(amenities.getFireplace());
        assertFalse(amenities.getEquippedKitchen());
    }

    @Test
    void testNullPropertyHandling() {
        amenities.setProperty(null);
        assertNull(amenities.getProperty());
    }
}
