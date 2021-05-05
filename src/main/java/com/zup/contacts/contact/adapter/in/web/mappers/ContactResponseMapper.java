package com.zup.contacts.contact.adapter.in.web.mappers;

import com.zup.contacts.contact.adapter.in.web.response.ContactResponse;
import com.zup.contacts.contact.domain.ContactDomain;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ContactResponseMapper {

    private final ModelMapper modelMapper;

    public ContactResponse domainToResponse(final ContactDomain contact) {
        return modelMapper.map(contact, ContactResponse.class);
    }

    public List<ContactResponse> domainToResponse(final List<ContactDomain> contacts) {
        return contacts.stream().map(this::domainToResponse).collect(Collectors.toList());
    }

}
