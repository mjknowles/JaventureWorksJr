package com.cts.sbtutorial1.services;

import java.util.List;

import com.cts.sbtutorial1.domain.Address;

public interface AddressService {
	
	public void saveAddress(Address address);
	public void deleteAddress(int id);
	public Address getAddressByID(int id);
	public List<Address> getAllAddresses();
}
