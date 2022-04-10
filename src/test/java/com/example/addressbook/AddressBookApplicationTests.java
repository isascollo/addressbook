package com.example.addressbook;

import com.example.addressbook.controller.ContactController;
import com.example.addressbook.entity.Contact;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class AddressBookApplicationTests {

    @Autowired
    ContactController contactController;

//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    void getAllBlank() {
//        ResponseEntity<List<Contact>> entity;
//        entity = contactController.getAllUniqueContacts();
//        assertEquals(entity, contactController.getAllUniqueContacts());
//    }
//
//    @Test
//    void create() {
//        Contact contact = new Contact("Isa", "Scollo", "1231314234");
//        assertEquals(new ResponseEntity<>(contact, HttpStatus.CREATED),
//                contactController.createContact(contact));
//    }
//
//    @Test
//    void createblank() {
//        Contact contact = new Contact();
//        assertEquals(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR),
//                contactController.createContact(contact));
//    }
//
//    @Test
//    void put() {
//        Contact contact = new Contact("Isa", "Scollo", "1231314234");
//        Contact newContact = new Contact("Isa", "Scollo", "000");
//        contactController.createContact(contact);
//    }
}
