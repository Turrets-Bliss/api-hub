package com.example.Spring_app.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PricingDetails")
public class PricingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "base_price_per_sq_ft")
    private BigDecimal basePricePerSqFt;

    @Column(name = "maintenance_charges_per_month")
    private BigDecimal maintenanceChargesPerMonth;

    @Column(name = "booking_amount")
    private BigDecimal bookingAmount;

    // One-to-Many relationship with PaymentPlans
    @OneToMany(mappedBy = "pricingDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PaymentPlans> paymentPlans;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBasePricePerSqFt() {
        return basePricePerSqFt;
    }

    public void setBasePricePerSqFt(BigDecimal basePricePerSqFt) {
        this.basePricePerSqFt = basePricePerSqFt;
    }

    public BigDecimal getMaintenanceChargesPerMonth() {
        return maintenanceChargesPerMonth;
    }

    public void setMaintenanceChargesPerMonth(BigDecimal maintenanceChargesPerMonth) {
        this.maintenanceChargesPerMonth = maintenanceChargesPerMonth;
    }

    public BigDecimal getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(BigDecimal bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public List<PaymentPlans> getPaymentPlans() {
        return paymentPlans;
    }

    public void setPaymentPlans(List<PaymentPlans> paymentPlans) {
        this.paymentPlans = paymentPlans;
    }
}