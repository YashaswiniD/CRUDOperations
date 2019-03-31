package com.crudpractice.app.contactApp.exceptions;

//This is a global application handler which handles any error in the application
//Not particular to one controller


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ContactRestExceptionHandler extends ResponseEntityExceptionHandler {

    //Handles only Contact not found exception
    @ExceptionHandler
    public ResponseEntity<ContactErrorResponse> handleException(ContactNotFoundException exc){

        ContactErrorResponse error = new ContactErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //Handles anytype of exception in the application
    @ExceptionHandler
    public ResponseEntity<ContactErrorResponse> handleException(Exception exc){

        ContactErrorResponse error = new ContactErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }



}


