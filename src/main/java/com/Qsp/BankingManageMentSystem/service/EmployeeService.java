package com.Qsp.BankingManageMentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Qsp.BankingManageMentSystem.dao.EmployeeDao;
import com.Qsp.BankingManageMentSystem.dto.Employee;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;
@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	ResponseStructure<Employee> responseStructure;
	
	public ResponseEntity<ResponseStructure<Employee>>  saveEmployee(Employee employee) {
		responseStructure.setMessage("Successfully saved Employee in db");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(employeeDao.saveEmployee(employee));
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Employee>>  fetchEmployeeById(int customrId) {
		responseStructure.setMessage("succecssfully fetched EmployeeBy Id");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(employeeDao.fetchEmployeeById(customrId));
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Employee>>  deleteEmployeeById(int EmployeeId) {
		responseStructure.setMessage("Successfully deleted Employee ");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(employeeDao.deleteEmployeeById(EmployeeId));
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.OK);
	}

	public ResponseStructure<Employee> updateEmployeeById(int oldEmployeeId, Employee newEmployee) {
		responseStructure.setMessage("successfully Updater employee");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(employeeDao.updateEmployeeById(oldEmployeeId, newEmployee));	
		return responseStructure;

	}

	public List<Employee> fetchAllEmployees() {
		return employeeDao.fetchAllEmployees();

	}

}
