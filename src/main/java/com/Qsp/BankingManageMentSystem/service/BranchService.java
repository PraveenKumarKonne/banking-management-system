package com.Qsp.BankingManageMentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Qsp.BankingManageMentSystem.dao.BranchDao;
import com.Qsp.BankingManageMentSystem.dto.Branch;
import com.Qsp.BankingManageMentSystem.dto.Customer;
import com.Qsp.BankingManageMentSystem.dto.Employee;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;

@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;
	@Autowired
	ResponseStructure<Branch> responseStructure;

	// one to many(Branch to Employees)
	public Branch addExistingBranchToExistingEmployee(int branchId, int EmployeeId) {

		return branchDao.addExistingBranchToExistingEmployee(branchId, EmployeeId);

	}
	public Branch addNewEmployeeToExistingBranch(int branchId,Employee employee) {
		return branchDao.addNewEmployeeToExistingBranch(branchId, employee);
	
	}
	

//one to many(Branch to customers)
	public Branch addExistingBrachToExistingCustomers(int brachId, int CustomerId) {
		return branchDao.addExistingBrachToExistingCustomers(brachId, CustomerId);

	}
	
	public Branch addNewBranchToExistingCustomer(int branchId,Customer customer) {
		return branchDao.addNewBranchToExistingCustomer(branchId, customer);
	
	}

	// one to one
	public Branch addExistingManagerToExistingBranch(int branchId, int ManagerId) {

		return branchDao.addExistingManagerToExistingBranch(branchId, ManagerId);
	}

	// One to one
	public Branch addExistingAddressToExistingBranch(int branchid, int AddressId) {

		return branchDao.addExistingAddressToExistingBranch(branchid, AddressId);

	}

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		responseStructure.setMessage("successfully created Branch in db");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int BranchId) {
		responseStructure.setMessage("successfully fetched Branch in db");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(branchDao.fetchBranchById(BranchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int BranchId) {
		responseStructure.setMessage("successfully deleted Branch in db");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.deleteBranchById(BranchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}

	public ResponseStructure<Branch> updateBranchById(int OldBranchId, Branch NewBranch) {
		responseStructure.setMessage("successfully created Branch in db");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.updateBranchById(OldBranchId, NewBranch));
		return responseStructure;

	}

	public List<Branch> fetchAllBranch() {
		return branchDao.fetchAllBranch();

	}

}
