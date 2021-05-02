package com.zup.contacts.contacts.application.port.in;

import com.zup.contacts.contacts.domain.ContactDomain;

public interface CreateContactUseCase {

     ContactDomain execute(final CreateContactCommand command);

}
