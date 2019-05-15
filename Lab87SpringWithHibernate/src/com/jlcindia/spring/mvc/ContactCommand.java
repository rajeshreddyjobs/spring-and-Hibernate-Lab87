package com.jlcindia.spring.mvc;

public class ContactCommand {
private String ContactName;
private String contactEmail;
private String contactPhone;
public String getContactName() {
	return ContactName;
}
public void setContactName(String contactName) {
	ContactName = contactName;
}
public String getContactEmail() {
	return contactEmail;
}
public void setContactEmail(String contactEmail) {
	this.contactEmail = contactEmail;
}
public String getContactPhone() {
	return contactPhone;
}
public void setContactPhone(String contactPhone) {
	this.contactPhone = contactPhone;
}


}
