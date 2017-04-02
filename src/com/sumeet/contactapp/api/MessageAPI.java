package com.sumeet.contactapp.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.sumeet.contactapp.bean.Messages;
import com.sumeet.contactapp.resources.Factory;
import com.sumeet.contactapp.service.MessageService;

@Path("MessageAPI")
public class MessageAPI {
	
	//get All Messages
	@GET
	@Path("allMessages")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMessages()throws Exception{
		Response response=null;
		try{
			MessageService serv=Factory.createMessageService();
			List<Messages> MessageList=serv.getAllMessages();
			
			String returnString=new Gson().toJson(MessageList);
			response=Response.ok(returnString).build();
		}
		catch(Exception e){
			Messages msg = new Messages();
			msg.setErrMsg((e.getMessage()));
			String returnString = new Gson().toJson(msg);
			if (e.getMessage().contains("DATABASE")) {
				response = Response.status(Status.SERVICE_UNAVAILABLE)
						.entity(returnString).build();
			} else {
				response = Response.status(Status.BAD_REQUEST)
						.entity(returnString).build();

			}
			}
		return response;
	}
	
	@POST
	@Path("addMessages/{cId}/{otp}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAddMessages(@PathParam("cId") Integer cId, @PathParam("otp") Integer otp)throws Exception{
		Response response=null;
		try{
			MessageService serv=Factory.createMessageService();
			String msg=serv.addMessages(cId, otp);
			response=Response.ok(msg).build();
			System.out.println(response);
		}
		catch(Exception e){
			Messages msg = new Messages();
			msg.setErrMsg((e.getMessage()));
			String returnString = new Gson().toJson(msg);
			if (e.getMessage().contains("DATABASE")) {
				response = Response.status(Status.SERVICE_UNAVAILABLE)
						.entity(returnString).build();
			} else {
				response = Response.status(Status.BAD_REQUEST)
						.entity(returnString).build();

			}
			}
		return response;
	}
}
