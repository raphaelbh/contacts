package com.zup.contacts.contact.adapter.out.persistence.dynamodb;

import com.zup.contacts.contact.adapter.out.persistence.configurations.PersistenceAdapter;
import com.zup.contacts.contact.adapter.out.persistence.dynamodb.mappers.ContactTableMapper;
import com.zup.contacts.contact.adapter.out.persistence.dynamodb.repositories.ContactRepository;
import com.zup.contacts.contact.adapter.out.persistence.dynamodb.tables.ContactTable;
import com.zup.contacts.contact.application.port.out.ContactPersistence;
import com.zup.contacts.contact.domain.ContactDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;


import java.util.List;

@Primary
@PersistenceAdapter
@RequiredArgsConstructor
public class ContactPersistenceDynamoDBAdapter implements ContactPersistence {

    private final ContactTableMapper contactTableMapper;
    private final ContactRepository contactRepository;

    @Override
    public ContactDomain save(ContactDomain contactDomain) {
        var result = contactRepository.save(contactTableMapper.domainToTable(contactDomain));
        return contactTableMapper.tableToDomain(result);
    }

    @Override
    public List<ContactDomain> getAll() {
        var result = (List<ContactTable>) contactRepository.findAll();
        return contactTableMapper.tableToDomain(result);
    }
}
