package com.crudpractice.app.contactApp.repository;

import com.crudpractice.app.contactApp.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Long> {

    public List<Contact> findAll();
    public Contact findById(long id);
}
