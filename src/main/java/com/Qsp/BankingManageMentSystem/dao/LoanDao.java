package com.Qsp.BankingManageMentSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Qsp.BankingManageMentSystem.dto.Employee;
import com.Qsp.BankingManageMentSystem.dto.Loan;
import com.Qsp.BankingManageMentSystem.repo.LoanRepo;
@Repository
public class LoanDao {
@Autowired
LoanRepo loanRepo;
	
	
	public Loan svaeLoan(Loan loan ) {
		return loanRepo.save(loan);
	}

//	Optional<Owner> owner=ownerRepo.findById(OwnerId);
//	if(owner.isEmpty()) {
//		return null;
//	}
//	else {
//		return owner.get();
//	}
//	
	public Loan fetchLoanById(int loanId) {
		Optional<Loan> loan=loanRepo.findById(loanId);
		if(loan.isEmpty()) {
			return null;
		}else {
			return loan.get();
		}
 	}

	public Loan deleteLoanById(int LoanId) {
		Loan loan = fetchLoanById(LoanId);
		loanRepo.deleteById(LoanId);
		return loan;
	}

	public Loan updateLoanById(int oldLoanId,  Loan newLoan) {
		newLoan.setLoanId(oldLoanId);
		return loanRepo.save(newLoan);

	}

	public List<Loan> fetchAllLoans() {
		return loanRepo.findAll();

	}
}
