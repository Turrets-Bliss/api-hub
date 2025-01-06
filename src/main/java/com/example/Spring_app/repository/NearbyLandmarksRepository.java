package com.example.Spring_app.repository;

import com.example.Spring_app.entity.NearbyLandmarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NearbyLandmarksRepository extends JpaRepository<NearbyLandmarks, Long> {
}