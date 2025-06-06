package com.Qsp.BankingManageMentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Qsp.BankingManageMentSystem.dao.CustomerDao;
import com.Qsp.BankingManageMentSystem.dto.Account;
import com.Qsp.BankingManageMentSystem.dto.Card;
import com.Qsp.BankingManageMentSystem.dto.Customer;
import com.Qsp.BankingManageMentSystem.dto.Loan;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;

@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;
	@Autowired
	ResponseStructure<Customer> responseStructure;

	// one to many(customer to accounts)
	public Customer addExistingCustomerToExistingAccount(int Accountid, int Customerid) {
		return customerDao.addExistingCustomerToExistingAccount(Accountid, Customerid);
	}

	public Customer addnewAccountToExistingCustomer(int customerId, Account newAccount) {

		return customerDao.addnewAccountToExistingCustomer(customerId, newAccount);

	}
	// one to many(customer to Loan)
	
	public Customer addExistingCustomerToExistingloan(int  loanid, int Customerid) {
	return customerDao.addExistingCustomerToExistingloan(loanid, Customerid);
	}

	public Customer addnewLoanToExistingCustomer(int customerId, Loan newlLoan) {

		return customerDao.addnewLoanToExistingCustomer(customerId, newlLoan);
	}

//one to many(customer to Cards)
	public Customer addExistingCustomerToExistingCards(int CardId, int Customerid) {
	return customerDao.addExistingCustomerToExistingCards(CardId, Customerid);
	}

	public Customer addnewCardToExistingCustomer(int customerId, Card newCard) {

		return customerDao.addnewCardToExistingCustomer(customerId, newCard);
	}
	
	

	public  ResponseEntity<ResponseStructure<Customer>>  saveCustomer(Customer customer) {
		responseStructure.setMessage("Successfully created Customer");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(customerDao.saveCustomer(customer));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Customer>> fetchCustomerById(int customrId) {
		responseStructure.setMessage("successfully Fetched Customer");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(customerDao.fetchCustomerById(customrId));
		return new  ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.FOUND);	}

	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(int customerId) {
		responseStructure.setMessage("successfully  deleted Customer");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.deleteCustomerById(customerId));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.OK);
	}

	public ResponseStructure<Customer> updateCustomerById(int oldCustomerId, Customer newCustomer) {
		responseStructure.setMessage("successfully updated Customer");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.updateCustomerById(oldCustomerId, newCustomer));
		return responseStructure;

	}

	public List<Customer> fetchAllCustomers() {
		return customerDao.fetchAllCustomers();

	}

}
