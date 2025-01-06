package com.example.Spring_app;

import com.example.Spring_app.entity.PaymentPlans;
import com.example.Spring_app.entity.PricingDetails;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentPlansTest {

    @Test
    void testPaymentPlansEntity() {
        // Create an instance of PricingDetails (since PaymentPlans has a relationship with it)
        PricingDetails pricingDetails = new PricingDetails();
        pricingDetails.setId(1L);

        // Create a new PaymentPlans instance
        PaymentPlans paymentPlan = new PaymentPlans();

        // Set values using setters
        paymentPlan.setPricingDetails(pricingDetails);
        paymentPlan.setPlanType("Annual Plan");
        paymentPlan.setDescription("This is a yearly subscription plan.");

        // Validate getters
        assertEquals(pricingDetails, paymentPlan.getPricingDetails(), "PricingDetails should match the set value");
        assertEquals("Annual Plan", paymentPlan.getPlanType(), "Plan type should match the set value");
        assertEquals("This is a yearly subscription plan.", paymentPlan.getDescription(), "Description should match the set value");

        // Validate ID (should be null initially)
        assertNull(paymentPlan.getId(), "ID should be null initially");

        // Test the ID setter and getter
        paymentPlan.setId(1L);
        assertEquals(1L, paymentPlan.getId(), "ID should match the set value");
    }
}
