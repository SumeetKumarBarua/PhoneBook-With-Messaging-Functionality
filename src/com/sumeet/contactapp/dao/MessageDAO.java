package com.sumeet.contactapp.dao;

import java.util.List;

import com.sumeet.contactapp.bean.Messages;



public interface MessageDAO {
	
	public List<Messages> getAllMessages() throws Exception;
	public String addMessages(Integer cId, Integer otp) throws Exception;
	
}
