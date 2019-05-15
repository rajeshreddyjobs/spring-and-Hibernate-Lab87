package com.jlcindia.spring.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.jlcindia.spring.hibernate.Contact;
import com.jlcindia.spring.to.ContactTo;

@Repository
@Transactional
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	HibernateTemplate hTemp;

	//@org.springframework.transaction.annotation.Transactional(readOnly = false)
	@Override
	public boolean addContact(ContactTo cto) {
		//System.out.println("ContactDAOIMPL 1 : "+cto.getContactName()+"\t"+cto.getContactEmail()+"\t"+cto.getContactPhone());

		Contact contact=new Contact();
		contact.setContactName(cto.getContactName());
		contact.setContactEmail(cto.getContactEmail());
		contact.setContactPhone(cto.getContactPhone());
		//ssSystem.out.println("ContactDAOIMPL 2 : "+contact.getContactName()+"\t"+contact.getContactEmail()+"\t"+contact.getContactPhone());
		hTemp.save(contact);
		return true;
	}

	//@org.springframework.transaction.annotation.Transactional(readOnly = true)
	@Override
	public List<ContactTo> getAllContacts() {
		List<ContactTo> cList=null;
		List<Contact> list=(List<Contact>) hTemp.find("from Contact c");
		if(list.size()>0) {
			cList=new ArrayList<ContactTo>();
		
			for(Contact c:list) {
				ContactTo cto=new ContactTo();
				cto.setContactName(c.getContactName());
				cto.setContactEmail(c.getContactEmail());
				cto.setContactPhone(c.getContactPhone());
				cList.add(cto);
				
			}
		System.out.println(cList);
		}
		
		
		return cList;
	}
	
}
