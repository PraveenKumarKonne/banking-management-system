package com.Qsp.BankingManageMentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Qsp.BankingManageMentSystem.dao.AccountDao;
import com.Qsp.BankingManageMentSystem.dto.Account;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;

@Service
public class AccountService {
	@Autowired
	AccountDao accountDao;
	@Autowired
	ResponseStructure<Account> responseStructure;

	public ResponseEntity<ResponseStructure<Account>> saveAccount(Account account) {
		responseStructure.setMessage("Successfully createdd account in Db");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(accountDao.saveAccount(account));
		return new ResponseEntity<ResponseStructure<Account>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Account>> fetchAccountById(int accountId) {
		responseStructure.setMessage("Successfully fetched account in Db");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(accountDao.fetchAccountById(accountId));
		return new ResponseEntity<ResponseStructure<Account>>(responseStructure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Account>> deleteAccountById(int accountId) {
		responseStructure.setMessage("Successfully deleted account in Db");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(accountDao.deleteAccountById(accountId));
		return new ResponseEntity<ResponseStructure<Account>>(responseStructure, HttpStatus.OK);
	}

	public ResponseStructure<Account> updateAccountById(int oldAccountId, Account newAccount) {
		responseStructure.setMessage("Successfully updated account in Db");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(accountDao.updateAccountById(oldAccountId, newAccount));
		return responseStructure;

	}

	public List<Account> fetchAllAccount() {
		return accountDao.fetchAllAccount();

	}

}
