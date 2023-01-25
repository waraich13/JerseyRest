package com.dav.Resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dav.JerseyRest.People;
import com.dav.Repository.PeopleRepository;

@Path("/people")
public class PeopleResource {

	PeopleRepository peoplerepo = null;

	public PeopleResource() throws Exception {
		this.peoplerepo = new PeopleRepository();
	}	

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_XML)
	public List<People> GetListOfPeopleAsXML() throws Exception {

		return peoplerepo.getPeople();

	}
	
	@Context
	private HttpServletResponse response;
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<People> GetListOfPeopleAsJson() throws Exception {
		
		if(peoplerepo == null) {
			response.setStatus(Response.Status.CREATED.getStatusCode());
		}
		
		return peoplerepo.getPeople();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addpeople")
	public Response CreatePeople(String person) throws Exception {

		// 1 ) if p is null return BadRequest..value is null
		// 2) if person added successfully, return something(person variable with a
		// message; a simple message(person added))
		if (person == null || person.trim().length() ==0) {
			return Response.status(404).entity("person is null").build();
		} else {
			peoplerepo.addPeople(person);
			return Response.status(200).entity("person added!").build();
		}
	}
}
