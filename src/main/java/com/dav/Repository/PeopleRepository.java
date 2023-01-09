package com.dav.Repository;

import java.util.ArrayList;
import java.util.List;

import com.dav.JerseyRest.People;

public class PeopleRepository {
	List<People> people;

	public PeopleRepository() {
		people = new ArrayList<People>();

		People p1 = new People();
		p1.setName("Dav");

		People p2 = new People();
		p2.setName("Jas");

		people.add(p1);
		people.add(p2);
	}

	public List<People> getPeople() {

		return people;
	}

	public void addPeople(People p) {

		people.add(p);

	}

}
