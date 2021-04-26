package com.zup.apipoc.contacts.application.port.in;

import lombok.Builder;
import lombok.Getter;

import java.util.Optional;

@Builder
public class CreateContactCommand {

    @Getter private Optional<String> name;
    @Getter private Optional<String> phone;
    @Getter private Optional<String> email;

}
