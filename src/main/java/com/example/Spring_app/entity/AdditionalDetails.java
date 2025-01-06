package com.example.Spring_app.entity;

import jakarta.persistence.*;

@Entity
public class AdditionalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "furnished_status") // Mapping to snake_case column name
    private String furnishedStatus;

    @Column(name = "green_rating") // Mapping to snake_case column name
    private String greenRating;

    @Column(name = "pet_friendly") // Mapping to snake_case column name
    private Boolean petFriendly;

    @Column(name = "car_parking") // Mapping to snake_case column name
    private String carParking;

    @Column(name = "total_car_parking_spaces") // Mapping to snake_case column name
    private Integer totalCarParkingSpaces;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFurnishedStatus() {
        return furnishedStatus;
    }

    public void setFurnishedStatus(String furnishedStatus) {
        this.furnishedStatus = furnishedStatus;
    }

    public String getGreenRating() {
        return greenRating;
    }

    public void setGreenRating(String greenRating) {
        this.greenRating = greenRating;
    }

    public Boolean getPetFriendly() {
        return petFriendly;
    }

    public void setPetFriendly(Boolean petFriendly) {
        this.petFriendly = petFriendly;
    }

    public String getCarParking() {
        return carParking;
    }

    public void setCarParking(String carParking) {
        this.carParking = carParking;
    }

    public Integer getTotalCarParkingSpaces() {
        return totalCarParkingSpaces;
    }

    public void setTotalCarParkingSpaces(Integer totalCarParkingSpaces) {
        this.totalCarParkingSpaces = totalCarParkingSpaces;
    }
}