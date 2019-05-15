package com.jlcindia.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlcindia.spring.dao.ContactDAO;
import com.jlcindia.spring.to.ContactTo;
@Service
public  class ContactServiceImpl  implements ContactService{
	@Autowired
	ContactDAO contactDAO;
	
	@Override
	public boolean addContact(ContactTo cto) {
		//System.out.println("ContactServiceIMPL:  "+cto.getContactid()+"\t"+cto.getContactName()+"\t"+cto.getContactEmail()+"\t"+cto.getContactPhone());
		return contactDAO.addContact(cto);
	}

	@Override
	public List<ContactTo> getAllContacts() {
		return contactDAO.getAllContacts();
	}

}
