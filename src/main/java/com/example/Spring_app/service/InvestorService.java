package com.example.Spring_app.service;

import com.example.Spring_app.dto.InvestorDTO;
import com.example.Spring_app.entity.Investor;
import com.example.Spring_app.repository.investor.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class InvestorService {

    @Autowired
    private InvestorRepository investorRepository;

    // Fetch all data for a specific user
    public List<InvestorDTO> getInvestorDetails(String userId) {
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
    public Map<String, BigDecimal> getRoiByUserId(String userId) {
        List<Investor> investors = getInvestorsByUserId(userId);

        if (investors == null || investors.isEmpty()) {
            System.out.println("No investors found with userId: " + userId);
            return Collections.emptyMap(); // Return an empty map instead of null
        }

        // Get the max values
        BigDecimal maxMarketValue = investors.stream()
                .map(Investor::getCurrentMarketValue)
                .filter(Objects::nonNull)
                .sorted(Comparator.reverseOrder())  // Sorting in descending order
                .findFirst()  // Find the first element after sorting
                .orElse(BigDecimal.ZERO);

        BigDecimal maxInvestment = investors.stream()
                .map(Investor::getCurrentInvestments)
                .filter(Objects::nonNull)
                .sorted(Comparator.reverseOrder())  // Sorting in descending order
                .findFirst()  // Find the first element after sorting
                .orElse(BigDecimal.ZERO);

        // Calculate ROI
        BigDecimal roi = maxMarketValue.subtract(maxInvestment);

        // Calculate Max Investment (maxInvestment * 10)
        BigDecimal maxInvestments = maxInvestment.multiply(BigDecimal.TEN);

        // Create response map
        Map<String, BigDecimal> response = new HashMap<>();
        response.put("ROI", roi);
        response.put("Max Value", maxInvestments);
        response.put("Current Investment", maxInvestment);

        return response;
    }


    // Fetch only current investments for a specific user
    public List<Map<String, Object>> getInvestmentsByUserId(String userId) {
        // Fetch all investments by the given userId
        List<Investor> investors = getInvestorsByUserId(userId);  // Ensure getInvestorsByUserId is correct
        if (investors == null || investors.isEmpty()) {
            System.out.println("No investors found with userId: " + userId);
            return Collections.emptyList(); // Return an empty list instead of null
        }

        List<Map<String, Object>> responseList = new ArrayList<>();
        for (Investor investor : investors) {
            // Create a map for each investor's investment data
            Map<String, Object> investmentData = new HashMap<>();

            // Add the investment data to the map
            investmentData.put("currentInvestments", investor.getCurrentInvestments());
            investmentData.put("yearOfInvestment", investor.getYearOfInvestment());
            investmentData.put("currentMarketValue", investor.getCurrentMarketValue());


            // Add the map to the response list
            responseList.add(investmentData);
        }

        return responseList;
    }

    // Fetch only current market value for a specific user
    public List<Map<String, Object>> getMarketValueByUserId(String userId) {
        List<Investor> investors = getInvestorsByUserId(userId);
        if (investors == null || investors.isEmpty()) {
            System.out.println("No investors found with userId: " + userId);
            return Collections.emptyList(); // Return an empty list instead of null
        }

        List<Map<String, Object>> responseList = new ArrayList<>();
        for (Investor investor : investors) {
            Map<String, Object> marketValueData = new HashMap<>();
            marketValueData.put("currentMarketValue", investor.getCurrentMarketValue());
            marketValueData.put("yearOfInvestment", investor.getYearOfInvestment());
            responseList.add(marketValueData);
        }
        return responseList;
    }

    // Private helper method to fetch investors by user ID (returns a list of investors)
    private List<Investor> getInvestorsByUserId(String userId) {
        return investorRepository.findByUserId(userId); // Assuming this returns List<Investor>
    }

    public InvestorDTO addInvestor(InvestorDTO investorDTO) {
        Investor investor = new Investor();
        investor.setUserId(investorDTO.getUserId());
        investor.setYearOfInvestment(investorDTO.getYearOfInvestment());
        investor.setPropertyId(investorDTO.getPropertyId());
        investor.setCurrentMarketValue(investorDTO.getCurrentMarketValue());
        investor.setCurrentInvestments(investorDTO.getCurrentInvestments());
        investor.setRoi(investorDTO.getRoi());

        // Save the new investor entry to the database
        investor = investorRepository.save(investor);

        return investorDTO;
    }

    public boolean deleteInvestorByUserId(String userId) {
        List<Investor> investors = investorRepository.findByUserId(userId);
        if (investors.isEmpty()) {
            return false;
        }
        investorRepository.deleteAll(investors);
        return true;
    }

}
