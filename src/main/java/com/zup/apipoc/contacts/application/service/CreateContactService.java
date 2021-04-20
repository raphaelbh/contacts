package com.zup.apipoc.contacts.application.service;

import com.zup.apipoc.contacts.adapter.out.persistence.ContactPersistenceAdapter;
import com.zup.apipoc.contacts.application.port.in.CreateContactCommand;
import com.zup.apipoc.contacts.application.port.in.CreateContactUseCase;
import com.zup.apipoc.contacts.domain.ContactDomain;

public class CreateContactService implements CreateContactUseCase {

    private ContactPersistenceAdapter contactPersistenceAdapter;

    public void create(final CreateContactCommand command) {
        var contactDomain = ContactDomain.create(command.getNome(), command.getTelefone(), command.getEmail());
        contactDomain.validateState();
        contactDomain.sanitize();
//        contactPersistenceAdapter.save();
    }
}
