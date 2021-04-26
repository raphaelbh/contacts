package com.zup.apipoc.contacts.application.service;

import com.zup.apipoc.configurations.annotations.UseCase;
import com.zup.apipoc.contacts.application.port.in.CreateContactCommand;
import com.zup.apipoc.contacts.application.port.in.CreateContactUseCase;
import com.zup.apipoc.contacts.application.port.out.ContactPersistence;
import com.zup.apipoc.contacts.domain.ContactDomain;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@UseCase
@RequiredArgsConstructor
public class CreateContactUseCaseService implements CreateContactUseCase {

    private final ContactPersistence contactPersistence;

    public ContactDomain execute(final CreateContactCommand command) {

        var contact = ContactDomain.builder()
                .id(Optional.empty())
                .name(command.getName())
                .phone(command.getPhone())
                .email(command.getEmail()).build();

        contact.validate();
        contact.sanitize();

        return contactPersistence.save(contact);
    }
}
