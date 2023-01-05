package com.dav.JerseyRest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class People {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
