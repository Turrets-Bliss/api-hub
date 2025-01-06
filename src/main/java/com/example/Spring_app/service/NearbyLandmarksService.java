package com.example.Spring_app.service;


import com.example.Spring_app.entity.NearbyLandmarks;
import com.example.Spring_app.repository.NearbyLandmarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NearbyLandmarksService {

    @Autowired
    private NearbyLandmarksRepository nearbyLandmarksRepository;

    public List<NearbyLandmarks> getAllLandmarks() {
        return nearbyLandmarksRepository.findAll();
    }

    public Optional<NearbyLandmarks> getLandmarkById(Long id) {
        return nearbyLandmarksRepository.findById(id);
    }

    public NearbyLandmarks saveLandmark(NearbyLandmarks landmark) {
        return nearbyLandmarksRepository.save(landmark);
    }

    public void deleteLandmark(Long id) {
        nearbyLandmarksRepository.deleteById(id);
    }
}