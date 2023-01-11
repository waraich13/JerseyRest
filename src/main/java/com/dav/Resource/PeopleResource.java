package com.dav.Resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dav.JerseyRest.People;
import com.dav.Repository.PeopleRepository;
import com.dav.Repository.Peopledb;

@Path("/people")
public class PeopleResource {

	PeopleRepository peoplerepo = null;
	Peopledb peopledb = null;
	
	
	public PeopleResource() throws Exception {
		this.peoplerepo = new PeopleRepository(); // data is comming from Repository class 
		this.peopledb = new Peopledb(); // data is coming from sql server db
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_XML)
	public List<People> GetListOfPeopleAsXML() throws Exception {

		return peopledb.getPeople();

	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<People> GetListOfPeopleAsJson() throws Exception {

		return peopledb.getPeople();

	}
	

	@POST
	@Path("/addpeople")
	public void CreatePeople(String person) throws Exception {
		
		//1 ) if p is null return BadRequest..value is null
		// 2) if person added successfully, return something(person variable with a message; a simple message(person added))
		
		peopledb.addPeople(person);

	}

}
