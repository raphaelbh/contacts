package com.zup.apipoc.contacts.adapter.out.persistence.memory.mappers;

import com.zup.apipoc.contacts.adapter.out.persistence.memory.entities.ContactEntity;
import com.zup.apipoc.contacts.domain.ContactDomain;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ContactEntityMapper {

    private final ModelMapper modelMapper;

    public ContactEntity to(ContactDomain contact) {

        var entity =  ContactEntity.builder()
                .name(contact.getName().get())
                .phone(contact.getPhone().get())
                .email(contact.getEmail().get()).build();

        if (contact.getId().isPresent()) {
            entity.setId(contact.getId().get());
        }

        return entity;
    }

    public ContactDomain to(ContactEntity entity) {
        return ContactDomain.builder()
                .id(Optional.of(entity.getId()))
                .name(Optional.of(entity.getName()))
                .phone(Optional.of(entity.getPhone()))
                .email(Optional.of(entity.getEmail())).build();
    }

    public List<ContactDomain> to(List<ContactEntity> entities) {
        return entities.stream().map(this::to).collect(Collectors.toList());
    }

}
