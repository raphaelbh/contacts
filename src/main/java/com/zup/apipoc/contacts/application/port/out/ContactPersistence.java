package com.zup.apipoc.contacts.application.port.out;

import com.zup.apipoc.contacts.domain.ContactDomain;

import java.util.List;

public interface ContactPersistence {

    ContactDomain save(ContactDomain contact);
    List<ContactDomain> getAll();

}
