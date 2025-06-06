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

import com.Qsp.BankingManageMentSystem.dto.Account;
import com.Qsp.BankingManageMentSystem.dto.Card;
import com.Qsp.BankingManageMentSystem.dto.Customer;
import com.Qsp.BankingManageMentSystem.dto.Loan;
import com.Qsp.BankingManageMentSystem.service.CustomerService;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	
	// one to many(customer to accounts)
	
	@PutMapping("/addExistingCustomerToExistingAccount")
	public Customer addExistingCustomerToExistingAccount(int Accountid, int Customerid) {
	return customerService.addExistingCustomerToExistingAccount(Accountid, Customerid);
	}
	@PutMapping("/addnewAccountToExistingCustomer")
		public Customer addnewAccountToExistingCustomer(@RequestParam int customerId,@RequestParam Account newAccount) {

			return customerService.addnewAccountToExistingCustomer(customerId, newAccount);

		}
		// one to many(customer to Loan)
	@PutMapping("/addExistingCustomerToExistingloan")
	public Customer addExistingCustomerToExistingloan(int  loanid, int Customerid) {
	return customerService.addExistingCustomerToExistingloan(loanid, Customerid);
	}

@PutMapping("/addnewLoanToExistingCustomer")
		public Customer addnewLoanToExistingCustomer(@RequestParam int customerId,@RequestParam Loan newlLoan) {

			return customerService.addnewLoanToExistingCustomer(customerId, newlLoan);
		}

	//one to many(customer to Cards)
@PutMapping("/addExistingCustomerToExistingCards")
public Customer addExistingCustomerToExistingCards(int CardId, int Customerid) {
return customerService.addExistingCustomerToExistingCards(CardId, Customerid);
}
@PutMapping("/addnewCardToExistingCustomer")
		public Customer addnewCardToExistingCustomer(@RequestParam int customerId,@RequestParam Card newCard) {

			return customerService.addnewCardToExistingCustomer(customerId, newCard);
		}
		
@Operation
(summary = "Save customer", description = "API is used to save the customer")
@ApiResponses
(value = { @ApiResponse (responseCode = "201", description = "Successfully saved"),
		@ApiResponse (responseCode = "404", description = "customer not found for the given id") })
	@PostMapping("/saveCustomer")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
@Operation
(summary = "fetch customer", description = "API is used to fetch the customer")
@ApiResponses
(value = { @ApiResponse (responseCode = "301", description = "Successfully fetched"),
		@ApiResponse (responseCode = "404", description = "customer not found for the given id") })
	@GetMapping("/fetchCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> fetchCustomerById(@RequestParam int customrId) {
		return customerService.fetchCustomerById(customrId);
	}
@Operation
(summary = "deleteCustomer", description = "API is used to delete the customer")
@ApiResponses
(value = { @ApiResponse (responseCode = "200", description = "Successfully deleted"),
		@ApiResponse (responseCode = "404", description = "customer not found for the given id") })
	@DeleteMapping("/deleteCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(@RequestParam int customerId) {
		ResponseEntity<ResponseStructure<Customer>> customer = fetchCustomerById(customerId);
		customerService.deleteCustomerById(customerId);
		return customer;
	}
@Operation
(summary = "update Customer", description = "API is used to update the customer")
@ApiResponses
(value = { @ApiResponse (responseCode = "200", description = "Successfully updated"),
		@ApiResponse (responseCode = "404", description = "customer not found for the given id") })
	@PutMapping("/updateCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomerById(@RequestParam int oldCustomerId, @RequestBody Customer newCustomer) {
		newCustomer.setCustomerId(oldCustomerId);
		return customerService.saveCustomer(newCustomer);

	}

	@GetMapping("/fetchAllCustomers")
	public List<Customer> fetchAllCustomers() {
		return customerService.fetchAllCustomers();

	}

}
