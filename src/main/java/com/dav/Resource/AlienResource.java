package com.dav.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dav.JerseyRest.Alien;

@Path("/alien")
public class AlienResource {
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Alien getAlien() { 
		System.out.println("getAlien Working");
		Alien a1 = new Alien();
		a1.setName("Dav");
		a1.setPoints(90);
		
		return a1;
	}
}
