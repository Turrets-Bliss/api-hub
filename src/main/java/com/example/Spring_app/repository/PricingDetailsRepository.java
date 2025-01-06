package com.example.Spring_app.repository;

import com.example.Spring_app.entity.PricingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingDetailsRepository extends JpaRepository<PricingDetails, Long> {
}