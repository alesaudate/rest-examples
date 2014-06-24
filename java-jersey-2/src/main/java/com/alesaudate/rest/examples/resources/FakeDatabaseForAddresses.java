package com.alesaudate.rest.examples.resources;

import java.util.HashMap;
import java.util.Map;

import com.alesaudate.rest.examples.model.Address;

public class FakeDatabaseForAddresses {
	
	private Map<String, Address> map;
	
	public FakeDatabaseForAddresses() {
		this.map = new HashMap<>();
	}
	
	public Address find(String id) {
		return map.get(id);
	}

	public void set(Address address) {
		map.put(address.getId(), address);
	}
}
