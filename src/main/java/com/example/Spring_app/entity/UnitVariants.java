package com.example.Spring_app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "UnitVariants") // Maps to your table name
public class UnitVariants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_details_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private PropertyDetails propertyDetails;

    @Column(name = "unit_type", length = 50)
    private String unitType;

    @Column(name = "size_sq_ft")
    private Integer sizeSqFt;

    @Column(name = "price", precision = 15, scale = 2)
    private BigDecimal price;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PropertyDetails getPropertyDetails() {
        return propertyDetails;
    }

    public void setPropertyDetails(PropertyDetails propertyDetails) {
        this.propertyDetails = propertyDetails;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public Integer getSizeSqFt() {
        return sizeSqFt;
    }

    public void setSizeSqFt(Integer sizeSqFt) {
        this.sizeSqFt = sizeSqFt;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}