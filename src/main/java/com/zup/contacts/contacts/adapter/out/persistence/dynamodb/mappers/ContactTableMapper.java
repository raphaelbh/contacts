package com.zup.contacts.contacts.adapter.out.persistence.dynamodb.mappers;

import com.zup.contacts.contacts.adapter.out.persistence.dynamodb.tables.ContactTable;
import com.zup.contacts.contacts.domain.ContactDomain;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContactTableMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public ContactTableMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public ContactTable maptoTable(ContactDomain contactDomain) {
        return modelMapper.map(contactDomain, ContactTable.class);
    }

    public ContactDomain mapToDomain(ContactTable contactTable) {
        return modelMapper.map(contactTable, ContactDomain.class);
    }

    public List<ContactDomain> mapToDomain(List<ContactTable> contacts) {
        return contacts
                .stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

}

