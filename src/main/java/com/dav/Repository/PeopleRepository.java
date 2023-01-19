package com.dav.Repository;

import java.sql.SQLException;
import java.util.List;

import com.dav.JerseyRest.People;

public class PeopleRepository {
	List<People> people;

	Peopledb peopledb = null;

	public PeopleRepository() throws Exception {
		this.peopledb = new Peopledb();
	
	}

	public List<People> getPeople() throws ClassNotFoundException, SQLException {

		return this.peopledb.getPeople();
	}

	public void addPeople(String person) throws Exception {
		this.peopledb.addPeople(person);

	}

}
