package com.example.Spring_app.controller;

import com.example.Spring_app.entity.LegalInformation;
import com.example.Spring_app.service.LegalInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/legal-info")
public class LegalInformationController {

    @Autowired
    private LegalInformationService legalInformationService;

    @GetMapping
    public List<LegalInformation> getAllLegalInformation() {
        return legalInformationService.getAllLegalInformation();
    }

    @GetMapping("/{id}")
    public Optional<LegalInformation> getLegalInformationById(@PathVariable Long id) {
        return legalInformationService.getLegalInformationById(id);
    }

    @PostMapping
    public LegalInformation createLegalInformation(@RequestBody LegalInformation legalInformation) {
        return legalInformationService.saveLegalInformation(legalInformation);
    }

    @DeleteMapping("/{id}")
    public void deleteLegalInformation(@PathVariable Long id) {
        legalInformationService.deleteLegalInformation(id);
    }
}