package com.crudpractice.app.contactApp.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="contact_id", unique = true)
    @NotBlank(message = "Contact id is required")
    private String contactId;

    @Column(name="name")
    @NotBlank(message = "Contact name is required")
    private String name;

    @Column(name="email")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Column(name="phone")
    private String phone;


    public Contact(){}

    public Contact(String contactId, @NotBlank(message = "Contact name is required") String name, String email, @NotBlank(message = "Phone number is required") String phone) {
        this.contactId = contactId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }


    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", contactId='" + contactId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
