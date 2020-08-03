package com.webservice.Demorest.resources;

import java.util.List;

import com.webservice.Demorest.beans.MessageFilterBeans;
import com.webservice.Demorest.model.Message;
import com.webservice.Demorest.service.MessageService;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResources {

	MessageService ms= new MessageService();
	 

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages(@BeanParam MessageFilterBeans mfb) {
		List<Message> ans = ms.getAllMessages();
		if(mfb.getYear()>0) {
			return ms.getAllMessagesInYear(mfb.getYear()).toString();
		}
		if(mfb.getStart()>=0 && mfb.getSize()>=0) {
			System.out.println(mfb.getStart()+" "+mfb.getSize());
			return ms.getAllMessagesPaginated(mfb.getStart(), mfb.getSize()).toString();
		} 
		System.out.println(ans.get(0).getAuthor());
		return ans.toString();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id ) {

		return ms.getMessage(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		return ms.addMessage(message);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id,Message message) {
		message.setId(id);
		return ms.updateMessage(message);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message deleteMessage(@PathParam("messageId") long id) {
		return ms.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getComments() {
		return new CommentResource();
	}
	
}
