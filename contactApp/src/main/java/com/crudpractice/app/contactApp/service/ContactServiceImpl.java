package com.crudpractice.app.contactApp.service;

import com.crudpractice.app.contactApp.entity.Contact;
import com.crudpractice.app.contactApp.exceptions.ContactNotFoundException;
import com.crudpractice.app.contactApp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactServiceImpl implements  ContactService{


    private ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository theContactRepository){
        contactRepository = theContactRepository;
    }


    @Override
    public Contact getContact(long id) {
        Contact contact =  contactRepository.findById(id);
        if(contact == null){
            throw new ContactNotFoundException("Contact Id '"+id+"' does not exist");
        }
        return contact;

    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact saveOrUpdateContact(Contact contact) {
        try{
            return contactRepository.save(contact);
        }catch (Exception exc){
            throw new ContactNotFoundException(exc);
        }
    }


    @Override
    public void deleteContact(long id) {
        Contact contact =  contactRepository.findById(id);

        if(contact == null){
            throw  new  ContactNotFoundException("Cannot found Contact with ID '"+id+"'. This Contact does not exist");
        }

        contactRepository.delete(contact);
    }
}
