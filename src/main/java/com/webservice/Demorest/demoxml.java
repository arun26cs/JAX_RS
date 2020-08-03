package com.webservice.Demorest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("demoxml")
public class demoxml {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Student getStudent() {
		Student st = new Student();
		st.setName("Arun");
		st.setRoll(25);
		return st;
	}
}
