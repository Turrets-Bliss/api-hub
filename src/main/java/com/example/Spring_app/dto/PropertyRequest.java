package com.example.Spring_app.dto;

import com.example.Spring_app.entity.AdditionalData;
import com.example.Spring_app.entity.Amenities;
import com.example.Spring_app.entity.PricingDetails;
import com.example.Spring_app.entity.PropertyDetails;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

public class PropertyRequest {
    private PropertyDetails propertyDetails;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AdditionalData additionalData;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PricingDetails pricingDetails;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Amenities amenities;

    public PropertyDetails getPropertyDetails() {
        return propertyDetails;
    }

    public void setPropertyDetails(PropertyDetails propertyDetails) {
        this.propertyDetails = propertyDetails;
    }

    public AdditionalData getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(AdditionalData additionalData) {
        this.additionalData = additionalData;
    }

    public PricingDetails getPricingDetails() {
        return pricingDetails;
    }

    public void setPricingDetails(PricingDetails pricingDetails) {
        this.pricingDetails = pricingDetails;
    }

    public Amenities getAmenities() {
        return amenities;
    }

    public void setAmenities(Amenities amenities) {
        this.amenities = amenities;
    }

}