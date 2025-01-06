package com.example.Spring_app;

import com.example.Spring_app.entity.PaymentPlans;
import com.example.Spring_app.repository.PaymentPlansRepository;
import com.example.Spring_app.service.PaymentPlansService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentPlansServiceTest {

    @Mock
    private PaymentPlansRepository repository;

    @InjectMocks
    private PaymentPlansService service;

    @Test
    void testGetAllPaymentPlans() {
        // Arrange
        PaymentPlans plan1 = new PaymentPlans();
        plan1.setId(1L);
        plan1.setPlanType("Type1");

        PaymentPlans plan2 = new PaymentPlans();
        plan2.setId(2L);
        plan2.setPlanType("Type2");

        when(repository.findAll()).thenReturn(Arrays.asList(plan1, plan2));

        // Act
        List<PaymentPlans> result = service.getAllPaymentPlans();

        // Assert
        assertNotNull(result, "The result should not be null");
        assertEquals(2, result.size(), "There should be 2 payment plans");
        assertEquals("Type1", result.get(0).getPlanType(), "First plan type should match");
        assertEquals("Type2", result.get(1).getPlanType(), "Second plan type should match");
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetPaymentPlanById_Found() {
        // Arrange
        PaymentPlans plan = new PaymentPlans();
        plan.setId(1L);
        plan.setPlanType("Type1");

        when(repository.findById(1L)).thenReturn(Optional.of(plan));

        // Act
        PaymentPlans result = service.getPaymentPlanById(1L);

        // Assert
        assertNotNull(result, "The result should not be null");
        assertEquals(1L, result.getId(), "ID should match");
        assertEquals("Type1", result.getPlanType(), "Plan type should match");
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testGetPaymentPlanById_NotFound() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> service.getPaymentPlanById(1L));
        assertEquals("PaymentPlan not found", exception.getMessage(), "Exception message should match");
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testCreatePaymentPlan() {
        // Arrange
        PaymentPlans plan = new PaymentPlans();
        plan.setId(1L);
        plan.setPlanType("Type1");

        when(repository.save(plan)).thenReturn(plan);

        // Act
        PaymentPlans result = service.createPaymentPlan(plan);

        // Assert
        assertNotNull(result, "The saved plan should not be null");
        assertEquals(1L, result.getId(), "ID should match");
        assertEquals("Type1", result.getPlanType(), "Plan type should match");
        verify(repository, times(1)).save(plan);
    }

    @Test
    void testUpdatePaymentPlan() {
        // Arrange
        PaymentPlans existingPlan = new PaymentPlans();
        existingPlan.setId(1L);
        existingPlan.setPlanType("Type1");
        existingPlan.setDescription("Old Description");

        PaymentPlans updatedPlan = new PaymentPlans();
        updatedPlan.setPlanType("Type2");
        updatedPlan.setDescription("New Description");

        when(repository.findById(1L)).thenReturn(Optional.of(existingPlan));
        when(repository.save(existingPlan)).thenReturn(existingPlan);

        // Act
        PaymentPlans result = service.updatePaymentPlan(1L, updatedPlan);

        // Assert
        assertNotNull(result, "The updated plan should not be null");
        assertEquals(1L, result.getId(), "ID should match");
        assertEquals("Type2", result.getPlanType(), "Updated plan type should match");
        assertEquals("New Description", result.getDescription(), "Updated description should match");
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(existingPlan);
    }

    @Test
    void testDeletePaymentPlan() {
        // Arrange
        Long id = 1L;
        doNothing().when(repository).deleteById(id);

        // Act
        service.deletePaymentPlan(id);

        // Assert
        verify(repository, times(1)).deleteById(id);
    }
}
