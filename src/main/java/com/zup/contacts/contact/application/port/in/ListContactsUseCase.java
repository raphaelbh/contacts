package com.zup.contacts.contact.application.port.in;

import com.zup.contacts.contact.domain.ContactDomain;

import java.util.List;

public interface ListContactsUseCase {

    List<ContactDomain> execute();

}
