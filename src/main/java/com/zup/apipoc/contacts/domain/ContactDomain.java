package com.zup.apipoc.contacts.domain;

import com.zup.apipoc.commons.exceptions.RequiredFieldException;
import com.zup.apipoc.commons.utils.StringUtils;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Locale;
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
        this.email = this.email.toLowerCase(Locale.ROOT);
    }

    public void validateState() {
        if(StringUtils.isNullOrEmpty(nome)) {
            throw new RequiredFieldException("O campo nome não pode ser nulo ou vazio");
        }
        if(StringUtils.isNullOrEmpty(telefone)) {
            throw new RequiredFieldException("O campo telefone não pode ser nulo ou vazio");
        }
        if(StringUtils.isNullOrEmpty(email)) {
            throw new RequiredFieldException("O campo email não pode ser nulo ou vazio");
        }
    }

}
