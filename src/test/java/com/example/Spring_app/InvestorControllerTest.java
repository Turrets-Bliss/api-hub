package com.example.Spring_app;

import com.example.Spring_app.controller.InvestorController;
import com.example.Spring_app.dto.InvestorDTO;
import com.example.Spring_app.service.InvestorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
class InvestorControllerTest {

    private MockMvc mockMvc;

    @Mock
    private InvestorService investorService;

    @InjectMocks
    private InvestorController investorController;

    private InvestorDTO sampleInvestor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(investorController).build();

        sampleInvestor = new InvestorDTO();
        sampleInvestor.setUserId("1");
        sampleInvestor.setYearOfInvestment(2020);
        sampleInvestor.setPropertyId(101);
        sampleInvestor.setCurrentMarketValue(new BigDecimal("50000"));
        sampleInvestor.setCurrentInvestments(new BigDecimal("40000"));
        sampleInvestor.setRoi(new BigDecimal("10.5"));
    }

    @Test
    void testGetInvestorDetails_Success() throws Exception {
        when(investorService.getInvestorDetails("1")).thenReturn(List.of(sampleInvestor));

        mockMvc.perform(get("/api/investor/details/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].userId").value("1"));

        verify(investorService, times(1)).getInvestorDetails("1");
    }

    @Test
    void testGetInvestorDetails_NotFound() throws Exception {
        when(investorService.getInvestorDetails("99")).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/investor/details/99"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(0));
    }

    @Test
    void testAddInvestor_Success() throws Exception {
        when(investorService.addInvestor(any(InvestorDTO.class))).thenReturn(sampleInvestor);

        String requestBody = """
            {
                "userId": "1",
                "yearOfInvestment": 2020,
                "propertyId": 101,
                "currentMarketValue": 50000,
                "currentInvestments": 40000,
                "roi": 10.5
            }
            """;

        mockMvc.perform(post("/api/investor/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value("1"));

        verify(investorService, times(1)).addInvestor(any(InvestorDTO.class));
    }

    @Test
    void testAddInvestor_BadRequest() throws Exception {
        String requestBody = """
            {
                  "userId": "ayush@gmail.com",
                  "yearOfInvestment": 2026
                  "roi": 50000.00
                
            }
            """;
        mockMvc.perform(post("/api/investor/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testDeleteInvestor_Success() throws Exception {
        when(investorService.deleteInvestorByUserId("1")).thenReturn(true);

        mockMvc.perform(delete("/api/investor/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Investor with ID 1 deleted successfully."));
    }

    @Test
    void testDeleteInvestor_NotFound() throws Exception {
        when(investorService.deleteInvestorByUserId("5")).thenReturn(false);

        mockMvc.perform(delete("/api/investor/delete/5"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Investor with ID 5 not found."));


        verify(investorService, times(1)).deleteInvestorByUserId("5");
    }

    @Test
    void testGetRoiByUserId_Success() throws Exception {
        Map<String, BigDecimal> roiData = Map.of("roi", new BigDecimal("10.5"));

        when(investorService.getRoiByUserId("1")).thenReturn(roiData);

        mockMvc.perform(get("/api/investor/roi/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.roi").value(10.5));
    }

    @Test
    void testGetInvestmentsByUserId_Success() throws Exception {
        List<Map<String, Object>> investments = List.of(Map.of("propertyId", 101, "amount", new BigDecimal("40000")));

        when(investorService.getInvestmentsByUserId("1")).thenReturn(investments);

        mockMvc.perform(get("/api/investor/investments/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].propertyId").value(101))
                .andExpect(jsonPath("$[0].amount").value(40000));
    }

    @Test
    void testGetMarketValueByUserId_Success() throws Exception {
        List<Map<String, Object>> marketValues = List.of(Map.of("propertyId", 101, "marketValue", new BigDecimal("50000")));

        when(investorService.getMarketValueByUserId("1")).thenReturn(marketValues);

        mockMvc.perform(get("/api/investor/market-value/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].propertyId").value(101))
                .andExpect(jsonPath("$[0].marketValue").value(50000));
    }
}
