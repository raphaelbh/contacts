package com.zup.contacts.contacts.application.port.in;

import com.zup.contacts.contacts.domain.ContactDomain;

import java.util.List;

public interface ListContactsUseCase {
    List<ContactDomain> execute();
}
