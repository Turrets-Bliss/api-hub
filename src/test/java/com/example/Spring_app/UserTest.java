package com.example.Spring_app;

import com.example.Spring_app.entity.PropertyDetails;
import com.example.Spring_app.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;
    private UUID userId;

    @BeforeEach
    void setUp() {
        user = new User();
        userId = UUID.randomUUID();
        user.setId(userId);
    }

    @Test
    void testUserIdGetterSetter() {
        assertEquals(userId, user.getId());
    }

    @Test
    void testUserPropertiesSetterGetter() {
        PropertyDetails property1 = new PropertyDetails();
        PropertyDetails property2 = new PropertyDetails();
        List<PropertyDetails> properties = Arrays.asList(property1, property2);

        user.setProperties(properties);
        assertEquals(2, user.getProperties().size());
    }

    @Test
    void testUserWithEmptyPropertiesList() {
        user.setProperties(new ArrayList<>());
        assertNotNull(user.getProperties());
        assertTrue(user.getProperties().isEmpty());
    }

    @Test
    void testUserWithNullProperties() {
        user.setProperties(null);
        assertNull(user.getProperties());
    }

    @Test
    void testUserWithLargeNumberOfProperties() {
        List<PropertyDetails> properties = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            properties.add(new PropertyDetails());
        }
        user.setProperties(properties);
        assertEquals(1000, user.getProperties().size());
    }

    @Test
    void testOrphanRemovalProperty() {
        PropertyDetails property1 = new PropertyDetails();
        PropertyDetails property2 = new PropertyDetails();
        List<PropertyDetails> properties = new ArrayList<>(Arrays.asList(property1, property2));
        user.setProperties(properties);

        // Remove one property and check if orphan removal works
        properties.remove(property1);
        user.setProperties(properties);

        assertEquals(1, user.getProperties().size());
    }

    @Test
    void testUserWithDuplicateProperties() {
        PropertyDetails property = new PropertyDetails();
        List<PropertyDetails> properties = Arrays.asList(property, property); // Same object added twice

        user.setProperties(properties);
        assertEquals(2, user.getProperties().size()); // List allows duplicates
    }
}