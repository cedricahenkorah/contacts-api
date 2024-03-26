package com.example.contactsapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class ContactController {

    private final ContactRepository repository;

    ContactController(ContactRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/contacts")
    List<Contact> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/contacts")
    Contact newContact(@RequestBody Contact newContact) {
        return repository.save(newContact);
    }

    // single item
    @GetMapping("/contacts/{id}")
    Contact one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException(id));
    }

    @PutMapping("/contacts/{id}")
    Contact replaceContact(@RequestBody Contact newContact, @PathVariable Long id) {

        return repository.findById(id)
                .map(contact -> {
                    contact.setName(newContact.getName());
                    contact.setEmail(newContact.getEmail());
                    contact.setNumber(newContact.getNumber());

                    return repository.save(contact);
                })
                .orElseGet(() -> {
                    newContact.setId(id);

                    return repository.save(newContact);
                });
    }

    @DeleteMapping("/contacts/{id}")
    void deleteContact(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
