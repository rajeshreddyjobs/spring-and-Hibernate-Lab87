package com.jlcindia.spring.dao;

import java.util.List;

import com.jlcindia.spring.to.ContactTo;

public interface ContactDAO {

	public boolean addContact(ContactTo cto);
	public List<ContactTo> getAllContacts();
}
