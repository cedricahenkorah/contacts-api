package com.example.contactsapi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
class Contact {

    private @Id @GeneratedValue Long id;
    private String name;
    private String email;
    private String number;

    Contact() {}

    Contact(String name, String email, String number) {

        this.name = name;
        this.email = email;
        this.number = number;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNumber() {
        return this.number;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (!(o instanceof Contact))
            return false;

        Contact contact = (Contact) o;

        return Objects.equals(this.id, contact.id) && Objects.equals(this.name, contact.name) && Objects.equals(this.email, contact.email) && Objects.equals(this.number, contact.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.email, this.number);
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + this.id + ", name='" + this.name + '\'' + ", email='" + this.email + '\'' + ", number='" + this.number + '\'' + '}';
    }
}
