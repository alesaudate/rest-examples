package com.alesaudate.rest.examples.resources;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;



//Will register itself as a mechanism of bootstrap (very similar to a servlet mapping)
//Works with servlet 3.0-compatible containers
@ApplicationPath("/services")
public class Bootstrap extends Application{
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(PersonResource.class);
		return classes;
	}

}
