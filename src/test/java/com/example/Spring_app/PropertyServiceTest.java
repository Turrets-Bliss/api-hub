package com.example.Spring_app;

import com.example.Spring_app.dto.PropertyRequest;
import com.example.Spring_app.entity.*;
import com.example.Spring_app.repository.primary.*;
import com.example.Spring_app.service.PropertyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PropertyServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PropertyDetailsRepository propertyDetailsRepo;

    @Mock
    private AdditionalDataRepository additionalDataRepo;

    @Mock
    private PricingDetailsRepository pricingDetailsRepo;

    @Mock
    private AmenitiesRepository amenitiesRepo;

    @InjectMocks
    private PropertyService propertyService;

    private UUID userId;
    private User user;
    private PropertyDetails property;
    private PropertyRequest request;

    @BeforeEach
    void setUp() {
        userId = UUID.randomUUID();
        user = new User();
        user.setId(userId);

        property = new PropertyDetails();
        property.setId(1L);
        property.setUser(user);

        request = new PropertyRequest();
        request.setPropertyDetails(property);
        request.setAdditionalData(new AdditionalData());
        request.setPricingDetails(new PricingDetails());
        request.setAmenities(new Amenities());
    }

    @Test
    void createUser_ShouldRegisterUser() {
        when(userRepository.findById(userId)).thenReturn(Optional.empty());
        String result = propertyService.createUser(userId);
        assertEquals("User registered successfully", result);
        verify(userRepository).save(any(User.class));
    }

    @Test
    void createUser_ShouldReturnUserAlreadyRegistered() {
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        String result = propertyService.createUser(userId);
        assertEquals("User already registered", result);
    }

    @Test
    void deleteUser_ShouldDeleteUser() {
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        String result = propertyService.deleteUser(userId);
        assertEquals("User deleted successfully", result);
        verify(userRepository).deleteById(userId);
    }

    @Test
    void deleteUser_ShouldReturnUserNotFound() {
        when(userRepository.findById(userId)).thenReturn(Optional.empty());
        String result = propertyService.deleteUser(userId);
        assertEquals("User not found", result);
    }

    @Test
    void createProperty_ShouldCreateSuccessfully() {
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(propertyDetailsRepo.save(any(PropertyDetails.class))).thenReturn(property);

        String result = propertyService.createProperty(userId, request);
        assertEquals("Property created successfully!", result);
    }

    @Test
    void createProperty_ShouldThrowException_WhenUserNotFound() {
        when(userRepository.findById(userId)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> propertyService.createProperty(userId, request));
    }

    @Test
    void getProperty_ShouldReturnProperty() {
        when(propertyDetailsRepo.findByIdAndUserId(1L, userId)).thenReturn(Optional.of(property));
        PropertyRequest result = propertyService.getProperty(userId, 1L);
        assertNotNull(result);
        assertEquals(property, result.getPropertyDetails());
    }

    @Test
    void getProperty_ShouldThrowException_WhenNotFound() {
        when(propertyDetailsRepo.findByIdAndUserId(1L, userId)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> propertyService.getProperty(userId, 1L));
    }

    @Test
    void getAllProperties_ShouldReturnList() {
        when(propertyDetailsRepo.findByUserId(userId)).thenReturn(List.of(property));
        List<PropertyDetails> result = propertyService.getAllProperties(userId);
        assertEquals(1, result.size());
    }

    @Test
    void updateProperty_ShouldUpdateSuccessfully() {
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(propertyDetailsRepo.findByIdAndUserId(1L, userId)).thenReturn(Optional.of(property));

        String result = propertyService.updateProperty(1L, userId, request);
        assertEquals("Property updated successfully!", result);
    }

    @Test
    void updateProperty_ShouldThrowException_WhenUserNotFound() {
        when(userRepository.findById(userId)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> propertyService.updateProperty(1L, userId, request));
    }

    @Test
    void updateProperty_ShouldThrowException_WhenPropertyNotFound() {
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(propertyDetailsRepo.findByIdAndUserId(1L, userId)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> propertyService.updateProperty(1L, userId, request));
    }

    @Test
    void deleteProperty_ShouldDeleteSuccessfully() {
        when(propertyDetailsRepo.findByIdAndUserId(1L, userId)).thenReturn(Optional.of(property));

        String result = propertyService.deleteProperty(userId, 1L);
        assertEquals("Property deleted successfully!", result);
        verify(propertyDetailsRepo).delete(property);
    }

    @Test
    void deleteProperty_ShouldThrowException_WhenPropertyNotFound() {
        when(propertyDetailsRepo.findByIdAndUserId(1L, userId)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> propertyService.deleteProperty(userId, 1L));
    }
}
