package com.Qsp.BankingManageMentSystem.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressid;
	private String plotNumber;
	private String addressStreet;
	private int addressPincode;
	private String addressCity;
	private String aaddressState;

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getPlotNumber() {
		return plotNumber;
	}

	public void setPlotNumber(String plotNumber) {
		this.plotNumber = plotNumber;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public int getAddressPincode() {
		return addressPincode;
	}

	public void setAddressPincode(int addressPincode) {
		this.addressPincode = addressPincode;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAaddressState() {
		return aaddressState;
	}

	public void setAaddressState(String aaddressState) {
		this.aaddressState = aaddressState;
	}

}
