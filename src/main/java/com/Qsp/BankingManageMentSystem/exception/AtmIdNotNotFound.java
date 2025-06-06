package com.Qsp.BankingManageMentSystem.exception;

public class AtmIdNotNotFound extends RuntimeException {
	public String Message="Atm not found in Db";
	public String getMessage() {
		return Message;
		
	}

}
