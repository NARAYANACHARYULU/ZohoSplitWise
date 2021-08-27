package com.zoho.Splitwiseapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zoho.Splitwiseapplication.entity.Contact;
import com.zoho.Splitwiseapplication.repository.ContactRepository;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
			
	}

}
