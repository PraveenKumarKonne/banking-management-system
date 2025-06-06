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

import com.Qsp.BankingManageMentSystem.dto.Manager;
import com.Qsp.BankingManageMentSystem.service.ManagerService;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ManagerController {
	@Autowired
	ManagerService managerService;

	@Operation(summary = " SaveManager", description = "API is used to Save the Manager")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully saved"),
			@ApiResponse(responseCode = "404", description = "Manager not found for the given id") })
	@PostMapping("/saveManager")
	public ResponseEntity<ResponseStructure<Manager>> saveManager(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}

	@Operation(summary = "fetchManager", description = "API is used to fetch the Manager")
	@ApiResponses(value = { @ApiResponse(responseCode = "301", description = "Successfully fetched"),
			@ApiResponse(responseCode = "404", description = "manager not found for the given id") })
	@GetMapping("/fetchManagerById")
	public ResponseEntity<ResponseStructure<Manager>> fetchManagerById(@RequestParam int ManagerId) {
		return managerService.fetchManagerById(ManagerId);
	}

	@Operation(summary = "deletemanager Owner", description = "API is used to delete the manager")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "manager not found for the given id") })
	@DeleteMapping("/deleteManagerById")
	public ResponseEntity<ResponseStructure<Manager>> deleteManagerById(@RequestParam int ManagerId) {
		ResponseEntity<ResponseStructure<Manager>> manager = fetchManagerById(ManagerId);
		managerService.deleteManagerById(ManagerId);
		return manager;
	}

	@Operation(summary = "update manager", description = "API is used to update the manager")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "manager not found for the given id") })
	@PutMapping("/updateManagerById")
	public ResponseEntity<ResponseStructure<Manager>> updateManagerById(@RequestParam int oldManagerId,
			@RequestBody Manager newManager) {
		newManager.setManagerID(oldManagerId);
		return managerService.saveManager(newManager);

	}

	@GetMapping("/fetchAllManager")
	public List<Manager> fetchAllManager() {
		return managerService.fetchAllManager();

	}
}
