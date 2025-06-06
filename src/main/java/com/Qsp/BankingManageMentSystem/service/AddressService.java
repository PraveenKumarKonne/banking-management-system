package com.Qsp.BankingManageMentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Qsp.BankingManageMentSystem.dao.AddressDao;
import com.Qsp.BankingManageMentSystem.dto.Address;
import com.Qsp.BankingManageMentSystem.util.ResponseStructure;
@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;
	@Autowired
	ResponseStructure<Address>responseStructure;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		responseStructure.setMessage("successfully creatd Address in db");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.CREATED);
		}

	public  ResponseEntity<ResponseStructure<Address>>  fetchAddressById(int addressId) {
		responseStructure.setMessage("successfully fetched  Address in db");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(addressDao.fetchAddressById(addressId));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND);		}

	public  ResponseEntity<ResponseStructure<Address>>  deleteAddressById(int addressId) {
		responseStructure.setMessage("successfully deleted Address in db");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(addressDao.deleteAddressById(addressId));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
	}

	public ResponseStructure<Address>  updateAddressById(int oldAddressId,Address newAddress) {
		responseStructure.setMessage("successfully updated Address in db");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));
		return responseStructure;

	}
	public List<Address>  fetchAllAddresses() {
		return addressDao.fetchAllAddresses();
		
	}

}
