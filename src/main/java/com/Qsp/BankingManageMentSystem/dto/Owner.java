package com.Qsp.BankingManageMentSystem.dto;
import com.Qsp.BankingManageMentSystem.dto.Bank;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerId;
	private String ownerName;
	private long ownerPhone;
	private double ownerNetworth;
	
	//no need of disturbing bank class if we use cascade
	@OneToOne(cascade = CascadeType.ALL)
	private Bank bank;

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public long getOwnerPhone() {
		return ownerPhone;
	}

	public void setOwnerPhone(long ownerPhone) {
		this.ownerPhone = ownerPhone;
	}

	public double getOwnerNetworth() {
		return ownerNetworth;
	}

	public void setOwnerNetworth(double ownerNetworth) {
		this.ownerNetworth = ownerNetworth;
	}

}
