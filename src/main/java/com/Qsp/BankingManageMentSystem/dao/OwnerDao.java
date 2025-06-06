package com.Qsp.BankingManageMentSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Qsp.BankingManageMentSystem.dto.Bank;
import com.Qsp.BankingManageMentSystem.dto.Owner;
import com.Qsp.BankingManageMentSystem.repo.OwnerRepo;

@Repository
public class OwnerDao {
	@Autowired
	OwnerRepo ownerRepo;
	@Autowired
	BankDao bankDao;

	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}

	// one to one
	public Owner addExistingBankToExistingOwner(int bankId, int ownerId) {
		Bank bank = bankDao.fetchBankById(bankId);
		Owner owner = fetchOwnerById(ownerId);
		owner.setBank(bank);
		return saveOwner(owner);

	}

	public Owner fetchOwnerById(int OwnerId) {
		Optional<Owner> owner=ownerRepo.findById(OwnerId);
		if(owner.isEmpty()) {
			return null;
		}
		else {
			return owner.get();
		}
		
 	}

	public Owner deleteOwnerById(int OwnerId) {
		Owner owner = fetchOwnerById(OwnerId);
		ownerRepo.deleteById(OwnerId);
		return owner;
	}

	public Owner updateOwnerById(int OldOwnerdId, Owner NewOwner) {
		NewOwner.setOwnerId(OldOwnerdId);
		return ownerRepo.save(NewOwner);

	}

	public List<Owner> fetchAllOwner() {
		return ownerRepo.findAll();

	}

}
