package com.zup.contacts.contact.application.port.out;

import com.zup.contacts.contact.domain.ContactDomain;

import java.util.List;

public interface ContactPersistence {

    ContactDomain save(ContactDomain contact);
    List<ContactDomain> getAll();

}
