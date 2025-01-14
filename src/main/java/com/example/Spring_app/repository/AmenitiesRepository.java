package com.example.Spring_app.repository;

import com.example.Spring_app.entity.Amenities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AmenitiesRepository extends JpaRepository<Amenities, Long> {
    @Query("SELECT a FROM Amenities a WHERE a.property.id = :propertyId")
    Amenities findByPropertyId(@Param("propertyId") Long propertyId);
}
