package com.Qsp.BankingManageMentSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Qsp.BankingManageMentSystem.dto.Customer;
import com.Qsp.BankingManageMentSystem.dto.Employee;
import com.Qsp.BankingManageMentSystem.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepo employeeRepo;

	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
//	Optional<Owner> owner=ownerRepo.findById(OwnerId);
//	if(owner.isEmpty()) {
//		return null;
//	}
//	else {
//		return owner.get();
//	}
	
	public Employee fetchEmployeeById(int employeeId) {
		Optional<Employee>employee=employeeRepo.findById(employeeId);
		if(employee.isEmpty()) {
			return null;
		}
		else {
			return employee.get();
		}
 	}

	public Employee deleteEmployeeById(int EmployeeId) {
		Employee employee = fetchEmployeeById(EmployeeId);
		employeeRepo.deleteById(EmployeeId);
		return employee;
	}

	public Employee updateEmployeeById(int oldEmployeeId, Employee newEmployee) {
		newEmployee.setEmployeeId(oldEmployeeId);
		return employeeRepo.save(newEmployee);

	}

	public List<Employee> fetchAllEmployees() {
		return employeeRepo.findAll();

	}

}
