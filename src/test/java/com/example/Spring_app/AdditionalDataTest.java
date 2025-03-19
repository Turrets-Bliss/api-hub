package com.example.Spring_app;



import com.example.Spring_app.entity.AdditionalData;
import com.example.Spring_app.entity.PropertyDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdditionalDataTest {

    private AdditionalData additionalData;
    private PropertyDetails propertyDetails;

    @BeforeEach
    void setUp() {
        additionalData = new AdditionalData();
        propertyDetails = new PropertyDetails();
    }

    @Test
    void testIdSetterAndGetter() {
        additionalData.setId(1L);
        assertEquals(1L, additionalData.getId());
    }

    @Test
    void testPropertySetterAndGetter() {
        additionalData.setProperty(propertyDetails);
        assertEquals(propertyDetails, additionalData.getProperty());
    }

    @Test
    void testVideoLinkSetterAndGetter() {
        String videoLink = "https://example.com/video.mp4";
        additionalData.setVideoLink(videoLink);
        assertEquals(videoLink, additionalData.getVideoLink());
    }

    @Test
    void testVideoFromSetterAndGetter() {
        String videoFrom = "YouTube";
        additionalData.setVideoFrom(videoFrom);
        assertEquals(videoFrom, additionalData.getVideoFrom());
    }

    @Test
    void testImageLinkSetterAndGetter() {
        List<String> imageLinks = Arrays.asList("https://example.com/image1.jpg", "https://example.com/image2.jpg");
        additionalData.setImageLink(imageLinks);
        assertEquals(imageLinks, additionalData.getImageLink());
    }

    @Test
    void testImageLinkEmptyList() {
        List<String> emptyList = new ArrayList<>();
        additionalData.setImageLink(emptyList);
        assertEquals(emptyList, additionalData.getImageLink());
        assertTrue(additionalData.getImageLink().isEmpty());
    }

    @Test
    void testNullProperty() {
        additionalData.setProperty(null);
        assertNull(additionalData.getProperty());
    }

    @Test
    void testNullVideoLink() {
        additionalData.setVideoLink(null);
        assertNull(additionalData.getVideoLink());
    }

    @Test
    void testNullVideoFrom() {
        additionalData.setVideoFrom(null);
        assertNull(additionalData.getVideoFrom());
    }

    @Test
    void testNullImageLink() {
        additionalData.setImageLink(null);
        assertNull(additionalData.getImageLink());
    }
}

