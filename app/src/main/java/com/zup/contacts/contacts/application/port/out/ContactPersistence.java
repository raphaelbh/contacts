package com.zup.contacts.contacts.application.port.out;

import com.zup.contacts.contacts.domain.ContactDomain;

import java.util.List;

public interface ContactPersistence {

    ContactDomain save(ContactDomain contact);
    List<ContactDomain> getAll();

}
