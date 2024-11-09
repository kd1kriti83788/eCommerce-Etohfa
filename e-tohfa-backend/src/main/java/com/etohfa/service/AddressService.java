package com.etohfa.service;

import java.util.List;

import com.etohfa.entity.Address;
import com.etohfa.entity.User;

public interface AddressService {
	
	Address addAddress(Address address);
	
	Address updateAddress(Address address);
	
	Address getAddressById(int addressId);

}
