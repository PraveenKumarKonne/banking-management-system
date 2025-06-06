package com.Qsp.BankingManageMentSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Qsp.BankingManageMentSystem.dto.Account;

public interface AccountRepo extends JpaRepository<Account,Integer> {

}
