package com.zup.apipoc.contacts.application.port.out;

import com.zup.apipoc.contacts.adapter.out.persistence.entities.ContactEntity;

public interface CreateContactPersistence {
    void save(ContactEntity contactEntity);
}
