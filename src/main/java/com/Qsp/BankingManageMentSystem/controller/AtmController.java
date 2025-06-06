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
import com.Qsp.BankingManageMentSystem.service.AtmService;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AtmController {
	@Autowired
	AtmService atmService;

	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	
	@PostMapping("/saveAtm")
	public ResponseEntity<ResponseStructure<Atm>> saveAtm(@RequestBody Atm atm) {
		return atmService.saveAtm(atm);
	}
	@Operation
	(summary = "fetch Atm", description = "API is used to fetch the Atm")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "302", description = "Successfully fetched"),
			@ApiResponse (responseCode = "404", description = "Atm not found for the given id") })
	@GetMapping("/fetchAtmById")
	public ResponseEntity<ResponseStructure<Atm>> fetchAtmById(@RequestParam int atmId) {
		return atmService.fetchAtmById(atmId);
	}
	@Operation
	(summary = "Delete Atm", description = "API is used to delete the Atm")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "200", description = "Successfully created"),
			@ApiResponse (responseCode = "404", description = "Atm not found for the given id") })
	@DeleteMapping("/deleteAtmById")
	public ResponseEntity<ResponseStructure<Atm>> deleteAtmById(@RequestParam int atmId) {
		ResponseEntity<ResponseStructure<Atm>> atm = fetchAtmById(atmId);
		atmService.deleteAtmById(atmId);
		return atm;
	}
	@Operation
	(summary = "update Atm", description = "API is used to update the Atm")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "200", description = "Successfully updated"),
			@ApiResponse (responseCode = "404", description = "Atm not found for the given id") })

	@PutMapping("/updateAtmById")
	public ResponseEntity<ResponseStructure<Atm>> updateAtmById(@RequestParam int oldAtmId, @RequestBody Atm newAtm) {
		newAtm.setAtmId(oldAtmId);
		return atmService.saveAtm(newAtm);

	}

	@GetMapping("/fetchAllAtms")
	public List<Atm> fetchAllAtms() {
		return atmService.fetchAllAtms();

	}

}
