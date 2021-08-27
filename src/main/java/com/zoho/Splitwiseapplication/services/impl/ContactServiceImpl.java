package com.zoho.Splitwiseapplication.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoho.Splitwiseapplication.entity.Contact;
import com.zoho.Splitwiseapplication.repository.ContactRepository;
import com.zoho.Splitwiseapplication.services.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	
	private ContactRepository contactRepository;
	
	public ContactServiceImpl(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}



	@Override
	public List<Contact> getAllContacts() {
		
		return contactRepository.findAll();
	}



	@Override
	public Contact saveContact(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public Contact getContactById(Long id) {
		return contactRepository.findById(id).get();
	}

	@Override
	public Contact updateContact(Contact contact) {
		return contactRepository.save(contact);
	}



	@Override
	public void deleteContactById(Long id) {
		contactRepository.deleteById(id);
	}


}
