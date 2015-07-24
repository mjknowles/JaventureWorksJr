package com.cts.sbtutorial1.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.sbtutorial1.domain.Address;
import com.cts.sbtutorial1.repositories.AddressRepository;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	
	private final Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);
	
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public void saveAddress(Address address) {
		log.debug("Service request to save an address.");
		addressRepository.save(address);
	}

	@Override
	public void deleteAddress(int id) {
		log.debug("Service request to delete an address.");
		addressRepository.delete(id);
		
	}

	@Override
	public Address getAddressByID(int id) {
		log.debug("Service request to get an address by ID.");
		return addressRepository.findOne(id);
	}

	@Override
	public List<Address> getAllAddresses() {
		log.debug("Service request to get all addresses.");
		return addressRepository.findAll();
	}


	public void setAddressRepository(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
}
