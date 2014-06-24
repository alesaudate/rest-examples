package com.alesaudate.rest.examples.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement //Annotation needed because JAXB will use it as a root element
@XmlAccessorType(XmlAccessType.FIELD) //So JAXB uses the field personList - directly.
public class People {

	
	//JAXB needs a no-args constructor
	public People() {}
	
	public People(List<Person> personList) {
		this.personList = personList;
	}
	
	
	@XmlElement(name="person")
	private List<Person> personList;
	
	
}
