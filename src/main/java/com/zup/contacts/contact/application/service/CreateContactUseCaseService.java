package com.zup.contacts.contact.application.service;

import com.zup.contacts.configurations.annotations.UseCase;
import com.zup.contacts.contact.application.port.in.CreateContactCommand;
import com.zup.contacts.contact.application.port.in.CreateContactUseCase;
import com.zup.contacts.contact.application.port.out.ContactPersistence;
import com.zup.contacts.contact.domain.ContactDomain;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CreateContactUseCaseService implements CreateContactUseCase {

    private final ContactPersistence contactPersistence;

    public ContactDomain execute(final CreateContactCommand command) {

        var contact = ContactDomain.builder()
                .id(null)
                .name(command.getName())
                .phone(command.getPhone())
                .email(command.getEmail()).build();

        contact.validate();
        contact.sanitize();

        return contactPersistence.save(contact);
    }

}
