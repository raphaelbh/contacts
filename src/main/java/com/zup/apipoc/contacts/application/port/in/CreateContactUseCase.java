package com.zup.apipoc.contacts.application.port.in;

import com.zup.apipoc.contacts.domain.ContactDomain;

public interface CreateContactUseCase {

     ContactDomain execute(final CreateContactCommand command);

}
