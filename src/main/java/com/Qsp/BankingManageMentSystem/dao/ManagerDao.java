package com.Qsp.BankingManageMentSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Qsp.BankingManageMentSystem.dto.Loan;
import com.Qsp.BankingManageMentSystem.dto.Manager;
import com.Qsp.BankingManageMentSystem.dto.Owner;
import com.Qsp.BankingManageMentSystem.repo.ManagerRepo;
import com.Qsp.BankingManageMentSystem.repo.OwnerRepo;
@Repository
public class ManagerDao {
	@Autowired
	ManagerRepo managerRepo;
	
	public Manager saveManager(Manager manager ) {
		return managerRepo.save(manager);
	}

//	public Owner fetchOwnerById(int OwnerId) {
//		Optional<Owner> owner=ownerRepo.findById(OwnerId);
//		if(owner.isEmpty()) {
//			return null;
//		}
//		else {
//			return owner.get();
//		}
//		
// 	}
	
	public  Manager fetchManagerById(int ManagerId) {
		Optional<Manager> manager=managerRepo.findById(ManagerId);
		if(manager.isEmpty()) {
			return null;
		}
		else {
			return manager.get();
		}
 	}

	public Manager deleteManagerById(int ManagerId) {
		Manager manager = fetchManagerById(ManagerId);
		managerRepo.deleteById(ManagerId);
		return manager;
	}

	public Manager updateManagerById(int oldManagerId,  Manager newManager) {
		newManager.setManagerID(oldManagerId);
		return managerRepo.save(newManager);

	}

	public List<Manager> fetchAllManager() {
		return managerRepo.findAll();

	}

}
