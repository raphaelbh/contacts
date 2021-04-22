package com.zup.apipoc.contacts.adapter.in.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public class ContactResponse {

    @Getter @Setter private UUID id;

    @Getter @Setter private String nome;

    @Getter @Setter private String telefone;

    @Getter @Setter private String email;

}
