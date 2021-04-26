package com.zup.apipoc.contacts.adapter.in.web.mappers;

import com.zup.apipoc.contacts.adapter.in.web.response.ContactResponse;
import com.zup.apipoc.contacts.domain.ContactDomain;
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
                .name(contact.getName().get())
                .phone(contact.getPhone().get())
                .email(contact.getEmail().get()).build();

        if (contact.getId().isPresent()) {
            contactResponse.setId(contact.getId().get().toString());
        }

        return contactResponse;
    }

    public List<ContactResponse> to(List<ContactDomain> contacts) {
        return contacts.stream().map(this::to).collect(Collectors.toList());
    }

}
