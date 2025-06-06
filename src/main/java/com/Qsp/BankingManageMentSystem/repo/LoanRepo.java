package com.Qsp.BankingManageMentSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Qsp.BankingManageMentSystem.dto.Loan;

public interface LoanRepo extends JpaRepository<Loan,Integer> {

}
