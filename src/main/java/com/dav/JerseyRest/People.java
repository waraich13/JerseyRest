package com.dav.JerseyRest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/people")
public class People {

	@GET
	public Response GetListOfPeople() {

		return Response.status(200).entity("getPeoplesList").build();

	}
	/*
	 * @Produces("text/plain") public String[] GetListOfPeople() { return new
	 * String[] {"Jas","Dav"}; }
	 */

}
