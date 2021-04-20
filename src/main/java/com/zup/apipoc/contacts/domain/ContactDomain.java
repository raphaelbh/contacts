package com.zup.apipoc.contacts.domain;

import com.zup.apipoc.commons.exceptions.RequiredFieldException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ContactDomain {

//    TODO: use Optional

    @Getter private UUID id;

    @Getter private String nome;

    @Getter private String telefone;

    @Getter private String email;

    public static ContactDomain create(String nome, String telefone, String email) {
        return new ContactDomain(UUID.randomUUID(), nome, telefone, email);
    }

    public void sanitize() {
        if(this.email != null)
        this.email.toLowerCase();
    }

    //    TODO: alterar para utilizar string utils para as validacoes
    public void validateState() {
        if(nome == null || nome.trim().isEmpty()) {
            throw new RequiredFieldException("O campo nome não pode ser nulo ou vazio");
        }
        if(telefone == null || telefone.trim().isEmpty()) {
            throw new RequiredFieldException("O campo telefone não pode ser nulo ou vazio");
        }
        if(email == null || email.trim().isEmpty()) {
            throw new RequiredFieldException("O campo email não pode ser nulo ou vazio");
        }
    }


}
