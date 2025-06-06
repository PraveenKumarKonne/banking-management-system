package com.Qsp.BankingManageMentSystem.exception;

public class CardIdNotFound extends RuntimeException {
	public String Message="Card not foound in Database";
	public String getMessage() {
		
		return Message;
	}

}
