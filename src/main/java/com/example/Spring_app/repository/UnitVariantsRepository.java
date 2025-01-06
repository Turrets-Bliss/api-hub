package com.example.Spring_app.repository;

import com.example.Spring_app.entity.UnitVariants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitVariantsRepository extends JpaRepository<UnitVariants, Long> {}
