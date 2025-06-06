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

import com.Qsp.BankingManageMentSystem.dto.Owner;
import com.Qsp.BankingManageMentSystem.service.OwnerService;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
public class OwnerController {
	@Autowired
	OwnerService ownerService;
	
	
	@Operation
	(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "201", description = "Successfully created"),
			@ApiResponse (responseCode = "404", description = "Owner not found for the given id") })
	@PostMapping("/SaveOwner")
	public ResponseEntity<ResponseStructure<Owner>> saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}
	
	

	@PutMapping("/addExistingBankToExistingOwner")
	public Owner addExistingBankToExistingOwner(@RequestParam int bankId, @RequestParam int ownerId) {
		return ownerService.addExistingBankToExistingOwner(bankId, ownerId);

	}
	@Operation
	(summary = "fetch Owner", description = "API is used to fetch the Owner")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "302", description = "Successfully fetched"),
			@ApiResponse (responseCode = "404", description = "Owner not found for the given id") })
	@GetMapping("/fetchOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(@RequestParam int OwnerId) {
		return ownerService.fetchOwnerById(OwnerId);
	}
	@Operation
	(summary = "Delete Owner", description = "API is used to delete the Owner")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "200", description = "Successfully created"),
			@ApiResponse (responseCode = "404", description = "Owner not found for the given id") })
	@DeleteMapping("/deleteOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(@RequestParam int OwnerId) {
		ResponseEntity<ResponseStructure<Owner>> owner = fetchOwnerById(OwnerId);
		ownerService.deleteOwnerById(OwnerId);

		return owner;
	}
	@Operation
	(summary = "update Owner", description = "API is used to update the Owner")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "200", description = "Successfully updated"),
			@ApiResponse (responseCode = "404", description = "Owner not found for the given id") })

	@PutMapping("/updateOwnerById")
	public ResponseStructure<Owner> updateOwnerById(@RequestParam int OldOwnerdId, @RequestBody Owner NewOwner) {
		NewOwner.setOwnerId(OldOwnerdId);
		return ownerService.updateOwnerById(OldOwnerdId, NewOwner);

	}

	@GetMapping("/fetchAllOwner")
	public List<Owner> fetchAllOwner() {
		return ownerService.fetchAllOwner();

	}
}
