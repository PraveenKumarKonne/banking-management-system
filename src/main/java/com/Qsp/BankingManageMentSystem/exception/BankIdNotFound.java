package com.Qsp.BankingManageMentSystem.exception;

public class BankIdNotFound extends RuntimeException {
	public String Message="Bank Not Found in Db";
	public String getMessage() {
		return Message;
		
	}

}
