package com.example.Spring_app;

import com.example.Spring_app.entity.PricingDetails;
import com.example.Spring_app.entity.PaymentPlans;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Arrays;

class PricingDetailsTest {

    @Test
    void testPricingDetailsEntity() {
        // Create a new instance of PricingDetails
        PricingDetails pricingDetails = new PricingDetails();

        // Set values using setters
        pricingDetails.setId(1L);
        pricingDetails.setBasePricePerSqFt(new BigDecimal("1500.00"));
        pricingDetails.setMaintenanceChargesPerMonth(new BigDecimal("200.00"));
        pricingDetails.setBookingAmount(new BigDecimal("5000.00"));

        // Create a list of PaymentPlans
        PaymentPlans paymentPlan1 = new PaymentPlans();
        paymentPlan1.setPlanType("Monthly Plan");
        paymentPlan1.setDescription("Pay monthly for the property");

        PaymentPlans paymentPlan2 = new PaymentPlans();
        paymentPlan2.setPlanType("Yearly Plan");
        paymentPlan2.setDescription("Pay yearly for the property");

        // Add payment plans to the pricing details
        pricingDetails.setPaymentPlans(Arrays.asList(paymentPlan1, paymentPlan2));

        // Validate getters
        assertEquals(1L, pricingDetails.getId(), "ID should match the set value");
        assertEquals(new BigDecimal("1500.00"), pricingDetails.getBasePricePerSqFt(), "Base price per sq ft should match the set value");
        assertEquals(new BigDecimal("200.00"), pricingDetails.getMaintenanceChargesPerMonth(), "Maintenance charges per month should match the set value");
        assertEquals(new BigDecimal("5000.00"), pricingDetails.getBookingAmount(), "Booking amount should match the set value");

        // Validate PaymentPlans
        assertNotNull(pricingDetails.getPaymentPlans(), "Payment plans should not be null");
        assertEquals(2, pricingDetails.getPaymentPlans().size(), "There should be 2 payment plans");

        PaymentPlans firstPlan = pricingDetails.getPaymentPlans().get(0);
        assertEquals("Monthly Plan", firstPlan.getPlanType(), "First payment plan type should be 'Monthly Plan'");
        assertEquals("Pay monthly for the property", firstPlan.getDescription(), "First payment plan description should match");

        PaymentPlans secondPlan = pricingDetails.getPaymentPlans().get(1);
        assertEquals("Yearly Plan", secondPlan.getPlanType(), "Second payment plan type should be 'Yearly Plan'");
        assertEquals("Pay yearly for the property", secondPlan.getDescription(), "Second payment plan description should match");
    }
}
