package com.example.Spring_app.repository.primary;

import com.example.Spring_app.entity.PropertyDetails;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PropertyDetailsRepository extends JpaRepository<PropertyDetails, Long> {

    @EntityGraph(attributePaths = {"additionalData", "pricingDetails", "amenities"})
//    List<PropertyDetails> findAll();
    List<PropertyDetails> findByUserId(UUID userId);
    Optional<PropertyDetails> findByIdAndUserId(Long id, UUID userId);

}
