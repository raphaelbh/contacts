package com.zup.apipoc.contacts.adapter.out.persistence.dynamodb.mappers;

import com.zup.apipoc.contacts.adapter.out.persistence.dynamodb.tables.ContactTable;
import com.zup.apipoc.contacts.domain.ContactDomain;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ContactTableMapper {

    ModelMapper modelMapper;

    @Autowired
    public ContactTableMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.addMappings(mapPropetyToTable);
        this.modelMapper.addMappings(mapPropertyToDomain);
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

    PropertyMap<ContactDomain, ContactTable> mapPropetyToTable = new PropertyMap<ContactDomain, ContactTable>() {
        protected void configure() {
            using(stringContactConvert).map(source.getId()).setId(null);
            using(stringContactConvert).map(source.getName()).setName(null);
            using(stringContactConvert).map(source.getPhone()).setPhone(null);
            using(stringContactConvert).map(source.getEmail()).setEmail(null);
        }
    };

    PropertyMap<ContactTable, ContactDomain> mapPropertyToDomain = new PropertyMap<ContactTable, ContactDomain>() {
        @Override
        protected void configure() {
            using(optionalContactConvert).map(source.getId()).setId(Optional.empty());
            using(optionalContactConvert).map(source.getName()).setName(Optional.empty());
            using(optionalContactConvert).map(source.getPhone()).setPhone(Optional.empty());
            using(optionalContactConvert).map(source.getEmail()).setEmail(Optional.empty());
        }
    };

    Converter<Optional, Object> stringContactConvert = new Converter<Optional, Object>() {
        @Override
        public Object convert(MappingContext<Optional, Object> context) {
            if(context.getSource().isPresent()) {
                return context.getSource().get();
            }
            return null;
        }
    };

    Converter<String, Optional> optionalContactConvert = new Converter<String, Optional>() {
        @Override
        public Optional convert(MappingContext<String, Optional> context) {
            if(context.getSource() != null) {
                return Optional.of(context.getSource());
            }
            return null;
        }
    };


}

