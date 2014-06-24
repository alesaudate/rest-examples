package com.alesaudate.rest.examples.resources;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.alesaudate.rest.examples.model.Person;

public class FakeDatabaseForPeople {
	
	private Map<String, Person> map;
	
	private FakeDatabaseForAddresses fakeDatabaseForAddresses;
	
	public FakeDatabaseForPeople() {
		this.map = new HashMap<>();
		this.fakeDatabaseForAddresses = new FakeDatabaseForAddresses();
	}
	
	public Person find (String id) {
		return map.get(id);
	}
	
	public Collection<Person> findAll() {
		return map.values();
	}
	
	public void set(Person person) {
		map.put(person.getId(), person);
		getFakeDatabaseForAddresses().set(person.getAddress());
	}
	
	
	public FakeDatabaseForAddresses getFakeDatabaseForAddresses() {
		return fakeDatabaseForAddresses;
	}
	

}
