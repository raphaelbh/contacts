package com.zup.contacts.contact.adapter.out.persistence.memory.mappers;

import com.zup.contacts.contact.adapter.out.persistence.memory.entities.ContactEntity;
import com.zup.contacts.contact.domain.ContactDomain;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ContactEntityMapper {

    private final ModelMapper modelMapper;

    public ContactEntity to(ContactDomain contact) {

        var entity =  ContactEntity.builder()
                .name(contact.getName())
                .phone(contact.getPhone())
                .email(contact.getEmail()).build();

        if (contact.getId() != null) {
            entity.setId(contact.getId());
        }

        return entity;
    }

    public ContactDomain to(ContactEntity entity) {
        return ContactDomain.builder()
                .id(entity.getId())
                .name(entity.getName())
                .phone(entity.getPhone())
                .email(entity.getEmail()).build();
    }

    public List<ContactDomain> to(List<ContactEntity> entities) {
        return entities.stream().map(this::to).collect(Collectors.toList());
    }

}
