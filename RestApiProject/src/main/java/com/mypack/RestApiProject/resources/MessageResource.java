package com.mypack.RestApiProject.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mypack.model.Message;
import com.mypack.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	MessageService ms = new MessageService();
	@GET
	public List<Message> getMessages(@QueryParam("year") int year) {
		return ms.getAllMessages();
	}
	
	@POST
	public Message addMessage(Message message) {
		return ms.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updatemessage(@PathParam("messageId") long id,Message message) {
		message.setId(id);
		return ms.updateMessage(message);
		
	}
	@DELETE
	@Path("/{messageId}")
	public Message deleteMessage(@PathParam("messageId") long messageId) {
		System.out.println("messageId=="+messageId);
		return ms.removeMessage(messageId);		
	}
	@GET
	@Path("/{messageId}")
	public Message test(@PathParam("messageId") long messageId) {
		System.out.println("messageId=="+messageId);
		return ms.getMessage(messageId);		
	}
}
