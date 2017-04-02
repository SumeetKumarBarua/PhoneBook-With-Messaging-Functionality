package com.sumeet.contactapp.bean;

public class Contacts{
  private Integer contactId;
  private String firstName;
  private String lastName;
  private String phoneNo;
  private String location;
  private String errMsg;
  
public Integer getContactId() {
	return contactId;
}
public void setContactId(Integer contactId) {
	this.contactId = contactId;
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
public String getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}
public String getErrMsg() {
	return errMsg;
}
public void setErrMsg(String errMsg) {
	this.errMsg = errMsg;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
 
  
}
