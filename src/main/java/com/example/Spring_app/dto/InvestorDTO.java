package com.example.Spring_app.dto;

import java.math.BigDecimal;

public class InvestorDTO {
    private Long userId;                 // Unique identifier for the user
    private Integer yearOfInvestment;    // Year of the investment
    private Integer propertyId;          // Property ID associated with the investment
    private BigDecimal currentMarketValue; // Current market value
    private BigDecimal currentInvestments; // Current investments
    private BigDecimal roi;              // Return on investment

    // Getter and Setter for userId
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Getter and Setter for yearOfInvestment
    public Integer getYearOfInvestment() {
        return yearOfInvestment;
    }

    public void setYearOfInvestment(Integer yearOfInvestment) {
        this.yearOfInvestment = yearOfInvestment;
    }

    // Getter and Setter for propertyId
    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    // Getter and Setter for currentMarketValue
    public BigDecimal getCurrentMarketValue() {
        return currentMarketValue;
    }

    public void setCurrentMarketValue(BigDecimal currentMarketValue) {
        this.currentMarketValue = currentMarketValue;
    }

    // Getter and Setter for currentInvestments
    public BigDecimal getCurrentInvestments() {
        return currentInvestments;
    }

    public void setCurrentInvestments(BigDecimal currentInvestments) {
        this.currentInvestments = currentInvestments;
    }

    // Getter and Setter for roi
    public BigDecimal getRoi() {
        return roi;
    }

    public void setRoi(BigDecimal roi) {
        this.roi = roi;
    }
}
