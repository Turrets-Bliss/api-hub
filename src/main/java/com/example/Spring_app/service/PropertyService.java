package com.example.Spring_app.service;


import com.example.Spring_app.dto.PropertyRequest;
import com.example.Spring_app.entity.*;
import com.example.Spring_app.repository.primary.AdditionalDataRepository;
import com.example.Spring_app.repository.primary.AmenitiesRepository;
import com.example.Spring_app.repository.primary.PricingDetailsRepository;
import com.example.Spring_app.repository.primary.PropertyDetailsRepository;
import com.example.Spring_app.repository.primary.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PropertyService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PropertyDetailsRepository propertyDetailsRepo;
    @Autowired
    private AdditionalDataRepository additionalDataRepo;
    @Autowired
    private PricingDetailsRepository pricingDetailsRepo;
    @Autowired
    private AmenitiesRepository amenitiesRepo;

    public String createUser(UUID userId) {
        // Check if the user already exists
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            return "User already registered";
        }

        // Create new user
        User newUser = new User();
        newUser.setId(userId); // Assuming User entity has a field 'userId'
        userRepository.save(newUser);

        return "User registered successfully";
    }

    public String deleteUser(UUID userId) {
        // Check if user exists
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return "User not found";
        }

        // Delete user
        userRepository.deleteById(userId);
        return "User deleted successfully";
    }

    @Transactional
    public String createProperty(UUID userId, PropertyRequest request) {
        try {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Save PropertyDetails
            PropertyDetails property = request.getPropertyDetails();
            property.setUser(user); // ✅ Associate with User
            property = propertyDetailsRepo.save(property);

            if (property.getLatitude() == null || property.getLongitude() == null) {
                property.setLatitude(null);
                property.setLongitude(null);
            }

            request.getAdditionalData().setProperty(property);
            additionalDataRepo.save(request.getAdditionalData());
            request.getPricingDetails().setProperty(property);
            pricingDetailsRepo.save(request.getPricingDetails());
            request.getAmenities().setProperty(property);
            amenitiesRepo.save(request.getAmenities());
            return "Property created successfully!";
        } catch (Exception e) {
            // Optionally log the error and throw an exception to rollback
            throw new RuntimeException("Error occurred while creating property: " + e.getMessage());
        }
    }


    public PropertyRequest getProperty(UUID userId, Long propertyId) {
        PropertyDetails property = propertyDetailsRepo.findByIdAndUserId(propertyId, userId)
                .orElseThrow(() -> new RuntimeException("Property not found for the given user"));

        PropertyRequest response = new PropertyRequest();
        response.setPropertyDetails(property);
        return response;
    }


    public List<PropertyDetails> getAllProperties(UUID userId) {
        // Fetch properties only for the given user
        return propertyDetailsRepo.findByUserId(userId);
    }


    @Transactional
    public String updateProperty(Long propertyId, UUID userId, PropertyRequest request) {
        try {
            // Fetch the user from the database using userId from parameter
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Ensure the property exists and belongs to the user
            PropertyDetails property = propertyDetailsRepo.findByIdAndUserId(propertyId, userId)
                    .orElseThrow(() -> new RuntimeException("Property not found or user not authorized"));

            // Set the fetched user to the property (fixing the null constraint issue)
            property.setUser(user);
            property.setPropertyTitle(request.getPropertyDetails().getPropertyTitle());
            property.setDescription(request.getPropertyDetails().getDescription());
            property.setPropertyType(request.getPropertyDetails().getPropertyType());
            property.setPropertyStatus(request.getPropertyDetails().getPropertyStatus());
            property.setPropertyCategory(request.getPropertyDetails().getPropertyCategory());
            property.setLotSize(request.getPropertyDetails().getLotSize());
            property.setSizeInFt(request.getPropertyDetails().getSizeInFt());
            property.setBedrooms(request.getPropertyDetails().getBedrooms());
            property.setRooms(request.getPropertyDetails().getRooms());
            property.setYearBuilt(request.getPropertyDetails().getYearBuilt());
            property.setGarages(request.getPropertyDetails().getGarages());
            property.setAvailableFrom(request.getPropertyDetails().getAvailableFrom());
            property.setGarageSize(request.getPropertyDetails().getGarageSize());
            property.setExtraDetails(request.getPropertyDetails().getExtraDetails());
            property.setBasement(request.getPropertyDetails().getBasement());
            property.setExteriorMaterial(request.getPropertyDetails().getExteriorMaterial());
            property.setRoofing(request.getPropertyDetails().getRoofing());
            property.setStructureType(request.getPropertyDetails().getStructureType());
            property.setFloors(request.getPropertyDetails().getFloors());
            property.setOwnerNotes(request.getPropertyDetails().getOwnerNotes());
            property.setEnergyIndex(request.getPropertyDetails().getEnergyIndex());
            property.setEnergyClass(request.getPropertyDetails().getEnergyClass());
            property.setPossessionDate(request.getPropertyDetails().getPossessionDate());
            property.setCity(request.getPropertyDetails().getCity());
            property.setCountry(request.getPropertyDetails().getCountry());
            property.setState(request.getPropertyDetails().getState());
            property.setZipcode(request.getPropertyDetails().getZipcode());
            property.setNeighbourhood(request.getPropertyDetails().getNeighbourhood());
            property.setAddress(request.getPropertyDetails().getAddress());
            property.setStreetViewAngle(request.getPropertyDetails().getStreetViewAngle());

            // Update Latitude and Longitude if provided
            if (request.getPropertyDetails().getLatitude() != null && request.getPropertyDetails().getLongitude() != null) {
                property.setLatitude(request.getPropertyDetails().getLatitude());
                property.setLongitude(request.getPropertyDetails().getLongitude());
            }

            // Save the updated PropertyDetails
            propertyDetailsRepo.save(property);

            // Update or create AdditionalData related to this property
            AdditionalData additionalData = additionalDataRepo.findByPropertyId(propertyId);
            if (additionalData != null) {
                // Update the existing AdditionalData
                additionalData.setVideoLink(request.getAdditionalData().getVideoLink());
                additionalData.setVideoFrom(request.getAdditionalData().getVideoFrom());
                additionalData.setImageLink(request.getAdditionalData().getImageLink());
                additionalDataRepo.save(additionalData);
            } else {
                // If no AdditionalData exists, create a new one
                request.getAdditionalData().setProperty(property);
                additionalDataRepo.save(request.getAdditionalData());
            }

            // Update or create PricingDetails related to this property
            PricingDetails pricingDetails = pricingDetailsRepo.findByPropertyId(propertyId);
            if (pricingDetails != null) {
                // Update the existing PricingDetails
                pricingDetails.setAfterPriceLabel(request.getPricingDetails().getAfterPriceLabel());
                pricingDetails.setBeforePriceLabel(request.getPricingDetails().getBeforePriceLabel());
                pricingDetails.setPrice(request.getPricingDetails().getPrice());
                pricingDetails.setHomeOwnersAssociationFee(request.getPricingDetails().getHomeOwnersAssociationFee());
                pricingDetails.setTaxRate(request.getPricingDetails().getTaxRate());
                pricingDetailsRepo.save(pricingDetails);
            } else {
                // If no PricingDetails exists, create a new one
                request.getPricingDetails().setProperty(property);
                pricingDetailsRepo.save(request.getPricingDetails());
            }

            // Update or create Amenities related to this property
            Amenities amenities = amenitiesRepo.findByPropertyId(propertyId);
            if (amenities != null) {
                // Update the existing Amenities
                amenities.setPool(request.getAmenities().getPool());
                amenities.setGym(request.getAmenities().getGym());
                amenities.setFireplace(request.getAmenities().getFireplace());
                amenities.setEquippedKitchen(request.getAmenities().getEquippedKitchen());
                amenities.setLaundry(request.getAmenities().getLaundry());
                amenities.setMediaRoom(request.getAmenities().getMediaRoom());
                amenities.setHotBath(request.getAmenities().getHotBath());
                amenities.setBasketballCourt(request.getAmenities().getBasketballCourt());
                amenities.setBackYard(request.getAmenities().getBackYard());
                amenities.setFrontYard(request.getAmenities().getFrontYard());
                amenities.setGarageAttached(request.getAmenities().getGarageAttached());
                amenities.setHeating(request.getAmenities().getHeating());
                amenities.setWater(request.getAmenities().getWater());
                amenities.setElectricity(request.getAmenities().getElectricity());
                amenities.setVentilation(request.getAmenities().getVentilation());
                amenities.setCentralAir(request.getAmenities().getCentralAir());
                amenities.setNaturalGas(request.getAmenities().getNaturalGas());
                amenities.setElevator(request.getAmenities().getElevator());
                amenities.setChairAccessible(request.getAmenities().getChairAccessible());
                amenities.setWifi(request.getAmenities().getWifi());
                amenities.setWasherAndDryer(request.getAmenities().getWasherAndDryer());
                amenities.setSmokeDetectors(request.getAmenities().getSmokeDetectors());
                amenitiesRepo.save(amenities);
            } else {
                // If no Amenities exists, create a new one
                request.getAmenities().setProperty(property);
                amenitiesRepo.save(request.getAmenities());
            }

            return "Property updated successfully!";
        } catch (Exception e) {
            // Optionally log the error and throw an exception to rollback
            throw new RuntimeException("Error occurred while updating property: " + e.getMessage());
        }
    }




    @Transactional
    public String deleteProperty(UUID userId, Long propertyId) {
        PropertyDetails property = propertyDetailsRepo.findByIdAndUserId(propertyId, userId)
                .orElseThrow(() -> new RuntimeException("Property not found for the given user"));

        propertyDetailsRepo.delete(property);
        return "Property deleted successfully!";
    }
}


