package com.example.addressbook.controller;

import com.example.addressbook.entity.Contact;
import com.example.addressbook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class ContactController {

    ContactRepository contactRepository;

    @Autowired
    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping("/contacts")
    public ResponseEntity<Contact> createContact(@Valid @NotNull @RequestBody Contact contact) {
        try {
            return new ResponseEntity<>(contactRepository.save(contact), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<Contact> getContact(
            @PathVariable(value = "id") long contactId) {
        try {
            Optional<Contact> contactData = contactRepository.findById(contactId);
            return contactData.map(contact -> new ResponseEntity<>(contact, HttpStatus.OK)).orElseGet(() ->
                    new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> getAllUniqueContacts() {
        try{
            return new ResponseEntity<>(contactRepository.findAll(),HttpStatus.OK) ;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/contacts/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable("id") long id, @RequestBody Contact contactRequest) {
        try{
            Optional<Contact> contactData = contactRepository.findById(id);
            if(contactData.isPresent()) {
                Contact _contact = contactData.get();
                _contact.setFirstName(contactRequest.getFirstName());
                _contact.setLastName(contactRequest.getLastName());
                _contact.setPhone(contactRequest.getPhone());
                return new ResponseEntity<>(contactRepository.save(_contact), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable("id") long id) {
        try {
            contactRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/contacts")
    public ResponseEntity<HttpStatus> deleteAllContacts() {
        try {
            contactRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
