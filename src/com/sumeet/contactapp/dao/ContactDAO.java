package com.sumeet.contactapp.dao;

import java.util.List;

import com.sumeet.contactapp.bean.Contacts;



public interface ContactDAO {
	
	public List<Contacts> getAllContacts() throws Exception;
	public List<Contacts> getContactById(Integer contactId) throws Exception;
	
}
