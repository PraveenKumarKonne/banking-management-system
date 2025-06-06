package com.Qsp.BankingManageMentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Qsp.BankingManageMentSystem.dao.AtmDao;
import com.Qsp.BankingManageMentSystem.dto.Atm;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;
@Service
public class AtmService {
	@Autowired
	AtmDao atmDao;
	@Autowired
	ResponseStructure<Atm> responseStructure;
	

	public ResponseEntity<ResponseStructure<Atm>> saveAtm(Atm atm) {
		responseStructure.setMessage("Successfully created Atm in db");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(atmDao.saveAtm(atm));
		return new ResponseEntity<ResponseStructure<Atm>>(responseStructure,HttpStatus.CREATED);
		}

	public ResponseEntity<ResponseStructure<Atm>> fetchAtmById(int atmId) {
		responseStructure.setMessage("Successfully fetched  Atm in db");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(atmDao.fetchAtmById(atmId));
		return new ResponseEntity<ResponseStructure<Atm>>(responseStructure,HttpStatus.FOUND);		}

	public ResponseEntity<ResponseStructure<Atm>> deleteAtmById(int atmId) {
		responseStructure.setMessage("Successfully deleted Atm in db");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(atmDao.deleteAtmById(atmId));
		return new ResponseEntity<ResponseStructure<Atm>>(responseStructure,HttpStatus.OK);
	}

	public ResponseStructure<Atm> updateAtmById(int oldAtmId,Atm newAtm) {
		responseStructure.setMessage("Successfully updated Atm in db");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(atmDao.updateAtmById(oldAtmId, newAtm));
		return responseStructure;

	}
	public List<Atm>  fetchAllAtms() {
		return atmDao. fetchAllAtms();
		
	}

}
