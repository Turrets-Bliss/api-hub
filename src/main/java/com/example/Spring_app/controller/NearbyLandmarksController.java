package com.example.Spring_app.controller;

import com.example.Spring_app.entity.NearbyLandmarks;
import com.example.Spring_app.service.NearbyLandmarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/landmarks")
public class NearbyLandmarksController {

    @Autowired
    private NearbyLandmarksService nearbyLandmarksService;

    @GetMapping
    public List<NearbyLandmarks> getAllLandmarks() {
        return nearbyLandmarksService.getAllLandmarks();
    }

    @GetMapping("/{id}")
    public Optional<NearbyLandmarks> getLandmarkById(@PathVariable Long id) {
        return nearbyLandmarksService.getLandmarkById(id);
    }

    @PostMapping
    public NearbyLandmarks createLandmark(@RequestBody NearbyLandmarks landmark) {
        return nearbyLandmarksService.saveLandmark(landmark);
    }

    @DeleteMapping("/{id}")
    public void deleteLandmark(@PathVariable Long id) {
        nearbyLandmarksService.deleteLandmark(id);
    }
}
