package com.example.Spring_app;

import com.example.Spring_app.dto.InvestorDTO;
import com.example.Spring_app.entity.Investor;
import com.example.Spring_app.repository.investor.InvestorRepository;
import com.example.Spring_app.service.InvestorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InvestorServiceTest {

    @Mock
    private InvestorRepository investorRepository;

    @InjectMocks
    private InvestorService investorService;

    private Investor investor;
    private InvestorDTO investorDTO;
    private final String userId = "123";

    @BeforeEach
    void setUp() {
        investor = new Investor();
        investor.setUserId(userId);
        investor.setYearOfInvestment(2022);
        investor.setPropertyId(1);
        investor.setCurrentMarketValue(BigDecimal.valueOf(200000));
        investor.setCurrentInvestments(BigDecimal.valueOf(150000));
        investor.setRoi(BigDecimal.valueOf(50000));

        investorDTO = new InvestorDTO();
        investorDTO.setUserId(userId);
        investorDTO.setYearOfInvestment(2022);
        investorDTO.setPropertyId(1);
        investorDTO.setCurrentMarketValue(BigDecimal.valueOf(200000));
        investorDTO.setCurrentInvestments(BigDecimal.valueOf(150000));
        investorDTO.setRoi(BigDecimal.valueOf(50000));
    }

    @Test
    void testGetInvestorDetails_Success() {
        when(investorRepository.findByUserId(userId)).thenReturn(Collections.singletonList(investor));

        List<InvestorDTO> result = investorService.getInvestorDetails(userId);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(userId, result.get(0).getUserId());
        verify(investorRepository, times(1)).findByUserId(userId);
    }

    @Test
    void testGetInvestorDetails_NotFound() {
        when(investorRepository.findByUserId(userId)).thenReturn(Collections.emptyList());

        List<InvestorDTO> result = investorService.getInvestorDetails(userId);

        assertNull(result);
        verify(investorRepository, times(1)).findByUserId(userId);
    }

    @Test
    void testGetRoiByUserId_Success() {
        when(investorRepository.findByUserId(userId)).thenReturn(Collections.singletonList(investor));

        Map<String, BigDecimal> result = investorService.getRoiByUserId(userId);

        assertFalse(result.isEmpty());
        assertEquals(BigDecimal.valueOf(50000), result.get("ROI"));
        assertEquals(BigDecimal.valueOf(1500000), result.get("Max Value"));
        assertEquals(BigDecimal.valueOf(150000), result.get("Current Investment"));
    }

    @Test
    void testGetRoiByUserId_NotFound() {
        when(investorRepository.findByUserId(userId)).thenReturn(Collections.emptyList());

        Map<String, BigDecimal> result = investorService.getRoiByUserId(userId);

        assertTrue(result.isEmpty());
    }

    @Test
    void testGetInvestmentsByUserId_Success() {
        when(investorRepository.findByUserId(userId)).thenReturn(Collections.singletonList(investor));

        List<Map<String, Object>> result = investorService.getInvestmentsByUserId(userId);

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(BigDecimal.valueOf(150000), result.get(0).get("currentInvestments"));
    }

    @Test
    void testGetInvestmentsByUserId_NotFound() {
        when(investorRepository.findByUserId(userId)).thenReturn(Collections.emptyList());

        List<Map<String, Object>> result = investorService.getInvestmentsByUserId(userId);

        assertTrue(result.isEmpty());
    }

    @Test
    void testGetMarketValueByUserId_Success() {
        when(investorRepository.findByUserId(userId)).thenReturn(Collections.singletonList(investor));

        List<Map<String, Object>> result = investorService.getMarketValueByUserId(userId);

        assertFalse(result.isEmpty());
        assertEquals(BigDecimal.valueOf(200000), result.get(0).get("currentMarketValue"));
    }

    @Test
    void testGetMarketValueByUserId_NotFound() {
        when(investorRepository.findByUserId(userId)).thenReturn(Collections.emptyList());

        List<Map<String, Object>> result = investorService.getMarketValueByUserId(userId);

        assertTrue(result.isEmpty());
    }

    @Test
    void testAddInvestor_Success() {
        when(investorRepository.save(any(Investor.class))).thenReturn(investor);

        InvestorDTO result = investorService.addInvestor(investorDTO);

        assertNotNull(result);
        assertEquals(userId, result.getUserId());
        verify(investorRepository, times(1)).save(any(Investor.class));
    }

    @Test
    void testDeleteInvestorByUserId_Success() {
        when(investorRepository.findByUserId(userId)).thenReturn(Collections.singletonList(investor));

        boolean result = investorService.deleteInvestorByUserId(userId);

        assertTrue(result);
        verify(investorRepository, times(1)).deleteAll(anyList());
    }

    @Test
    void testDeleteInvestorByUserId_NotFound() {
        when(investorRepository.findByUserId(userId)).thenReturn(Collections.emptyList());

        boolean result = investorService.deleteInvestorByUserId(userId);

        assertFalse(result);
        verify(investorRepository, never()).deleteAll(anyList());
    }
}
