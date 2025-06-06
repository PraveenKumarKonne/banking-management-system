package com.Qsp.BankingManageMentSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Qsp.BankingManageMentSystem.dto.Account;
import com.Qsp.BankingManageMentSystem.dto.Atm;
import com.Qsp.BankingManageMentSystem.dto.Bank;
import com.Qsp.BankingManageMentSystem.dto.Branch;
import com.Qsp.BankingManageMentSystem.dto.Card;
import com.Qsp.BankingManageMentSystem.dto.Customer;
import com.Qsp.BankingManageMentSystem.dto.Employee;
import com.Qsp.BankingManageMentSystem.dto.Loan;
import com.Qsp.BankingManageMentSystem.repo.CustomerRepo;
@Repository
public class CustomerDao {
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	AccountDao accountDao;
	 @Autowired
	 LoanDao loanDao;
	 @Autowired
	 CardDao cardDao;
	
	
	
//	//One to many(Bank to atms)
//public Bank addNewAtmToExistingBank(int bankid,Atm newAtm) {
//			Bank bank = fetchBankById(bankid);
//			List<Atm> list = bank.getAtms();
//			list.add(newAtm);
//			bank.setAtms(list);
//			return saveBank(bank);
//		}
	
	//one to many(customer to accounts)
	
	public Customer addExistingCustomerToExistingAccount(int Accountid, int Customerid) {
		Account  account = accountDao.fetchAccountById(Accountid);
		Customer  customer = fetchCustomerById(Customerid);
		List<Account> list = customer.getAccounts();
		list.add(account);
		customer.setAccounts(list);

		return saveCustomer(customer);

	}
	public Customer addnewAccountToExistingCustomer(int customerId,Account newAccount) {
		Customer customer=fetchCustomerById(customerId);
		List<Account>list=customer.getAccounts();
		list.add(newAccount);
		customer.setAccounts(list);
				
		return saveCustomer(customer);
		
	}
	//one to many(customer to Loan)
	public Customer addExistingCustomerToExistingloan(int  loanid, int Customerid) {
		 Loan loan = loanDao.fetchLoanById(loanid);
		Customer  customer = fetchCustomerById(Customerid);
		List<Loan> list = customer.getLoans();
		list.add(loan);
		customer.setLoans(list);

		return saveCustomer(customer);}

public Customer addnewLoanToExistingCustomer(int customerId,Loan newlLoan) {
	Customer customer=fetchCustomerById(customerId);
	List<Loan>list=customer.getLoans();
	list.add(newlLoan);
	customer.setLoans(list);
	
	return saveCustomer(customer);
	}	
	

//one to many(customer to Cards)
public Customer addExistingCustomerToExistingCards(int CardId, int Customerid) {
	Card card = cardDao.fetchCardById(CardId);
	Customer  customer = fetchCustomerById(Customerid);
	List<Card> list = customer.getCards();
	list.add(card);
	customer.setCards(list);

	return saveCustomer(customer);
}
public Customer addnewCardToExistingCustomer(int customerId,Card newCard) {
	Customer customer=fetchCustomerById(customerId);
	List<Card>list=customer.getCards();
	list.add(newCard);
	customer.setCards(list);
	return saveCustomer(customer);
}
	
	public Customer saveCustomer( Customer customer) {
		return customerRepo.save(customer);
		}


	public Customer fetchCustomerById(int customrId) {
		Optional<Customer>customer=customerRepo.findById(customrId);
		if(customer.isEmpty()) {
			return null;
		}
		else {
			return customer.get();
			}
 		}

	public Customer deleteCustomerById(int customerId) {
		Customer customer=fetchCustomerById(customerId);
		customerRepo.deleteById(customerId);
		return  customer;
	}

	public Customer updateCustomerById(int oldCustomerId,Customer newCustomer) {
	  newCustomer.setCustomerId(oldCustomerId);
		return customerRepo.save(newCustomer);

	}
	public List<Customer>  fetchAllCustomers() {
		return customerRepo.findAll();
		
	}

}
