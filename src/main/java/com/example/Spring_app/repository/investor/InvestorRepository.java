package com.example.Spring_app.repository.investor;

import com.example.Spring_app.entity.Investor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, String> {
    // Retrieve all investments for a specific user
    List<Investor> findByUserId(String userId);

    // Retrieve all investments for a specific user and year
    List<Investor> findByUserIdAndYearOfInvestment(String userId, Integer yearOfInvestment);

    // Delete by userId
    @Modifying
    @Transactional
    @Query("DELETE FROM Investor i WHERE i.userId = :userId")
    void deleteByUserId(String userId);
}
