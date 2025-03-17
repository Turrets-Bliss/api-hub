package com.example.Spring_app.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")  // Match the table name exactly
public class User {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    // One-to-Many Relationship (One User → Many Properties)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PropertyDetails> properties;

    // Default constructor
    public User() {}

    // Getter and Setter for ID
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<PropertyDetails> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyDetails> properties) {
        this.properties = properties;
    }
}
