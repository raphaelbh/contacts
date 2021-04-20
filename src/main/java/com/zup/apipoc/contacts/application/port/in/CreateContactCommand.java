package com.zup.apipoc.contacts.application.port.in;

import lombok.Getter;

public class CreateContactCommand {


    @Getter private String nome;

    @Getter private String telefone;

    @Getter private String email;

    private CreateContactCommand(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
}
