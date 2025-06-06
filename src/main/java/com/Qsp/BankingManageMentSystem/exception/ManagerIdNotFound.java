package com.Qsp.BankingManageMentSystem.exception;

public class ManagerIdNotFound extends RuntimeException{
	public String message="manager not Found in db";
	
	public String getMessage() {
		return message;
		
	}	

}
