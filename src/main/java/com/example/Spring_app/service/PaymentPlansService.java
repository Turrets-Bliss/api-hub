package com.example.Spring_app.service;

import com.example.Spring_app.entity.PaymentPlans;
import com.example.Spring_app.repository.PaymentPlansRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PaymentPlansService {
    private final PaymentPlansRepository repository;

    public PaymentPlansService(PaymentPlansRepository repository) {
        this.repository = repository;
    }

    public List<PaymentPlans> getAllPaymentPlans() {
        return repository.findAll();
    }

    public PaymentPlans getPaymentPlanById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("PaymentPlan not found"));
    }

    public PaymentPlans createPaymentPlan(PaymentPlans paymentPlan) {
        return repository.save(paymentPlan);
    }

    public PaymentPlans updatePaymentPlan(Long id, PaymentPlans paymentPlan) {
        PaymentPlans existing = getPaymentPlanById(id);
        existing.setPlanType(paymentPlan.getPlanType());
        existing.setDescription(paymentPlan.getDescription());
        return repository.save(existing);
    }

    public void deletePaymentPlan(Long id) {
        repository.deleteById(id);
    }
}