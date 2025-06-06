package com.Qsp.BankingManageMentSystem.exception;

public class CustomerIdNotFound extends RuntimeException{
	public String Message="Customer Not found In Db";
	
	public String getMessage() {
		return Message;
	}
			
			
	

}
