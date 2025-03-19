package com.example.Spring_app;

import com.example.Spring_app.dto.InvestorDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class InvestorDTOTest {

    private InvestorDTO investorDTO;

    @BeforeEach
    void setUp() {
        investorDTO = new InvestorDTO();
    }

    @Test
    void testUserIdGetterSetter() {
        String userId = "user123";
        investorDTO.setUserId(userId);
        assertEquals(userId, investorDTO.getUserId());
    }

    @Test
    void testYearOfInvestmentGetterSetter() {
        Integer year = 2023;
        investorDTO.setYearOfInvestment(year);
        assertEquals(year, investorDTO.getYearOfInvestment());
    }

    @Test
    void testPropertyIdGetterSetter() {
        Integer propertyId = 101;
        investorDTO.setPropertyId(propertyId);
        assertEquals(propertyId, investorDTO.getPropertyId());
    }

    @Test
    void testCurrentMarketValueGetterSetter() {
        BigDecimal marketValue = new BigDecimal("500000.75");
        investorDTO.setCurrentMarketValue(marketValue);
        assertEquals(marketValue, investorDTO.getCurrentMarketValue());
    }

    @Test
    void testCurrentInvestmentsGetterSetter() {
        BigDecimal investments = new BigDecimal("100000.50");
        investorDTO.setCurrentInvestments(investments);
        assertEquals(investments, investorDTO.getCurrentInvestments());
    }

    @Test
    void testRoiGetterSetter() {
        BigDecimal roi = new BigDecimal("12.5");
        investorDTO.setRoi(roi);
        assertEquals(roi, investorDTO.getRoi());
    }

    // Edge Cases

    @Test
    void testNullValues() {
        investorDTO.setUserId(null);
        investorDTO.setYearOfInvestment(null);
        investorDTO.setPropertyId(null);
        investorDTO.setCurrentMarketValue(null);
        investorDTO.setCurrentInvestments(null);
        investorDTO.setRoi(null);

        assertNull(investorDTO.getUserId());
        assertNull(investorDTO.getYearOfInvestment());
        assertNull(investorDTO.getPropertyId());
        assertNull(investorDTO.getCurrentMarketValue());
        assertNull(investorDTO.getCurrentInvestments());
        assertNull(investorDTO.getRoi());
    }

    @Test
    void testNegativeValues() {
        investorDTO.setCurrentMarketValue(new BigDecimal("-50000"));
        investorDTO.setCurrentInvestments(new BigDecimal("-20000"));
        investorDTO.setRoi(new BigDecimal("-10.5"));

        assertEquals(new BigDecimal("-50000"), investorDTO.getCurrentMarketValue());
        assertEquals(new BigDecimal("-20000"), investorDTO.getCurrentInvestments());
        assertEquals(new BigDecimal("-10.5"), investorDTO.getRoi());
    }

    @Test
    void testZeroValues() {
        investorDTO.setCurrentMarketValue(BigDecimal.ZERO);
        investorDTO.setCurrentInvestments(BigDecimal.ZERO);
        investorDTO.setRoi(BigDecimal.ZERO);

        assertEquals(BigDecimal.ZERO, investorDTO.getCurrentMarketValue());
        assertEquals(BigDecimal.ZERO, investorDTO.getCurrentInvestments());
        assertEquals(BigDecimal.ZERO, investorDTO.getRoi());
    }

    @Test
    void testLargeValues() {
        BigDecimal largeValue = new BigDecimal("99999999999999999999999.99");
        investorDTO.setCurrentMarketValue(largeValue);
        investorDTO.setCurrentInvestments(largeValue);
        investorDTO.setRoi(largeValue);

        assertEquals(largeValue, investorDTO.getCurrentMarketValue());
        assertEquals(largeValue, investorDTO.getCurrentInvestments());
        assertEquals(largeValue, investorDTO.getRoi());
    }

    @Test
    void testExtremeYearOfInvestment() {
        investorDTO.setYearOfInvestment(1800);
        assertEquals(1800, investorDTO.getYearOfInvestment());

        investorDTO.setYearOfInvestment(3000);
        assertEquals(3000, investorDTO.getYearOfInvestment());
    }

    @Test
    void testDuplicatePropertyIdHandling() {
        InvestorDTO investor1 = new InvestorDTO();
        InvestorDTO investor2 = new InvestorDTO();

        investor1.setPropertyId(1001);
        investor2.setPropertyId(1001);

        assertEquals(investor1.getPropertyId(), investor2.getPropertyId());
    }
}
