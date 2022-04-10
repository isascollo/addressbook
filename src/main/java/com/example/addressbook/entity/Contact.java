package com.example.addressbook.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name="tbl_contact")
public class Contact {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="contact_id")
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;
    private String phone;

    @CreationTimestamp
    @Column(name="created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updatedAt;

    public Contact(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Contact() {}

    @Override
    public String toString() {
        return  "id: " + id + "\n" +
                firstName + " " + lastName + "\n" +
                "P: " + phone + "\n";
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
