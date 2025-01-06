package com.example.Spring_app.controller;

import com.example.Spring_app.entity.PaymentPlans;
import com.example.Spring_app.repository.PaymentPlansRepository;
import com.example.Spring_app.service.PaymentPlansService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payment-plans")
public class PaymentPlansController {

    @Autowired
    private PaymentPlansRepository paymentPlansRepository;

    // Get all payment plans
    @GetMapping
    public List<PaymentPlans> getAllPaymentPlans() {
        return paymentPlansRepository.findAll();
    }

    // Get a payment plan by ID
    @GetMapping("/{id}")
    public ResponseEntity<PaymentPlans> getPaymentPlan(@PathVariable Long id) {
        Optional<PaymentPlans> paymentPlan = paymentPlansRepository.findById(id);
        return paymentPlan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create new payment plan
    @PostMapping
    public PaymentPlans createPaymentPlan(@RequestBody PaymentPlans paymentPlans) {
        return paymentPlansRepository.save(paymentPlans);
    }

    // Update existing payment plan
    @PutMapping("/{id}")
    public ResponseEntity<PaymentPlans> updatePaymentPlan(@PathVariable Long id, @RequestBody PaymentPlans paymentPlans) {
        if (!paymentPlansRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        paymentPlans.setId(id);
        PaymentPlans updatedPaymentPlan = paymentPlansRepository.save(paymentPlans);
        return ResponseEntity.ok(updatedPaymentPlan);
    }

    // Delete payment plan
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentPlan(@PathVariable Long id) {
        if (!paymentPlansRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        paymentPlansRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}