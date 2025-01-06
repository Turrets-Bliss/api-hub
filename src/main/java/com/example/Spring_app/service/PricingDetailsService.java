package com.example.Spring_app.service;

import com.example.Spring_app.entity.PricingDetails;
import com.example.Spring_app.repository.PricingDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PricingDetailsService {
    private final PricingDetailsRepository repository;

    public PricingDetailsService(PricingDetailsRepository repository) {
        this.repository = repository;
    }

    public List<PricingDetails> getAllPricingDetails() {
        return repository.findAll();
    }

    public PricingDetails getPricingDetailsById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("PricingDetails not found"));
    }

    public PricingDetails createPricingDetails(PricingDetails pricingDetails) {
        return repository.save(pricingDetails);
    }

    public PricingDetails updatePricingDetails(Long id, PricingDetails pricingDetails) {
        PricingDetails existing = getPricingDetailsById(id);
        existing.setBasePricePerSqFt(pricingDetails.getBasePricePerSqFt());
        existing.setMaintenanceChargesPerMonth(pricingDetails.getMaintenanceChargesPerMonth());
        existing.setBookingAmount(pricingDetails.getBookingAmount());
        return repository.save(existing);
    }

    public void deletePricingDetails(Long id) {
        repository.deleteById(id);
    }
}