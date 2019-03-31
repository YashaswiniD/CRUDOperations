package com.crudpractice.app.contactApp.controller;

import com.crudpractice.app.contactApp.repository.ContactRepository;
import com.crudpractice.app.contactApp.entity.Contact;
import com.crudpractice.app.contactApp.service.ContactService;
import com.crudpractice.app.contactApp.service.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private ContactService contactService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    public ContactController(ContactService theContactService){
        contactService = theContactService;
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAll(){
        List<Contact> list = contactService.getAllContacts();
        return new ResponseEntity<List<Contact>>(list,HttpStatus.OK);
    }


    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Contact> getContactById(@PathVariable long id){
        Contact contact1 = contactService.getContact(id);
        return new ResponseEntity<Contact>(contact1, HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<?> saveOrUpdateContact(@Valid @RequestBody Contact contact  , BindingResult result){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;

        Contact contact1 = contactService.saveOrUpdateContact(contact);
        return new ResponseEntity<Contact>(contact, HttpStatus.CREATED);
    }


    @DeleteMapping(path ={"/{id}"})
    public  ResponseEntity<?>  delete(@PathVariable("id") long id) {
        contactService.deleteContact(id);
        return new ResponseEntity<String>("Contact with ID: '"+id+"' was deleted", HttpStatus.OK);

    }

}
