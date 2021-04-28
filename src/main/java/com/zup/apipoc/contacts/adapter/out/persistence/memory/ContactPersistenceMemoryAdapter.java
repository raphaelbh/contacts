package com.zup.apipoc.contacts.adapter.out.persistence.memory;

import com.zup.apipoc.configurations.annotations.PersistenceAdapter;
import com.zup.apipoc.contacts.adapter.out.persistence.memory.entities.ContactEntity;
import com.zup.apipoc.contacts.adapter.out.persistence.memory.mappers.ContactEntityMapper;
import com.zup.apipoc.contacts.application.port.out.ContactPersistence;
import com.zup.apipoc.contacts.domain.ContactDomain;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class ContactPersistenceMemoryAdapter implements ContactPersistence {

    private final ContactEntityMapper contactMapper;

    private List<ContactEntity> contactsDatabase = new ArrayList<>();

    @Override
    public ContactDomain save(ContactDomain contact) {

        var contactEntity = contactMapper.to(contact);
        contactEntity.setId(UUID.randomUUID().toString());

        contactsDatabase.add(contactEntity);
        contact.setId(contactEntity.getId());

        return contact;
    }

    @Override
    public List<ContactDomain> getAll() {
        return contactMapper.to(contactsDatabase);
    }
}
