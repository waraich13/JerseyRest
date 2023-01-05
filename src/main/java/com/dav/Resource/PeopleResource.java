package com.dav.Resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.catalina.tribes.util.Arrays;

import com.dav.JerseyRest.People;

@Path("/people")
public class PeopleResource {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<People> GetListOfPeople() {
		
		People p1 = new People();
		p1.setName("Dav");
		
		People p2 = new People();
		p2.setName("Jas");
		
		
		//List<People> peoples = Arrays.asList(p1,p2); 
		 List<People> peoples = new ArrayList<People>();
		 peoples.add(p1);
		 peoples.add(p2);
		
		
		return peoples;
		
	}

}
 	