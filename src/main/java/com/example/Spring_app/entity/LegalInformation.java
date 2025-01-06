package com.example.Spring_app.entity;

import jakarta.persistence.*;

@Entity
public class LegalInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rera_number") // Mapping to snake_case column name
    private String reraNumber;

    private String approvals;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReraNumber() {
        return reraNumber;
    }

    public void setReraNumber(String reraNumber) {
        this.reraNumber = reraNumber;
    }

    public String getApprovals() {
        return approvals;
    }

    public void setApprovals(String approvals) {
        this.approvals = approvals;
    }
}
