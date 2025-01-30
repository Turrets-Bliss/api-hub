package com.example.Spring_app.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Investment")
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // This might not exist in the schema but can be ignored if not mapped

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "year_of_investment", nullable = false)
    private Integer yearOfInvestment;

    @Column(name = "property_id", nullable = false)
    private Integer propertyId;

    @Column(name = "current_market_value", nullable = false)
    private BigDecimal currentMarketValue;

    @Column(name = "current_investments", nullable = false)
    private BigDecimal currentInvestments;

    @Column(name = "roi", nullable = false)
    private BigDecimal roi;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getYearOfInvestment() {
        return yearOfInvestment;
    }

    public void setYearOfInvestment(Integer yearOfInvestment) {
        this.yearOfInvestment = yearOfInvestment;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public BigDecimal getCurrentMarketValue() {
        return currentMarketValue;
    }

    public void setCurrentMarketValue(BigDecimal currentMarketValue) {
        this.currentMarketValue = currentMarketValue;
    }

    public BigDecimal getCurrentInvestments() {
        return currentInvestments;
    }

    public void setCurrentInvestments(BigDecimal currentInvestments) {
        this.currentInvestments = currentInvestments;
    }

    public BigDecimal getRoi() {
        return roi;
    }

    public void setRoi(BigDecimal roi) {
        this.roi = roi;
    }
}
