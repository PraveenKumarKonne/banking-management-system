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

import com.Qsp.BankingManageMentSystem.dto.Branch;
import com.Qsp.BankingManageMentSystem.dto.Customer;
import com.Qsp.BankingManageMentSystem.dto.Employee;
import com.Qsp.BankingManageMentSystem.service.BranchService;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BranchController {
	@Autowired
	BranchService branchService;

	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@PostMapping("/SaveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}

//one to one 
	@PutMapping("/addExistingManagerToExistingBranch")
	public Branch addExistingManagerToExistingBranch(@RequestParam int branchId, @RequestParam int ManagerId) {

		return branchService.addExistingManagerToExistingBranch(branchId, ManagerId);
	}

	// One to one
	@PutMapping("/addExistingAddressToExistingBranch")
	public Branch addExistingAddressToExistingBranch(@RequestParam int branchid, @RequestParam int AddressId) {

		return branchService.addExistingAddressToExistingBranch(branchid, AddressId);

	}

//one to  many(Branch to Employees) 
	@PutMapping("/addExistingBranchToExistingEmployee")
	public Branch addExistingBranchToExistingEmployee(@RequestParam int branchId, @RequestParam int EmployeeId) {

		return branchService.addExistingBranchToExistingEmployee(branchId, EmployeeId);

	}

	public Branch addNewEmployeeToExistingBranch(int branchId, Employee employee) {
		return branchService.addNewEmployeeToExistingBranch(branchId, employee);

	}

//one to many(Brannch to customers)
	@PutMapping("/addExistingBrachToExistingCustomers")
	public Branch addExistingBrachToExistingCustomers(@RequestParam int brachId, @RequestParam int CustomerId) {
		return branchService.addExistingBrachToExistingCustomers(brachId, CustomerId);

	}

	public Branch addNewBranchToExistingCustomer(int branchId, Customer customer) {
		return branchService.addNewBranchToExistingCustomer(branchId, customer);

	}

	@Operation(summary = "fetch Banch", description = "API is used to fetch the Banch")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully fetched"),
			@ApiResponse(responseCode = "404", description = "Banch not found for the given id") })
	@GetMapping("/fetchBranchById")
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(@RequestParam int BranchId) {
		return branchService.fetchBranchById(BranchId);
	}

	@Operation(summary = "Delete Banch", description = "API is used to delete the Banch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Banch not found for the given id") })
	@DeleteMapping("/deleteBranchById")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(@RequestParam int BranchId) {
		ResponseEntity<ResponseStructure<Branch>> branch = fetchBranchById(BranchId);
		branchService.deleteBranchById(BranchId);
		return branch;
	}

	@Operation(summary = "update Banch", description = "API is used to update the Banch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Banch not found for the given id") })
	@GetMapping("/updateBranchById")
	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(@RequestParam int OldBranchId,
			@RequestBody Branch NewBranch) {
		NewBranch.setBranchId(OldBranchId);
		return branchService.saveBranch(NewBranch);

	}

	@GetMapping("/fetchAllBranch")
	public List<Branch> fetchAllBranch() {
		return branchService.fetchAllBranch();

	}

}
