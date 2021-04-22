package com.zup.apipoc.contacts.application.port.out;

import com.zup.apipoc.contacts.adapter.out.persistence.entities.ContactJpaEntity;

public interface CreateContactPersistence {
    void save(ContactJpaEntity contactEntity);
}
