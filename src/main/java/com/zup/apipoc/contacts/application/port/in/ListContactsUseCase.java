package com.zup.apipoc.contacts.application.port.in;

import com.zup.apipoc.contacts.domain.ContactDomain;

import java.util.List;

public interface ListContactsUseCase {
    List<ContactDomain> execute();
}
