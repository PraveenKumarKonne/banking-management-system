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

import com.Qsp.BankingManageMentSystem.dto.Loan;
import com.Qsp.BankingManageMentSystem.service.LoanService;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class LoanController {
	@Autowired
	LoanService loanService;
	@Operation
	(summary = "SaveLoan", description = "API is used to Save the loan")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "201", description = "Successfully saved"),
			@ApiResponse (responseCode = "404", description = "loan not found for the given id") })
	@PostMapping("/saveLoan")
	public ResponseEntity<ResponseStructure<Loan>> saveLoan(@RequestBody Loan loan) {
		return loanService.SaveLoan(loan);
	}
	@Operation
	(summary = "fetchLoan ", description = "API is used to fetch the loan")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "301", description = "Successfully fetched"),
			@ApiResponse (responseCode = "404", description = "loan not found for the given id") })
	@GetMapping("/fetchLoanById")
	public ResponseEntity<ResponseStructure<Loan>> fetchLoanById(@RequestParam int loanId) {
		return loanService.fetchLoanById(loanId);
	}
	@Operation
	(summary = "delete Loan ", description = "API is used to delete the loan")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "200", description = "Successfully deleted"),
			@ApiResponse (responseCode = "404", description = "loan not found for the given id") })
	@DeleteMapping("/deleteLoanById")
	public ResponseEntity<ResponseStructure<Loan>> deleteLoanById(@RequestParam int LoanId) {
		ResponseEntity<ResponseStructure<Loan>> loan = fetchLoanById(LoanId);
		loanService.deleteLoanById(LoanId);
		return loan;
	}
	@Operation
	(summary = "update loan", description = "API is used to update the loan")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "200", description = "Successfully updated"),
			@ApiResponse (responseCode = "404", description = "Owner not found for the given id") })
	@PutMapping("/updateLoanById")
	public ResponseEntity<ResponseStructure<Loan>> updateLoanById(@RequestParam int oldLoanId, @RequestBody Loan newLoan) {
		newLoan.setLoanId(oldLoanId);
		return loanService.SaveLoan(newLoan);

	}

	@GetMapping("/fetchAllLoans")
	public List<Loan> fetchAllLoans() {
		return loanService.fetchAllLoans();

	}

}
