package com.Qsp.BankingManageMentSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Qsp.BankingManageMentSystem.dto.Customer;

public interface CustomerRepo extends  JpaRepository<Customer,Integer> {

}
