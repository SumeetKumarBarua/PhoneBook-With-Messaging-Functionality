package com.sumeet.contactapp.bean;

import java.util.Calendar;

public class Messages {
	private Integer messageId;
	private Integer contactId;
	private String messageDesc;
	private String firstName;
	private String lastName;
	private Calendar sentDetails;
	private String errMsg;
	private String convDate;
	
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public String getMessageDesc() {
		return messageDesc;
	}
	public void setMessageDesc(String messageDesc) {
		this.messageDesc = messageDesc;
	}
	public Calendar getSentDetails() {
		return sentDetails;
	}
	public void setSentDetails(Calendar sentDetails) {
		this.sentDetails = sentDetails;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getConvDate() {
		return convDate;
	}
	public void setConvDate(String convDate) {
		this.convDate = convDate;
	}
	
	
}
