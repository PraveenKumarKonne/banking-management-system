package com.Qsp.BankingManageMentSystem.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.Qsp.BankingManageMentSystem.dto.Owner;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;

@RestController
public class ApplicationExceptionHandler {
	@Autowired
	ResponseStructure<String> responseStructure;
	
 @ExceptionHandler
	(OwnerIdNotFount.class)
	public ResponseEntity<ResponseStructure<String>> ownerIdNotFound(OwnerIdNotFount ownerIdNotFound){
		responseStructure.setMessage("Id Not Found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ownerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
 
 
}
