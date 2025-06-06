package com.Qsp.BankingManageMentSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Qsp.BankingManageMentSystem.dto.Address;
import com.Qsp.BankingManageMentSystem.dto.Atm;
import com.Qsp.BankingManageMentSystem.dto.Bank;
import com.Qsp.BankingManageMentSystem.dto.Branch;
import com.Qsp.BankingManageMentSystem.dto.Customer;
import com.Qsp.BankingManageMentSystem.dto.Employee;
import com.Qsp.BankingManageMentSystem.dto.Manager;
import com.Qsp.BankingManageMentSystem.repo.BranchRepo;

@Repository
public class BranchDao {
	@Autowired
	BranchRepo branchRepo;
	@Autowired
	AddressDao addressDao;
	@Autowired
	ManagerDao managerDao;
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	CustomerDao customerDao;

	// one to one Branch to Managerr
	public Branch addExistingManagerToExistingBranch(int branchId, int ManagerId) {
		Manager manager = managerDao.fetchManagerById(ManagerId);
		Branch branch = fetchBranchById(branchId);
		branch.setManager(manager);
		return saveBranch(branch);
	}

	// One to one branch to Address
	public Branch addExistingAddressToExistingBranch(int branchid, int AddressId) {
		Address address = addressDao.fetchAddressById(AddressId);
		Branch branch = fetchBranchById(branchid);
		branch.setAddress(address);
		return saveBranch(branch);

	}

	// one to many(Branch to employees)

	public Branch addExistingBranchToExistingEmployee(int branchId, int EmployeeId) {
		Employee employee = employeeDao.fetchEmployeeById(EmployeeId);
		Branch branch = fetchBranchById(branchId);
		List<Employee> list = branch.getEmployees();
		list.add(employee);
		branch.setEmployees(list);

		return saveBranch(branch);

	}
	
	
	public Branch addNewEmployeeToExistingBranch(int branchId, Employee newEmployee) {
		Branch branch = fetchBranchById(branchId);
		List<Employee> list = branch.getEmployees();
		list.add(newEmployee);
		branch.setEmployees(list);
		return saveBranch(branch);
	}

	// one to many(Branch to Customers)
	public Branch addExistingBrachToExistingCustomers(int brachId, int CustomerId) {
		Customer customer = customerDao.fetchCustomerById(CustomerId);
		Branch branch = fetchBranchById(CustomerId);
		List<Customer> list = branch.getCustomers();
		list.add(customer);
		branch.setCustomers(list);

		return saveBranch(branch);

	}
	public Branch addNewBranchToExistingCustomer(int branchId,Customer customer) {
		Branch branch = fetchBranchById(branchId);
		List<Customer> list = branch. getCustomers();
		list.add(customer);
		branch.setCustomers(list);
		return saveBranch(branch);
	}

	 
	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}


	
public Branch fetchBranchById(int BranchId) {
		Optional<Branch> branch= branchRepo.findById(BranchId);
		if(branch.isEmpty()) {
			return null;
		}
		else {
			return branch.get();
		}
	}

	public Branch deleteBranchById(int BranchId) {
		Branch branch = fetchBranchById(BranchId);
		branchRepo.deleteById(BranchId);
		return branch;
	}

	public Branch updateBranchById(int OldBranchId, Branch NewBranch) {
		NewBranch.setBranchId(OldBranchId);
		return branchRepo.save(NewBranch);

	}

	public List<Branch> fetchAllBranch() {
		return branchRepo.findAll();

	}

}
