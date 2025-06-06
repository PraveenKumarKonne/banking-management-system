package com.Qsp.BankingManageMentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Qsp.BankingManageMentSystem.dao.OwnerDao;
import com.Qsp.BankingManageMentSystem.dto.Owner;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;

@Service
public class OwnerService {
	@Autowired
	OwnerDao ownerDao;
	@Autowired
	ResponseStructure<Owner> responseStructure;
//one to one owner to bank
	public Owner addExistingBankToExistingOwner(int bankId, int ownerId) {
		return ownerDao.addExistingBankToExistingOwner(bankId, ownerId);
	}

	public ResponseEntity<ResponseStructure<Owner>> saveOwner(Owner owner) {
		responseStructure.setMessage("successfully Owner created db");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(ownerDao.saveOwner(owner));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(int OwnerId) {
		responseStructure.setMessage("successfully fetched OwnerById");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(ownerDao.fetchOwnerById(OwnerId));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(int OwnerId) {
responseStructure.setMessage("successfully deleted OwnerById");
responseStructure.setStatusCode(HttpStatus.OK.value());
responseStructure.setData(ownerDao.deleteOwnerById(OwnerId));

		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.OK);
	}

	public ResponseStructure<Owner> updateOwnerById(int OldOwnerdId, Owner NewOwner) {
		responseStructure.setMessage("successfuly");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(ownerDao.updateOwnerById(OldOwnerdId, NewOwner));
	
		return responseStructure;

	}

	public List<Owner> fetchAllOwner() {
		return ownerDao.fetchAllOwner();

	}
	
	
 

}
