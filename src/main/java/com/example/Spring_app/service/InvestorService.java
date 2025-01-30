package com.example.Spring_app.service;

import com.example.Spring_app.dto.InvestorDTO;
import com.example.Spring_app.entity.Investor;
import com.example.Spring_app.repository.investor.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvestorService {

    @Autowired
    private InvestorRepository investorRepository;

    // Fetch all data for a specific user
    public List<InvestorDTO> getInvestorDetails(Long userId) {
        List<Investor> investors = getInvestorsByUserId(userId);

        if (investors == null || investors.isEmpty()) {
            // Log if no investors found
            System.out.println("No investors found with userId: " + userId);
            return null; // or throw an exception based on your use case
        }

        List<InvestorDTO> investorDTOList = new ArrayList<>();
        for (Investor investor : investors) {
            InvestorDTO investorDTO = new InvestorDTO();
            investorDTO.setUserId(investor.getUserId());
            investorDTO.setYearOfInvestment(investor.getYearOfInvestment());
            investorDTO.setPropertyId(investor.getPropertyId());
            investorDTO.setCurrentMarketValue(investor.getCurrentMarketValue());
            investorDTO.setCurrentInvestments(investor.getCurrentInvestments());
            investorDTO.setRoi(investor.getRoi());
            investorDTOList.add(investorDTO);
        }
        return investorDTOList;
    }

    // Fetch only ROI for a specific user
    public List<BigDecimal> getRoiByUserId(Long userId) {
        List<Investor> investors = getInvestorsByUserId(userId);
        if (investors == null || investors.isEmpty()) {
            System.out.println("No investors found with userId: " + userId);
            return null; // or throw an exception based on your use case
        }

        List<BigDecimal> rois = new ArrayList<>();
        for (Investor investor : investors) {
            rois.add(investor.getRoi());
        }
        return rois;
    }

    // Fetch only current investments for a specific user
    public List<BigDecimal> getInvestmentsByUserId(Long userId) {
        List<Investor> investors = getInvestorsByUserId(userId);
        if (investors == null || investors.isEmpty()) {
            System.out.println("No investors found with userId: " + userId);
            return null; // or throw an exception based on your use case
        }

        List<BigDecimal> investments = new ArrayList<>();
        for (Investor investor : investors) {
            investments.add(investor.getCurrentInvestments());
        }
        return investments;
    }

    // Fetch only current market value for a specific user
    public List<BigDecimal> getMarketValueByUserId(Long userId) {
        List<Investor> investors = getInvestorsByUserId(userId);
        if (investors == null || investors.isEmpty()) {
            System.out.println("No investors found with userId: " + userId);
            return null; // or throw an exception based on your use case
        }

        List<BigDecimal> marketValues = new ArrayList<>();
        for (Investor investor : investors) {
            marketValues.add(investor.getCurrentMarketValue());
        }
        return marketValues;
    }

    // Private helper method to fetch investors by user ID (returns a list of investors)
    private List<Investor> getInvestorsByUserId(Long userId) {
        return investorRepository.findByUserId(userId); // Assuming this returns List<Investor>
    }
}
