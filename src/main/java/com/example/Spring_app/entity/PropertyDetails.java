package com.example.Spring_app.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PropertyDetails")
public class PropertyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "property_title")
    private String propertyTitle;

    @Column(name = "description")
    private String description;

    @Column(name = "property_type")
    private String propertyType;

    @Column(name = "property_status")
    private String propertyStatus;

    @Column(name = "property_category")
    private String propertyCategory;

    @Column(name = "lot_size")
    private BigDecimal lotSize;

    @Column(name = "size_in_ft")
    private BigDecimal sizeInFt;

    @Column(name = "bedrooms")
    private Integer bedrooms;

    @Column(name = "rooms")
    private Integer rooms;

    @Column(name = "year_built")
    private Integer yearBuilt;

    @Column(name = "garages")
    private String garages;

    @Column(name = "available_from")
    private Date availableFrom;

    @Column(name = "garage_size")
    private String garageSize;

    @Column(name = "extra_details")
    private String extraDetails;

    @Column(name = "basement")
    private String basement;

    @Column(name = "exterior_material")
    private String exteriorMaterial;

    @Column(name = "roofing")
    private String roofing;

    @Column(name = "structure_type")
    private String structureType;

    @Column(name = "floors")
    private Integer floors;

    @Column(name = "owner_notes")
    private String ownerNotes;

    @Column(name = "energy_index")
    private BigDecimal energyIndex;

    @Column(name = "energy_class")
    private String energyClass;

    @Column(name = "possession_date")
    private Date possessionDate;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "neighbourhood")
    private String neighbourhood;

    @Column(name = "address")
    private String address;

    @Column(name = "street_view_angle")
    private BigDecimal streetViewAngle;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<AdditionalData> additionalData = new HashSet<>();

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<PricingDetails> pricingDetails = new HashSet<>();

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Amenities> amenities = new HashSet<>();

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyTitle() {
        return propertyTitle;
    }

    public void setPropertyTitle(String propertyTitle) {
        this.propertyTitle = propertyTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyStatus() {
        return propertyStatus;
    }

    public void setPropertyStatus(String propertyStatus) {
        this.propertyStatus = propertyStatus;
    }

    public String getPropertyCategory() {
        return propertyCategory;
    }

    public void setPropertyCategory(String propertyCategory) {
        this.propertyCategory = propertyCategory;
    }

    public BigDecimal getLotSize() {
        return lotSize;
    }

    public void setLotSize(BigDecimal lotSize) {
        this.lotSize = lotSize;
    }

    public BigDecimal getSizeInFt() {
        return sizeInFt;
    }

    public void setSizeInFt(BigDecimal sizeInFt) {
        this.sizeInFt = sizeInFt;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Integer getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(Integer yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public String getGarages() {
        return garages;
    }

    public void setGarages(String garages) {
        this.garages = garages;
    }

    public Date getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(Date availableFrom) {
        this.availableFrom = availableFrom;
    }

    public String getGarageSize() {
        return garageSize;
    }

    public void setGarageSize(String garageSize) {
        this.garageSize = garageSize;
    }

    public String getExtraDetails() {
        return extraDetails;
    }

    public void setExtraDetails(String extraDetails) {
        this.extraDetails = extraDetails;
    }

    public String getBasement() {
        return basement;
    }

    public void setBasement(String basement) {
        this.basement = basement;
    }

    public String getExteriorMaterial() {
        return exteriorMaterial;
    }

    public void setExteriorMaterial(String exteriorMaterial) {
        this.exteriorMaterial = exteriorMaterial;
    }

    public String getRoofing() {
        return roofing;
    }

    public void setRoofing(String roofing) {
        this.roofing = roofing;
    }

    public String getStructureType() {
        return structureType;
    }

    public void setStructureType(String structureType) {
        this.structureType = structureType;
    }

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public String getOwnerNotes() {
        return ownerNotes;
    }

    public void setOwnerNotes(String ownerNotes) {
        this.ownerNotes = ownerNotes;
    }

    public BigDecimal getEnergyIndex() {
        return energyIndex;
    }

    public void setEnergyIndex(BigDecimal energyIndex) {
        this.energyIndex = energyIndex;
    }

    public String getEnergyClass() {
        return energyClass;
    }

    public void setEnergyClass(String energyClass) {
        this.energyClass = energyClass;
    }

    public Date getPossessionDate() {
        return possessionDate;
    }

    public void setPossessionDate(Date possessionDate) {
        this.possessionDate = possessionDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getStreetViewAngle() {
        return streetViewAngle;
    }

    public void setStreetViewAngle(BigDecimal streetViewAngle) {
        this.streetViewAngle = streetViewAngle;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}
