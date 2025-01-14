package com.example.Spring_app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PricingDetails")
public class PricingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    @JsonBackReference
    private PropertyDetails property;

    @Column(name = "after_price_label")
    private String afterPriceLabel;

    @Column(name = "before_price_label")
    private String beforePriceLabel;

    @Column(name = "price")
    private Integer price;

    @Column(name = "home_owners_association_fee")
    private Integer homeOwnersAssociationFee;

    @Column(name = "tax_rate")
    private BigDecimal taxRate;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PropertyDetails getProperty() {
        return property;
    }

    public void setProperty(PropertyDetails property) {
        this.property = property;
    }

    public String getAfterPriceLabel() {
        return afterPriceLabel;
    }

    public void setAfterPriceLabel(String afterPriceLabel) {
        this.afterPriceLabel = afterPriceLabel;
    }

    public String getBeforePriceLabel() {
        return beforePriceLabel;
    }

    public void setBeforePriceLabel(String beforePriceLabel) {
        this.beforePriceLabel = beforePriceLabel;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getHomeOwnersAssociationFee() {
        return homeOwnersAssociationFee;
    }

    public void setHomeOwnersAssociationFee(Integer homeOwnersAssociationFee) {
        this.homeOwnersAssociationFee = homeOwnersAssociationFee;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
}
