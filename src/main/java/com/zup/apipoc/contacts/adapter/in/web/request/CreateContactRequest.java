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

    @Getter @Setter private Optional<String> name;
    @Getter @Setter private Optional<String> phone;
    @Getter @Setter private Optional<String> email;

}
