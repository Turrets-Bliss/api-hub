package com.example.Spring_app.repository;

import com.example.Spring_app.entity.PaymentPlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentPlansRepository extends JpaRepository<PaymentPlans, Long> {
}
