package com.example.Spring_app.service;


import com.example.Spring_app.dto.PropertyRequest;
import com.example.Spring_app.entity.*;
import com.example.Spring_app.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyDetailsRepository propertyDetailsRepo;
    @Autowired
    private AdditionalDataRepository additionalDataRepo;
    @Autowired
    private PricingDetailsRepository pricingDetailsRepo;
    @Autowired
    private AmenitiesRepository amenitiesRepo;

    @Transactional
    public String createProperty(PropertyRequest request) {
        try {
            PropertyDetails property = propertyDetailsRepo.save(request.getPropertyDetails());

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

    public PropertyRequest getProperty(Long id) {
        PropertyDetails property = propertyDetailsRepo.findById(id).orElseThrow();
        AdditionalData additional = additionalDataRepo.findByPropertyId(id);
        PricingDetails pricing = pricingDetailsRepo.findByPropertyId(id);
        Amenities amenities = amenitiesRepo.findByPropertyId(id);

        PropertyRequest response = new PropertyRequest();
        response.setPropertyDetails(property);
        response.setAdditionalData(additional);
        response.setPricingDetails(pricing);
        response.setAmenities(amenities);
        return response;
    }

    public List<PropertyDetails> getAllProperties() {
        return propertyDetailsRepo.findAll();
    }

    @Transactional
    public String updateProperty(Long propertyId, PropertyRequest request) {
        try {
            // Ensure PropertyDetails exists
            PropertyDetails property = propertyDetailsRepo.findById(propertyId).orElseThrow(() -> new RuntimeException("Property not found"));

            // Update PropertyDetails fields (Update only the fields provided)
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




    public String deleteProperty(Long id) {
        propertyDetailsRepo.deleteById(id);
        return "Property deleted successfully!";
    }
}

