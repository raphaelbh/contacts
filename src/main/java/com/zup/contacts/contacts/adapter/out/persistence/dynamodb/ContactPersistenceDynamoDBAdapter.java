package com.zup.contacts.contacts.adapter.out.persistence.dynamodb;

import com.zup.contacts.configurations.annotations.PersistenceAdapter;
import com.zup.contacts.contacts.adapter.out.persistence.dynamodb.mappers.ContactTableMapper;
import com.zup.contacts.contacts.adapter.out.persistence.dynamodb.repositories.ContactRepository;
import com.zup.contacts.contacts.adapter.out.persistence.dynamodb.tables.ContactTable;
import com.zup.contacts.contacts.application.port.out.ContactPersistence;
import com.zup.contacts.contacts.domain.ContactDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;


import java.util.List;


@PersistenceAdapter
@Primary
@RequiredArgsConstructor
public class ContactPersistenceDynamoDBAdapter implements ContactPersistence {

    private final ContactTableMapper contactTableMapper;

    private final ContactRepository contactRepository;

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
