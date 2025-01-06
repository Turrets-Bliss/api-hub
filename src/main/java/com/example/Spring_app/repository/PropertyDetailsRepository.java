package com.example.Spring_app.repository;

import com.example.Spring_app.entity.PropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDetailsRepository extends JpaRepository<PropertyDetails, Long> {}
