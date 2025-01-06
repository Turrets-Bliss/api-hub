package com.example.Spring_app.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "PropertyDetails") // Maps to your table name
public class PropertyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "property_type", length = 100)
    private String propertyType;

    @Column(name = "developer", length = 100)
    private String developer;

    @Column(name = "total_towers")
    private Integer totalTowers;

    @Column(name = "total_units")
    private Integer totalUnits;

    @Column(name = "total_floors")
    private Integer totalFloors;

    @Column(name = "possession_date")
    private LocalDate possessionDate;

    @OneToMany(mappedBy = "propertyDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<UnitVariants> unitVariants = new ArrayList<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Integer getTotalTowers() {
        return totalTowers;
    }

    public void setTotalTowers(Integer totalTowers) {
        this.totalTowers = totalTowers;
    }

    public Integer getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(Integer totalUnits) {
        this.totalUnits = totalUnits;
    }

    public Integer getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(Integer totalFloors) {
        this.totalFloors = totalFloors;
    }

    public LocalDate getPossessionDate() {
        return possessionDate;
    }

    public void setPossessionDate(LocalDate possessionDate) {
        this.possessionDate = possessionDate;
    }

    public List<UnitVariants> getUnitVariants() {
        return unitVariants;
    }

    public void setUnitVariants(List<UnitVariants> unitVariants) {
        this.unitVariants = unitVariants;
    }
}