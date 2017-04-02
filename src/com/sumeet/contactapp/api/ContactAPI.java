package com.sumeet.contactapp.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.sumeet.contactapp.bean.Contacts;
import com.sumeet.contactapp.resources.Factory;
import com.sumeet.contactapp.service.ContactService;


@Path("ContactAPI")
public class ContactAPI {
	
	//get All contacts
	@GET
	@Path("allContacts")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllContacts()throws Exception{
		Response response=null;
		try{
			ContactService serv=Factory.createContactService();
			List<Contacts> contactList=serv.getAllContacts();
			
			String returnString=new Gson().toJson(contactList);
			response=Response.ok(returnString).build();
		}
		catch(Exception e){
			e.printStackTrace();
			Contacts msg = new Contacts();
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
	// gets details by contactId from DB
		@GET
		@Path("contact/{cId}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getContactById(@PathParam("cId") Integer contactId)
				throws Exception {
			Response response = null;
			try {
				ContactService ser = Factory.createContactService();
				List<Contacts> contactList = ser.getContactById(contactId);

				String returnString = new Gson().toJson(contactList);
				response = Response.ok(returnString).build();
				//System.out.println(response);
			} catch (Exception e) {

				Contacts msg = new Contacts();
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
