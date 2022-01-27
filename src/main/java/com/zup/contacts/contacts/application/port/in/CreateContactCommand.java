package com.zup.contacts.contacts.application.port.in;

import lombok.Builder;
import lombok.Getter;

@Builder
public class CreateContactCommand {

    @Getter private String name;
    @Getter private String phone;
    @Getter private String email;

}
