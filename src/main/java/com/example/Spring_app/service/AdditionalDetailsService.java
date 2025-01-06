package com.example.Spring_app.service;

import com.example.Spring_app.entity.AdditionalDetails;
import com.example.Spring_app.repository.AdditionalDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdditionalDetailsService {

    @Autowired
    private AdditionalDetailsRepository additionalDetailsRepository;

    public List<AdditionalDetails> getAllAdditionalDetails() {
        return additionalDetailsRepository.findAll();
    }

    public Optional<AdditionalDetails> getAdditionalDetailsById(Long id) {
        return additionalDetailsRepository.findById(id);
    }

    public AdditionalDetails saveAdditionalDetails(AdditionalDetails additionalDetails) {
        return additionalDetailsRepository.save(additionalDetails);
    }

    public void deleteAdditionalDetails(Long id) {
        additionalDetailsRepository.deleteById(id);
    }
}
