package com.example.Spring_app.repository.primary;

import com.example.Spring_app.entity.AdditionalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalDataRepository extends JpaRepository<AdditionalData, Long> {
    @Query("SELECT a FROM AdditionalData a WHERE a.property.id = :propertyId")
    AdditionalData findByPropertyId(@Param("propertyId") Long propertyId);
}
