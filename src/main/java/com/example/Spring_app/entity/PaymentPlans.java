package com.example.Spring_app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
@Table(name = "PaymentPlans")
public class PaymentPlans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pricing_details_id", nullable = false)
    @JsonBackReference
    private PricingDetails pricingDetails;

    @Column(name = "plan_type")
    private String planType;

    @Column(name = "description")
    private String description;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PricingDetails getPricingDetails() {
        return pricingDetails;
    }

    public void setPricingDetails(PricingDetails pricingDetails) {
        this.pricingDetails = pricingDetails;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}