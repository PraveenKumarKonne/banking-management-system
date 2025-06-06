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

import com.Qsp.BankingManageMentSystem.dto.Atm;
import com.Qsp.BankingManageMentSystem.dto.Bank;
import com.Qsp.BankingManageMentSystem.dto.Branch;
import com.Qsp.BankingManageMentSystem.service.BankService;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BankController {
	@Autowired
	BankService bankService;

	// one to many(bank to banks)
	@PutMapping("/addExistingBranchToExistingBank")
	public Bank addExistingBranchToExistingBank(@RequestParam int branchId, @RequestParam int bankId) {
		return bankService.addExistingBranchToExistingBank(branchId, bankId);
	}

	@PutMapping("/addNewBranchToExistingBank")
	public Bank addNewBranchToExistingBank(int bankid, Branch newBranch) {
		return bankService.addExistingBranchToExistingBank(bankid, bankid);

	}

	// one to many(bank to atms)
	@PutMapping("/addExistingAtmToExistingBank")
	public Bank addExistingAtmToExistingBank(int branchId, int atmid) {
		return bankService.addExistingAtmToExistingBank(branchId, atmid);

	}
	@PutMapping("/addNewAtmToExistingBank")
	public Bank addNewAtmToExistingBank(@RequestParam int bankid, @RequestParam Atm newAtm) {
		return bankService.addNewAtmToExistingBank(bankid, newAtm);

	}
	@Operation
	(summary = "Save Bank", description = "API is used to save the Bank")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "201", description = "Successfully created"),
			@ApiResponse (responseCode = "404", description = "Bank not found for the given id") })
	@PostMapping("/SaveBank")
	public ResponseEntity<ResponseStructure<Bank>> saveBank(@RequestBody Bank bank) {
		return bankService.saveBank(bank);
	}
	@Operation
	(summary = "fetch Bank", description = "API is used to fetch the Bank")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "302", description = "Successfully fetched"),
			@ApiResponse (responseCode = "404", description = "Bank not found for the given id") })
	@GetMapping("/fetchBankByBId")
	public ResponseEntity<ResponseStructure<Bank>> fetchBankById(@RequestParam int BankId) {
		return bankService.fetchBankById(BankId);
	}
	@Operation
	(summary = "Delete Bank", description = "API is used to delete the Bank")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "200", description = "Successfully created"),
			@ApiResponse (responseCode = "404", description = "Bank not found for the given id") })
	@DeleteMapping("/deleteBankById")
	public ResponseEntity<ResponseStructure<Bank>> deleteBankById(@RequestParam int BankId) {
		ResponseEntity<ResponseStructure<Bank>> bank = fetchBankById(BankId);
		bankService.deleteBankById(BankId);
		return bank;
	}

	@Operation
	(summary = "update Bank", description = "API is used to update the Bank")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "200", description = "Successfully updated"),
			@ApiResponse (responseCode = "404", description = "Bank not found for the given id") })
	@PutMapping("/updateBankById")
	public ResponseEntity<ResponseStructure<Bank>> updateBankById(@RequestParam int OldBankId,
			@RequestBody Bank NewBank) {
		NewBank.setBankId(OldBankId);
		return bankService.saveBank(NewBank);

	}

	@GetMapping("/fetchAllBank")
	public List<Bank> fetchAllBank() {
		return bankService.fetchAllBank();

	}

}
