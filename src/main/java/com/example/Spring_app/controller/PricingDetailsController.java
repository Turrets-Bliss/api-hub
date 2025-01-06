package com.example.Spring_app.controller;

import com.example.Spring_app.entity.PricingDetails;
import com.example.Spring_app.repository.PricingDetailsRepository;
import com.example.Spring_app.service.PricingDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pricing-details")
public class PricingDetailsController {

    @Autowired
    private PricingDetailsRepository pricingDetailsRepository;

    // Get all pricing details
    @GetMapping
    public List<PricingDetails> getAllPricingDetails() {
        return pricingDetailsRepository.findAll();
    }

    // Get a pricing detail by ID
    @GetMapping("/{id}")
    public ResponseEntity<PricingDetails> getPricingDetail(@PathVariable Long id) {
        Optional<PricingDetails> pricingDetail = pricingDetailsRepository.findById(id);
        return pricingDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create new pricing detail
    @PostMapping
    public PricingDetails createPricingDetail(@RequestBody PricingDetails pricingDetails) {
        return pricingDetailsRepository.save(pricingDetails);
    }

    // Update existing pricing detail
    @PutMapping("/{id}")
    public ResponseEntity<PricingDetails> updatePricingDetail(@PathVariable Long id, @RequestBody PricingDetails pricingDetails) {
        if (!pricingDetailsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pricingDetails.setId(id);
        PricingDetails updatedPricingDetails = pricingDetailsRepository.save(pricingDetails);
        return ResponseEntity.ok(updatedPricingDetails);
    }

    // Delete pricing detail
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePricingDetail(@PathVariable Long id) {
        if (!pricingDetailsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pricingDetailsRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}