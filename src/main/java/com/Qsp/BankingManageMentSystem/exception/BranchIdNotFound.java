package com.Qsp.BankingManageMentSystem.exception;

public class BranchIdNotFound extends RuntimeException {
public String Message="Branch Not Found in Db";
public String getMessage() {
	return Message;
	
}
}
