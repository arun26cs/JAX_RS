package com.webservice.Demorest.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/")
public class CommentResource {

	@GET
	@Path("/{commentId}")
	public String getComments(@PathParam("commentId") long commentid) {
		return "testing comment get";
	}
}
