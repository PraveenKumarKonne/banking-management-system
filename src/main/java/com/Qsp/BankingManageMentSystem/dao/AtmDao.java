package com.Qsp.BankingManageMentSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Qsp.BankingManageMentSystem.dto.Address;
import com.Qsp.BankingManageMentSystem.dto.Atm;
import com.Qsp.BankingManageMentSystem.repo.AtmRepo;
@Repository
public class AtmDao {
@Autowired
AtmRepo atmRepo; 
	

	public Atm saveAtm(Atm atm) {
		return atmRepo.save(atm);
		}

	public Atm fetchAtmById(int atmId) {
		Optional<Atm>atm= atmRepo.findById(atmId);
		if(atm.isEmpty()) {
			return null;
		}
		else {
			return atm.get();
		}
		}

	public Atm deleteAtmById(int atmId) {
		 Atm  atm=fetchAtmById(atmId);
		 atmRepo.deleteById(atmId);
		return atm;
	}

	public Atm updateAtmById(int oldAtmId,Atm newAtm) {
	  newAtm.setAtmId(oldAtmId);
		return atmRepo.save(newAtm);

	}
	public List<Atm>  fetchAllAtms() {
		return atmRepo.findAll();
		
	}
}
