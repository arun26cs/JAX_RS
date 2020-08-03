package com.webservice.Demorest.resources;

import java.util.List;

import com.webservice.Demorest.model.Profile;
import com.webservice.Demorest.service.ProfileService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/profiles")
public class ProfileResources {

	ProfileService ps = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getProfiles(){
		return ps.getProfiles().toString();
		
	}
	
	@GET
	@Path("/{profilename}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam("profilename") String pfname ) {
		return ps.getProfile(pfname);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile) {
		return ps.addProfile(profile);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile updateProfile(Profile profile) {
		return ps.updateProfile(profile);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profilename}")
	public Profile deleteProfile(@PathParam("profilename") String profname) {
		return ps.deleteProfile(profname);
	}
	
}
