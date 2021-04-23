package com.zup.apipoc.contacts.application.service;

import com.zup.apipoc.configurations.annotations.UseCase;
import com.zup.apipoc.contacts.application.port.in.ListContactsUseCase;
import com.zup.apipoc.contacts.application.port.out.ContactPersistence;
import com.zup.apipoc.contacts.domain.ContactDomain;
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
