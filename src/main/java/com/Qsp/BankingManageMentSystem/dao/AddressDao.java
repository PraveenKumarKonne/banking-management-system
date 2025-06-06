package com.Qsp.BankingManageMentSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Qsp.BankingManageMentSystem.dto.Address;
import com.Qsp.BankingManageMentSystem.dto.Account;
import com.Qsp.BankingManageMentSystem.dto.Address;
import com.Qsp.BankingManageMentSystem.repo.AccountRepo;
import com.Qsp.BankingManageMentSystem.repo.AddressRepo;
@Repository
public class AddressDao {
	@Autowired 
AddressRepo addressRepo;

	public Address saveAddress(Address address) {
		return addressRepo.save(address);
		}

	public Address fetchAddressById(int addressId) {
		Optional<Address>address= addressRepo.findById(addressId);
		if(address.isEmpty()) {
			return null;
		}
		else {
			return address.get();
		}
		}

	public Address deleteAddressById(int addressId) {
		 Address  address=fetchAddressById(addressId);
		addressRepo.deleteById(addressId);
		return address;
	}

	public Address updateAddressById(int oldAddressId,Address newAddress) {
	  newAddress.setAddressid(oldAddressId);
		return addressRepo.save(newAddress);

	}
	public List<Address>  fetchAllAddresses() {
		return addressRepo.findAll();
		
	}
}
