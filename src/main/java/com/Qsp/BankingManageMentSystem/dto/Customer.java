package com.Qsp.BankingManageMentSystem.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	private long customerPhone;
	private String customerEmail;
	private int customerAge;
	private String customerGender;
	
	
	//no need to disturb account if we use cascade
			@OneToMany(cascade = CascadeType.ALL)
			private List<Account> accounts;
			
			//no need to disturb loans if we use cascade
			@OneToMany(cascade = CascadeType.ALL)
			private List<Loan> loans;
			
			
			//no need to disturb card if we use cascade
			@OneToMany(cascade = CascadeType.ALL)
			private List<Card> cards;
			
			public List<Account> getAccounts() {
				return accounts;
			}

			public void setAccounts(List<Account> accounts) {
				this.accounts = accounts;
			}

			public List<Loan> getLoans() {
				return loans;
			}

			public void setLoans(List<Loan> loans) {
				this.loans = loans;
			}

			public List<Card> getCards() {
				return cards;
			}

			public void setCards(List<Card> cards) {
				this.cards = cards;
			}

		

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(long customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

}
