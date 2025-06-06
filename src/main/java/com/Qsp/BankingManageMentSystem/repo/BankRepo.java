package com.Qsp.BankingManageMentSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Qsp.BankingManageMentSystem.dto.Bank;

public interface BankRepo extends JpaRepository<Bank, Integer> {

}
