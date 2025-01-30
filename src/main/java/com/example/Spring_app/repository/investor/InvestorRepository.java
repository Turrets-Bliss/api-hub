package com.example.Spring_app.repository.investor;

import com.example.Spring_app.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {
    // Retrieve all investments for a specific user
    List<Investor> findByUserId(Long userId);

    // Retrieve all investments for a specific user and year
    List<Investor> findByUserIdAndYearOfInvestment(Long userId, Integer yearOfInvestment);
}
