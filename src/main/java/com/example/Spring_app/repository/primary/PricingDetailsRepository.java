package com.example.Spring_app.repository.primary;

import com.example.Spring_app.entity.PricingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingDetailsRepository extends JpaRepository<PricingDetails, Long> {
    @Query("SELECT p FROM PricingDetails p WHERE p.property.id = :propertyId")
    PricingDetails findByPropertyId(@Param("propertyId") Long propertyId);
}
