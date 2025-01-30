package com.example.Spring_app.repository.primary;

import com.example.Spring_app.entity.PropertyDetails;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyDetailsRepository extends JpaRepository<PropertyDetails, Long> {

    @EntityGraph(attributePaths = {"additionalData", "pricingDetails", "amenities"})
    List<PropertyDetails> findAll();
}
