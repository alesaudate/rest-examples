package com.alesaudate.rest.examples.resources;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import com.alesaudate.rest.examples.model.Address;
import com.alesaudate.rest.examples.model.People;
import com.alesaudate.rest.examples.model.Person;


@Path("/person") //specifies a fragment of the URL needed to access this resource.

//specifies what kind of media type this service will be able to understand ("read")
@Consumes({MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON})


//specifies what kind of media type this service will be able to generate ("write")
@Produces({MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
public class PersonResource {

	
	//It needs to be static because, otherwise, it would be lost (instances of services
	//are created and destroyed as needed)
	private static FakeDatabaseForPeople fakeDatabaseForPeople = new FakeDatabaseForPeople();
	
	static {
		
		Person personOne = Person.Builder
				.newPerson()
				.withDateOfBirth(new Date())
				.withName("John Doe")
				.withAddress(
					Address.Builder
					.newAddress()
					.withComplement("Ap. 123")
					.withZipAddress("111111")
					.build()
				)
				.build();
		
		Person personTwo = Person.Builder
				.newPerson()
				.withDateOfBirth(new Date())
				.withName("Jane Doe")
				.withAddress(
					Address.Builder
					.newAddress()
					.withComplement("Ap. 123")
					.withZipAddress("111111")
					.build()
				)
				.build();
				
		fakeDatabaseForPeople.set(personOne);
		fakeDatabaseForPeople.set(personTwo);
		
	}
	
	//specifies that the HTTP method GET will be used to reach this method
	@GET
	public People findAll() {
		Collection<Person> collection = fakeDatabaseForPeople.findAll();
		List<Person> personList = Arrays.asList(collection.toArray(new Person[]{}));
		return new People(personList);	
	}
	
	
	@GET
	
	//will add to the class's @Path annotation to produce a new one (in this case, /person/{id}).
	//This is just a template (marked by '{' and '}'). It must be complemented by
	//@PathParam
	@Path("/{id}")
	public Person findSpecific(@PathParam("id") String personId) {
		
		Person person = fakeDatabaseForPeople.find(personId);
		
		if (person == null) {
			
			//Client will receive code 404 Not Found as result
			throw new WebApplicationException(Status.NOT_FOUND);
		}
		
		return person;
	}
	
	
	
}
