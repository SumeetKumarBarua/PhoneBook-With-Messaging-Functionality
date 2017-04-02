package com.sumeet.contactapp.service;


import java.util.List;

import com.sumeet.contactapp.bean.Messages;
import com.sumeet.contactapp.dao.MessageDAO;
import com.sumeet.contactapp.resources.Factory;


public class MessageServiceImpl implements MessageService {
		
	public List<Messages> getAllMessages() throws Exception {
		MessageDAO dao=Factory.createMessageDAO();
		List<Messages> result=dao.getAllMessages();
		return result;
	}

	@Override
	public String addMessages(Integer cId, Integer otp) throws Exception {
		MessageDAO dao=Factory.createMessageDAO();
		String result=dao.addMessages(cId, otp);
		return result;
	}

}
