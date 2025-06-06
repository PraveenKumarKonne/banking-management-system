package com.Qsp.BankingManageMentSystem.exception;

public class OwnerIdNotFount extends RuntimeException {
	private String message="ownerid  not found in Db";

			public String getMessage() {
		return message;
	}
}
