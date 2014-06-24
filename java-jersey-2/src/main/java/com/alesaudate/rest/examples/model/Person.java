package com.alesaudate.rest.examples.model;

import java.util.Date;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement //Annotation needed because JAXB will use it as a root element
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER) //Maps getters and setters and public fields. It's the default.
public class Person {
	
	
	private String id;
	private String name;
	private Date dateOfBirth;
	private Address address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	public static class Builder {
		
		private Person building;
		
		public static Builder newPerson() {
			Builder builder = new Builder();
			builder.building = new Person();
			builder.building.setId(UUID.randomUUID().toString());
			return builder;
		}
		
		public Builder withName(String name) {
			building.setName(name);
			return this;
		}
		
		public Builder withDateOfBirth(Date date) {
			building.setDateOfBirth(date);
			return this;
		}
		
		public Builder withAddress(Address address) {
			building.setAddress(address);
			return this;
		}
		
		public Person build() {
			Person built = this.building;
			this.building = null;
			return built;
		}
		
		
	}
	
	
}
