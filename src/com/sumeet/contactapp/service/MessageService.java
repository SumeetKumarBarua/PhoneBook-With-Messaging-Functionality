package com.sumeet.contactapp.service;

import java.util.List;

import com.sumeet.contactapp.bean.Messages;


public interface MessageService {
	
	public List<Messages> getAllMessages() throws Exception;
	public String addMessages(Integer cId, Integer otp) throws Exception;
}
