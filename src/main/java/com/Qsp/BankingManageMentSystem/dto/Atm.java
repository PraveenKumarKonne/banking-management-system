package com.Qsp.BankingManageMentSystem.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Atm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int atmId;
	private String atmName;
	private String currencyType;
	private double cashAvailable;
	private int maxWithdeawalLimit;

	public int getAtmId() {
		return atmId;
	}

	public void setAtmId(int atmId) {
		this.atmId = atmId;
	}

	public String getAtmName() {
		return atmName;
	}

	public void setAtmName(String atmName) {
		this.atmName = atmName;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public double getCashAvailable() {
		return cashAvailable;
	}

	public void setCashAvailable(double cashAvailable) {
		this.cashAvailable = cashAvailable;
	}

	public int getMaxWithdeawalLimit() {
		return maxWithdeawalLimit;
	}

	public void setMaxWithdeawalLimit(int maxWithdeawalLimit) {
		this.maxWithdeawalLimit = maxWithdeawalLimit;
	}

}
