package com.Qsp.BankingManageMentSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Qsp.BankingManageMentSystem.dto.Employee;

public interface EmployeeRepo extends  JpaRepository<Employee,Integer> {

}
