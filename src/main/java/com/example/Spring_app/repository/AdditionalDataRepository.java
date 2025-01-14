package com.example.Spring_app.repository;

import com.example.Spring_app.entity.AdditionalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdditionalDataRepository extends JpaRepository<AdditionalData, Long> {
    @Query("SELECT a FROM AdditionalData a WHERE a.property.id = :propertyId")
    AdditionalData findByPropertyId(@Param("propertyId") Long propertyId);
}
