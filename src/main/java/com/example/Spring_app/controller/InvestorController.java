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

    // 1. Fetch all data for a specific user
    @GetMapping("/details/{userId}")
    public List<InvestorDTO> getInvestorDetails(@PathVariable String userId) { // Changed Long to String
        return investorService.getInvestorDetails(userId);
    }

    // 2. Fetch ROI for a specific user
    @GetMapping("/roi/{userId}")
    public Map<String, BigDecimal> getRoiByUserId(@PathVariable String userId) { // Changed Long to String
        return investorService.getRoiByUserId(userId);
    }

    // 3. Fetch current investments for a specific user
    @GetMapping("/investments/{userId}")
    public List<Map<String, Object>> getInvestmentsByUserId(@PathVariable String userId) { // Changed Long to String
        return investorService.getInvestmentsByUserId(userId);
    }

    // 4. Fetch current market value for a specific user
    @GetMapping("/market-value/{userId}")
    public List<Map<String, Object>> getMarketValueByUserId(@PathVariable String userId) { // Changed Long to String
        return investorService.getMarketValueByUserId(userId);
    }

    // 5. Add investor
    @PostMapping("/create")
    public InvestorDTO addInvestor(@RequestBody InvestorDTO investorDTO) {
        return investorService.addInvestor(investorDTO);
    }
}

