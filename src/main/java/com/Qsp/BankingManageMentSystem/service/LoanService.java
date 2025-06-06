package com.Qsp.BankingManageMentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Qsp.BankingManageMentSystem.dao.LoanDao;
import com.Qsp.BankingManageMentSystem.dto.Loan;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;
@Service
public class LoanService {
@Autowired
LoanDao loanDao;
@Autowired
ResponseStructure<Loan>responseStructure;
	
	
	public ResponseEntity<ResponseStructure<Loan>> SaveLoan(Loan loan ) {
		responseStructure.setMessage("Successfully Created  loan inDb");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(loanDao.svaeLoan(loan));
		return new ResponseEntity<ResponseStructure<Loan>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Loan>> fetchLoanById(int loanId) {
		responseStructure.setMessage("Successfully fetched loab inDb");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(loanDao.fetchLoanById(loanId));
		return new ResponseEntity<ResponseStructure<Loan>>(responseStructure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Loan>> deleteLoanById(int LoanId) {
		responseStructure.setMessage("Successfully  deleted loan inDb");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(loanDao.deleteLoanById(LoanId));
		return new ResponseEntity<ResponseStructure<Loan>>(responseStructure,HttpStatus.OK);
	}

	public ResponseStructure<Loan> updateLoanById(int oldLoanId,  Loan newLoan) {
		responseStructure.setMessage("Successfully  updated loan inDb");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(loanDao.updateLoanById(oldLoanId, newLoan));		
		return responseStructure;

	}

	public List<Loan> fetchAllLoans() {
		return loanDao.fetchAllLoans();

	}
}
