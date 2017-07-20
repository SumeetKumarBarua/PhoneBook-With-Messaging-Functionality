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
import com.sumeet.contactapp.bean.Facts;
import com.sumeet.contactapp.bean.Messages;
import com.sumeet.contactapp.client.AppClient;
import com.sumeet.contactapp.resources.Factory;
import com.sumeet.contactapp.service.MessageService;

@Path("FactAPI")
public class FactAPI {
	
	//get All Facts
	@GET
	@Path("allFacts")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllFacts()throws Exception{
		Response response=null;
		try{
			AppClient client=new AppClient();
			List<Facts> factList=client.allFacts();
			
			String returnString=new Gson().toJson(factList);
			response=Response.ok(returnString).build();
		}
		catch(Exception e){
			Facts msg = new Facts();
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