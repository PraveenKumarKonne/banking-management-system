package com.Qsp.BankingManageMentSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Qsp.BankingManageMentSystem.dto.Employee;
import com.Qsp.BankingManageMentSystem.service.EmployeeService;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@Operation(summary = "saveEmployee ", description = "API is used to save the employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully saved"),
			@ApiResponse(responseCode = "404", description = "Employee not found for the given id") })
	@PostMapping("/saveEmployee")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	@Operation
	(summary = "fetch Employee", description = "API is used to fetch the employee")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "301", description = "Successfully fetched"),
			@ApiResponse (responseCode = "404", description = "employee not found for the given id") })
	@GetMapping("/fetchEmployeeById")
	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(@RequestParam int employeeId) {
		return employeeService.fetchEmployeeById(employeeId);
	}
	@Operation
	(summary = "deleteEmployee", description = "API is used to delete the employee")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "200", description = "Successfully deleted"),
			@ApiResponse (responseCode = "404", description = "employee not found for the given id") })
	@DeleteMapping("/deleteEmployeeById")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(@RequestParam int EmployeeId) {
		ResponseEntity<ResponseStructure<Employee>> employee = fetchEmployeeById(EmployeeId);
		employeeService.deleteEmployeeById(EmployeeId);
		return employee;
	}
	@Operation
	(summary = "update employee", description = "API is used to update the Owner")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "200", description = "Successfully updated"),
			@ApiResponse (responseCode = "404", description = "employee not found for the given id") })
	@PutMapping("/updateEmployeeById")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeById(@RequestParam int oldEmployeeId,
			@RequestBody Employee newEmployee) {
		newEmployee.setEmployeeId(oldEmployeeId);
		return employeeService.saveEmployee(newEmployee);

	}

	@GetMapping("/fetchAllEmployees")
	public List<Employee> fetchAllEmployees() {
		return employeeService.fetchAllEmployees();

	}

}
