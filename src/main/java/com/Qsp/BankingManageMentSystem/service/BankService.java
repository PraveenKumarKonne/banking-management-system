package com.Qsp.BankingManageMentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Qsp.BankingManageMentSystem.dao.BankDao;
import com.Qsp.BankingManageMentSystem.dto.Atm;
import com.Qsp.BankingManageMentSystem.dto.Bank;
import com.Qsp.BankingManageMentSystem.dto.Branch;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;

@Service
public class BankService {
	@Autowired
	BankDao bankDao;
	@Autowired
	ResponseStructure<Bank> responseStructure;

	// one to many(Bank to Branches)
	public Bank addExistingBranchToExistingBank(int branchId, int bankId) {

		return bankDao.addExistingBranchToExistingBank(branchId, bankId);
	}

	public Bank addNewBranchToExistingBank(int bankid, Branch newBranch) {
		return bankDao.addNewBranchToExistingBank(bankid, newBranch);

	}

	// one to many(Bank to ams)

	public Bank addExistingAtmToExistingBank(int branchId, int atmid) {
		return bankDao.addExistingBranchToExistingEmployee(branchId, atmid);

	}

	public Bank addNewAtmToExistingBank(int bankid, Atm newAtm) {
		return bankDao.addNewAtmToExistingBank(bankid, newAtm);

	}

	public ResponseEntity<ResponseStructure<Bank>> saveBank(Bank bank) {
		responseStructure.setMessage("sucessfully created Bank in db");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(bankDao.saveBank(bank));
		return new ResponseEntity<ResponseStructure<Bank>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Bank>> fetchBankById(int BankId) {
		responseStructure.setMessage("sucessfully fetched Bank in db");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.fetchBankById(BankId));
		return new ResponseEntity<ResponseStructure<Bank>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Bank>> deleteBankById(int BankId) {
		responseStructure.setMessage("sucessfully deleted  Bank in db");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.deleteBankById(BankId));
		return new ResponseEntity<ResponseStructure<Bank>>(responseStructure, HttpStatus.OK);
	}

	public ResponseStructure<Bank> updateBankById(int OldBankId, Bank NewBank) {
		responseStructure.setMessage("sucessfully created Bank in db");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.updateBankById(OldBankId, NewBank));
		return responseStructure;

	}

	public List<Bank> fetchAllBank() {
		return bankDao.fetchAllBank();

	}

}
