package com.Qsp.BankingManageMentSystem.exception;

public class AddressIdNotFound extends RuntimeException {
	public String Message="Address Not found in Db";
	public String getMessage() {
		return Message;
		
	}

}
