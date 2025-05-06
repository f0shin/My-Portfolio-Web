package com.portfolio.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import com.portfolio.model.Contact;
import com.portfolio.repository.ContactRepository;

public class ContactService {
	
    private ContactRepository contactRepository = new ContactRepository();

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

	public void saveContact(String name, String email, String message) {
		
		String uuid = UUID.randomUUID().toString(); // UUID 생성
        Timestamp createdAt = new Timestamp(System.currentTimeMillis()); // 현재 시각
        Contact contact = new Contact(uuid, name, email, message, createdAt, 0);

        // Repository를 이용해 저장
        contactRepository.save(contact);
		
	}

	public void modifyContactCompleted(String contactId, int i) {
		
		contactRepository.modifyCompleted(contactId, i);
		
	}
    
}
