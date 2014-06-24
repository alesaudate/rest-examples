package com.alesaudate.rest.examples.model;

import java.util.UUID;

import com.alesaudate.rest.examples.model.Person.Builder;

public class Address {

	
	private String id;
	private String zipAddress;
	private String number;
	private String complement;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZipAddress() {
		return zipAddress;
	}
	public void setZipAddress(String zipAddress) {
		this.zipAddress = zipAddress;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	
	public static class Builder {
		
		private Address building;
		
		public static Builder newAddress() {
			Builder builder = new Builder();
			builder.building = new Address();
			builder.building.setId(UUID.randomUUID().toString());
			return builder;
		}
		
		public Builder withZipAddress(String zipAddress) {
			this.building.setZipAddress(zipAddress);
			return this;
		}
		
		public Builder withNumber(String number) {
			this.building.setNumber(number);
			return this;
		}
		
		public Builder withComplement(String complement) {
			this.building.setComplement(complement);
			return this;
		}
		
		public Address build() {
			Address address = this.building;
			this.building = null;
			return address;
		}
	}
	
	
	
}
