package com.sumeet.contactapp.service;

import java.util.List;

import com.sumeet.contactapp.bean.Contacts;



public interface ContactService {
	
	public List<Contacts> getAllContacts() throws Exception;
	public List<Contacts> getContactById(Integer contactId) throws Exception;
}
