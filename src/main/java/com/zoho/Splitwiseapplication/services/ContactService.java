package com.zoho.Splitwiseapplication.services;

import java.util.List;

import com.zoho.Splitwiseapplication.entity.Contact;

public interface ContactService {
	
	List<Contact> getAllContacts();
	
	Contact saveContact(Contact contact);
	
	Contact getContactById(Long id);
	
	Contact updateContact(Contact contact);
	
	void deleteContactById(Long id);
	
}
