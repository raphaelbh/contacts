package com.zup.contacts.contacts.application.service;

import com.zup.contacts.configurations.annotations.UseCase;
import com.zup.contacts.contacts.application.port.in.CreateContactCommand;
import com.zup.contacts.contacts.application.port.in.CreateContactUseCase;
import com.zup.contacts.contacts.application.port.out.ContactPersistence;
import com.zup.contacts.contacts.domain.ContactDomain;
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
