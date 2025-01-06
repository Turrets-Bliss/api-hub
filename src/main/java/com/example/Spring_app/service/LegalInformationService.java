package com.example.Spring_app.service;

import com.example.Spring_app.entity.LegalInformation;
import com.example.Spring_app.repository.LegalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LegalInformationService {

    @Autowired
    private LegalInformationRepository legalInformationRepository;

    public List<LegalInformation> getAllLegalInformation() {
        return legalInformationRepository.findAll();
    }

    public Optional<LegalInformation> getLegalInformationById(Long id) {
        return legalInformationRepository.findById(id);
    }

    public LegalInformation saveLegalInformation(LegalInformation legalInformation) {
        return legalInformationRepository.save(legalInformation);
    }

    public void deleteLegalInformation(Long id) {
        legalInformationRepository.deleteById(id);
    }
}
