package com.example.Spring_app.repository;

import com.example.Spring_app.entity.AdditionalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalDetailsRepository extends JpaRepository<AdditionalDetails, Long> {
}