package com.zup.contacts.contact.application.service;

import com.zup.contacts.configurations.annotations.UseCase;
import com.zup.contacts.contact.application.port.in.ListContactsUseCase;
import com.zup.contacts.contact.application.port.out.ContactPersistence;
import com.zup.contacts.contact.domain.ContactDomain;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ListContactUseCaseService implements ListContactsUseCase {

    private final ContactPersistence contactPersistence;

    @Override
    public List<ContactDomain> execute() {
        return contactPersistence.getAll();
    }
}
