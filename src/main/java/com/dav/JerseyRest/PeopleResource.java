package com.dav.JerseyRest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/people")
public class PeopleResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String GetListOfPeople() {
		
		People p1 = new People();
		p1.setName("Dav");
		System.out.println("Dav");
		
		return p1.toString();
		
	}

}
 	