package com.zup.contacts.contact.adapter.out.persistence.memory;

import com.zup.contacts.contact.adapter.out.persistence.configurations.PersistenceAdapter;
import com.zup.contacts.contact.adapter.out.persistence.memory.entities.ContactEntity;
import com.zup.contacts.contact.adapter.out.persistence.memory.mappers.ContactEntityMapper;
import com.zup.contacts.contact.application.port.out.ContactPersistence;
import com.zup.contacts.contact.domain.ContactDomain;
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
