package com.zup.apipoc.contacts.adapter.out.persistence.dynamodb;

import com.zup.apipoc.configurations.annotations.PersistenceAdapter;
import com.zup.apipoc.contacts.adapter.out.persistence.dynamodb.mappers.ContactTableMapper;
import com.zup.apipoc.contacts.adapter.out.persistence.dynamodb.repositories.ContactRepository;
import com.zup.apipoc.contacts.adapter.out.persistence.dynamodb.tables.ContactTable;
import com.zup.apipoc.contacts.application.port.out.ContactPersistence;
import com.zup.apipoc.contacts.domain.ContactDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;


import java.util.List;

@PersistenceAdapter
@Primary
public class ContactPersistenceDynamoDBAdapter implements ContactPersistence {

    private final ContactTableMapper contactTableMapper;

    private final ContactRepository contactRepository;

    @Autowired
    public ContactPersistenceDynamoDBAdapter (ContactTableMapper contactTableMapper, ContactRepository contactRepository) {
        this.contactTableMapper = contactTableMapper;
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactDomain save(ContactDomain contactDomain) {
        var result = contactRepository.save(contactTableMapper.maptoTable(contactDomain));
        return contactTableMapper.mapToDomain(result);
    }

    @Override
    public List<ContactDomain> getAll() {
        var result = (List<ContactTable>) contactRepository.findAll();
        return contactTableMapper.mapToDomain(result);
    }
}
