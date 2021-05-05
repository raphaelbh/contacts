package com.zup.contacts.contact.adapter.out.persistence.dynamodb.mappers;

import com.zup.contacts.contact.adapter.out.persistence.dynamodb.tables.ContactTable;
import com.zup.contacts.contact.domain.ContactDomain;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ContactTableMapper {

    private final ModelMapper modelMapper;

    public ContactTable domainToTable(final ContactDomain contactDomain) {
        return modelMapper.map(contactDomain, ContactTable.class);
    }

    public ContactDomain tableToDomain(final ContactTable contactTable) {
        return modelMapper.map(contactTable, ContactDomain.class);
    }

    public List<ContactDomain> tableToDomain(final List<ContactTable> contacts) {
        return contacts
                .stream()
                .map(this::tableToDomain)
                .collect(Collectors.toList());
    }

}

