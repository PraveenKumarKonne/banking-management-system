package com.Qsp.BankingManageMentSystem.exception;

public class LoanIdNotFound extends RuntimeException {
	public String Message="Loan not foound in db";

			public String getMessage() {
		return Message;
	}

}
