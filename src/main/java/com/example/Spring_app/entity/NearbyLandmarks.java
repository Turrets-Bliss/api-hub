package com.example.Spring_app.entity;

import jakarta.persistence.*;

@Entity
public class NearbyLandmarks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String school;
    private String hospital;

    @Column(name = "shopping_mall") // Mapping to snake_case column name
    private String shoppingMall;

    @Column(name = "metro_station") // Mapping to snake_case column name
    private String metroStation;

    private String airport;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getShoppingMall() {
        return shoppingMall;
    }

    public void setShoppingMall(String shoppingMall) {
        this.shoppingMall = shoppingMall;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public void setMetroStation(String metroStation) {
        this.metroStation = metroStation;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }
}