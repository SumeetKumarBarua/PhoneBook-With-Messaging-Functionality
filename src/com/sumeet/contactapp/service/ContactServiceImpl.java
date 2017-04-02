package com.sumeet.contactapp.service;


import java.util.List;

import com.sumeet.contactapp.bean.Contacts;
import com.sumeet.contactapp.dao.ContactDAO;
import com.sumeet.contactapp.resources.Factory;



public class ContactServiceImpl implements ContactService {
	
	
	public List<Contacts> getAllContacts() throws Exception{
		ContactDAO dao=Factory.createContactDAO();
		List<Contacts> result=dao.getAllContacts();
		return result;
	}

	public List<Contacts> getContactById(Integer contactId) throws Exception{
		ContactDAO dao=Factory.createContactDAO();
		List<Contacts> result=dao.getContactById(contactId);
		return result;
	}
	
	
	public static void main(String[] args) {
		ContactServiceImpl dao=new ContactServiceImpl();
		try {
			System.out.println(dao.getAllContacts());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
