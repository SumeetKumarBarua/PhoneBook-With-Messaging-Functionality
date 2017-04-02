package com.sumeet.contactapp.resources;

import com.sumeet.contactapp.dao.ContactDAOImpl;
import com.sumeet.contactapp.dao.MessageDAOImpl;
import com.sumeet.contactapp.service.ContactServiceImpl;
import com.sumeet.contactapp.service.MessageServiceImpl;

public class Factory {

	public static ContactServiceImpl createContactService(){
		return new ContactServiceImpl();
	}	
	public static ContactDAOImpl createContactDAO()
	{ 
		return new ContactDAOImpl();
	}
	
	public static MessageServiceImpl createMessageService(){
		return new MessageServiceImpl();
	}	
	public static MessageDAOImpl createMessageDAO()
	{ 
		return new MessageDAOImpl();
	}
}
