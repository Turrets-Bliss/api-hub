package com.example.Spring_app;

import com.example.Spring_app.entity.PricingDetails;
import com.example.Spring_app.entity.PropertyDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PricingDetailsTest {

    private PricingDetails pricingDetails;

    @BeforeEach
    void setUp() {
        pricingDetails = new PricingDetails();
    }

    @Test
    void testIdSetterAndGetter() {
        pricingDetails.setId(1L);
        assertEquals(1L, pricingDetails.getId());
    }

    @Test
    void testPropertySetterAndGetter() {
        PropertyDetails property = new PropertyDetails();
        pricingDetails.setProperty(property);
        assertEquals(property, pricingDetails.getProperty());
    }

    @Test
    void testAfterPriceLabelSetterAndGetter() {
        pricingDetails.setAfterPriceLabel("Discounted");
        assertEquals("Discounted", pricingDetails.getAfterPriceLabel());
    }

    @Test
    void testBeforePriceLabelSetterAndGetter() {
        pricingDetails.setBeforePriceLabel("Original");
        assertEquals("Original", pricingDetails.getBeforePriceLabel());
    }

    @Test
    void testPriceSetterAndGetter() {
        pricingDetails.setPrice(500000);
        assertEquals(500000, pricingDetails.getPrice());
    }

    @Test
    void testHomeOwnersAssociationFeeSetterAndGetter() {
        pricingDetails.setHomeOwnersAssociationFee(200);
        assertEquals(200, pricingDetails.getHomeOwnersAssociationFee());
    }

    @Test
    void testTaxRateSetterAndGetter() {
        BigDecimal taxRate = new BigDecimal("0.08");
        pricingDetails.setTaxRate(taxRate);
        assertEquals(taxRate, pricingDetails.getTaxRate());
    }

    // Edge Case Tests

    @Test
    void testNullValues() {
        pricingDetails.setAfterPriceLabel(null);
        pricingDetails.setBeforePriceLabel(null);
        pricingDetails.setTaxRate(null);

        assertNull(pricingDetails.getAfterPriceLabel());
        assertNull(pricingDetails.getBeforePriceLabel());
        assertNull(pricingDetails.getTaxRate());
    }

    @Test
    void testNegativeValues() {
        pricingDetails.setPrice(-100);
        pricingDetails.setHomeOwnersAssociationFee(-50);
        pricingDetails.setTaxRate(new BigDecimal("-0.05"));

        assertEquals(-100, pricingDetails.getPrice());
        assertEquals(-50, pricingDetails.getHomeOwnersAssociationFee());
        assertEquals(new BigDecimal("-0.05"), pricingDetails.getTaxRate());
    }

    @Test
    void testLargeValues() {
        BigDecimal largeTaxRate = new BigDecimal("9999999999.9999");
        pricingDetails.setPrice(Integer.MAX_VALUE);
        pricingDetails.setHomeOwnersAssociationFee(Integer.MAX_VALUE);
        pricingDetails.setTaxRate(largeTaxRate);

        assertEquals(Integer.MAX_VALUE, pricingDetails.getPrice());
        assertEquals(Integer.MAX_VALUE, pricingDetails.getHomeOwnersAssociationFee());
        assertEquals(largeTaxRate, pricingDetails.getTaxRate());
    }

    @Test
    void testEmptyStrings() {
        pricingDetails.setAfterPriceLabel("");
        pricingDetails.setBeforePriceLabel("");

        assertEquals("", pricingDetails.getAfterPriceLabel());
        assertEquals("", pricingDetails.getBeforePriceLabel());
    }
}
