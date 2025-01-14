package com.example.Spring_app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Amenities")
public class Amenities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    @JsonBackReference
    private PropertyDetails property;

    @Column(name = "pool")
    private Boolean pool;

    @Column(name = "gym")
    private Boolean gym;

    @Column(name = "fireplace")
    private Boolean fireplace;

    @Column(name = "equipped_kitchen")
    private Boolean equippedKitchen;

    @Column(name = "laundry")
    private Boolean laundry;

    @Column(name = "media_room")
    private Boolean mediaRoom;

    @Column(name = "hot_bath")
    private Boolean hotBath;

    @Column(name = "basketball_court")
    private Boolean basketballCourt;

    @Column(name = "back_yard")
    private Boolean backYard;

    @Column(name = "front_yard")
    private Boolean frontYard;

    @Column(name = "garage_attached")
    private Boolean garageAttached;

    @Column(name = "heating")
    private Boolean heating;

    @Column(name = "water")
    private Boolean water;

    @Column(name = "electricity")
    private Boolean electricity;

    @Column(name = "ventilation")
    private Boolean ventilation;

    @Column(name = "central_air")
    private Boolean centralAir;

    @Column(name = "natural_gas")
    private Boolean naturalGas;

    @Column(name = "elevator")
    private Boolean elevator;

    @Column(name = "chair_accessible")
    private Boolean chairAccessible;

    @Column(name = "wifi")
    private Boolean wifi;

    @Column(name = "washer_and_dryer")
    private Boolean washerAndDryer;

    @Column(name = "smoke_detectors")
    private Boolean smokeDetectors;

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

    public Boolean getPool() {
        return pool;
    }

    public void setPool(Boolean pool) {
        this.pool = pool;
    }

    public Boolean getGym() {
        return gym;
    }

    public void setGym(Boolean gym) {
        this.gym = gym;
    }

    public Boolean getFireplace() {
        return fireplace;
    }

    public void setFireplace(Boolean fireplace) {
        this.fireplace = fireplace;
    }

    public Boolean getEquippedKitchen() {
        return equippedKitchen;
    }

    public void setEquippedKitchen(Boolean equippedKitchen) {
        this.equippedKitchen = equippedKitchen;
    }

    public Boolean getLaundry() {
        return laundry;
    }

    public void setLaundry(Boolean laundry) {
        this.laundry = laundry;
    }

    public Boolean getMediaRoom() {
        return mediaRoom;
    }

    public void setMediaRoom(Boolean mediaRoom) {
        this.mediaRoom = mediaRoom;
    }

    public Boolean getHotBath() {
        return hotBath;
    }

    public void setHotBath(Boolean hotBath) {
        this.hotBath = hotBath;
    }

    public Boolean getBasketballCourt() {
        return basketballCourt;
    }

    public void setBasketballCourt(Boolean basketballCourt) {
        this.basketballCourt = basketballCourt;
    }

    public Boolean getBackYard() {
        return backYard;
    }

    public void setBackYard(Boolean backYard) {
        this.backYard = backYard;
    }

    public Boolean getFrontYard() {
        return frontYard;
    }

    public void setFrontYard(Boolean frontYard) {
        this.frontYard = frontYard;
    }

    public Boolean getGarageAttached() {
        return garageAttached;
    }

    public void setGarageAttached(Boolean garageAttached) {
        this.garageAttached = garageAttached;
    }

    public Boolean getHeating() {
        return heating;
    }

    public void setHeating(Boolean heating) {
        this.heating = heating;
    }

    public Boolean getWater() {
        return water;
    }

    public void setWater(Boolean water) {
        this.water = water;
    }

    public Boolean getElectricity() {
        return electricity;
    }

    public void setElectricity(Boolean electricity) {
        this.electricity = electricity;
    }

    public Boolean getVentilation() {
        return ventilation;
    }

    public void setVentilation(Boolean ventilation) {
        this.ventilation = ventilation;
    }

    public Boolean getCentralAir() {
        return centralAir;
    }

    public void setCentralAir(Boolean centralAir) {
        this.centralAir = centralAir;
    }

    public Boolean getNaturalGas() {
        return naturalGas;
    }

    public void setNaturalGas(Boolean naturalGas) {
        this.naturalGas = naturalGas;
    }

    public Boolean getElevator() {
        return elevator;
    }

    public void setElevator(Boolean elevator) {
        this.elevator = elevator;
    }

    public Boolean getChairAccessible() {
        return chairAccessible;
    }

    public void setChairAccessible(Boolean chairAccessible) {
        this.chairAccessible = chairAccessible;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getWasherAndDryer() {
        return washerAndDryer;
    }

    public void setWasherAndDryer(Boolean washerAndDryer) {
        this.washerAndDryer = washerAndDryer;
    }

    public Boolean getSmokeDetectors() {
        return smokeDetectors;
    }

    public void setSmokeDetectors(Boolean smokeDetectors) {
        this.smokeDetectors = smokeDetectors;
    }
}
