package com.example.Spring_app.repository;

import com.example.Spring_app.entity.LegalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegalInformationRepository extends JpaRepository<LegalInformation, Long> {
}