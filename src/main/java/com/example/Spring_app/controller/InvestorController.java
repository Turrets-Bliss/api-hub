package com.example.Spring_app.controller;

import com.example.Spring_app.dto.InvestorDTO;
import com.example.Spring_app.service.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/investor")
public class InvestorController {

    @Autowired
    private InvestorService investorService;

    // 1. Endpoint for fetching all data for a specific user
    @GetMapping("/details/{userId}")
    public List<InvestorDTO> getInvestorDetails(@PathVariable Long userId) {
        return investorService.getInvestorDetails(userId); // Now returns a list of InvestorDTO
    }

    // 2. Endpoint for fetching ROI for a specific user
    @GetMapping("/roi/{userId}")
    public Map<String, BigDecimal> getRoiByUserId(@PathVariable Long userId) {
        return investorService.getRoiByUserId(userId);
    }

    // 3. Endpoint for fetching current investments for a specific user
    @GetMapping("/investments/{userId}")
    public List<Map<String, Object>> getInvestmentsByUserId(@PathVariable Long userId) {
        return investorService.getInvestmentsByUserId(userId); // Now returns a list of maps with only the required keys
    }

    // 4. Endpoint for fetching current market value for a specific user
    @GetMapping("/market-value/{userId}")
    public List<Map<String, Object>> getMarketValueByUserId(@PathVariable Long userId) {
        return investorService.getMarketValueByUserId(userId); // Now returns a list of maps with only the required keys
    }

}
