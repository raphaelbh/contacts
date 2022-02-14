package com.zup.contacts.contacts.adapter.in.web.mappers;

import com.zup.contacts.contacts.adapter.in.web.response.ContactResponse;
import com.zup.contacts.contacts.domain.ContactDomain;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ContactResponseMapper {

    private final ModelMapper modelMapper;

    public ContactResponse to(ContactDomain contact) {
        var contactResponse = ContactResponse.builder()
                .name(contact.getName())
                .phone(contact.getPhone())
                .email(contact.getEmail()).build();

        if (contact.getId() != null) {
            contactResponse.setId(contact.getId());
        }

        return contactResponse;
    }

    public List<ContactResponse> to(List<ContactDomain> contacts) {
        return contacts.stream().map(this::to).collect(Collectors.toList());
    }

}
