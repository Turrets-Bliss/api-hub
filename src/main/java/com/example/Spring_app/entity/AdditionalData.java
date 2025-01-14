package com.example.Spring_app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "AdditionalData")
public class AdditionalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    @JsonBackReference
    private PropertyDetails property;

    @Column(name = "video_link")
    private String videoLink;

    @Column(name = "video_from")
    private String videoFrom;

    @Column(name = "image_link")
    private String imageLink;

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

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getVideoFrom() {
        return videoFrom;
    }

    public void setVideoFrom(String videoFrom) {
        this.videoFrom = videoFrom;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
