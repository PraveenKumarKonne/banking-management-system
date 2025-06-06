package com.Qsp.BankingManageMentSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Qsp.BankingManageMentSystem.dto.Atm;
import com.Qsp.BankingManageMentSystem.dto.Bank;
import com.Qsp.BankingManageMentSystem.dto.Branch;
import com.Qsp.BankingManageMentSystem.dto.Employee;
import com.Qsp.BankingManageMentSystem.dto.Owner;
import com.Qsp.BankingManageMentSystem.repo.BankRepo;

@Repository
public class BankDao {
	@Autowired
	BankRepo bankRepo;
	@Autowired
	BranchDao branchDao;
	@Autowired
	AtmDao atmDao;

//one to many(Bank to Branches)
	public Bank addExistingBranchToExistingBank(int branchId, int bankId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Bank bank = fetchBankById(bankId);
		List<Branch> list = bank.getBranchs();
		list.add(branch);
		bank.setBranchs(list);

		return saveBank(bank);

	}
	
	

	public Bank addNewBranchToExistingBank(int bankid, Branch newBranch) {
		Bank bank = fetchBankById(bankid);
		List<Branch> list = bank.getBranchs();
		list.add(newBranch);
		bank.setBranchs(list);
		return saveBank(bank);
	}

	//One to many(Bank to atms)
	public Bank addExistingBranchToExistingEmployee(int branchId, int atmid) {
		Atm atm = atmDao.fetchAtmById(atmid);
		Bank  bank = fetchBankById(atmid);
		List<Atm> list = bank.getAtms();
		list.add(atm);
		bank.setAtms(list);

		return saveBank(bank);

	}
	public Bank addNewAtmToExistingBank(int bankid,Atm newAtm) {
		Bank bank = fetchBankById(bankid);
		List<Atm> list = bank.getAtms();
		list.add(newAtm);
		bank.setAtms(list);
		return saveBank(bank);
	}
	
	
	
	

	
	public Bank saveBank(Bank bank) {
		return bankRepo.save(bank);
	}
//	Optional<Owner> owner=ownerRepo.findById(OwnerId);
//	if(owner.isEmpty()) {
//		return null;
//	}
//	else {
//		return owner.get();
//	}
	
	public Bank fetchBankById(int BankId) {
		Optional<Bank>bank= bankRepo.findById(BankId);
	if(bank.isEmpty()) {
		return null;
	}
	else {
		return bank.get();
	}
	}

	public Bank deleteBankById(int BankId) {
		Bank bank = fetchBankById(BankId);
		bankRepo.deleteById(BankId);
		return bank;
	}

	public Bank updateBankById(int OldBankId, Bank NewBank) {
		NewBank.setBankId(OldBankId);
		return bankRepo.save(NewBank);

	}

	public List<Bank> fetchAllBank() {
		return bankRepo.findAll();

	}

}
