package com.zup.apipoc.contacts.adapter.in.web.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
public class CreateContactRequest implements Serializable {

    @Getter @Setter private String name;
    @Getter @Setter private String phone;
    @Getter @Setter private String email;

}
