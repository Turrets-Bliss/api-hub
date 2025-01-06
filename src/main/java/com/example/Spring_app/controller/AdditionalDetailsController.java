package com.example.Spring_app.controller;

import com.example.Spring_app.entity.AdditionalDetails;
import com.example.Spring_app.service.AdditionalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/additional-details")
public class AdditionalDetailsController {

    @Autowired
    private AdditionalDetailsService additionalDetailsService;

    @GetMapping
    public List<AdditionalDetails> getAllAdditionalDetails() {
        return additionalDetailsService.getAllAdditionalDetails();
    }

    @GetMapping("/{id}")
    public Optional<AdditionalDetails> getAdditionalDetailsById(@PathVariable Long id) {
        return additionalDetailsService.getAdditionalDetailsById(id);
    }

    @PostMapping
    public AdditionalDetails createAdditionalDetails(@RequestBody AdditionalDetails additionalDetails) {
        return additionalDetailsService.saveAdditionalDetails(additionalDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteAdditionalDetails(@PathVariable Long id) {
        additionalDetailsService.deleteAdditionalDetails(id);
    }
}