package com.dav.Resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<People> GetListOfPeopleAsJson() throws Exception {

		return peoplerepo.getPeople();

	}
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addpeople")
	public void CreatePeople( String person) throws Exception {
		
		//1 ) if p is null return BadRequest..value is null
		// 2) if person added successfully, return something(person variable with a message; a simple message(person added))
		
		peoplerepo.addPeople(person);

	}
}
