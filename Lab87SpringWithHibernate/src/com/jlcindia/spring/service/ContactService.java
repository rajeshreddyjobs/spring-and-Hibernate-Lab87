package com.jlcindia.spring.service;

import java.util.List;

import com.jlcindia.spring.to.ContactTo;

public interface ContactService {
public  boolean addContact(ContactTo cto);
public List <ContactTo> getAllContacts();
}
