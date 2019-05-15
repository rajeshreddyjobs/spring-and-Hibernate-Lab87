package com.jlcindia.spring.mvc;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jlcindia.spring.service.ContactService;
import com.jlcindia.spring.to.ContactTo;

@Controller
@SessionAttributes
public class ContactController {

	@Autowired
	ContactService contactService;

	//@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/showaddcontact.jlc" })
	protected String showContactPage(Map map) throws Exception {
		System.out.println("Show");
		ContactCommand c = new ContactCommand();
		map.put("contact", c);

		return "contact";
	}

	@RequestMapping(value = { "/addcontact.jlc" }, method = RequestMethod.POST)
	protected String addcontact(@ModelAttribute(value = "contact") ContactCommand contact, HttpServletRequest req)
			throws Exception {

		System.out.println("addContact");
		String name = contact.getContactName();
		String email = contact.getContactEmail();
		String phone = contact.getContactPhone();
		System.out.println(name+"\t"+email+"\t"+phone);

		ContactTo cto = new ContactTo();
		cto.setContactName(name);
		cto.setContactEmail(email);
		cto.setContactPhone(phone);
		
		System.out.println(cto.getContactid()+"\t"+cto.getContactName()+"\t"+cto.getContactEmail()+"\t"+cto.getContactPhone());

		boolean added = contactService.addContact(cto);
		System.out.println(added);
		if (added) {
			req.setAttribute("MSG", "Contact added successfully");
		} else {
			req.setAttribute("MSG", "Error while adding contact");
		}

		List<ContactTo> cList = contactService.getAllContacts();
		if (cList != null && cList.size() > 0)
			req.setAttribute("CLIST", cList);
		contact.setContactName("");
		contact.setContactEmail("");
		contact.setContactPhone("");
		System.out.println(contact);
		return "contact";

	}
}
