package com.example.Spring_app.repository.primary;

import com.example.Spring_app.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @EntityGraph(attributePaths = {
            "properties",
            "properties.additionalData",
            "properties.pricingDetails",
            "properties.amenities"
    })
    Optional<User> findById(UUID id);
}
