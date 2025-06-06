package com.Qsp.BankingManageMentSystem.exception;

public class EmployeeIdNotFound extends RuntimeException{

	public String Message="Employee Not found in db";
	public String getMessage() {
		return Message;
		
	}
	
}
