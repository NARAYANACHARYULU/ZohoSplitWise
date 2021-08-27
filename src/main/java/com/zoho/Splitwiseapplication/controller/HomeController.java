package com.zoho.Splitwiseapplication.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zoho.Splitwiseapplication.entity.Contact;
import com.zoho.Splitwiseapplication.repository.ContactRepository;
import com.zoho.Splitwiseapplication.services.ContactService;

@Controller
public class HomeController {

		private ContactService contactService;

		public HomeController(ContactService contactService) {
			super();
			this.contactService = contactService;
		}
		
		//method to return mv
		@GetMapping("/contacts")
		public String listContacts(Model model)
		{
			model.addAttribute("contacts",contactService.getAllContacts());
			model.addAttribute("total", (int) contactService.getAllContacts().size());
			return "contacts";
		}
		
		@GetMapping("/contacts/new")
		public String CreateContactForm(Model model)
		{
			Contact contact = new Contact();
			model.addAttribute("contact",contact);
			return "create_contact";
		}
		
		@PostMapping("/contacts")
		public String saveContact(@ModelAttribute("contact") Contact contact)
		{
			contactService.saveContact(contact);
			return "redirect:/contacts";
		}
		
		@GetMapping("/contacts/edit/{id}")
		public String editContactForm(@PathVariable Long id, Model model)
		{
			model.addAttribute("contact", contactService.getContactById(id));
			return "edit_contact";
		}
		
		@PostMapping("/contacts/{id}")
		public String updateContact(@PathVariable Long id, @ModelAttribute("contact") Contact contact, Model model)
		{
			Contact existingContact = contactService.getContactById(id);
			existingContact.setId(id);
			existingContact.setName(contact.getName());	
			existingContact.setMobileNumber(contact.getMobileNumber());
			contactService.updateContact(existingContact);
			return "redirect:/contacts";
		}
		
		@GetMapping("/contacts/{id}")
		public String deleteContact(@PathVariable Long id)
		{
			contactService.deleteContactById(id);
			return "redirect:/contacts";
		}
}
