package com.example.Spring_app;

import com.example.Spring_app.entity.Investor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class InvestorTest {

    private Investor investor;

    @BeforeEach
    void setUp() {
        investor = new Investor();
    }

    @Test
    void testIdGetterAndSetter() {
        investor.setId(1L);
        assertEquals(1L, investor.getId());
    }

    @Test
    void testUserIdGetterAndSetter() {
        investor.setUserId("user123");
        assertEquals("user123", investor.getUserId());
    }

    @Test
    void testYearOfInvestmentGetterAndSetter() {
        investor.setYearOfInvestment(2022);
        assertEquals(2022, investor.getYearOfInvestment());
    }

    @Test
    void testPropertyIdGetterAndSetter() {
        investor.setPropertyId(1001);
        assertEquals(1001, investor.getPropertyId());
    }

    @Test
    void testCurrentMarketValueGetterAndSetter() {
        BigDecimal value = new BigDecimal("150000.75");
        investor.setCurrentMarketValue(value);
        assertEquals(value, investor.getCurrentMarketValue());
    }

    @Test
    void testCurrentInvestmentsGetterAndSetter() {
        BigDecimal investment = new BigDecimal("50000.50");
        investor.setCurrentInvestments(investment);
        assertEquals(investment, investor.getCurrentInvestments());
    }

    @Test
    void testRoiGetterAndSetter() {
        BigDecimal roi = new BigDecimal("12.5");
        investor.setRoi(roi);
        assertEquals(roi, investor.getRoi());
    }

    @Test
    void testNullHandling() {
        investor.setUserId(null);
        investor.setCurrentMarketValue(null);
        investor.setCurrentInvestments(null);
        investor.setRoi(null);

        assertNull(investor.getUserId());
        assertNull(investor.getCurrentMarketValue());
        assertNull(investor.getCurrentInvestments());
        assertNull(investor.getRoi());
    }
}
