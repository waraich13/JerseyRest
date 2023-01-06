package com.dav.Resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dav.JerseyRest.People;
import com.dav.Repository.PeopleRepository;

@Path("/people")
public class PeopleResource {

	PeopleRepository peoplerepo = new PeopleRepository();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<People> GetListOfPeople() {

		return peoplerepo.getPeople();

	}

	@POST
	@Path("/addpeople")
	public People CreatePeople(People p) {

		peoplerepo.addPeople(p);
		System.out.println(p);

		return p;
	}

}
