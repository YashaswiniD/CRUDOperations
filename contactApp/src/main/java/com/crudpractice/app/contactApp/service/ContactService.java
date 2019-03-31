package com.crudpractice.app.contactApp.service;

import com.crudpractice.app.contactApp.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ContactService {

    public Contact getContact(long id);
    public List<Contact> getAllContacts();

    public Contact saveOrUpdateContact(Contact contact);

    public void deleteContact(long id);


}
