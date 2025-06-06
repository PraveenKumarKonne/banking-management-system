package com.Qsp.BankingManageMentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Qsp.BankingManageMentSystem.dao.ManagerDao;
import com.Qsp.BankingManageMentSystem.dto.Manager;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;
@Service
public class ManagerService {
@Autowired
ManagerDao managerDao;
@Autowired
ResponseStructure<Manager>responseStructure;
	
	public ResponseEntity<ResponseStructure<Manager>>  saveManager(Manager manager ) {
		responseStructure.setMessage("Successfully saved Manager in db");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(managerDao.saveManager(manager));
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Manager>> fetchManagerById(int ManagerId) {
		responseStructure.setMessage("successfully fetched manager");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(managerDao.fetchManagerById(ManagerId));
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Manager>> deleteManagerById(int ManagerId) {
		responseStructure.setMessage("successfully deleted ManagerById");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(managerDao.deleteManagerById(ManagerId));
		 return new ResponseEntity<ResponseStructure<Manager>>(responseStructure,HttpStatus.OK);
	}

	public ResponseStructure<Manager> updateManagerById(int oldManagerId,  Manager newManager) {
		responseStructure.setMessage("Successfully updated By id");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(managerDao.updateManagerById(oldManagerId, newManager));
 		return responseStructure;

	}

	public List<Manager> fetchAllManager() {
		return managerDao.fetchAllManager();

	}
}
