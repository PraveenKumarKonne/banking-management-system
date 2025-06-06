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

import com.Qsp.BankingManageMentSystem.dto.Address;
import com.Qsp.BankingManageMentSystem.service.AddressService;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AddressController {
	@Autowired
	AddressService addressService;
	@Operation
	(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "201", description = "Successfully created"),
			@ApiResponse (responseCode = "404", description = "Owner not found for the given id") })
	@PostMapping("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}

	@Operation
	(summary = "fetch Address", description = "API is used to fetch the Address")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "302", description = "Successfully fetched"),
			@ApiResponse (responseCode = "404", description = "Address not found for the given id") })
	@GetMapping("/fetchAddressById")
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(@RequestParam int addressId) {
		return addressService.fetchAddressById(addressId);
	}
	@Operation
	(summary = "Delete Address", description = "API is used to delete the Address")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "200", description = "Successfully created"),
			@ApiResponse (responseCode = "404", description = "Address not found for the given id") })
	@DeleteMapping("/deleteAddressById")
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(@RequestParam int addressId) {
		ResponseEntity<ResponseStructure<Address>> address = fetchAddressById(addressId);
		addressService.deleteAddressById(addressId);
		return address;
	}
	@Operation
	(summary = "update Address", description = "API is used to update the Address")
	@ApiResponses
	(value = { @ApiResponse (responseCode = "200", description = "Successfully updated"),
			@ApiResponse (responseCode = "404", description = "Address not found for the given id") })
	@PutMapping("/updateAddressById")
	public ResponseEntity<ResponseStructure<Address>> updateAddressById(@RequestParam int oldAddressId, @RequestBody Address newAddress) {
		newAddress.setAddressid(oldAddressId);
		return addressService.saveAddress(newAddress);

	}

	@GetMapping("/fetchAllAddresses")
	public List<Address> fetchAllAddresses() {
		return addressService.fetchAllAddresses();

	}

}
