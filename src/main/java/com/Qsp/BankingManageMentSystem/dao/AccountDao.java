package com.Qsp.BankingManageMentSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Qsp.BankingManageMentSystem.dto.Account;
import com.Qsp.BankingManageMentSystem.repo.AccountRepo;

@Repository
public class AccountDao {
@Autowired 
AccountRepo accountRepo;

public Account saveAccount(Account  account  ) {
	return accountRepo.save(account);
	}

public Account fetchAccountById(int accountId) {
	Optional<Account>account= accountRepo.findById(accountId);
	if (account.isEmpty()){
		return null;
		}
	else {
		return account.get();
	}
	}

public Account deleteAccountById(int accountId) {
	Account  account=fetchAccountById(accountId);
	accountRepo.deleteById(accountId);
	return account;
}

public Account updateAccountById(int oldAccountId,Account newAccount) {
 newAccount.setAccountId(oldAccountId);
	return accountRepo.save(newAccount);

}
public List<Account>  fetchAllAccount() {
	return accountRepo.findAll();
	
}


	
}
