package com.zup.contacts.contact.application.port.in;

import com.zup.contacts.contact.domain.ContactDomain;

public interface CreateContactUseCase {

     ContactDomain execute(final CreateContactCommand command);

}
